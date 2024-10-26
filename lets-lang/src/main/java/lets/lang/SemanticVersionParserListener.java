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

/**
 * This interface defines a complete listener for a parse tree produced by {@link
 * SemanticVersionParser}.
 */
public interface SemanticVersionParserListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link SemanticVersionParser#tag}.
   *
   * @param ctx the parse tree
   */
  void enterTag(SemanticVersionParser.TagContext ctx);

  /**
   * Exit a parse tree produced by {@link SemanticVersionParser#tag}.
   *
   * @param ctx the parse tree
   */
  void exitTag(SemanticVersionParser.TagContext ctx);

  /**
   * Enter a parse tree produced by the {@code BuildNumber} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   */
  void enterBuildNumber(SemanticVersionParser.BuildNumberContext ctx);

  /**
   * Exit a parse tree produced by the {@code BuildNumber} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   */
  void exitBuildNumber(SemanticVersionParser.BuildNumberContext ctx);

  /**
   * Enter a parse tree produced by the {@code BuildIdentifierExtended} labeled alternative in
   * {@link SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   */
  void enterBuildIdentifierExtended(SemanticVersionParser.BuildIdentifierExtendedContext ctx);

  /**
   * Exit a parse tree produced by the {@code BuildIdentifierExtended} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   */
  void exitBuildIdentifierExtended(SemanticVersionParser.BuildIdentifierExtendedContext ctx);

  /**
   * Enter a parse tree produced by the {@code BuildDash} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   */
  void enterBuildDash(SemanticVersionParser.BuildDashContext ctx);

  /**
   * Exit a parse tree produced by the {@code BuildDash} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   */
  void exitBuildDash(SemanticVersionParser.BuildDashContext ctx);

  /**
   * Enter a parse tree produced by the {@code BuildIdentifier} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   */
  void enterBuildIdentifier(SemanticVersionParser.BuildIdentifierContext ctx);

  /**
   * Exit a parse tree produced by the {@code BuildIdentifier} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   */
  void exitBuildIdentifier(SemanticVersionParser.BuildIdentifierContext ctx);

  /**
   * Enter a parse tree produced by the {@code BuildTagged} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   */
  void enterBuildTagged(SemanticVersionParser.BuildTaggedContext ctx);

  /**
   * Exit a parse tree produced by the {@code BuildTagged} labeled alternative in {@link
   * SemanticVersionParser#build}.
   *
   * @param ctx the parse tree
   */
  void exitBuildTagged(SemanticVersionParser.BuildTaggedContext ctx);

  /**
   * Enter a parse tree produced by the {@code PreReleaseDash} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   */
  void enterPreReleaseDash(SemanticVersionParser.PreReleaseDashContext ctx);

  /**
   * Exit a parse tree produced by the {@code PreReleaseDash} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   */
  void exitPreReleaseDash(SemanticVersionParser.PreReleaseDashContext ctx);

  /**
   * Enter a parse tree produced by the {@code PreReleaseIdentifier} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   */
  void enterPreReleaseIdentifier(SemanticVersionParser.PreReleaseIdentifierContext ctx);

  /**
   * Exit a parse tree produced by the {@code PreReleaseIdentifier} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   */
  void exitPreReleaseIdentifier(SemanticVersionParser.PreReleaseIdentifierContext ctx);

  /**
   * Enter a parse tree produced by the {@code PreReleaseTagged} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   */
  void enterPreReleaseTagged(SemanticVersionParser.PreReleaseTaggedContext ctx);

  /**
   * Exit a parse tree produced by the {@code PreReleaseTagged} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   */
  void exitPreReleaseTagged(SemanticVersionParser.PreReleaseTaggedContext ctx);

  /**
   * Enter a parse tree produced by the {@code PreReleaseIdentifierExtended} labeled alternative in
   * {@link SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   */
  void enterPreReleaseIdentifierExtended(
      SemanticVersionParser.PreReleaseIdentifierExtendedContext ctx);

  /**
   * Exit a parse tree produced by the {@code PreReleaseIdentifierExtended} labeled alternative in
   * {@link SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   */
  void exitPreReleaseIdentifierExtended(
      SemanticVersionParser.PreReleaseIdentifierExtendedContext ctx);

  /**
   * Enter a parse tree produced by the {@code PreReleaseNumber} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   */
  void enterPreReleaseNumber(SemanticVersionParser.PreReleaseNumberContext ctx);

  /**
   * Exit a parse tree produced by the {@code PreReleaseNumber} labeled alternative in {@link
   * SemanticVersionParser#preRelease}.
   *
   * @param ctx the parse tree
   */
  void exitPreReleaseNumber(SemanticVersionParser.PreReleaseNumberContext ctx);

  /**
   * Enter a parse tree produced by {@link SemanticVersionParser#versionCore}.
   *
   * @param ctx the parse tree
   */
  void enterVersionCore(SemanticVersionParser.VersionCoreContext ctx);

  /**
   * Exit a parse tree produced by {@link SemanticVersionParser#versionCore}.
   *
   * @param ctx the parse tree
   */
  void exitVersionCore(SemanticVersionParser.VersionCoreContext ctx);

  /**
   * Enter a parse tree produced by {@link SemanticVersionParser#semver}.
   *
   * @param ctx the parse tree
   */
  void enterSemver(SemanticVersionParser.SemverContext ctx);

  /**
   * Exit a parse tree produced by {@link SemanticVersionParser#semver}.
   *
   * @param ctx the parse tree
   */
  void exitSemver(SemanticVersionParser.SemverContext ctx);
}
