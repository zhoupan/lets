/*
 * Copyright (c) 2024 zhoupan (https://github.com/zhoupan).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package example.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class ExampleTest {

  //  Execute before all test methods in the current class  @BeforeClass  @BeforeAll
  //  Execute after all test methods in the current class   @AfterClass   @AfterAll
  //  Execute before each test method   @Before   @BeforeEach
  //  Execute after each test method  @After  @AfterEach
  //  Disable a test method/class   @Ignore   @Disabled
  //  Test factory for dynamic tests  NA  @TestFactory
  //  Nested tests  NA  @Nested
  //  Tagging and filtering   @Category   @Tag
  //  Register custom extensions  NA  @ExtendWith
  @BeforeAll
  public static void beforeClass() {
    System.out.println("BeforeClass");
  }

  @AfterAll
  public static void afterClass() {
    System.out.println("AfterClass");
  }

  @BeforeEach
  public void before() {
    System.out.println("Before");
  }

  @AfterEach
  public void after() {
    System.out.println("After");
  }

  @Test
  public void works_1() {
    System.out.println("works_1");
  }

  @Test
  public void works_2() {
    System.out.println("works_2");
  }

  @Disabled
  public void works_ignore() {
    System.out.println("works_ignore");
  }
}
