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
package lets.lang;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public abstract class CPP14ParserBase extends Parser {
  protected CPP14ParserBase(TokenStream input) {
    super(input);
  }

  protected boolean IsPureSpecifierAllowed() {
    try {
      ParserRuleContext x = this._ctx; // memberDeclarator
      ParseTree c = x.getChild(0).getChild(0);
      ParseTree c2 = c.getChild(0);
      ParseTree p = c2.getChild(1);
      if (p == null) return false;
      return (p instanceof CPP14Parser.ParametersAndQualifiersContext);
    } catch (Exception e) {
    }
    return false;
  }
}
