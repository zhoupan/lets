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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/** This interface defines a complete listener for a parse tree produced by {@link CMakeParser}. */
public interface CMakeListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link CMakeParser#file_}.
   *
   * @param ctx the parse tree
   */
  void enterFile_(CMakeParser.File_Context ctx);

  /**
   * Exit a parse tree produced by {@link CMakeParser#file_}.
   *
   * @param ctx the parse tree
   */
  void exitFile_(CMakeParser.File_Context ctx);

  /**
   * Enter a parse tree produced by {@link CMakeParser#command_invocation}.
   *
   * @param ctx the parse tree
   */
  void enterCommand_invocation(CMakeParser.Command_invocationContext ctx);

  /**
   * Exit a parse tree produced by {@link CMakeParser#command_invocation}.
   *
   * @param ctx the parse tree
   */
  void exitCommand_invocation(CMakeParser.Command_invocationContext ctx);

  /**
   * Enter a parse tree produced by {@link CMakeParser#single_argument}.
   *
   * @param ctx the parse tree
   */
  void enterSingle_argument(CMakeParser.Single_argumentContext ctx);

  /**
   * Exit a parse tree produced by {@link CMakeParser#single_argument}.
   *
   * @param ctx the parse tree
   */
  void exitSingle_argument(CMakeParser.Single_argumentContext ctx);

  /**
   * Enter a parse tree produced by {@link CMakeParser#compound_argument}.
   *
   * @param ctx the parse tree
   */
  void enterCompound_argument(CMakeParser.Compound_argumentContext ctx);

  /**
   * Exit a parse tree produced by {@link CMakeParser#compound_argument}.
   *
   * @param ctx the parse tree
   */
  void exitCompound_argument(CMakeParser.Compound_argumentContext ctx);
}
