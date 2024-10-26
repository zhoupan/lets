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
package lets.lang.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;
import lets.core.DataResultSupport;
import org.junit.jupiter.api.Test;

public class LangTransformTest {

  @Test
  public void javaToPython() {
    LangFeatures javaFeatures = new JavaFeatures();
    LangFeatures pythonFeatures = new PythonFeatures();
    PythonPrettyPrinter pythonPrinter = new PythonPrettyPrinter();
    LangTransformer transformer = new LangTransformer(javaFeatures, pythonFeatures, pythonPrinter);
    File javaSrc = new File("src/main/java");
    File pythonSrc = new File("target/src.python");
    DataResultSupport<List<File>> transform = transformer.transform(javaSrc, pythonSrc);
    assertTrue(transform.isSuccess(), transform.getMessage());
  }
}
