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
package lets.lang.parser;

import static org.junit.jupiter.api.Assertions.*;

import com.github.javaparser.utils.LineSeparator;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

public class LangSourcePrinterTest {

  @Test
  public void indent() {
    PrinterConfigurationBuilder builder = new PrinterConfigurationBuilder();
    builder.withIndentation(false, 2);
    builder.withEndOfLine(LineSeparator.LF);
    LangSourcePrinter printer = new LangSourcePrinter(builder.build());
    printer.println("A");
    assertEquals("A\n", printer.toString());
    printer.indent();
    printer.println("A1");
    assertEquals("A\n  A1\n", printer.toString());
    printer.println("A2");
    assertEquals("A\n  A1\n  A2\n", printer.toString());
    printer.unindent();

    printer.println("B");
    assertEquals("A\n  A1\n  A2\nB\n", printer.toString());
  }

  @Test
  public void withIdent() {
    PrinterConfigurationBuilder builder = new PrinterConfigurationBuilder();
    builder.withIndentation(false, 2);
    builder.withEndOfLine(LineSeparator.LF);
    LangSourcePrinter printer = new LangSourcePrinter(builder.build());
    printer.println("B");
    assertEquals("B\n", printer.toString());
    printer.withIndent(
        new Consumer<LangSourcePrinter>() {
          @Override
          public void accept(LangSourcePrinter printer) {
            printer.println("B1");
            printer.println("B2");
          }
        });
    assertEquals("B\n  B1\n  B2\n", printer.toString());
    printer.withIndent(
        (p) -> {
          p.println("B1");
          p.println("B2");
        });
  }

  @Test
  public void withBody() {
    PrinterConfigurationBuilder builder = new PrinterConfigurationBuilder();
    builder.withIndentation(false, 2);
    builder.withEndOfLine(LineSeparator.LF);
    LangSourcePrinter printer = new LangSourcePrinter(builder.build());

    printer.println("void hello()");
    printer.withBody(
        (p) -> {
          p.println("System.out.println();");
        },
        "{",
        "}");
    assertEquals("void hello()\n{\n  System.out.println();\n}\n", printer.toString());
  }
}
