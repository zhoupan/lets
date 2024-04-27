project(
  'letsc',
  'c',
  version : '1.0.0',
  default_options : ['warning_level=3', 'c_std=c11']
)
# These arguments are only used to build the shared library
# not the executables that use the library.
lib_args = ['-DBUILDING_MESON_LIBRARY']
letsc_sources = ['main.c']
letsc_dependencies = [dependency('glib-2.0'), dependency('thrift')]
letsc_shared = shared_library(
  'letsc',
  letsc_sources,
  dependencies : letsc_dependencies,
  install : true,
  c_args : lib_args
)

letsc_test_exe = executable(
  'letsc_test',
  ['letsc_test.c', 'cute.h'],
  link_with : [letsc_shared]
)

letsc_unit_exe = executable(
  'letsc_unit',
  ['letsc_test.c', 'cute.h'],
  dependencies : letsc_dependencies
)

test('letsc_test', letsc_test_exe)
