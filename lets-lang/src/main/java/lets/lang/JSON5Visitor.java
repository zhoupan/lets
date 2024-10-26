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
 * JSON5Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface JSON5Visitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link JSON5Parser#json5}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJson5(JSON5Parser.Json5Context ctx);

  /**
   * Visit a parse tree produced by {@link JSON5Parser#obj}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitObj(JSON5Parser.ObjContext ctx);

  /**
   * Visit a parse tree produced by {@link JSON5Parser#pair}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPair(JSON5Parser.PairContext ctx);

  /**
   * Visit a parse tree produced by {@link JSON5Parser#key}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitKey(JSON5Parser.KeyContext ctx);

  /**
   * Visit a parse tree produced by {@link JSON5Parser#value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue(JSON5Parser.ValueContext ctx);

  /**
   * Visit a parse tree produced by {@link JSON5Parser#arr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArr(JSON5Parser.ArrContext ctx);

  /**
   * Visit a parse tree produced by {@link JSON5Parser#number}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNumber(JSON5Parser.NumberContext ctx);
}
