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
package lets.antlr4;

import org.antlr.v4.Tool;
import org.antlr.v4.tool.ANTLRMessage;
import org.antlr.v4.tool.ANTLRToolListener;
import org.slf4j.Logger;
import org.stringtemplate.v4.ST;

public class Antlr4ErrorLog implements ANTLRToolListener {

  private final Tool tool;
  private final Logger log;

  /**
   * Creates an instance of {@link Antlr4ErrorLog}.
   *
   * @param log The Maven log
   */
  public Antlr4ErrorLog(Tool tool, Logger log) {
    this.tool = tool;
    this.log = log;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This implementation passes the message to the Maven log.
   *
   * @param message The message to send to Maven
   */
  @Override
  public void info(String message) {
    if (tool.errMgr.formatWantsSingleLineMessage()) {
      message = message.replace('\n', ' ');
    }
    log.info(message);
  }

  /**
   * {@inheritDoc}
   *
   * <p>This implementation passes the message to the Maven log.
   *
   * @param message The message to send to Maven.
   */
  @Override
  public void error(ANTLRMessage message) {
    ST msgST = tool.errMgr.getMessageTemplate(message);
    String outputMsg = msgST.render();
    if (tool.errMgr.formatWantsSingleLineMessage()) {
      outputMsg = outputMsg.replace('\n', ' ');
    }

    log.error(outputMsg);

    if (message.fileName != null) {
      String text = message.getMessageTemplate(false).render();
      // buildContext.addMessage(new File(message.fileName), message.line, message.charPosition,
      // text, BuildContext.SEVERITY_ERROR, message.getCause());
    }
  }

  /**
   * {@inheritDoc}
   *
   * <p>This implementation passes the message to the Maven log.
   *
   * @param message
   */
  @Override
  public void warning(ANTLRMessage message) {
    ST msgST = tool.errMgr.getMessageTemplate(message);
    String outputMsg = msgST.render();
    if (tool.errMgr.formatWantsSingleLineMessage()) {
      outputMsg = outputMsg.replace('\n', ' ');
    }

    log.warn(outputMsg);

    if (message.fileName != null) {
      String text = message.getMessageTemplate(false).render();
      // buildContext.addMessage(new File(message.fileName), message.line, message.charPosition,
      // text, BuildContext.SEVERITY_WARNING, message.getCause());
    }
  }
}
