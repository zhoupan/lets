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
 * JSONParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface JSONVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link JSONParser#json}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJson(JSONParser.JsonContext ctx);

  /**
   * Visit a parse tree produced by {@link JSONParser#obj}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitObj(JSONParser.ObjContext ctx);

  /**
   * Visit a parse tree produced by {@link JSONParser#pair}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPair(JSONParser.PairContext ctx);

  /**
   * Visit a parse tree produced by {@link JSONParser#arr}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArr(JSONParser.ArrContext ctx);

  /**
   * Visit a parse tree produced by {@link JSONParser#value}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValue(JSONParser.ValueContext ctx);
}
