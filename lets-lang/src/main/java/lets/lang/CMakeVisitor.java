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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link
 * CMakeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface CMakeVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link CMakeParser#file_}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFile_(CMakeParser.File_Context ctx);

  /**
   * Visit a parse tree produced by {@link CMakeParser#command_invocation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCommand_invocation(CMakeParser.Command_invocationContext ctx);

  /**
   * Visit a parse tree produced by {@link CMakeParser#single_argument}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSingle_argument(CMakeParser.Single_argumentContext ctx);

  /**
   * Visit a parse tree produced by {@link CMakeParser#compound_argument}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCompound_argument(CMakeParser.Compound_argumentContext ctx);
}
