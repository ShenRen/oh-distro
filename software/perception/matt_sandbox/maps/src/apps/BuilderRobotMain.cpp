#include <maps/MapManager.hpp>
#include <maps/LocalMap.hpp>
#include <maps/SensorDataReceiver.hpp>
#include <maps/DeltaPublisher.hpp>

#include <lcm/lcm-cpp.hpp>
#include <boost/thread.hpp>

#include <pcl/common/transforms.h>

using namespace std;

class State {
public:
  boost::shared_ptr<SensorDataReceiver> mSensorDataReceiver;
  boost::shared_ptr<DeltaPublisher> mDeltaPublisher;
  boost::shared_ptr<MapManager> mManager;

  State() {
    mSensorDataReceiver.reset(new SensorDataReceiver());
    mDeltaPublisher.reset(new DeltaPublisher());
    mManager.reset(new MapManager());
  }
};

class DataConsumer {
public:
  DataConsumer(State* iState) {
    mState = iState;
    mCounter = 0;
  }

  void operator()() {
    while(true) {
      SensorDataReceiver::PointCloudWithPose data;
      if (mState->mSensorDataReceiver->waitForData(data)) {
        mState->mManager->addToBuffer(data.mTimestamp, data.mPointCloud,
                                      data.mPose);
        // TODO: should be true (ray trace) but very inefficient
        mState->mManager->getActiveMap()->add(data.mPointCloud,
                                              data.mPose, false);
      }
    }
  }

protected:
  State* mState;
  int mCounter;
};

int main(const int iArgc, const char** iArgv) {
  State state;

  boost::shared_ptr<lcm::LCM> theLcm(new lcm::LCM());
  if (!theLcm->good()) {
    cerr << "Cannot create lcm instance." << endl;
    return -1;
  }

  // TODO: temporary; need server
  BotParam* theParam = bot_param_new_from_file("/home/antone/drc/software/config/drc_robot.cfg");

  state.mSensorDataReceiver->setLcm(theLcm);
  state.mSensorDataReceiver->setBotParam(theParam);
  state.mSensorDataReceiver->setMaxBufferSize(100);
  state.mSensorDataReceiver->
    addChannel("ROTATING_SCAN",
               SensorDataReceiver::SensorTypePlanarLidar,
               "ROTATING_SCAN", "local");
  /*
    addChannel("WIDE_STEREO_POINTS",
               SensorDataReceiver::SensorTypePointCloud,
               "CAMERA", "local");
  */
  state.mSensorDataReceiver->start();

  state.mManager->setMapResolution(0.01);
  state.mManager->setMapDimensions(Eigen::Vector3d(10,10,10));
  state.mManager->setDataBufferLength(1000);
  state.mManager->createMap(Eigen::Isometry3d::Identity());

  state.mDeltaPublisher->setPublishInterval(5000);
  state.mDeltaPublisher->setManager(state.mManager);
  state.mDeltaPublisher->setLcm(theLcm);
  state.mDeltaPublisher->start();

  DataConsumer consumer(&state);
  boost::thread thread(consumer);
                                       
  while (0 == theLcm->handle());

  state.mDeltaPublisher->stop();
  thread.join();

  return 0;
}
