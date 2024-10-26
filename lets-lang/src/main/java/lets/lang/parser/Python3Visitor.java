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

import lets.lang.Python3ParserBaseVisitor;

public class Python3Visitor extends Python3ParserBaseVisitor<Void> {

  protected Python3ParserController controller;

  public Python3Visitor() {
    this(new Python3ParserController());
  }

  public Python3Visitor(Python3ParserController controller) {
    this.controller = controller;
  }

  public Python3ParserController getController() {
    return controller;
  }
}
