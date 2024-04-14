#define CUTE_MAIN
#include "cute.h"
TEST(hello) {
  printf("Hello, World!\n");
}
bool is_target;

static void setup(const char *testname) {
  is_target = strcmp(testname, "setup_target") == 0;
}

static void teardown(void) {
  is_target = false;
}

int main(void) {
  BEFORE_EACH(setup);
  AFTER_EACH(teardown);
  return RUN_ALL();
}