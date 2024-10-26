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
import java.io.File;
import lets.antlr4.Antlr4Tool;
import org.junit.jupiter.api.Test;

class Antlr4ToolTest {
  @Test
  void velocity() throws Exception {
    File projectDir = new File("e:\\target\\velocity");
    //    <configuration>
    //					<sourceDirectory>${basedir}</sourceDirectory>
    //					<includes>
    //						<include>VTLLexer.g4</include>
    //						<include>VTLParser.g4</include>
    //					</includes>
    //					<visitor>true</visitor>
    //					<listener>true</listener>
    //					<arguments>
    //						<argument>-Dlanguage=Java</argument>
    //						<argument>-package</argument>
    //						<argument>lang</argument>
    //					</arguments>
    //				</configuration>
    Antlr4Tool at = new Antlr4Tool(projectDir, "target");
    at.setAntlr4GrammarDirectory(projectDir);
    // at.getIncludes().add("*.g4");
    // at.getIncludes().add("VTLParser.g4");
    at.setVisitor(true);
    at.setListener(true);
    at.setOutputDirectory(new File(projectDir, "src/main/java/lang"));
    at.withArguments("-Dlanguage=Java", "-package", "lang");
    at.execute();
  }
}
