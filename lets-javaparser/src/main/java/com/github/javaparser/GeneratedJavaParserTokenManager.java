/*
 * Copyright (c) 2007-2010 zhoupan (https://github.com/zhoupan).
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
package com.github.javaparser;

import static com.github.javaparser.GeneratedJavaParser.*;
import static com.github.javaparser.GeneratedJavaParserTokenManagerBase.*;
import static com.github.javaparser.Position.*;
import static com.github.javaparser.Range.*;
import static com.github.javaparser.ast.NodeList.*;
import static com.github.javaparser.ast.stmt.SwitchEntry.Type.*;
import static com.github.javaparser.ast.type.ArrayType.*;
import static com.github.javaparser.utils.Utils.*;

import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.modules.*;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.type.*;
import com.github.javaparser.utils.*;
import java.io.*;
import java.util.*;

/** Token Manager. */
@SuppressWarnings("unused")
public class GeneratedJavaParserTokenManager implements GeneratedJavaParserConstants {
  private List<JavaToken> tokens = new ArrayList<JavaToken>();
  private CommentsCollection commentsCollection = new CommentsCollection();
  private JavaToken homeToken;
  private Stack<Token> tokenWorkStack = new Stack<Token>();
  private boolean storeTokens;
  private boolean yieldSupported = false;

  void reset() {
    tokens = new ArrayList<JavaToken>();
    commentsCollection = new CommentsCollection();
    homeToken = null;
  }

  List<JavaToken> getTokens() {
    if (storeTokens) {
      return tokens;
    }
    return null;
  }

  CommentsCollection getCommentsCollection() {
    return commentsCollection;
  }

  /* Get the very first token in the file */
  JavaToken getHomeToken() {
    return homeToken;
  }

  /* Makes the parser keep a list of tokens */
  public void setStoreTokens(boolean storeTokens) {
    this.storeTokens = storeTokens;
  }

  public void setYieldSupported() {
    yieldSupported = true;
  }

  private void CommonTokenAction(Token token) {
    // Use an intermediary stack to avoid recursion, see issue 1003
    do {
      tokenWorkStack.push(token);
      token = token.specialToken;
    } while (token != null);

    // The stack is now filled with tokens in left-to-right order. Process them.
    while (!tokenWorkStack.empty()) {
      token = tokenWorkStack.pop();
      token.javaToken = new JavaToken(token, tokens);

      if (storeTokens) {
        tokens.add(token.javaToken);
      }

      if (homeToken == null) {
        homeToken = token.javaToken;
      }

      if (TokenTypes.isComment(token.kind)) {
        Comment comment = createCommentFromToken(token);
        commentsCollection.addComment(comment);
      }
    }
  }

