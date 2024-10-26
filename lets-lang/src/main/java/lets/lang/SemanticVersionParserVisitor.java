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
 * SemanticVersionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface SemanticVersionParserVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link SemanticVersionParser#tag}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTag(SemanticVersionParser.TagContext ctx);

  /**
   * Visit a parse tree produced by the {@code BuildNumber} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBuildNumber(SemanticVersionParser.BuildNumberContext ctx);

  /**
   * Visit a parse tree produced by the {@code BuildIdentifierExtended} labeled alternative in
   * {@link SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBuildIdentifierExtended(SemanticVersionParser.BuildIdentifierExtendedContext ctx);

  /**
   * Visit a parse tree produced by the {@code BuildDash} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBuildDash(SemanticVersionParser.BuildDashContext ctx);

  /**
   * Visit a parse tree produced by the {@code BuildIdentifier} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBuildIdentifier(SemanticVersionParser.BuildIdentifierContext ctx);

  /**
   * Visit a parse tree produced by the {@code BuildTagged} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBuildTagged(SemanticVersionParser.BuildTaggedContext ctx);

  /**
   * Visit a parse tree produced by the {@code PreReleaseDash} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPreReleaseDash(SemanticVersionParser.PreReleaseDashContext ctx);

  /**
   * Visit a parse tree produced by the {@code PreReleaseIdentifier} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPreReleaseIdentifier(SemanticVersionParser.PreReleaseIdentifierContext ctx);

  /**
   * Visit a parse tree produced by the {@code PreReleaseTagged} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPreReleaseTagged(SemanticVersionParser.PreReleaseTaggedContext ctx);

  /**
   * Visit a parse tree produced by the {@code PreReleaseIdentifierExtended} labeled alternative in
   * {@link SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPreReleaseIdentifierExtended(
      SemanticVersionParser.PreReleaseIdentifierExtendedContext ctx);

  /**
   * Visit a parse tree produced by the {@code PreReleaseNumber} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPreReleaseNumber(SemanticVersionParser.PreReleaseNumberContext ctx);

  /**
   * Visit a parse tree produced by {@link SemanticVersionParser#versionCore}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVersionCore(SemanticVersionParser.VersionCoreContext ctx);

  /**
   * Visit a parse tree produced by {@link SemanticVersionParser#semver}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSemver(SemanticVersionParser.SemverContext ctx);
}
