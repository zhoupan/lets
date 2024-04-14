project('letsc', 'c',
        version : '1.0.0',
        default_options : ['warning_level=3', 'c_std=c11'])

# These arguments are only used to build the shared library
# not the executables that use the library.
lib_args = ['-DBUILDING_MESON_LIBRARY']

shared_library('letsc', 'main.c',
               install : true,
               c_args : lib_args
)