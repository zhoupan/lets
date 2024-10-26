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

/** This interface defines a complete listener for a parse tree produced by {@link URLParser}. */
public interface URLListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link URLParser#url}.
   *
   * @param ctx the parse tree
   */
  void enterUrl(URLParser.UrlContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#url}.
   *
   * @param ctx the parse tree
   */
  void exitUrl(URLParser.UrlContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#uri}.
   *
   * @param ctx the parse tree
   */
  void enterUri(URLParser.UriContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#uri}.
   *
   * @param ctx the parse tree
   */
  void exitUri(URLParser.UriContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#scheme}.
   *
   * @param ctx the parse tree
   */
  void enterScheme(URLParser.SchemeContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#scheme}.
   *
   * @param ctx the parse tree
   */
  void exitScheme(URLParser.SchemeContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#host}.
   *
   * @param ctx the parse tree
   */
  void enterHost(URLParser.HostContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#host}.
   *
   * @param ctx the parse tree
   */
  void exitHost(URLParser.HostContext ctx);

  /**
   * Enter a parse tree produced by the {@code DomainNameOrIPv4Host} labeled alternative in {@link
   * URLParser#hostname}.
   *
   * @param ctx the parse tree
   */
  void enterDomainNameOrIPv4Host(URLParser.DomainNameOrIPv4HostContext ctx);

  /**
   * Exit a parse tree produced by the {@code DomainNameOrIPv4Host} labeled alternative in {@link
   * URLParser#hostname}.
   *
   * @param ctx the parse tree
   */
  void exitDomainNameOrIPv4Host(URLParser.DomainNameOrIPv4HostContext ctx);

  /**
   * Enter a parse tree produced by the {@code IPv6Host} labeled alternative in {@link
   * URLParser#hostname}.
   *
   * @param ctx the parse tree
   */
  void enterIPv6Host(URLParser.IPv6HostContext ctx);

  /**
   * Exit a parse tree produced by the {@code IPv6Host} labeled alternative in {@link
   * URLParser#hostname}.
   *
   * @param ctx the parse tree
   */
  void exitIPv6Host(URLParser.IPv6HostContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#v6host}.
   *
   * @param ctx the parse tree
   */
  void enterV6host(URLParser.V6hostContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#v6host}.
   *
   * @param ctx the parse tree
   */
  void exitV6host(URLParser.V6hostContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#port}.
   *
   * @param ctx the parse tree
   */
  void enterPort(URLParser.PortContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#port}.
   *
   * @param ctx the parse tree
   */
  void exitPort(URLParser.PortContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#path}.
   *
   * @param ctx the parse tree
   */
  void enterPath(URLParser.PathContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#path}.
   *
   * @param ctx the parse tree
   */
  void exitPath(URLParser.PathContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#user}.
   *
   * @param ctx the parse tree
   */
  void enterUser(URLParser.UserContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#user}.
   *
   * @param ctx the parse tree
   */
  void exitUser(URLParser.UserContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#login}.
   *
   * @param ctx the parse tree
   */
  void enterLogin(URLParser.LoginContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#login}.
   *
   * @param ctx the parse tree
   */
  void exitLogin(URLParser.LoginContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#password}.
   *
   * @param ctx the parse tree
   */
  void enterPassword(URLParser.PasswordContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#password}.
   *
   * @param ctx the parse tree
   */
  void exitPassword(URLParser.PasswordContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#frag}.
   *
   * @param ctx the parse tree
   */
  void enterFrag(URLParser.FragContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#frag}.
   *
   * @param ctx the parse tree
   */
  void exitFrag(URLParser.FragContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#query}.
   *
   * @param ctx the parse tree
   */
  void enterQuery(URLParser.QueryContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#query}.
   *
   * @param ctx the parse tree
   */
  void exitQuery(URLParser.QueryContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#search}.
   *
   * @param ctx the parse tree
   */
  void enterSearch(URLParser.SearchContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#search}.
   *
   * @param ctx the parse tree
   */
  void exitSearch(URLParser.SearchContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#searchparameter}.
   *
   * @param ctx the parse tree
   */
  void enterSearchparameter(URLParser.SearchparameterContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#searchparameter}.
   *
   * @param ctx the parse tree
   */
  void exitSearchparameter(URLParser.SearchparameterContext ctx);

  /**
   * Enter a parse tree produced by {@link URLParser#string}.
   *
   * @param ctx the parse tree
   */
  void enterString(URLParser.StringContext ctx);

  /**
   * Exit a parse tree produced by {@link URLParser#string}.
   *
   * @param ctx the parse tree
   */
  void exitString(URLParser.StringContext ctx);
}
