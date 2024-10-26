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
package lets.antlr4; // https://www.graalvm.org/latest/reference-manual/native-image/

// Set up a GRAALVM_HOME environment variable pointing to your GraalVM installation,
// in which case the JDK pointed at this location will be used for Native Image builds instead
// call "C:\Program Files\Microsoft Visual Studio\2022\Community\VC\Auxiliary\Build\vcvars64.bat"
// From a Class
// $ java --version
// java 21.0.2 2024-01-16 LTS
// Java(TM) SE Runtime Environment Oracle GraalVM 21.0.2+13.1 (build 21.0.2+13-LTS-jvmci-23.1-b30)
// Java HotSpot(TM) 64-Bit Server VM Oracle GraalVM 21.0.2+13.1 (build 21.0.2+13-LTS-jvmci-23.1-b30,
// mixed mode, sharing)
// $ javac HelloWorld.java
// $ java HelloWorld
// Hello, Native World!
// $ native-image HelloWorld
// Produced artifacts: helloworld.exe (executable)
// Finished generating 'helloworld' in 39.4s.

public class LetsAntlr4Main {
  public static void main(String[] args) {
    org.antlr.v4.Tool.main(args);
  }
}
