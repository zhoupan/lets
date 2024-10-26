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
 * This interface defines a complete generic visitor for a parse tree produced by {@link URLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface URLVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link URLParser#url}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUrl(URLParser.UrlContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#uri}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUri(URLParser.UriContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#scheme}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitScheme(URLParser.SchemeContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#host}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitHost(URLParser.HostContext ctx);

  /**
   * Visit a parse tree produced by the {@code DomainNameOrIPv4Host} labeled alternative in {@link
   * URLParser#hostname}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDomainNameOrIPv4Host(URLParser.DomainNameOrIPv4HostContext ctx);

  /**
   * Visit a parse tree produced by the {@code IPv6Host} labeled alternative in {@link
   * URLParser#hostname}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIPv6Host(URLParser.IPv6HostContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#v6host}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitV6host(URLParser.V6hostContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#port}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPort(URLParser.PortContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#path}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPath(URLParser.PathContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#user}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUser(URLParser.UserContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#login}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLogin(URLParser.LoginContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#password}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPassword(URLParser.PasswordContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#frag}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFrag(URLParser.FragContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#query}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitQuery(URLParser.QueryContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#search}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSearch(URLParser.SearchContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#searchparameter}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSearchparameter(URLParser.SearchparameterContext ctx);

  /**
   * Visit a parse tree produced by {@link URLParser#string}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitString(URLParser.StringContext ctx);
}
