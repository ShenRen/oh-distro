cmake_minimum_required(VERSION 2.6.0)

# pull in the pods macros. See cmake/pods.cmake for documentation
set(POD_NAME mfallon_sandbox)
include(cmake/pods.cmake)

# automatically build LCM types.  This also defines a number of CMake
# variables, see cmake/lcmtypes.cmake for details
include(cmake/lcmtypes.cmake)
lcmtypes_build()

add_subdirectory(src/bounding_box)
add_subdirectory(src/renderer_sandia_palm)

#add_subdirectory(src/point-head)


#add_subdirectory(src/rgbd_vis)
#add_subdirectory(src/rgbd2file)
add_subdirectory(src/est_robot_state_fake)


#add_subdirectory(src/heightmap_lcmgl)
#add_subdirectory(src/tld_lcmgl)

#add_subdirectory(src/plane_detector)

add_subdirectory(src/terrain_classify)

#add_subdirectory(src/pcl_openni_grabber)
#add_subdirectory(src/pcl_pcd_grabber)



add_subdirectory(src/fisheye)


add_subdirectory(src/libbot_eigen_comparison)