  private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1, long active2) {
    switch (pos) {
      case 0:
        if ((active1 & 0x80000000L) != 0x0L) return 152;
        if ((active0 & 0xfffffffffffff800L) != 0x0L || (active1 & 0xffffL) != 0x0L) {
          jjmatchedKind = 98;
          return 153;
        }
        if ((active1 & 0x600000000000L) != 0x0L) return 2;
        if ((active0 & 0x80L) != 0x0L || (active2 & 0x1008L) != 0x0L) return 67;
        return -1;
      case 1:
        if ((active1 & 0x80000000L) != 0x0L) {
          if (jjmatchedPos != 1) {
            jjmatchedKind = 94;
            jjmatchedPos = 1;
          }
          return -1;
        }
        if ((active0 & 0x401800000L) != 0x0L || (active1 & 0x40L) != 0x0L) return 153;
        if ((active0 & 0x80L) != 0x0L) return 69;
        if ((active0 & 0xfffffffbfe7ff800L) != 0x0L || (active1 & 0xffbfL) != 0x0L) {
          if (jjmatchedPos != 1) {
            jjmatchedKind = 98;
            jjmatchedPos = 1;
          }
          return 153;
        }
        return -1;
      case 2:
        if ((active0 & 0xfffffb3aff7ff800L) != 0x0L || (active1 & 0xffbeL) != 0x0L) {
          if (jjmatchedPos != 2) {
            jjmatchedKind = 98;
            jjmatchedPos = 2;
          }
          return 153;
        }
        if ((active1 & 0x80000000L) != 0x0L) {
          if (jjmatchedPos < 1) {
            jjmatchedKind = 94;
            jjmatchedPos = 1;
          }
          return -1;
        }
        if ((active0 & 0x4c100000000L) != 0x0L || (active1 & 0x1L) != 0x0L) return 153;
        return -1;
      case 3:
        if ((active0 & 0x8800110206058000L) != 0x0L || (active1 & 0x8782L) != 0x0L) return 153;
        if ((active0 & 0x77ffe2b8f97a7800L) != 0x0L || (active1 & 0x783cL) != 0x0L) {
          if (jjmatchedPos != 3) {
            jjmatchedKind = 98;
            jjmatchedPos = 3;
          }
          return 153;
        }
        if ((active0 & 0x80000000000L) != 0x0L) {
          if (jjmatchedPos < 2) {
            jjmatchedKind = 98;
            jjmatchedPos = 2;
          }
          return -1;
        }
        return -1;
      case 4:
        if ((active0 & 0x46dfe2b809603800L) != 0x0L || (active1 & 0x7824L) != 0x0L) {
          if (jjmatchedPos != 4) {
            jjmatchedKind = 98;
            jjmatchedPos = 4;
          }
          return 153;
        }
        if ((active0 & 0x31200000f01a4000L) != 0x0L || (active1 & 0x218L) != 0x0L) return 153;
        if ((active0 & 0x80000000000L) != 0x0L) {
          if (jjmatchedPos < 2) {
            jjmatchedKind = 98;
            jjmatchedPos = 2;
          }
          return -1;
        }
        return -1;
      case 5:
        if ((active0 & 0x4481e0a848602800L) != 0x0L || (active1 & 0x7024L) != 0x0L) {
          jjmatchedKind = 98;
          jjmatchedPos = 5;
          return 153;
        }
        if ((active0 & 0x225e021001001000L) != 0x0L || (active1 & 0x800L) != 0x0L) return 153;
        if ((active0 & 0x80000000000L) != 0x0L) {
          if (jjmatchedPos < 2) {
            jjmatchedKind = 98;
            jjmatchedPos = 2;
          }
          return -1;
        }
        return -1;
      case 6:
        if ((active0 & 0xe00048402000L) != 0x0L || (active1 & 0x1000L) != 0x0L) return 153;
        if ((active0 & 0x80000000000L) != 0x0L) {
          if (jjmatchedPos < 2) {
            jjmatchedKind = 98;
            jjmatchedPos = 2;
          }
          return -1;
        }
        if ((active0 & 0x448100a800200800L) != 0x0L || (active1 & 0x6024L) != 0x0L) {
          jjmatchedKind = 98;
          jjmatchedPos = 6;
          return 153;
        }
        return -1;
      case 7:
        if ((active0 & 0x440100a800000000L) != 0x0L || (active1 & 0x4000L) != 0x0L) {
          jjmatchedKind = 98;
          jjmatchedPos = 7;
          return 153;
        }
        if ((active0 & 0x80000000200800L) != 0x0L || (active1 & 0x2024L) != 0x0L) return 153;
        if ((active0 & 0x80000000000L) != 0x0L) {
          if (jjmatchedPos < 2) {
            jjmatchedKind = 98;
            jjmatchedPos = 2;
          }
          return -1;
        }
        return -1;
      case 8:
        if ((active0 & 0x4001008000000000L) != 0x0L) return 153;
        if ((active0 & 0x400002800000000L) != 0x0L || (active1 & 0x4000L) != 0x0L) {
          jjmatchedKind = 98;
          jjmatchedPos = 8;
          return 153;
        }
        if ((active0 & 0x80000000000L) != 0x0L) {
          if (jjmatchedPos < 2) {
            jjmatchedKind = 98;
            jjmatchedPos = 2;
          }
          return -1;
        }
        return -1;
      case 9:
        if ((active0 & 0x2800000000L) != 0x0L || (active1 & 0x4000L) != 0x0L) return 153;
        if ((active0 & 0x400000000000000L) != 0x0L) {
          jjmatchedKind = 98;
          jjmatchedPos = 9;
          return 153;
        }
        if ((active0 & 0x80000000000L) != 0x0L) {
          if (jjmatchedPos < 2) {
            jjmatchedKind = 98;
            jjmatchedPos = 2;
          }
          return -1;
        }
        return -1;
      case 10:
        if ((active0 & 0x400000000000000L) != 0x0L) {
          jjmatchedKind = 98;
          jjmatchedPos = 10;
          return 153;
        }
        return -1;
      default:
        return -1;
    }
  }

  private final int jjStartNfa_0(int pos, long active0, long active1, long active2) {
    return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1, active2), pos + 1);
  }

  private int jjStopAtPos(int pos, int kind) {
    jjmatchedKind = kind;
    jjmatchedPos = pos;
    return pos + 1;
  }

  private int jjMoveStringLiteralDfa0_0() {
    switch (curChar) {
      case 10:
        return jjStopAtPos(0, 3);
      case 13:
        jjmatchedKind = 4;
        return jjMoveStringLiteralDfa1_0(0x4L, 0x0L, 0x0L);
      case 26:
        return jjStopAtPos(0, 151);
      case '!':
        jjmatchedKind = 115;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x800000000000000L, 0x0L);
      case '"':
        return jjMoveStringLiteralDfa1_0(0x0L, 0x80000000L, 0x0L);
      case '%':
        jjmatchedKind = 135;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x10000L);
      case '&':
        jjmatchedKind = 132;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x1000000000000000L, 0x2000L);
      case '(':
        return jjStopAtPos(0, 101);
      case ')':
        return jjStopAtPos(0, 102);
      case '*':
        jjmatchedKind = 130;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x800L);
      case '+':
        jjmatchedKind = 128;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x4000000000000000L, 0x200L);
      case ',':
        return jjStopAtPos(0, 108);
      case '-':
        jjmatchedKind = 129;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x8080000000000000L, 0x400L);
      case '.':
        jjmatchedKind = 109;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x400000000000L, 0x0L);
      case '/':
        jjmatchedKind = 131;
        return jjMoveStringLiteralDfa1_0(0x80L, 0x0L, 0x1000L);
      case ':':
        jjmatchedKind = 118;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x1000000000000L, 0x0L);
      case ';':
        return jjStopAtPos(0, 107);
      case '<':
        jjmatchedKind = 114;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x400000000000000L, 0x20100L);
      case '=':
        jjmatchedKind = 113;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x100000000000000L, 0x0L);
      case '>':
        jjmatchedKind = 150;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x200000000000000L, 0x3c0000L);
      case '?':
        return jjStopAtPos(0, 117);
      case '@':
        return jjStopAtPos(0, 111);
      case '[':
        return jjStopAtPos(0, 105);
      case ']':
        return jjStopAtPos(0, 106);
      case '^':
        jjmatchedKind = 134;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x8000L);
      case 'a':
        return jjMoveStringLiteralDfa1_0(0x1800L, 0x0L, 0x0L);
      case 'b':
        return jjMoveStringLiteralDfa1_0(0xe000L, 0x0L, 0x0L);
      case 'c':
        return jjMoveStringLiteralDfa1_0(0x3f0000L, 0x0L, 0x0L);
      case 'd':
        return jjMoveStringLiteralDfa1_0(0x1c00000L, 0x0L, 0x0L);
      case 'e':
        return jjMoveStringLiteralDfa1_0(0xe000000L, 0x1000L, 0x0L);
      case 'f':
        return jjMoveStringLiteralDfa1_0(0x1f0000000L, 0x0L, 0x0L);
      case 'g':
        return jjMoveStringLiteralDfa1_0(0x200000000L, 0x0L, 0x0L);
      case 'i':
        return jjMoveStringLiteralDfa1_0(0xfc00000000L, 0x0L, 0x0L);
      case 'l':
        return jjMoveStringLiteralDfa1_0(0x10000000000L, 0x0L, 0x0L);
      case 'm':
        return jjMoveStringLiteralDfa1_0(0x0L, 0x800L, 0x0L);
      case 'n':
        return jjMoveStringLiteralDfa1_0(0x1e0000000000L, 0x0L, 0x0L);
      case 'o':
        return jjMoveStringLiteralDfa1_0(0x0L, 0x300L, 0x0L);
      case 'p':
        return jjMoveStringLiteralDfa1_0(0x3e00000000000L, 0x2000L, 0x0L);
      case 'r':
        return jjMoveStringLiteralDfa1_0(0xc000000000000L, 0x20L, 0x0L);
      case 's':
        return jjMoveStringLiteralDfa1_0(0x7f0000000000000L, 0x0L, 0x0L);
      case 't':
        return jjMoveStringLiteralDfa1_0(0xf800000000000000L, 0x4041L, 0x0L);
      case 'u':
        return jjMoveStringLiteralDfa1_0(0x0L, 0x400L, 0x0L);
      case 'v':
        return jjMoveStringLiteralDfa1_0(0x0L, 0x6L, 0x0L);
      case 'w':
        return jjMoveStringLiteralDfa1_0(0x0L, 0x8088L, 0x0L);
      case 'y':
        return jjMoveStringLiteralDfa1_0(0x0L, 0x10L, 0x0L);
      case '{':
        return jjStopAtPos(0, 103);
      case '|':
        jjmatchedKind = 133;
        return jjMoveStringLiteralDfa1_0(0x0L, 0x2000000000000000L, 0x4000L);
      case '}':
        return jjStopAtPos(0, 104);
      case '~':
        return jjStopAtPos(0, 116);
      default:
        return jjMoveNfa_0(0, 0);
    }
  }

  private int jjMoveStringLiteralDfa1_0(long active0, long active1, long active2) {
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1, active2);
      return 1;
    }
    switch (curChar) {
      case 10:
        if ((active0 & 0x4L) != 0x0L) return jjStopAtPos(1, 2);
        break;
      case '"':
        return jjMoveStringLiteralDfa2_0(active0, 0x0L, active1, 0x80000000L, active2, 0x0L);
      case '&':
        if ((active1 & 0x1000000000000000L) != 0x0L) return jjStopAtPos(1, 124);
        break;
      case '*':
        if ((active0 & 0x80L) != 0x0L) return jjStartNfaWithStates_0(1, 7, 69);
        break;
      case '+':
        if ((active1 & 0x4000000000000000L) != 0x0L) return jjStopAtPos(1, 126);
        break;
      case '-':
        if ((active1 & 0x8000000000000000L) != 0x0L) return jjStopAtPos(1, 127);
        break;
      case '.':
        return jjMoveStringLiteralDfa2_0(active0, 0x0L, active1, 0x400000000000L, active2, 0x0L);
      case ':':
        if ((active1 & 0x1000000000000L) != 0x0L) return jjStopAtPos(1, 112);
        break;
      case '<':
        if ((active2 & 0x100L) != 0x0L) {
          jjmatchedKind = 136;
          jjmatchedPos = 1;
        }
        return jjMoveStringLiteralDfa2_0(active0, 0x0L, active1, 0x0L, active2, 0x20000L);
      case '=':
        if ((active1 & 0x100000000000000L) != 0x0L) return jjStopAtPos(1, 120);
        else if ((active1 & 0x200000000000000L) != 0x0L) return jjStopAtPos(1, 121);
        else if ((active1 & 0x400000000000000L) != 0x0L) return jjStopAtPos(1, 122);
        else if ((active1 & 0x800000000000000L) != 0x0L) return jjStopAtPos(1, 123);
        else if ((active2 & 0x200L) != 0x0L) return jjStopAtPos(1, 137);
        else if ((active2 & 0x400L) != 0x0L) return jjStopAtPos(1, 138);
        else if ((active2 & 0x800L) != 0x0L) return jjStopAtPos(1, 139);
        else if ((active2 & 0x1000L) != 0x0L) return jjStopAtPos(1, 140);
        else if ((active2 & 0x2000L) != 0x0L) return jjStopAtPos(1, 141);
        else if ((active2 & 0x4000L) != 0x0L) return jjStopAtPos(1, 142);
        else if ((active2 & 0x8000L) != 0x0L) return jjStopAtPos(1, 143);
        else if ((active2 & 0x10000L) != 0x0L) return jjStopAtPos(1, 144);
        break;
      case '>':
        if ((active1 & 0x80000000000000L) != 0x0L) return jjStopAtPos(1, 119);
        else if ((active2 & 0x200000L) != 0x0L) {
          jjmatchedKind = 149;
          jjmatchedPos = 1;
        }
        return jjMoveStringLiteralDfa2_0(active0, 0x0L, active1, 0x0L, active2, 0x1c0000L);
      case 'a':
        return jjMoveStringLiteralDfa2_0(active0, 0x220010030000L, active1, 0x0L, active2, 0x0L);
      case 'b':
        return jjMoveStringLiteralDfa2_0(active0, 0x800L, active1, 0x0L, active2, 0x0L);
      case 'e':
        return jjMoveStringLiteralDfa2_0(active0, 0x1c440000400000L, active1, 0x20L, active2, 0x0L);
      case 'f':
        if ((active0 & 0x400000000L) != 0x0L) return jjStartNfaWithStates_0(1, 34, 153);
        break;
      case 'h':
        return jjMoveStringLiteralDfa2_0(
            active0, 0x3820000000040000L, active1, 0x8008L, active2, 0x0L);
      case 'i':
        return jjMoveStringLiteralDfa2_0(active0, 0x60000000L, active1, 0x90L, active2, 0x0L);
      case 'l':
        return jjMoveStringLiteralDfa2_0(active0, 0x82080000L, active1, 0x0L, active2, 0x0L);
      case 'm':
        return jjMoveStringLiteralDfa2_0(active0, 0x1800000000L, active1, 0x0L, active2, 0x0L);
      case 'n':
        return jjMoveStringLiteralDfa2_0(active0, 0xe004000000L, active1, 0x0L, active2, 0x0L);
      case 'o':
        if ((active0 & 0x800000L) != 0x0L) {
          jjmatchedKind = 23;
          jjmatchedPos = 1;
        } else if ((active1 & 0x40L) != 0x0L) return jjStartNfaWithStates_0(1, 70, 153);
        return jjMoveStringLiteralDfa2_0(active0, 0x90301302000L, active1, 0x806L, active2, 0x0L);
      case 'p':
        return jjMoveStringLiteralDfa2_0(active0, 0x0L, active1, 0x300L, active2, 0x0L);
      case 'r':
        return jjMoveStringLiteralDfa2_0(
            active0, 0xc001800000004000L, active1, 0x6001L, active2, 0x0L);
      case 's':
        return jjMoveStringLiteralDfa2_0(active0, 0x1000L, active1, 0x400L, active2, 0x0L);
      case 't':
        return jjMoveStringLiteralDfa2_0(active0, 0xc0000000000000L, active1, 0x0L, active2, 0x0L);
      case 'u':
        return jjMoveStringLiteralDfa2_0(active0, 0x102100000000000L, active1, 0x0L, active2, 0x0L);
      case 'w':
        return jjMoveStringLiteralDfa2_0(active0, 0x200000000000000L, active1, 0x0L, active2, 0x0L);
      case 'x':
        return jjMoveStringLiteralDfa2_0(active0, 0x8000000L, active1, 0x1000L, active2, 0x0L);
      case 'y':
        return jjMoveStringLiteralDfa2_0(active0, 0x400000000008000L, active1, 0x0L, active2, 0x0L);
      case '|':
        if ((active1 & 0x2000000000000000L) != 0x0L) return jjStopAtPos(1, 125);
        break;
      default:
        break;
    }
    return jjStartNfa_0(0, active0, active1, active2);
  }

  private int jjMoveStringLiteralDfa2_0(
      long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_0(0, old0, old1, old2);
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, active1, active2);
      return 2;
    }
    switch (curChar) {
      case '"':
        if ((active1 & 0x80000000L) != 0x0L) return jjStopAtPos(2, 95);
        break;
      case '.':
        if ((active1 & 0x400000000000L) != 0x0L) return jjStopAtPos(2, 110);
        break;
      case '=':
        if ((active2 & 0x20000L) != 0x0L) return jjStopAtPos(2, 145);
        else if ((active2 & 0x40000L) != 0x0L) return jjStopAtPos(2, 146);
        break;
      case '>':
        if ((active2 & 0x100000L) != 0x0L) {
          jjmatchedKind = 148;
          jjmatchedPos = 2;
        }
        return jjMoveStringLiteralDfa3_0(active0, 0x0L, active1, 0x0L, active2, 0x80000L);
      case 'a':
        return jjMoveStringLiteralDfa3_0(
            active0, 0x40500000000c0000L, active1, 0x4000L, active2, 0x0L);
      case 'b':
        return jjMoveStringLiteralDfa3_0(active0, 0x2000000000000L, active1, 0x0L, active2, 0x0L);
      case 'c':
        return jjMoveStringLiteralDfa3_0(active0, 0x4200000000000L, active1, 0x0L, active2, 0x0L);
      case 'd':
        return jjMoveStringLiteralDfa3_0(active0, 0x0L, active1, 0x800L, active2, 0x0L);
      case 'e':
        return jjMoveStringLiteralDfa3_0(active0, 0x4000L, active1, 0x8710L, active2, 0x0L);
      case 'f':
        return jjMoveStringLiteralDfa3_0(active0, 0x400000L, active1, 0x0L, active2, 0x0L);
      case 'i':
        return jjMoveStringLiteralDfa3_0(active0, 0xa00800000000000L, active1, 0xaL, active2, 0x0L);
      case 'l':
        return jjMoveStringLiteralDfa3_0(active0, 0x100010000000L, active1, 0x4L, active2, 0x0L);
      case 'n':
        return jjMoveStringLiteralDfa3_0(active0, 0x400090060300000L, active1, 0x0L, active2, 0x0L);
      case 'o':
        return jjMoveStringLiteralDfa3_0(
            active0, 0x21000080002000L, active1, 0x2000L, active2, 0x0L);
      case 'p':
        return jjMoveStringLiteralDfa3_0(
            active0, 0x100001800000000L, active1, 0x1000L, active2, 0x0L);
      case 'q':
        return jjMoveStringLiteralDfa3_0(active0, 0x0L, active1, 0x20L, active2, 0x0L);
      case 'r':
        if ((active0 & 0x100000000L) != 0x0L) return jjStartNfaWithStates_0(2, 32, 153);
        return jjMoveStringLiteralDfa3_0(
            active0, 0x3080400000000000L, active1, 0x0L, active2, 0x0L);
      case 's':
        return jjMoveStringLiteralDfa3_0(active0, 0x2002011800L, active1, 0x0L, active2, 0x0L);
      case 't':
        if ((active0 & 0x4000000000L) != 0x0L) {
          jjmatchedKind = 38;
          jjmatchedPos = 2;
        }
        return jjMoveStringLiteralDfa3_0(active0, 0x8028208028000L, active1, 0x80L, active2, 0x0L);
      case 'u':
        return jjMoveStringLiteralDfa3_0(
            active0, 0x8000000005000000L, active1, 0x0L, active2, 0x0L);
      case 'w':
        if ((active0 & 0x40000000000L) != 0x0L) return jjStartNfaWithStates_0(2, 42, 153);
        break;
      case 'y':
        if ((active1 & 0x1L) != 0x0L) return jjStartNfaWithStates_0(2, 64, 153);
        break;
      default:
        break;
    }
    return jjStartNfa_0(1, active0, active1, active2);
  }

  private int jjMoveStringLiteralDfa3_0(
      long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_0(1, old0, old1, old2);
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, active1, active2);
      return 3;
    }
    switch (curChar) {
      case '-':
        return jjMoveStringLiteralDfa4_0(active0, 0x80000000000L, active1, 0x0L, active2, 0x0L);
      case '=':
        if ((active2 & 0x80000L) != 0x0L) return jjStopAtPos(3, 147);
        break;
      case 'a':
        return jjMoveStringLiteralDfa4_0(active0, 0xe0404000L, active1, 0x4L, active2, 0x0L);
      case 'b':
        return jjMoveStringLiteralDfa4_0(active0, 0x1000000L, active1, 0x0L, active2, 0x0L);
      case 'c':
        return jjMoveStringLiteralDfa4_0(active0, 0x400000000020000L, active1, 0x0L, active2, 0x0L);
      case 'd':
        if ((active1 & 0x2L) != 0x0L) return jjStartNfaWithStates_0(3, 65, 153);
        break;
      case 'e':
        if ((active0 & 0x8000L) != 0x0L) return jjStartNfaWithStates_0(3, 15, 153);
        else if ((active0 & 0x10000L) != 0x0L) return jjStartNfaWithStates_0(3, 16, 153);
        else if ((active0 & 0x2000000L) != 0x0L) return jjStartNfaWithStates_0(3, 25, 153);
        else if ((active0 & 0x8000000000000000L) != 0x0L) return jjStartNfaWithStates_0(3, 63, 153);
        return jjMoveStringLiteralDfa4_0(active0, 0x100008008001000L, active1, 0x0L, active2, 0x0L);
      case 'g':
        if ((active0 & 0x10000000000L) != 0x0L) return jjStartNfaWithStates_0(3, 40, 153);
        break;
      case 'h':
        if ((active1 & 0x80L) != 0x0L) return jjStartNfaWithStates_0(3, 71, 153);
        break;
      case 'i':
        return jjMoveStringLiteralDfa4_0(active0, 0x80020000000000L, active1, 0x0L, active2, 0x0L);
      case 'k':
        return jjMoveStringLiteralDfa4_0(active0, 0x200000000000L, active1, 0x0L, active2, 0x0L);
      case 'l':
        if ((active0 & 0x100000000000L) != 0x0L) return jjStartNfaWithStates_0(3, 44, 153);
        return jjMoveStringLiteralDfa4_0(active0, 0x12000800002000L, active1, 0x18L, active2, 0x0L);
      case 'm':
        if ((active0 & 0x4000000L) != 0x0L) return jjStartNfaWithStates_0(3, 26, 153);
        return jjMoveStringLiteralDfa4_0(active0, 0x400000000000L, active1, 0x0L, active2, 0x0L);
      case 'n':
        if ((active1 & 0x100L) != 0x0L) {
          jjmatchedKind = 72;
          jjmatchedPos = 3;
        } else if ((active1 & 0x8000L) != 0x0L) return jjStartNfaWithStates_0(3, 79, 153);
        return jjMoveStringLiteralDfa4_0(
            active0, 0x4000000000000000L, active1, 0x4200L, active2, 0x0L);
      case 'o':
        if ((active0 & 0x200000000L) != 0x0L) return jjStartNfaWithStates_0(3, 33, 153);
        return jjMoveStringLiteralDfa4_0(
            active0, 0x3004001000000000L, active1, 0x1000L, active2, 0x0L);
      case 'r':
        if ((active0 & 0x40000L) != 0x0L) return jjStartNfaWithStates_0(3, 18, 153);
        return jjMoveStringLiteralDfa4_0(active0, 0x20000000000000L, active1, 0x0L, active2, 0x0L);
      case 's':
        if ((active0 & 0x800000000000000L) != 0x0L) return jjStartNfaWithStates_0(3, 59, 153);
        else if ((active1 & 0x400L) != 0x0L) return jjStartNfaWithStates_0(3, 74, 153);
        return jjMoveStringLiteralDfa4_0(active0, 0x10180000L, active1, 0x0L, active2, 0x0L);
      case 't':
        return jjMoveStringLiteralDfa4_0(active0, 0x241002000200800L, active1, 0x0L, active2, 0x0L);
      case 'u':
        return jjMoveStringLiteralDfa4_0(active0, 0x8000000000000L, active1, 0x820L, active2, 0x0L);
      case 'v':
        return jjMoveStringLiteralDfa4_0(active0, 0x800000000000L, active1, 0x2000L, active2, 0x0L);
      default:
        break;
    }
    return jjStartNfa_0(2, active0, active1, active2);
  }

  private int jjMoveStringLiteralDfa4_0(
      long old0, long active0, long old1, long active1, long old2, long active2) {
    if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_0(2, old0, old1, old2);
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, active1, 0L);
      return 4;
    }
    switch (curChar) {
      case 'a':
        return jjMoveStringLiteralDfa5_0(active0, 0xa02000000000L, active1, 0x0L);
      case 'c':
        return jjMoveStringLiteralDfa5_0(active0, 0x280000000000000L, active1, 0x0L);
      case 'd':
        if ((active1 & 0x10L) != 0x0L) return jjStartNfaWithStates_0(4, 68, 153);
        break;
      case 'e':
        if ((active0 & 0x10000000L) != 0x0L) return jjStartNfaWithStates_0(4, 28, 153);
        else if ((active1 & 0x8L) != 0x0L) return jjStartNfaWithStates_0(4, 67, 153);
        return jjMoveStringLiteralDfa5_0(active0, 0x11000800002000L, active1, 0x0L);
      case 'h':
        if ((active0 & 0x20000L) != 0x0L) return jjStartNfaWithStates_0(4, 17, 153);
        return jjMoveStringLiteralDfa5_0(active0, 0x400000000000000L, active1, 0x0L);
      case 'i':
        return jjMoveStringLiteralDfa5_0(active0, 0x42400000200000L, active1, 0x2020L);
      case 'k':
        if ((active0 & 0x4000L) != 0x0L) return jjStartNfaWithStates_0(4, 14, 153);
        break;
      case 'l':
        if ((active0 & 0x20000000L) != 0x0L) {
          jjmatchedKind = 29;
          jjmatchedPos = 4;
        }
        return jjMoveStringLiteralDfa5_0(active0, 0x41000000L, active1, 0x800L);
      case 'n':
        return jjMoveStringLiteralDfa5_0(active0, 0x8000000L, active1, 0x0L);
      case 'r':
        if ((active0 & 0x100000000000000L) != 0x0L) return jjStartNfaWithStates_0(4, 56, 153);
        return jjMoveStringLiteralDfa5_0(active0, 0xc009000001800L, active1, 0x1000L);
      case 's':
        if ((active0 & 0x80000L) != 0x0L) return jjStartNfaWithStates_0(4, 19, 153);
        else if ((active1 & 0x200L) != 0x0L) return jjStartNfaWithStates_0(4, 73, 153);
        return jjMoveStringLiteralDfa5_0(active0, 0x4000080000000000L, active1, 0x4000L);
      case 't':
        if ((active0 & 0x100000L) != 0x0L) return jjStartNfaWithStates_0(4, 20, 153);
        else if ((active0 & 0x80000000L) != 0x0L) return jjStartNfaWithStates_0(4, 31, 153);
        else if ((active0 & 0x20000000000000L) != 0x0L) return jjStartNfaWithStates_0(4, 53, 153);
        return jjMoveStringLiteralDfa5_0(active0, 0x0L, active1, 0x4L);
      case 'u':
        return jjMoveStringLiteralDfa5_0(active0, 0x400000L, active1, 0x0L);
      case 'v':
        return jjMoveStringLiteralDfa5_0(active0, 0x20000000000L, active1, 0x0L);
      case 'w':
        if ((active0 & 0x1000000000000000L) != 0x0L) {
          jjmatchedKind = 60;
          jjmatchedPos = 4;
        }
        return jjMoveStringLiteralDfa5_0(active0, 0x2000000000000000L, active1, 0x0L);
      default:
        break;
    }
    return jjStartNfa_0(3, active0, active1, 0L);
  }

  private int jjMoveStringLiteralDfa5_0(long old0, long active0, long old1, long active1) {
    if (((active0 &= old0) | (active1 &= old1)) == 0L) return jjStartNfa_0(3, old0, old1, 0L);
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, active1, 0L);
      return 5;
    }
    switch (curChar) {
      case 'a':
        return jjMoveStringLiteralDfa6_0(active0, 0x2800L, active1, 0x0L);
      case 'c':
        if ((active0 & 0x2000000000000L) != 0x0L) return jjStartNfaWithStates_0(5, 49, 153);
        else if ((active0 & 0x40000000000000L) != 0x0L) return jjStartNfaWithStates_0(5, 54, 153);
        return jjMoveStringLiteralDfa6_0(active0, 0x1000000000000L, active1, 0x0L);
      case 'd':
        if ((active0 & 0x4000000000000L) != 0x0L) return jjStartNfaWithStates_0(5, 50, 153);
        else if ((active0 & 0x10000000000000L) != 0x0L) return jjStartNfaWithStates_0(5, 52, 153);
        return jjMoveStringLiteralDfa6_0(active0, 0x8000000L, active1, 0x2000L);
      case 'e':
        if ((active0 & 0x1000000L) != 0x0L) return jjStartNfaWithStates_0(5, 24, 153);
        else if ((active0 & 0x20000000000L) != 0x0L) return jjStartNfaWithStates_0(5, 41, 153);
        else if ((active1 & 0x800L) != 0x0L) return jjStartNfaWithStates_0(5, 75, 153);
        return jjMoveStringLiteralDfa6_0(active0, 0x80000000000L, active1, 0x0L);
      case 'f':
        return jjMoveStringLiteralDfa6_0(active0, 0x8000000000L, active1, 0x0L);
      case 'g':
        return jjMoveStringLiteralDfa6_0(active0, 0x200000000000L, active1, 0x0L);
      case 'h':
        if ((active0 & 0x200000000000000L) != 0x0L) return jjStartNfaWithStates_0(5, 57, 153);
        break;
      case 'i':
        return jjMoveStringLiteralDfa6_0(active0, 0x4000000000000000L, active1, 0x4004L);
      case 'l':
        return jjMoveStringLiteralDfa6_0(active0, 0x40400000L, active1, 0x0L);
      case 'm':
        return jjMoveStringLiteralDfa6_0(active0, 0x800000000L, active1, 0x0L);
      case 'n':
        if ((active0 & 0x8000000000000L) != 0x0L) return jjStartNfaWithStates_0(5, 51, 153);
        return jjMoveStringLiteralDfa6_0(active0, 0x2000200000L, active1, 0x0L);
      case 'r':
        return jjMoveStringLiteralDfa6_0(active0, 0x400000000000000L, active1, 0x20L);
      case 's':
        if ((active0 & 0x2000000000000000L) != 0x0L) return jjStartNfaWithStates_0(5, 61, 153);
        break;
      case 't':
        if ((active0 & 0x1000L) != 0x0L) return jjStartNfaWithStates_0(5, 12, 153);
        else if ((active0 & 0x1000000000L) != 0x0L) return jjStartNfaWithStates_0(5, 36, 153);
        return jjMoveStringLiteralDfa6_0(active0, 0x80c00000000000L, active1, 0x1000L);
      default:
        break;
    }
    return jjStartNfa_0(4, active0, active1, 0L);
  }

  private int jjMoveStringLiteralDfa6_0(long old0, long active0, long old1, long active1) {
    if (((active0 &= old0) | (active1 &= old1)) == 0L) return jjStartNfa_0(4, old0, old1, 0L);
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, active1, 0L);
      return 6;
    }
    switch (curChar) {
      case 'a':
        return jjMoveStringLiteralDfa7_0(active0, 0x88000000000L, active1, 0x0L);
      case 'c':
        return jjMoveStringLiteralDfa7_0(active0, 0x2000000800L, active1, 0x0L);
      case 'e':
        if ((active0 & 0x200000000000L) != 0x0L) return jjStartNfaWithStates_0(6, 45, 153);
        else if ((active0 & 0x800000000000L) != 0x0L) return jjStartNfaWithStates_0(6, 47, 153);
        return jjMoveStringLiteralDfa7_0(active0, 0x4000000800000000L, active1, 0x2020L);
      case 'f':
        return jjMoveStringLiteralDfa7_0(active0, 0x80000000000000L, active1, 0x0L);
      case 'l':
        return jjMoveStringLiteralDfa7_0(active0, 0x0L, active1, 0x4L);
      case 'n':
        if ((active0 & 0x2000L) != 0x0L) return jjStartNfaWithStates_0(6, 13, 153);
        break;
      case 'o':
        return jjMoveStringLiteralDfa7_0(active0, 0x400000000000000L, active1, 0x0L);
      case 's':
        if ((active0 & 0x8000000L) != 0x0L) return jjStartNfaWithStates_0(6, 27, 153);
        else if ((active0 & 0x400000000000L) != 0x0L) return jjStartNfaWithStates_0(6, 46, 153);
        else if ((active1 & 0x1000L) != 0x0L) return jjStartNfaWithStates_0(6, 76, 153);
        break;
      case 't':
        if ((active0 & 0x400000L) != 0x0L) return jjStartNfaWithStates_0(6, 22, 153);
        return jjMoveStringLiteralDfa7_0(active0, 0x1000000000000L, active1, 0x4000L);
      case 'u':
        return jjMoveStringLiteralDfa7_0(active0, 0x200000L, active1, 0x0L);
      case 'y':
        if ((active0 & 0x40000000L) != 0x0L) return jjStartNfaWithStates_0(6, 30, 153);
        break;
      default:
        break;
    }
    return jjStartNfa_0(5, active0, active1, 0L);
  }

  private int jjMoveStringLiteralDfa7_0(long old0, long active0, long old1, long active1) {
    if (((active0 &= old0) | (active1 &= old1)) == 0L) return jjStartNfa_0(5, old0, old1, 0L);
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, active1, 0L);
      return 7;
    }
    switch (curChar) {
      case 'c':
        return jjMoveStringLiteralDfa8_0(active0, 0x8000000000L, active1, 0x0L);
      case 'e':
        if ((active0 & 0x200000L) != 0x0L) return jjStartNfaWithStates_0(7, 21, 153);
        else if ((active1 & 0x4L) != 0x0L) return jjStartNfaWithStates_0(7, 66, 153);
        return jjMoveStringLiteralDfa8_0(active0, 0x1002000000000L, active1, 0x0L);
      case 'i':
        return jjMoveStringLiteralDfa8_0(active0, 0x0L, active1, 0x4000L);
      case 'l':
        return jjMoveStringLiteralDfa8_0(active0, 0x80000000000L, active1, 0x0L);
      case 'n':
        return jjMoveStringLiteralDfa8_0(active0, 0x4400000800000000L, active1, 0x0L);
      case 'p':
        if ((active0 & 0x80000000000000L) != 0x0L) return jjStartNfaWithStates_0(7, 55, 153);
        break;
      case 's':
        if ((active1 & 0x20L) != 0x0L) return jjStartNfaWithStates_0(7, 69, 153);
        else if ((active1 & 0x2000L) != 0x0L) return jjStartNfaWithStates_0(7, 77, 153);
        break;
      case 't':
        if ((active0 & 0x800L) != 0x0L) return jjStartNfaWithStates_0(7, 11, 153);
        break;
      default:
        break;
    }
    return jjStartNfa_0(6, active0, active1, 0L);
  }

  private int jjMoveStringLiteralDfa8_0(long old0, long active0, long old1, long active1) {
    if (((active0 &= old0) | (active1 &= old1)) == 0L) return jjStartNfa_0(6, old0, old1, 0L);
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0, active1, 0L);
      return 8;
    }
    switch (curChar) {
      case 'd':
        if ((active0 & 0x1000000000000L) != 0x0L) return jjStartNfaWithStates_0(8, 48, 153);
        break;
      case 'e':
        if ((active0 & 0x8000000000L) != 0x0L) return jjStartNfaWithStates_0(8, 39, 153);
        return jjMoveStringLiteralDfa9_0(active0, 0x80000000000L, active1, 0x0L);
      case 'i':
        return jjMoveStringLiteralDfa9_0(active0, 0x400000000000000L, active1, 0x0L);
      case 'o':
        return jjMoveStringLiteralDfa9_0(active0, 0x2000000000L, active1, 0x0L);
      case 't':
        if ((active0 & 0x4000000000000000L) != 0x0L) return jjStartNfaWithStates_0(8, 62, 153);
        return jjMoveStringLiteralDfa9_0(active0, 0x800000000L, active1, 0x0L);
      case 'v':
        return jjMoveStringLiteralDfa9_0(active0, 0x0L, active1, 0x4000L);
      default:
        break;
    }
    return jjStartNfa_0(7, active0, active1, 0L);
  }

  private int jjMoveStringLiteralDfa9_0(long old0, long active0, long old1, long active1) {
    if (((active0 &= old0) | (active1 &= old1)) == 0L) return jjStartNfa_0(7, old0, old1, 0L);
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0, active1, 0L);
      return 9;
    }
    switch (curChar) {
      case 'd':
        if ((active0 & 0x80000000000L) != 0x0L) return jjStopAtPos(9, 43);
        break;
      case 'e':
        if ((active1 & 0x4000L) != 0x0L) return jjStartNfaWithStates_0(9, 78, 153);
        break;
      case 'f':
        if ((active0 & 0x2000000000L) != 0x0L) return jjStartNfaWithStates_0(9, 37, 153);
        break;
      case 's':
        if ((active0 & 0x800000000L) != 0x0L) return jjStartNfaWithStates_0(9, 35, 153);
        break;
      case 'z':
        return jjMoveStringLiteralDfa10_0(active0, 0x400000000000000L, active1, 0x0L);
      default:
        break;
    }
    return jjStartNfa_0(8, active0, active1, 0L);
  }

  private int jjMoveStringLiteralDfa10_0(long old0, long active0, long old1, long active1) {
    if (((active0 &= old0) | (active1 &= old1)) == 0L) return jjStartNfa_0(8, old0, old1, 0L);
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(9, active0, 0L, 0L);
      return 10;
    }
    switch (curChar) {
      case 'e':
        return jjMoveStringLiteralDfa11_0(active0, 0x400000000000000L);
      default:
        break;
    }
    return jjStartNfa_0(9, active0, 0L, 0L);
  }

  private int jjMoveStringLiteralDfa11_0(long old0, long active0) {
    if (((active0 &= old0)) == 0L) return jjStartNfa_0(9, old0, 0L, 0L);
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_0(10, active0, 0L, 0L);
      return 11;
    }
    switch (curChar) {
      case 'd':
        if ((active0 & 0x400000000000000L) != 0x0L) return jjStartNfaWithStates_0(11, 58, 153);
        break;
      default:
        break;
    }
    return jjStartNfa_0(10, active0, 0L, 0L);
  }

  private int jjStartNfaWithStates_0(int pos, int kind, int state) {
    jjmatchedKind = kind;
    jjmatchedPos = pos;
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      return pos + 1;
    }
    return jjMoveNfa_0(state, pos + 1);
  }

  static final long[] jjbitVec0 = {0x0L, 0x0L, 0x100000020L, 0x0L};
  static final long[] jjbitVec1 = {0x0L, 0x0L, 0x1L, 0x0L};
  static final long[] jjbitVec2 = {0x4000L, 0x0L, 0x0L, 0x0L};
  static final long[] jjbitVec3 = {0x830000003fffL, 0x180000000L, 0x0L, 0x0L};
  static final long[] jjbitVec4 = {0x1L, 0x0L, 0x0L, 0x0L};
  static final long[] jjbitVec5 = {0x0L, 0x0L, 0x0L, 0x8000000000000000L};
  static final long[] jjbitVec6 = {
    0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
  };
  static final long[] jjbitVec8 = {0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL};
  static final long[] jjbitVec9 = {
    0xfff0000040220002L, 0xffffffffffffdfffL, 0xfffff02f7fffffffL, 0x12000000ff7fffffL
  };
  static final long[] jjbitVec10 = {0x0L, 0x0L, 0x420043c00000000L, 0xff7fffffff7fffffL};
  static final long[] jjbitVec11 = {
    0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0x501f0003ffc3L
  };
  static final long[] jjbitVec12 = {
    0x0L, 0xbcdf000000000000L, 0xfffffffbffffd740L, 0xffbfffffffffffffL
  };
  static final long[] jjbitVec13 = {
    0xffffffffffffffffL, 0xffffffffffffffffL, 0xfffffffffffffc03L, 0xffffffffffffffffL
  };
  static final long[] jjbitVec14 = {
    0xfffeffffffffffffL, 0xfffffffe027fffffL, 0x80ffL, 0x707ffffff0000L
  };
  static final long[] jjbitVec15 = {
    0xffffffff00000800L, 0xfffec000000007ffL, 0xffffffffffffffffL, 0x9c00c060002fffffL
  };
  static final long[] jjbitVec16 = {
    0xfffffffd0000L, 0xffffffffffffe000L, 0x2003fffffffffL, 0x43007fffffffc00L
  };
  static final long[] jjbitVec17 = {0x110043fffffL, 0x7ff01ffffffL, 0x3fdfffff00000000L, 0x0L};
  static final long[] jjbitVec18 = {
    0x23fffffffffffff0L, 0xfffe0003ff010000L, 0x23c5fdfffff99fe1L, 0x180f0003b0004000L
  };
  static final long[] jjbitVec19 = {
    0x36dfdfffff987e0L, 0x1c00005e000000L, 0x23edfdfffffbbfe0L, 0x202000300010000L
  };
  static final long[] jjbitVec20 = {
    0x23edfdfffff99fe0L, 0x20003b0000000L, 0x3ffc718d63dc7e8L, 0x200000000010000L
  };
  static final long[] jjbitVec21 = {
    0x23fffdfffffddfe0L, 0x307000000L, 0x23effdfffffddfe1L, 0x6000340000000L
  };
  static final long[] jjbitVec22 = {
    0x27fffffffffddfe0L, 0xfc00000380704000L, 0x2ffbfffffc7fffe0L, 0x7fL
  };
  static final long[] jjbitVec23 = {0x800dfffffffffffeL, 0x7fL, 0x200decaefef02596L, 0xf000005fL};
  static final long[] jjbitVec24 = {0x1L, 0x1ffffffffeffL, 0x1f00L, 0x0L};
  static final long[] jjbitVec25 = {
    0x800007ffffffffffL, 0xffe1c0623c3f0000L, 0xffffffff00004003L, 0xf7ffffffffff20bfL
  };
  static final long[] jjbitVec26 = {
    0xffffffffffffffffL, 0xffffffff3d7f3dffL, 0x7f3dffffffff3dffL, 0xffffffffff7fff3dL
  };
  static final long[] jjbitVec27 = {
    0xffffffffff3dffffL, 0x7ffffffL, 0xffffffff0000ffffL, 0x3f3fffffffffffffL
  };
  static final long[] jjbitVec28 = {
    0xffffffffffffffffL, 0xffff9fffffffffffL, 0xffffffff07fffffeL, 0x1ffc7ffffffffffL
  };
  static final long[] jjbitVec29 = {
    0x3ffff0003dfffL, 0x1dfff0003ffffL, 0xfffffffffffffL, 0x18800000L
  };
  static final long[] jjbitVec30 = {
    0xffffffff00000000L, 0xffffffffffffffL, 0xffff05ffffffff9fL, 0x3fffffffffffffL
  };
  static final long[] jjbitVec31 = {0x7fffffffL, 0x1f3fffffff0000L, 0xffff0fffffffffffL, 0x3ffL};
  static final long[] jjbitVec32 = {0xffffffff007fffffL, 0x1fffffL, 0x8000000000L, 0x0L};
  static final long[] jjbitVec33 = {0xfffffffffffe0L, 0xfe0L, 0xfc00c001fffffff8L, 0x3fffffffffL};
  static final long[] jjbitVec34 = {0xfffffffffL, 0x3ffffffffc00e000L, 0x1ffL, 0x63de0000000000L};
  static final long[] jjbitVec35 = {
    0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0x0L
  };
  static final long[] jjbitVec36 = {
    0xffffffff3f3fffffL, 0x3fffffffaaff3f3fL, 0x5fdfffffffffffffL, 0x1fdc1fff0fcf1fdcL
  };
  static final long[] jjbitVec37 = {
    0x8000000000000000L, 0x8002000000100001L, 0xffffffff1fff0000L, 0x0L
  };
  static final long[] jjbitVec38 = {0xf3ffbd503e2ffc84L, 0xffffffff000043e0L, 0x1ffL, 0x0L};
  static final long[] jjbitVec39 = {
    0xffff7fffffffffffL, 0xffffffff7fffffffL, 0xffffffffffffffffL, 0xc781fffffffffL
  };
  static final long[] jjbitVec40 = {
    0xffff20bfffffffffL, 0x80ffffffffffL, 0x7f7f7f7f007fffffL, 0x7f7f7f7fL
  };
  static final long[] jjbitVec41 = {0x800000000000L, 0x0L, 0x0L, 0x0L};
  static final long[] jjbitVec42 = {
    0x1f3e03fe000000e0L, 0xfffffffffffffffeL, 0xfffffffee07fffffL, 0xf7ffffffffffffffL
  };
  static final long[] jjbitVec43 = {
    0xfffe7fffffffffe0L, 0xffffffffffffffffL, 0x7ffffff00007fffL, 0xffff000000000000L
  };
  static final long[] jjbitVec44 = {
    0xffffffffffffffffL, 0xffffffffffffffffL, 0x3fffffffffffffL, 0x0L
  };
  static final long[] jjbitVec45 = {
    0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0x7ffffffffffL
  };
  static final long[] jjbitVec46 = {
    0xffffffffffffffffL, 0xffffffffffffffffL, 0x1fffL, 0x3fffffffffff0000L
  };
  static final long[] jjbitVec47 = {
    0xc00ffff1fffL, 0x80007fffffffffffL, 0xffffffff3fffffffL, 0xffffffffffffL
  };
  static final long[] jjbitVec48 = {
    0xfffffffcff800000L, 0xffffffffffffffffL, 0xff7ffffffff9ffL, 0xff80000000000000L
  };
  static final long[] jjbitVec49 = {
    0x1000007fffff7bbL, 0xfffffffffffffL, 0xffffffffffffcL, 0x28fc000000000000L
  };
  static final long[] jjbitVec50 = {
    0xffff003ffffffc00L, 0x1fffffff0000007fL, 0x7fffffffffff0L, 0x7c00ffdf00008000L
  };
  static final long[] jjbitVec51 = {
    0x1ffffffffffL, 0xc47fffff00000ff7L, 0x3e62ffffffffffffL, 0x1c07ff38000005L
  };
  static final long[] jjbitVec52 = {
    0xffff7f7f007e7e7eL, 0xffff003ff7ffffffL, 0xffffffffffffffffL, 0x7ffffffffL
  };
  static final long[] jjbitVec53 = {
    0xffffffffffffffffL, 0xffffffffffffffffL, 0xffff000fffffffffL, 0xffffffffffff87fL
  };
  static final long[] jjbitVec54 = {
    0xffffffffffffffffL, 0xffff3fffffffffffL, 0xffffffffffffffffL, 0x3ffffffL
  };
  static final long[] jjbitVec55 = {
    0x5f7ffdffa0f8007fL, 0xffffffffffffffdbL, 0x3ffffffffffffL, 0xfffffffffff80000L
  };
  static final long[] jjbitVec56 = {
    0x3fffffffffffffffL, 0xffffffffffff0000L, 0xfffffffffffcffffL, 0x1fff0000000000ffL
  };
  static final long[] jjbitVec57 = {
    0x18000000000000L, 0xffdf02000000e000L, 0xffffffffffffffffL, 0x1fffffffffffffffL
  };
  static final long[] jjbitVec58 = {
    0x87fffffe00000010L, 0xffffffc007fffffeL, 0x7fffffffffffffffL, 0x631cfcfcfcL
  };
  static final long[] jjbitVec59 = {0x0L, 0x0L, 0x420243cffffffffL, 0xff7fffffff7fffffL};
  static final long[] jjbitVec60 = {
    0xffffffffffffffffL, 0xbcdfffffffffffffL, 0xfffffffbffffd740L, 0xffbfffffffffffffL
  };
  static final long[] jjbitVec61 = {
    0xffffffffffffffffL, 0xffffffffffffffffL, 0xfffffffffffffcfbL, 0xffffffffffffffffL
  };
  static final long[] jjbitVec62 = {
    0xfffeffffffffffffL, 0xfffffffe027fffffL, 0xbffffffffffe80ffL, 0x707ffffff00b6L
  };
  static final long[] jjbitVec63 = {
    0xffffffff17ff083fL, 0xffffc3ffffffffffL, 0xffffffffffffffffL, 0x9ffffdffbfefffffL
  };
  static final long[] jjbitVec64 = {
    0xffffffffffff8000L, 0xffffffffffffe7ffL, 0x3ffffffffffffL, 0x43fffffffffffffL
  };
  static final long[] jjbitVec65 = {
    0x3fffffffffffL, 0x7ff0fffffffL, 0x3fdfffff00000000L, 0xfffffffffff00000L
  };
  static final long[] jjbitVec66 = {
    0xffffffffffffffffL, 0xfffeffcfffffffffL, 0xf3c5fdfffff99fefL, 0x180fffcfb080799fL
  };
  static final long[] jjbitVec67 = {
    0xd36dfdfffff987eeL, 0x3fffc05e023987L, 0xf3edfdfffffbbfeeL, 0xfe02ffcf00013bbfL
  };
  static final long[] jjbitVec68 = {
    0xf3edfdfffff99feeL, 0x2ffcfb0c0399fL, 0xc3ffc718d63dc7ecL, 0x200ffc000813dc7L
  };
  static final long[] jjbitVec69 = {
    0xe3fffdfffffddfefL, 0xffcf07603ddfL, 0xf3effdfffffddfefL, 0x6ffcf40603ddfL
  };
  static final long[] jjbitVec70 = {
    0xfffffffffffddfefL, 0xfc00ffcf80f07ddfL, 0x2ffbfffffc7fffecL, 0xcffc0ff5f847fL
  };
  static final long[] jjbitVec71 = {
    0x87fffffffffffffeL, 0x3ff7fffL, 0x3bffecaefef02596L, 0xf3ff3f5fL
  };
  static final long[] jjbitVec72 = {
    0xc2a003ff03000001L, 0xfffe1ffffffffeffL, 0x1ffffffffeffffdfL, 0x40L
  };
  static final long[] jjbitVec73 = {
    0xffffffffffffffffL, 0xffffffffffff03ffL, 0xffffffff3fffffffL, 0xf7ffffffffff20bfL
  };
  static final long[] jjbitVec74 = {
    0xffffffffff3dffffL, 0xe7ffffffL, 0xffffffff0000ffffL, 0x3f3fffffffffffffL
  };
  static final long[] jjbitVec75 = {
    0x1fffff001fdfffL, 0xddfff000fffffL, 0xffffffffffffffffL, 0x3ff388fffffL
  };
  static final long[] jjbitVec76 = {
    0xffffffff03ff7800L, 0xffffffffffffffL, 0xffff07ffffffffffL, 0x3fffffffffffffL
  };
  static final long[] jjbitVec77 = {
    0xfff0fff7fffffffL, 0x1f3fffffffffc0L, 0xffff0fffffffffffL, 0x3ff03ffL
  };
  static final long[] jjbitVec78 = {
    0xffffffff0fffffffL, 0x9fffffff7fffffffL, 0x3fff008003ff03ffL, 0x0L
  };
  static final long[] jjbitVec79 = {
    0xffffffffffffffffL, 0xff80003ff0fffL, 0xffffffffffffffffL, 0xfffffffffffffL
  };
  static final long[] jjbitVec80 = {
    0xffffffffffffffL, 0x3fffffffffffe3ffL, 0x1ffL, 0x3fffffffff70000L
  };
  static final long[] jjbitVec81 = {
    0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xfbffffffffffffffL
  };
  static final long[] jjbitVec82 = {
    0x80007c000000f800L, 0x8002ffdf00100001L, 0xffffffff1fff0000L, 0x1ffe21fff0000L
  };
  static final long[] jjbitVec83 = {
    0xffff7fffffffffffL, 0xffffffff7fffffffL, 0xffffffffffffffffL, 0xff81fffffffffL
  };
  static final long[] jjbitVec84 = {
    0xffff20bfffffffffL, 0x800080ffffffffffL, 0x7f7f7f7f007fffffL, 0xffffffff7f7f7f7fL
  };
  static final long[] jjbitVec85 = {
    0x1f3efffe000000e0L, 0xfffffffffffffffeL, 0xfffffffee67fffffL, 0xf7ffffffffffffffL
  };
  static final long[] jjbitVec86 = {
    0xfffffff1fffL, 0xbff0ffffffffffffL, 0xffffffffffffffffL, 0x3ffffffffffffL
  };
  static final long[] jjbitVec87 = {
    0x10000ffffffffffL, 0xfffffffffffffL, 0xffffffffffffffffL, 0x28ffffff03ff003fL
  };
  static final long[] jjbitVec88 = {
    0xffff3fffffffffffL, 0x1fffffff000fffffL, 0xffffffffffffffffL, 0x7fffffff03ff8001L
  };
  static final long[] jjbitVec89 = {
    0x7fffffffffffffL, 0xfc7fffff03ff3fffL, 0xffffffffffffffffL, 0x7cffff38000007L
  };
  static final long[] jjbitVec90 = {
    0xffff7f7f007e7e7eL, 0xffff003ff7ffffffL, 0xffffffffffffffffL, 0x3ff37ffffffffffL
  };
  static final long[] jjbitVec91 = {
    0x5f7ffdffe0f8007fL, 0xffffffffffffffdbL, 0x3ffffffffffffL, 0xfffffffffff80000L
  };
  static final long[] jjbitVec92 = {
    0x18ffff0000ffffL, 0xffdf02000000e000L, 0xffffffffffffffffL, 0x9fffffffffffffffL
  };
  static final long[] jjbitVec93 = {
    0x87fffffe03ff0010L, 0xffffffc007fffffeL, 0x7fffffffffffffffL, 0xe0000631cfcfcfcL
  };

  private int jjMoveNfa_0(int startState, int curPos) {
    int startsAt = 0;
    jjnewStateCnt = 152;
    int i = 1;
    jjstateSet[0] = startState;
    int kind = 0x7fffffff;
    for (; ; ) {
      if (++jjround == 0x7fffffff) ReInitRounds();
      if (curChar < 64) {
        long l = 1L << curChar;
        do {
          switch (jjstateSet[--i]) {
            case 152:
              if ((0xfffffffbffffdbffL & l) != 0x0L) {
                jjCheckNAddStates(0, 3);
              } else if (curChar == 34) {
                if (kind > 94) kind = 94;
              }
              break;
            case 153:
            case 54:
              if ((0x3ff00100fffc1ffL & l) == 0x0L) break;
              if (kind > 98) kind = 98;
              {
                jjCheckNAddTwoStates(54, 60);
              }
              break;
            case 67:
              if (curChar == 42) jjstateSet[jjnewStateCnt++] = 69;
              else if (curChar == 47) {
                if (kind > 5) kind = 5;
                {
                  jjCheckNAdd(68);
                }
              }
              break;
            case 0:
              if ((0x3ff000000000000L & l) != 0x0L) {
                if (kind > 81) kind = 81;
                {
                  jjCheckNAddStates(4, 18);
                }
              } else if ((0x100001200L & l) != 0x0L) {
                if (kind > 1) kind = 1;
              } else if (curChar == 47) {
                jjAddStates(19, 20);
              } else if (curChar == 36) {
                if (kind > 98) kind = 98;
                {
                  jjCheckNAddTwoStates(54, 60);
                }
              } else if (curChar == 34) {
                jjCheckNAddStates(0, 3);
              } else if (curChar == 39) {
                jjAddStates(21, 23);
              } else if (curChar == 46) jjstateSet[jjnewStateCnt++] = 2;
              if (curChar == 48) {
                jjAddStates(24, 31);
              }
              break;
            case 1:
              if (curChar == 46) jjstateSet[jjnewStateCnt++] = 2;
              break;
            case 2:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddStates(32, 35);
              }
              break;
            case 3:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(3, 4);
              }
              break;
            case 4:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddTwoStates(5, 10);
              }
              break;
            case 6:
              if ((0x280000000000L & l) != 0x0L) {
                jjCheckNAdd(7);
              }
              break;
            case 7:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddStates(36, 38);
              }
              break;
            case 8:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(8, 9);
              }
              break;
            case 9:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddTwoStates(7, 10);
              }
              break;
            case 11:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddStates(39, 42);
              }
              break;
            case 12:
              if (curChar == 39) {
                jjAddStates(21, 23);
              }
              break;
            case 13:
              if ((0xffffff7fffffdbffL & l) != 0x0L) {
                jjCheckNAdd(14);
              }
              break;
            case 14:
              if (curChar == 39 && kind > 93) kind = 93;
              break;
            case 16:
              if ((0x8400000000L & l) != 0x0L) {
                jjCheckNAdd(14);
              }
              break;
            case 17:
              if ((0xff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(18, 14);
              }
              break;
            case 18:
              if ((0xff000000000000L & l) != 0x0L) {
                jjCheckNAdd(14);
              }
              break;
            case 19:
              if ((0xf000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 20;
              break;
            case 20:
              if ((0xff000000000000L & l) != 0x0L) {
                jjCheckNAdd(18);
              }
              break;
            case 22:
              if (curChar == 53) jjstateSet[jjnewStateCnt++] = 23;
              break;
            case 24:
              if (curChar == 53) jjstateSet[jjnewStateCnt++] = 25;
              break;
            case 26:
              if (curChar == 48) jjstateSet[jjnewStateCnt++] = 24;
              break;
            case 27:
              if (curChar == 48) jjstateSet[jjnewStateCnt++] = 26;
              break;
            case 30:
              if (curChar == 48) jjstateSet[jjnewStateCnt++] = 22;
              break;
            case 31:
              if (curChar == 48) jjstateSet[jjnewStateCnt++] = 30;
              break;
            case 34:
              if ((0x3ff000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 35;
              break;
            case 35:
              if ((0x3ff000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 36;
              break;
            case 36:
              if ((0x3ff000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 37;
              break;
            case 37:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAdd(14);
              }
              break;
            case 38:
              if (curChar == 34) {
                jjCheckNAddStates(0, 3);
              }
              break;
            case 39:
              if ((0xfffffffbffffdbffL & l) != 0x0L) {
                jjCheckNAddStates(0, 3);
              }
              break;
            case 41:
              if ((0x8400000000L & l) != 0x0L) {
                jjCheckNAddStates(0, 3);
              }
              break;
            case 43:
              if ((0x3ff000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 44;
              break;
            case 44:
              if ((0x3ff000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 45;
              break;
            case 45:
              if ((0x3ff000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 46;
              break;
            case 46:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddStates(0, 3);
              }
              break;
            case 48:
              if (curChar == 34 && kind > 94) kind = 94;
              break;
            case 49:
              if ((0xff000000000000L & l) != 0x0L) {
                jjCheckNAddStates(43, 47);
              }
              break;
            case 50:
              if ((0xff000000000000L & l) != 0x0L) {
                jjCheckNAddStates(0, 3);
              }
              break;
            case 51:
              if ((0xf000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 52;
              break;
            case 52:
              if ((0xff000000000000L & l) != 0x0L) {
                jjCheckNAdd(50);
              }
              break;
            case 53:
              if (curChar != 36) break;
              if (kind > 98) kind = 98;
              {
                jjCheckNAddTwoStates(54, 60);
              }
              break;
            case 56:
              if ((0x3ff000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 57;
              break;
            case 57:
              if ((0x3ff000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 58;
              break;
            case 58:
            case 64:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAdd(59);
              }
              break;
            case 59:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 98) kind = 98;
              {
                jjCheckNAddTwoStates(54, 60);
              }
              break;
            case 62:
              if ((0x3ff000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 63;
              break;
            case 63:
              if ((0x3ff000000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 64;
              break;
            case 66:
              if (curChar == 47) {
                jjAddStates(19, 20);
              }
              break;
            case 68:
              if ((0xffffffffffffdbffL & l) == 0x0L) break;
              if (kind > 5) kind = 5;
              {
                jjCheckNAdd(68);
              }
              break;
            case 69:
              if (curChar == 42) jjstateSet[jjnewStateCnt++] = 70;
              break;
            case 70:
              if ((0xffff7fffffffffffL & l) != 0x0L && kind > 6) kind = 6;
              break;
            case 71:
              if (curChar == 42) jjstateSet[jjnewStateCnt++] = 69;
              break;
            case 72:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 81) kind = 81;
              {
                jjCheckNAddStates(4, 18);
              }
              break;
            case 73:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(73, 74);
              }
              break;
            case 74:
            case 110:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAdd(75);
              }
              break;
            case 76:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(76, 77);
              }
              break;
            case 77:
            case 121:
              if ((0x3ff000000000000L & l) != 0x0L && kind > 81) kind = 81;
              break;
            case 78:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(78, 79);
              }
              break;
            case 79:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(80, 10);
              }
              break;
            case 81:
              if ((0x280000000000L & l) != 0x0L) {
                jjCheckNAdd(82);
              }
              break;
            case 82:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddStates(48, 50);
              }
              break;
            case 83:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(83, 84);
              }
              break;
            case 84:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(82, 10);
              }
              break;
            case 85:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddStates(51, 54);
              }
              break;
            case 86:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(86, 87);
              }
              break;
            case 87:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAdd(88);
              }
              break;
            case 89:
              if ((0x280000000000L & l) != 0x0L) {
                jjCheckNAdd(90);
              }
              break;
            case 90:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddStates(55, 57);
              }
              break;
            case 91:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(91, 92);
              }
              break;
            case 92:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddTwoStates(90, 10);
              }
              break;
            case 93:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddStates(58, 61);
              }
              break;
            case 94:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(94, 95);
              }
              break;
            case 95:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAdd(96);
              }
              break;
            case 96:
              if (curChar != 46) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddStates(62, 64);
              }
              break;
            case 97:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddStates(65, 68);
              }
              break;
            case 98:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(98, 99);
              }
              break;
            case 99:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddTwoStates(100, 10);
              }
              break;
            case 101:
              if ((0x280000000000L & l) != 0x0L) {
                jjCheckNAdd(102);
              }
              break;
            case 102:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddStates(69, 71);
              }
              break;
            case 103:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(103, 104);
              }
              break;
            case 104:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddTwoStates(102, 10);
              }
              break;
            case 105:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddStates(72, 75);
              }
              break;
            case 106:
              if (curChar == 48) {
                jjAddStates(24, 31);
              }
              break;
            case 108:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddStates(76, 78);
              }
              break;
            case 109:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(109, 110);
              }
              break;
            case 111:
              if ((0xff000000000000L & l) != 0x0L) {
                jjCheckNAddStates(79, 81);
              }
              break;
            case 112:
              if ((0xff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(112, 113);
              }
              break;
            case 113:
              if ((0xff000000000000L & l) != 0x0L) {
                jjCheckNAdd(75);
              }
              break;
            case 115:
              if ((0x3000000000000L & l) != 0x0L) {
                jjCheckNAddStates(82, 84);
              }
              break;
            case 116:
              if ((0x3000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(116, 117);
              }
              break;
            case 117:
              if ((0x3000000000000L & l) != 0x0L) {
                jjCheckNAdd(75);
              }
              break;
            case 119:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 81) kind = 81;
              {
                jjCheckNAddTwoStates(120, 121);
              }
              break;
            case 120:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(120, 121);
              }
              break;
            case 122:
              if ((0xff000000000000L & l) == 0x0L) break;
              if (kind > 81) kind = 81;
              {
                jjCheckNAddTwoStates(123, 124);
              }
              break;
            case 123:
              if ((0xff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(123, 124);
              }
              break;
            case 124:
              if ((0xff000000000000L & l) != 0x0L && kind > 81) kind = 81;
              break;
            case 126:
              if ((0x3000000000000L & l) == 0x0L) break;
              if (kind > 81) kind = 81;
              {
                jjCheckNAddTwoStates(127, 128);
              }
              break;
            case 127:
              if ((0x3000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(127, 128);
              }
              break;
            case 128:
              if ((0x3000000000000L & l) != 0x0L && kind > 81) kind = 81;
              break;
            case 130:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddStates(85, 87);
              }
              break;
            case 131:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(131, 132);
              }
              break;
            case 132:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAdd(133);
              }
              break;
            case 133:
              if (curChar == 46) jjstateSet[jjnewStateCnt++] = 134;
              break;
            case 134:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddStates(88, 90);
              }
              break;
            case 135:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(135, 136);
              }
              break;
            case 136:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAdd(137);
              }
              break;
            case 138:
              if ((0x280000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 139;
              break;
            case 139:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddStates(91, 93);
              }
              break;
            case 140:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(140, 141);
              }
              break;
            case 141:
            case 151:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAdd(10);
              }
              break;
            case 143:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddStates(94, 97);
              }
              break;
            case 144:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(144, 145);
              }
              break;
            case 145:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(146, 147);
              }
              break;
            case 146:
              if (curChar == 46) {
                jjCheckNAdd(147);
              }
              break;
            case 148:
              if ((0x280000000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 149;
              break;
            case 149:
              if ((0x3ff000000000000L & l) == 0x0L) break;
              if (kind > 86) kind = 86;
              {
                jjCheckNAddStates(98, 100);
              }
              break;
            case 150:
              if ((0x3ff000000000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(150, 151);
              }
              break;
            default:
              break;
          }
        } while (i != startsAt);
      } else if (curChar < 128) {
        long l = 1L << (curChar & 077);
        do {
          switch (jjstateSet[--i]) {
            case 152:
              if ((0xffffffffefffffffL & l) != 0x0L) {
                jjCheckNAddStates(0, 3);
              } else if (curChar == 92) jjstateSet[jjnewStateCnt++] = 42;
              if (curChar == 92) {
                jjAddStates(101, 103);
              }
              break;
            case 153:
              if ((0x87fffffe87fffffeL & l) != 0x0L) {
                if (kind > 98) kind = 98;
                {
                  jjCheckNAddTwoStates(54, 60);
                }
              } else if (curChar == 92) jjstateSet[jjnewStateCnt++] = 55;
              break;
            case 0:
              if ((0x7fffffe87fffffeL & l) != 0x0L) {
                if (kind > 98) kind = 98;
                {
                  jjCheckNAddTwoStates(54, 60);
                }
              } else if (curChar == 92) jjstateSet[jjnewStateCnt++] = 61;
              break;
            case 3:
              if (curChar == 95) {
                jjAddStates(104, 105);
              }
              break;
            case 5:
              if ((0x2000000020L & l) != 0x0L) {
                jjAddStates(106, 107);
              }
              break;
            case 8:
              if (curChar == 95) {
                jjAddStates(108, 109);
              }
              break;
            case 10:
              if ((0x5000000050L & l) != 0x0L && kind > 86) kind = 86;
              break;
            case 13:
              if ((0xffffffffefffffffL & l) != 0x0L) {
                jjCheckNAdd(14);
              }
              break;
            case 15:
              if (curChar == 92) {
                jjCheckNAddStates(110, 112);
              }
              break;
            case 16:
              if ((0x1c404410000000L & l) != 0x0L) {
                jjCheckNAdd(14);
              }
              break;
            case 21:
              if (curChar == 92) {
                jjAddStates(113, 114);
              }
              break;
            case 23:
              if ((0x800000008L & l) != 0x0L) {
                jjCheckNAddTwoStates(16, 29);
              }
              break;
            case 25:
              if ((0x800000008L & l) != 0x0L) {
                jjCheckNAdd(14);
              }
              break;
            case 28:
              if (curChar == 117) jjstateSet[jjnewStateCnt++] = 27;
              break;
            case 29:
              if (curChar == 92) jjstateSet[jjnewStateCnt++] = 28;
              break;
            case 32:
              if (curChar == 117) jjstateSet[jjnewStateCnt++] = 31;
              break;
            case 33:
              if (curChar == 117) jjstateSet[jjnewStateCnt++] = 34;
              break;
            case 34:
              if ((0x7e0000007eL & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 35;
              break;
            case 35:
              if ((0x7e0000007eL & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 36;
              break;
            case 36:
              if ((0x7e0000007eL & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 37;
              break;
            case 37:
              if ((0x7e0000007eL & l) != 0x0L) {
                jjCheckNAdd(14);
              }
              break;
            case 39:
              if ((0xffffffffefffffffL & l) != 0x0L) {
                jjCheckNAddStates(0, 3);
              }
              break;
            case 40:
              if (curChar == 92) {
                jjAddStates(101, 103);
              }
              break;
            case 41:
              if ((0x1c404410000000L & l) != 0x0L) {
                jjCheckNAddStates(0, 3);
              }
              break;
            case 42:
              if (curChar == 117) jjstateSet[jjnewStateCnt++] = 43;
              break;
            case 43:
              if ((0x7e0000007eL & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 44;
              break;
            case 44:
              if ((0x7e0000007eL & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 45;
              break;
            case 45:
              if ((0x7e0000007eL & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 46;
              break;
            case 46:
              if ((0x7e0000007eL & l) != 0x0L) {
                jjCheckNAddStates(0, 3);
              }
              break;
            case 47:
              if (curChar == 92) jjstateSet[jjnewStateCnt++] = 42;
              break;
            case 53:
              if ((0x7fffffe87fffffeL & l) == 0x0L) break;
              if (kind > 98) kind = 98;
              {
                jjCheckNAddTwoStates(54, 60);
              }
              break;
            case 54:
              if ((0x87fffffe87fffffeL & l) == 0x0L) break;
              if (kind > 98) kind = 98;
              {
                jjCheckNAddTwoStates(54, 60);
              }
              break;
            case 55:
              if (curChar == 117) jjstateSet[jjnewStateCnt++] = 56;
              break;
            case 56:
              if ((0x7e0000007eL & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 57;
              break;
            case 57:
              if ((0x7e0000007eL & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 58;
              break;
            case 58:
            case 64:
              if ((0x7e0000007eL & l) != 0x0L) {
                jjCheckNAdd(59);
              }
              break;
            case 59:
              if ((0x7e0000007eL & l) == 0x0L) break;
              if (kind > 98) kind = 98;
              {
                jjCheckNAddTwoStates(54, 60);
              }
              break;
            case 60:
              if (curChar == 92) jjstateSet[jjnewStateCnt++] = 55;
              break;
            case 61:
              if (curChar == 117) jjstateSet[jjnewStateCnt++] = 62;
              break;
            case 62:
              if ((0x7e0000007eL & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 63;
              break;
            case 63:
              if ((0x7e0000007eL & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 64;
              break;
            case 65:
              if (curChar == 92) jjstateSet[jjnewStateCnt++] = 61;
              break;
            case 68:
              if (kind > 5) kind = 5;
              jjstateSet[jjnewStateCnt++] = 68;
              break;
            case 70:
              if (kind > 6) kind = 6;
              break;
            case 73:
              if (curChar == 95) {
                jjAddStates(115, 116);
              }
              break;
            case 75:
              if ((0x100000001000L & l) != 0x0L && kind > 80) kind = 80;
              break;
            case 76:
              if (curChar == 95) {
                jjAddStates(117, 118);
              }
              break;
            case 78:
              if (curChar == 95) {
                jjAddStates(119, 120);
              }
              break;
            case 80:
              if ((0x2000000020L & l) != 0x0L) {
                jjAddStates(121, 122);
              }
              break;
            case 83:
              if (curChar == 95) {
                jjAddStates(123, 124);
              }
              break;
            case 86:
              if (curChar == 95) {
                jjAddStates(125, 126);
              }
              break;
            case 88:
              if ((0x2000000020L & l) != 0x0L) {
                jjAddStates(127, 128);
              }
              break;
            case 91:
              if (curChar == 95) {
                jjAddStates(129, 130);
              }
              break;
            case 94:
              if (curChar == 95) {
                jjAddStates(131, 132);
              }
              break;
            case 98:
              if (curChar == 95) {
                jjAddStates(133, 134);
              }
              break;
            case 100:
              if ((0x2000000020L & l) != 0x0L) {
                jjAddStates(135, 136);
              }
              break;
            case 103:
              if (curChar == 95) {
                jjAddStates(137, 138);
              }
              break;
            case 107:
              if ((0x100000001000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 108;
              break;
            case 108:
              if ((0x7e0000007eL & l) != 0x0L) {
                jjCheckNAddStates(76, 78);
              }
              break;
            case 109:
              if ((0x7e8000007eL & l) != 0x0L) {
                jjCheckNAddTwoStates(109, 110);
              }
              break;
            case 110:
              if ((0x7e0000007eL & l) != 0x0L) {
                jjCheckNAdd(75);
              }
              break;
            case 112:
              if (curChar == 95) {
                jjAddStates(139, 140);
              }
              break;
            case 114:
              if ((0x400000004L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 115;
              break;
            case 116:
              if (curChar == 95) {
                jjAddStates(141, 142);
              }
              break;
            case 118:
              if ((0x100000001000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 119;
              break;
            case 119:
              if ((0x7e0000007eL & l) == 0x0L) break;
              if (kind > 81) kind = 81;
              {
                jjCheckNAddTwoStates(120, 121);
              }
              break;
            case 120:
              if ((0x7e8000007eL & l) != 0x0L) {
                jjCheckNAddTwoStates(120, 121);
              }
              break;
            case 121:
              if ((0x7e0000007eL & l) != 0x0L && kind > 81) kind = 81;
              break;
            case 123:
              if (curChar == 95) {
                jjAddStates(143, 144);
              }
              break;
            case 125:
              if ((0x400000004L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 126;
              break;
            case 127:
              if (curChar == 95) {
                jjAddStates(145, 146);
              }
              break;
            case 129:
              if ((0x100000001000000L & l) != 0x0L) {
                jjCheckNAddTwoStates(130, 133);
              }
              break;
            case 130:
              if ((0x7e0000007eL & l) != 0x0L) {
                jjCheckNAddStates(85, 87);
              }
              break;
            case 131:
              if ((0x7e8000007eL & l) != 0x0L) {
                jjCheckNAddTwoStates(131, 132);
              }
              break;
            case 132:
              if ((0x7e0000007eL & l) != 0x0L) {
                jjCheckNAdd(133);
              }
              break;
            case 134:
              if ((0x7e0000007eL & l) != 0x0L) {
                jjCheckNAddStates(88, 90);
              }
              break;
            case 135:
              if ((0x7e8000007eL & l) != 0x0L) {
                jjCheckNAddTwoStates(135, 136);
              }
              break;
            case 136:
              if ((0x7e0000007eL & l) != 0x0L) {
                jjCheckNAdd(137);
              }
              break;
            case 137:
              if ((0x1000000010000L & l) != 0x0L) {
                jjAddStates(147, 148);
              }
              break;
            case 140:
              if (curChar == 95) {
                jjAddStates(149, 150);
              }
              break;
            case 142:
              if ((0x100000001000000L & l) != 0x0L) jjstateSet[jjnewStateCnt++] = 143;
              break;
            case 143:
              if ((0x7e0000007eL & l) != 0x0L) {
                jjCheckNAddStates(94, 97);
              }
              break;
            case 144:
              if ((0x7e8000007eL & l) != 0x0L) {
                jjCheckNAddTwoStates(144, 145);
              }
              break;
            case 145:
              if ((0x7e0000007eL & l) != 0x0L) {
                jjCheckNAddTwoStates(146, 147);
              }
              break;
            case 147:
              if ((0x1000000010000L & l) != 0x0L) {
                jjAddStates(151, 152);
              }
              break;
            case 150:
              if (curChar == 95) {
                jjAddStates(153, 154);
              }
              break;
            default:
              break;
          }
        } while (i != startsAt);
      } else {
        int hiByte = (curChar >> 8);
        int i1 = hiByte >> 6;
        long l1 = 1L << (hiByte & 077);
        int i2 = (curChar & 0xff) >> 6;
        long l2 = 1L << (curChar & 077);
        do {
          switch (jjstateSet[--i]) {
            case 152:
            case 39:
              if (jjCanMove_1(hiByte, i1, i2, l1, l2)) {
                jjCheckNAddStates(0, 3);
              }
              break;
            case 153:
            case 54:
              if (!jjCanMove_3(hiByte, i1, i2, l1, l2)) break;
              if (kind > 98) kind = 98;
              {
                jjCheckNAddTwoStates(54, 60);
              }
              break;
            case 0:
              if (jjCanMove_0(hiByte, i1, i2, l1, l2)) {
                if (kind > 1) kind = 1;
              }
              if (jjCanMove_2(hiByte, i1, i2, l1, l2)) {
                if (kind > 98) kind = 98;
                {
                  jjCheckNAddTwoStates(54, 60);
                }
              }
              break;
            case 13:
              if (jjCanMove_1(hiByte, i1, i2, l1, l2)) jjstateSet[jjnewStateCnt++] = 14;
              break;
            case 53:
              if (!jjCanMove_2(hiByte, i1, i2, l1, l2)) break;
              if (kind > 98) kind = 98;
              {
                jjCheckNAddTwoStates(54, 60);
              }
              break;
            case 68:
              if (!jjCanMove_1(hiByte, i1, i2, l1, l2)) break;
              if (kind > 5) kind = 5;
              jjstateSet[jjnewStateCnt++] = 68;
              break;
            case 70:
              if (jjCanMove_1(hiByte, i1, i2, l1, l2) && kind > 6) kind = 6;
              break;
            default:
              if (i1 == 0 || l1 == 0 || i2 == 0 || l2 == 0) break;
              else break;
          }
        } while (i != startsAt);
      }
      if (kind != 0x7fffffff) {
        jjmatchedKind = kind;
        jjmatchedPos = curPos;
        kind = 0x7fffffff;
      }
      ++curPos;
      i = jjnewStateCnt;
      jjnewStateCnt = startsAt;
      startsAt = 152 - jjnewStateCnt;
      if (i == startsAt) return curPos;
      try {
        curChar = input_stream.readChar();
      } catch (final java.io.IOException e) {
        return curPos;
      }
    }
  }

  private int jjMoveStringLiteralDfa0_1() {
    switch (curChar) {
      case '*':
        return jjMoveStringLiteralDfa1_1(0x100L);
      default:
        return 1;
    }
  }

  private int jjMoveStringLiteralDfa1_1(long active0) {
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      return 1;
    }
    switch (curChar) {
      case '/':
        if ((active0 & 0x100L) != 0x0L) return jjStopAtPos(1, 8);
        break;
      default:
        return 2;
    }
    return 2;
  }

  private int jjMoveStringLiteralDfa0_2() {
    switch (curChar) {
      case '*':
        return jjMoveStringLiteralDfa1_2(0x200L);
      default:
        return 1;
    }
  }

  private int jjMoveStringLiteralDfa1_2(long active0) {
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      return 1;
    }
    switch (curChar) {
      case '/':
        if ((active0 & 0x200L) != 0x0L) return jjStopAtPos(1, 9);
        break;
      default:
        return 2;
    }
    return 2;
  }

  private final int jjStopStringLiteralDfa_3(int pos, long active0, long active1) {
    switch (pos) {
      case 0:
        if ((active1 & 0x100000000L) != 0x0L) {
          jjmatchedKind = 97;
          return -1;
        }
        return -1;
      case 1:
        if ((active1 & 0x100000000L) != 0x0L) {
          if (jjmatchedPos == 0) {
            jjmatchedKind = 97;
            jjmatchedPos = 0;
          }
          return -1;
        }
        return -1;
      default:
        return -1;
    }
  }

  private final int jjStartNfa_3(int pos, long active0, long active1) {
    return jjMoveNfa_3(jjStopStringLiteralDfa_3(pos, active0, active1), pos + 1);
  }

  private int jjMoveStringLiteralDfa0_3() {
    switch (curChar) {
      case '"':
        return jjMoveStringLiteralDfa1_3(0x100000000L);
      default:
        return jjMoveNfa_3(0, 0);
    }
  }

  private int jjMoveStringLiteralDfa1_3(long active1) {
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_3(0, 0L, active1);
      return 1;
    }
    switch (curChar) {
      case '"':
        return jjMoveStringLiteralDfa2_3(active1, 0x100000000L);
      default:
        break;
    }
    return jjStartNfa_3(0, 0L, active1);
  }

  private int jjMoveStringLiteralDfa2_3(long old1, long active1) {
    if (((active1 &= old1)) == 0L) return jjStartNfa_3(0, 0L, old1);
    try {
      curChar = input_stream.readChar();
    } catch (java.io.IOException e) {
      jjStopStringLiteralDfa_3(1, 0L, active1);
      return 2;
    }
    switch (curChar) {
      case '"':
        if ((active1 & 0x100000000L) != 0x0L) return jjStopAtPos(2, 96);
        break;
      default:
        break;
    }
    return jjStartNfa_3(1, 0L, active1);
  }

  private int jjMoveNfa_3(int startState, int curPos) {
    int startsAt = 0;
    jjnewStateCnt = 3;
    int i = 1;
    jjstateSet[0] = startState;
    int kind = 0x7fffffff;
    for (; ; ) {
      if (++jjround == 0x7fffffff) ReInitRounds();
      if (curChar < 64) {
        long l = 1L << curChar;
        do {
          switch (jjstateSet[--i]) {
            case 0:
              if (kind > 97) kind = 97;
              break;
            case 1:
              if (curChar == 34 && kind > 97) kind = 97;
              break;
            default:
              break;
          }
        } while (i != startsAt);
      } else if (curChar < 128) {
        long l = 1L << (curChar & 077);
        do {
          switch (jjstateSet[--i]) {
            case 0:
              if (kind > 97) kind = 97;
              if (curChar == 92) jjstateSet[jjnewStateCnt++] = 1;
              break;
            case 2:
              if (kind > 97) kind = 97;
              break;
            default:
              break;
          }
        } while (i != startsAt);
      } else {
        int hiByte = (curChar >> 8);
        int i1 = hiByte >> 6;
        long l1 = 1L << (hiByte & 077);
        int i2 = (curChar & 0xff) >> 6;
        long l2 = 1L << (curChar & 077);
        do {
          switch (jjstateSet[--i]) {
            case 0:
              if (jjCanMove_1(hiByte, i1, i2, l1, l2) && kind > 97) kind = 97;
              break;
            default:
              if (i1 == 0 || l1 == 0 || i2 == 0 || l2 == 0) break;
              else break;
          }
        } while (i != startsAt);
      }
      if (kind != 0x7fffffff) {
        jjmatchedKind = kind;
        jjmatchedPos = curPos;
        kind = 0x7fffffff;
      }
      ++curPos;
      i = jjnewStateCnt;
      jjnewStateCnt = startsAt;
      startsAt = 3 - jjnewStateCnt;
      if (i == startsAt) return curPos;
      try {
        curChar = input_stream.readChar();
      } catch (final java.io.IOException e) {
        return curPos;
      }
    }
  }

  /** Token literal values. */
  public static final String[] jjstrLiteralImages = {
    "",
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    "\141\142\163\164\162\141\143\164",
    "\141\163\163\145\162\164",
    "\142\157\157\154\145\141\156",
    "\142\162\145\141\153",
    "\142\171\164\145",
    "\143\141\163\145",
    "\143\141\164\143\150",
    "\143\150\141\162",
    "\143\154\141\163\163",
    "\143\157\156\163\164",
    "\143\157\156\164\151\156\165\145",
    "\144\145\146\141\165\154\164",
    "\144\157",
    "\144\157\165\142\154\145",
    "\145\154\163\145",
    "\145\156\165\155",
    "\145\170\164\145\156\144\163",
    "\146\141\154\163\145",
    "\146\151\156\141\154",
    "\146\151\156\141\154\154\171",
    "\146\154\157\141\164",
    "\146\157\162",
    "\147\157\164\157",
    "\151\146",
    "\151\155\160\154\145\155\145\156\164\163",
    "\151\155\160\157\162\164",
    "\151\156\163\164\141\156\143\145\157\146",
    "\151\156\164",
    "\151\156\164\145\162\146\141\143\145",
    "\154\157\156\147",
    "\156\141\164\151\166\145",
    "\156\145\167",
    "\156\157\156\55\163\145\141\154\145\144",
    "\156\165\154\154",
    "\160\141\143\153\141\147\145",
    "\160\145\162\155\151\164\163",
    "\160\162\151\166\141\164\145",
    "\160\162\157\164\145\143\164\145\144",
    "\160\165\142\154\151\143",
    "\162\145\143\157\162\144",
    "\162\145\164\165\162\156",
    "\163\145\141\154\145\144",
    "\163\150\157\162\164",
    "\163\164\141\164\151\143",
    "\163\164\162\151\143\164\146\160",
    "\163\165\160\145\162",
    "\163\167\151\164\143\150",
    "\163\171\156\143\150\162\157\156\151\172\145\144",
    "\164\150\151\163",
    "\164\150\162\157\167",
    "\164\150\162\157\167\163",
    "\164\162\141\156\163\151\145\156\164",
    "\164\162\165\145",
    "\164\162\171",
    "\166\157\151\144",
    "\166\157\154\141\164\151\154\145",
    "\167\150\151\154\145",
    "\171\151\145\154\144",
    "\162\145\161\165\151\162\145\163",
    "\164\157",
    "\167\151\164\150",
    "\157\160\145\156",
    "\157\160\145\156\163",
    "\165\163\145\163",
    "\155\157\144\165\154\145",
    "\145\170\160\157\162\164\163",
    "\160\162\157\166\151\144\145\163",
    "\164\162\141\156\163\151\164\151\166\145",
    "\167\150\145\156",
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    "\50",
    "\51",
    "\173",
    "\175",
    "\133",
    "\135",
    "\73",
    "\54",
    "\56",
    "\56\56\56",
    "\100",
    "\72\72",
    "\75",
    "\74",
    "\41",
    "\176",
    "\77",
    "\72",
    "\55\76",
    "\75\75",
    "\76\75",
    "\74\75",
    "\41\75",
    "\46\46",
    "\174\174",
    "\53\53",
    "\55\55",
    "\53",
    "\55",
    "\52",
    "\57",
    "\46",
    "\174",
    "\136",
    "\45",
    "\74\74",
    "\53\75",
    "\55\75",
    "\52\75",
    "\57\75",
    "\46\75",
    "\174\75",
    "\136\75",
    "\45\75",
    "\74\74\75",
    "\76\76\75",
    "\76\76\76\75",
    "\76\76\76",
    "\76\76",
    "\76",
    "\32",
  };

  protected Token jjFillToken() {
    final Token t;
    final String curTokenImage;
    final int beginLine;
    final int endLine;
    final int beginColumn;
    final int endColumn;
    String im = jjstrLiteralImages[jjmatchedKind];
    curTokenImage = im == null ? input_stream.getImage() : im;
    beginLine = input_stream.getBeginLine();
    beginColumn = input_stream.getBeginColumn();
    endLine = input_stream.getEndLine();
    endColumn = input_stream.getEndColumn();
    t = Token.newToken(jjmatchedKind);
    t.kind = jjmatchedKind;
    t.image = curTokenImage;

    t.beginLine = beginLine;
    t.endLine = endLine;
    t.beginColumn = beginColumn;
    t.endColumn = endColumn;

    return t;
  }

  static final int[] jjnextStates = {
    39, 40, 47, 48, 73, 74, 75, 76, 77, 78, 79, 80, 10, 86, 87, 88,
    94, 95, 96, 67, 71, 13, 15, 21, 107, 111, 114, 118, 122, 125, 129, 142,
    3, 4, 5, 10, 8, 10, 11, 7, 8, 10, 11, 39, 40, 50, 47, 48,
    83, 10, 85, 82, 83, 10, 85, 91, 10, 93, 90, 91, 10, 93, 97, 100,
    10, 98, 99, 100, 10, 103, 10, 105, 102, 103, 10, 105, 109, 110, 75, 112,
    113, 75, 116, 117, 75, 131, 132, 133, 135, 136, 137, 140, 141, 10, 144, 145,
    146, 147, 150, 151, 10, 41, 49, 51, 3, 4, 6, 7, 8, 9, 16, 17,
    19, 32, 33, 73, 74, 76, 77, 78, 79, 81, 82, 83, 84, 86, 87, 89,
    90, 91, 92, 94, 95, 98, 99, 101, 102, 103, 104, 112, 113, 116, 117, 123,
    124, 127, 128, 138, 139, 140, 141, 148, 149, 150, 151,
  };

  private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2) {
    switch (hiByte) {
      case 0:
        return ((jjbitVec0[i2] & l2) != 0L);
      case 22:
        return ((jjbitVec1[i2] & l2) != 0L);
      case 24:
        return ((jjbitVec2[i2] & l2) != 0L);
      case 32:
        return ((jjbitVec3[i2] & l2) != 0L);
      case 48:
        return ((jjbitVec4[i2] & l2) != 0L);
      case 254:
        return ((jjbitVec5[i2] & l2) != 0L);
      default:
        return false;
    }
  }

  private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2) {
    switch (hiByte) {
      case 0:
        return ((jjbitVec8[i2] & l2) != 0L);
      default:
        if ((jjbitVec6[i1] & l1) != 0L) return true;
        return false;
    }
  }

  private static final boolean jjCanMove_2(int hiByte, int i1, int i2, long l1, long l2) {
    switch (hiByte) {
      case 0:
        return ((jjbitVec10[i2] & l2) != 0L);
      case 2:
        return ((jjbitVec11[i2] & l2) != 0L);
      case 3:
        return ((jjbitVec12[i2] & l2) != 0L);
      case 4:
        return ((jjbitVec13[i2] & l2) != 0L);
      case 5:
        return ((jjbitVec14[i2] & l2) != 0L);
      case 6:
        return ((jjbitVec15[i2] & l2) != 0L);
      case 7:
        return ((jjbitVec16[i2] & l2) != 0L);
      case 8:
        return ((jjbitVec17[i2] & l2) != 0L);
      case 9:
        return ((jjbitVec18[i2] & l2) != 0L);
      case 10:
        return ((jjbitVec19[i2] & l2) != 0L);
      case 11:
        return ((jjbitVec20[i2] & l2) != 0L);
      case 12:
        return ((jjbitVec21[i2] & l2) != 0L);
      case 13:
        return ((jjbitVec22[i2] & l2) != 0L);
      case 14:
        return ((jjbitVec23[i2] & l2) != 0L);
      case 15:
        return ((jjbitVec24[i2] & l2) != 0L);
      case 16:
        return ((jjbitVec25[i2] & l2) != 0L);
      case 18:
        return ((jjbitVec26[i2] & l2) != 0L);
      case 19:
        return ((jjbitVec27[i2] & l2) != 0L);
      case 20:
        return ((jjbitVec6[i2] & l2) != 0L);
      case 22:
        return ((jjbitVec28[i2] & l2) != 0L);
      case 23:
        return ((jjbitVec29[i2] & l2) != 0L);
      case 24:
        return ((jjbitVec30[i2] & l2) != 0L);
      case 25:
        return ((jjbitVec31[i2] & l2) != 0L);
      case 26:
        return ((jjbitVec32[i2] & l2) != 0L);
      case 27:
        return ((jjbitVec33[i2] & l2) != 0L);
      case 28:
        return ((jjbitVec34[i2] & l2) != 0L);
      case 29:
        return ((jjbitVec35[i2] & l2) != 0L);
      case 31:
        return ((jjbitVec36[i2] & l2) != 0L);
      case 32:
        return ((jjbitVec37[i2] & l2) != 0L);
      case 33:
        return ((jjbitVec38[i2] & l2) != 0L);
      case 44:
        return ((jjbitVec39[i2] & l2) != 0L);
      case 45:
        return ((jjbitVec40[i2] & l2) != 0L);
      case 46:
        return ((jjbitVec41[i2] & l2) != 0L);
      case 48:
        return ((jjbitVec42[i2] & l2) != 0L);
      case 49:
        return ((jjbitVec43[i2] & l2) != 0L);
      case 77:
        return ((jjbitVec44[i2] & l2) != 0L);
      case 159:
        return ((jjbitVec45[i2] & l2) != 0L);
      case 164:
        return ((jjbitVec46[i2] & l2) != 0L);
      case 166:
        return ((jjbitVec47[i2] & l2) != 0L);
      case 167:
        return ((jjbitVec48[i2] & l2) != 0L);
      case 168:
        return ((jjbitVec49[i2] & l2) != 0L);
      case 169:
        return ((jjbitVec50[i2] & l2) != 0L);
      case 170:
        return ((jjbitVec51[i2] & l2) != 0L);
      case 171:
        return ((jjbitVec52[i2] & l2) != 0L);
      case 215:
        return ((jjbitVec53[i2] & l2) != 0L);
      case 250:
        return ((jjbitVec54[i2] & l2) != 0L);
      case 251:
        return ((jjbitVec55[i2] & l2) != 0L);
      case 253:
        return ((jjbitVec56[i2] & l2) != 0L);
      case 254:
        return ((jjbitVec57[i2] & l2) != 0L);
      case 255:
        return ((jjbitVec58[i2] & l2) != 0L);
      default:
        if ((jjbitVec9[i1] & l1) != 0L) return true;
        return false;
    }
  }

  private static final boolean jjCanMove_3(int hiByte, int i1, int i2, long l1, long l2) {
    switch (hiByte) {
      case 0:
        return ((jjbitVec59[i2] & l2) != 0L);
      case 2:
        return ((jjbitVec11[i2] & l2) != 0L);
      case 3:
        return ((jjbitVec60[i2] & l2) != 0L);
      case 4:
        return ((jjbitVec61[i2] & l2) != 0L);
      case 5:
        return ((jjbitVec62[i2] & l2) != 0L);
      case 6:
        return ((jjbitVec63[i2] & l2) != 0L);
      case 7:
        return ((jjbitVec64[i2] & l2) != 0L);
      case 8:
        return ((jjbitVec65[i2] & l2) != 0L);
      case 9:
        return ((jjbitVec66[i2] & l2) != 0L);
      case 10:
        return ((jjbitVec67[i2] & l2) != 0L);
      case 11:
        return ((jjbitVec68[i2] & l2) != 0L);
      case 12:
        return ((jjbitVec69[i2] & l2) != 0L);
      case 13:
        return ((jjbitVec70[i2] & l2) != 0L);
      case 14:
        return ((jjbitVec71[i2] & l2) != 0L);
      case 15:
        return ((jjbitVec72[i2] & l2) != 0L);
      case 16:
        return ((jjbitVec73[i2] & l2) != 0L);
      case 18:
        return ((jjbitVec26[i2] & l2) != 0L);
      case 19:
        return ((jjbitVec74[i2] & l2) != 0L);
      case 20:
        return ((jjbitVec6[i2] & l2) != 0L);
      case 22:
        return ((jjbitVec28[i2] & l2) != 0L);
      case 23:
        return ((jjbitVec75[i2] & l2) != 0L);
      case 24:
        return ((jjbitVec76[i2] & l2) != 0L);
      case 25:
        return ((jjbitVec77[i2] & l2) != 0L);
      case 26:
        return ((jjbitVec78[i2] & l2) != 0L);
      case 27:
        return ((jjbitVec79[i2] & l2) != 0L);
      case 28:
        return ((jjbitVec80[i2] & l2) != 0L);
      case 29:
        return ((jjbitVec81[i2] & l2) != 0L);
      case 31:
        return ((jjbitVec36[i2] & l2) != 0L);
      case 32:
        return ((jjbitVec82[i2] & l2) != 0L);
      case 33:
        return ((jjbitVec38[i2] & l2) != 0L);
      case 44:
        return ((jjbitVec83[i2] & l2) != 0L);
      case 45:
        return ((jjbitVec84[i2] & l2) != 0L);
      case 46:
        return ((jjbitVec41[i2] & l2) != 0L);
      case 48:
        return ((jjbitVec85[i2] & l2) != 0L);
      case 49:
        return ((jjbitVec43[i2] & l2) != 0L);
      case 77:
        return ((jjbitVec44[i2] & l2) != 0L);
      case 159:
        return ((jjbitVec45[i2] & l2) != 0L);
      case 164:
        return ((jjbitVec46[i2] & l2) != 0L);
      case 166:
        return ((jjbitVec86[i2] & l2) != 0L);
      case 167:
        return ((jjbitVec48[i2] & l2) != 0L);
      case 168:
        return ((jjbitVec87[i2] & l2) != 0L);
      case 169:
        return ((jjbitVec88[i2] & l2) != 0L);
      case 170:
        return ((jjbitVec89[i2] & l2) != 0L);
      case 171:
        return ((jjbitVec90[i2] & l2) != 0L);
      case 215:
        return ((jjbitVec53[i2] & l2) != 0L);
      case 250:
        return ((jjbitVec54[i2] & l2) != 0L);
      case 251:
        return ((jjbitVec91[i2] & l2) != 0L);
      case 253:
        return ((jjbitVec56[i2] & l2) != 0L);
      case 254:
        return ((jjbitVec92[i2] & l2) != 0L);
      case 255:
        return ((jjbitVec93[i2] & l2) != 0L);
      default:
        if ((jjbitVec9[i1] & l1) != 0L) return true;
        return false;
    }
  }

  int curLexState = 0;
  int defaultLexState = 0;
  int jjnewStateCnt;
  int jjround;
  int jjmatchedPos;
  int jjmatchedKind;

  /** Get the next Token. */
  public Token getNextToken() {
    Token specialToken = null;
    Token matchedToken;
    int curPos = 0;

    EOFLoop:
    for (; ; ) {
      try {
        curChar = input_stream.beginToken();
      } catch (final Exception e) {
        jjmatchedKind = 0;
        jjmatchedPos = -1;
        matchedToken = jjFillToken();
        matchedToken.specialToken = specialToken;
        CommonTokenAction(matchedToken);
        return matchedToken;
      }
      image = jjimage;
      image.setLength(0);
      jjimageLen = 0;

      for (; ; ) {
        switch (curLexState) {
          case 0:
            jjmatchedKind = 0x7fffffff;
            jjmatchedPos = 0;
            curPos = jjMoveStringLiteralDfa0_0();
            break;
          case 1:
            jjmatchedKind = 0x7fffffff;
            jjmatchedPos = 0;
            curPos = jjMoveStringLiteralDfa0_1();
            if (jjmatchedPos == 0 && jjmatchedKind > 10) {
              jjmatchedKind = 10;
            }
            break;
          case 2:
            jjmatchedKind = 0x7fffffff;
            jjmatchedPos = 0;
            curPos = jjMoveStringLiteralDfa0_2();
            if (jjmatchedPos == 0 && jjmatchedKind > 10) {
              jjmatchedKind = 10;
            }
            break;
          case 3:
            jjmatchedKind = 0x7fffffff;
            jjmatchedPos = 0;
            curPos = jjMoveStringLiteralDfa0_3();
            break;
        }
        if (jjmatchedKind != 0x7fffffff) {
          if (jjmatchedPos + 1 < curPos) input_stream.backup(curPos - jjmatchedPos - 1);
          if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
            matchedToken = jjFillToken();
            matchedToken.specialToken = specialToken;
            TokenLexicalActions(matchedToken);
            if (jjnewLexState[jjmatchedKind] != -1) curLexState = jjnewLexState[jjmatchedKind];
            CommonTokenAction(matchedToken);
            return matchedToken;
          } else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
            if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L) {
              matchedToken = jjFillToken();
              if (specialToken == null) specialToken = matchedToken;
              else {
                matchedToken.specialToken = specialToken;
                specialToken = (specialToken.next = matchedToken);
              }
              SkipLexicalActions(matchedToken);
            } else SkipLexicalActions(null);
            if (jjnewLexState[jjmatchedKind] != -1) curLexState = jjnewLexState[jjmatchedKind];
            continue EOFLoop;
          }
          MoreLexicalActions();
          if (jjnewLexState[jjmatchedKind] != -1) curLexState = jjnewLexState[jjmatchedKind];
          curPos = 0;
          jjmatchedKind = 0x7fffffff;
          try {
            curChar = input_stream.readChar();
            continue;
          } catch (final java.io.IOException e1) {
          }
        }
        int error_line = input_stream.getEndLine();
        int error_column = input_stream.getEndColumn();
        String error_after = null;
        boolean EOFSeen = false;
        try {
          input_stream.readChar();
          input_stream.backup(1);
        } catch (final java.io.IOException e1) {
          EOFSeen = true;
          error_after = curPos <= 1 ? "" : input_stream.getImage();
          if (curChar == '\n' || curChar == '\r') {
            error_line++;
            error_column = 0;
          } else error_column++;
        }
        if (!EOFSeen) {
          input_stream.backup(1);
          error_after = curPos <= 1 ? "" : input_stream.getImage();
        }
        throw new TokenMgrException(
            EOFSeen,
            curLexState,
            error_line,
            error_column,
            error_after,
            curChar,
            TokenMgrException.LEXICAL_ERROR);
      }
    }
  }

  void SkipLexicalActions(Token matchedToken) {
    switch (jjmatchedKind) {
      default:
        break;
    }
  }

  void MoreLexicalActions() {
    jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
    switch (jjmatchedKind) {
      case 6:
        image.append(input_stream.getSuffix(jjimageLen));
        jjimageLen = 0;
        input_stream.backup(1);
        break;
      default:
        break;
    }
  }

  void TokenLexicalActions(Token matchedToken) {
    switch (jjmatchedKind) {
      case 68:
        image.append(jjstrLiteralImages[68]);
        lengthOfMatch = jjstrLiteralImages[68].length();
        if (!yieldSupported) matchedToken.kind = IDENTIFIER;
        break;
      case 148:
        image.append(jjstrLiteralImages[148]);
        lengthOfMatch = jjstrLiteralImages[148].length();
        matchedToken.kind = GT;
        matchedToken.realKind = RUNSIGNEDSHIFT;
        input_stream.backup(2);
        break;
      case 149:
        image.append(jjstrLiteralImages[149]);
        lengthOfMatch = jjstrLiteralImages[149].length();
        matchedToken.kind = GT;
        matchedToken.realKind = RSIGNEDSHIFT;
        input_stream.backup(1);
        break;
      default:
        break;
    }
  }

  private void jjCheckNAdd(int state) {
    if (jjrounds[state] != jjround) {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
    }
  }

  private void jjAddStates(int start, int end) {
    do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
    } while (start++ != end);
  }

  private void jjCheckNAddTwoStates(int state1, int state2) {
    jjCheckNAdd(state1);
    jjCheckNAdd(state2);
  }

  private void jjCheckNAddStates(int start, int end) {
    do {
      jjCheckNAdd(jjnextStates[start]);
    } while (start++ != end);
  }

  /** Constructor. */
  public GeneratedJavaParserTokenManager(SimpleCharStream stream) {
    input_stream = stream;
  }

  /** Constructor. */
  public GeneratedJavaParserTokenManager(SimpleCharStream stream, int lexState) {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream) {

    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds() {
    int i;
    jjround = 0x80000001;
    for (i = 152; i-- > 0; ) jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream, int lexState) {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState) {
    if (lexState >= 4 || lexState < 0)
      throw new TokenMgrException(
          "Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.",
          TokenMgrException.INVALID_LEXICAL_STATE);
    else curLexState = lexState;
  }

  /** Lexer state names. */
  public static final String[] lexStateNames = {
    "DEFAULT", "IN_JAVADOC_COMMENT", "IN_MULTI_LINE_COMMENT", "IN_TEXT_BLOCK",
  };

  /** Lex State array. */
  public static final int[] jjnewLexState = {
    -1, -1, -1, -1, -1, -1, 1, 2, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 3, 0, -1, -1,
        -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1,
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1,
    -1, -1,
  };

  static final long[] jjtoToken = {
    0xfffffffffffff801L, 0xffffffe56043ffffL, 0xffffffL,
  };
  static final long[] jjtoSkip = {
    0x33eL, 0x0L, 0x0L,
  };
  static final long[] jjtoSpecial = {
    0x33eL, 0x0L, 0x0L,
  };
  static final long[] jjtoMore = {
    0x4c0L, 0x280000000L, 0x0L,
  };
  protected SimpleCharStream input_stream;

  private final int[] jjrounds = new int[152];
  private final int[] jjstateSet = new int[2 * 152];
  private final StringBuilder jjimage = new StringBuilder();
  private StringBuilder image = jjimage;
  private int jjimageLen;
  private int lengthOfMatch;
  protected int curChar;
}
