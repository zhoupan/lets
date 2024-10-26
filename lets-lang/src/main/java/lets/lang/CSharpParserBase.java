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

public abstract class CSharpParserBase extends Parser {
  protected CSharpParserBase(TokenStream input) {
    super(input);
  }

  protected boolean IsLocalVariableDeclaration() {
    if (!(this._ctx instanceof CSharpParser.Local_variable_declarationContext)) {
      return false;
    }
    CSharpParser.Local_variable_declarationContext local_var_decl =
        (CSharpParser.Local_variable_declarationContext) this._ctx;
    if (local_var_decl == null) return true;
    CSharpParser.Local_variable_typeContext local_variable_type =
        local_var_decl.local_variable_type();
    if (local_variable_type == null) return true;
    if (local_variable_type.getText().equals("var")) return false;
    return true;
  }
}
