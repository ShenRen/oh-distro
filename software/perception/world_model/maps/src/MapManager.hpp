#ifndef _maps_MapManager_hpp_
#define _maps_MapManager_hpp_

#include <unordered_map>
#include <boost/shared_ptr.hpp>
#include <Eigen/Geometry>

#include "Types.hpp"
#include "LocalMap.hpp"


namespace maps {

class PointDataBuffer;

class MapManager {

protected:
  typedef std::unordered_map<int64_t, LocalMap::Ptr> MapCollection;


public:
  // constructor/destructor
  MapManager();
  virtual ~MapManager();

  // completely clear the state
  void clear();

  // setters for map properties
  void setVerbose(const bool iVal);

  // create new map, return id if successful or -1 if not
  int64_t createMap(const LocalMap::Spec& iSpec);

  // whether map with given id exists
  bool hasMap(const int64_t iId) const;

  // get map with specified id, or null if not found
  LocalMap::Ptr getMap(const int64_t iId) const;

  // start forwarding data to particular map
  bool startUpdatingMap(const int64_t iId);

  // stop forwarding data to particular map
  bool stopUpdatingMap(const int64_t iId);

  // clear point data from specified map
  bool clearMap(const int64_t iId);

  // permanently remove specified map
  bool deleteMap(const int64_t iId);

  // clone specified map, return new id if successful or -1 if not
  int64_t snapshotMap(const int64_t iId);
  int64_t snapshotMap(const int64_t iId,
                      const int64_t iStartTime, const int64_t iEndTime);

  // add data to all active maps
  bool addData(const maps::PointSet& iPointSet);

  // get underlying point data (TODO: experimental)
  const boost::shared_ptr<PointDataBuffer> getPointData() const;

protected:
  MapCollection mMaps;
  int mNextMapId;
  boost::shared_ptr<PointDataBuffer> mPointData;

  bool mVerbose;
};

}

#endif
