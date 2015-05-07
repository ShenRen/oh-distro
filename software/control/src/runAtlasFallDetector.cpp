#include "AtlasFallDetector.hpp"

int main(int argc, char** argv) {
  const char* drc_path = std::getenv("DRC_BASE");
  if (!drc_path) {
    throw std::runtime_error("environment variable DRC_BASE is not set");
  }
  std::shared_ptr<RigidBodyManipulator> model(new RigidBodyManipulator(std::string(drc_path) + "/software/models/atlas_v5/model_minimal_contact.urdf"));
  model->setUseNewKinsol(true);
  model->compile();

  std::unique_ptr<AtlasFallDetector> fall_detector(new AtlasFallDetector(model));
  std::cout << "Atlas fall detector running" << std::endl;
  fall_detector->run();
  return 0;
}

