cmake_minimum_required(VERSION 2.8.2)

project(googletest-download NONE)

include(ExternalProject)
ExternalProject_Add(googletest
  GIT_REPOSITORY    https://github.com/google/googletest.git
  GIT_TAG           master
  SOURCE_DIR        "/data/Projects/GitProjects/mt-course/lab4_try2/src/results/expression_generated/cmake-build-debug/googletest-src"
  BINARY_DIR        "/data/Projects/GitProjects/mt-course/lab4_try2/src/results/expression_generated/cmake-build-debug/googletest-build"
  CONFIGURE_COMMAND ""
  BUILD_COMMAND     ""
  INSTALL_COMMAND   ""
  TEST_COMMAND      ""
)
