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
package com.github.javaparser.generator.core.other;

import java.util.function.Function;

/** Prints the LETTER and PART_LETTER tokens. They should be inserted into the grammar manually. */
public class GrammarLetterGenerator {

  public static void main(String[] args) {
    generate(
        "LETTER",
        c ->
            Character.isJavaIdentifierStart(c)
                || Character.isHighSurrogate((char) (int) c)
                || Character.isLowSurrogate((char) (int) c));
    generate(
        "PART_LETTER",
        c ->
            Character.isJavaIdentifierPart(c)
                || Character.isHighSurrogate((char) (int) c)
                || Character.isLowSurrogate((char) (int) c));
  }

  private static void generate(String tokenName, Function<Integer, Boolean> f) {
    final String indent = "         ";
    System.out.println("  < #" + tokenName + ": [");
    System.out.print(indent);
    int nltime = 0;
    int i = 0;
    while (i < 0x10000) {
      while (!f.apply(i) && i < 0x10000) {
        i++;
      }
      String start = format(i);
      while (f.apply(i) && i < 0x10000) {
        i++;
      }
      String end = format(i - 1);
      if (i >= 0x10000) {
        break;
      }
      if (start.equals(end)) {
        nltime++;
        System.out.print(start + ",  ");
      } else {
        nltime += 2;
        System.out.print(start + "-" + end + ",  ");
      }
      if (nltime >= 10) {
        nltime = 0;
        System.out.println();
        System.out.print(indent);
      }
    }
    // Too lazy to remove the final illegal comma.
    System.out.println("]");
    System.out.println("        | <UNICODE_ESCAPE>");
    System.out.println("  >");
  }

  private static String format(int i) {
    return String.format("\"\\u%04x\"", i);
  }
}
