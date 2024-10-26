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
package lets.swt.examples;

import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.jface.action.*;
import org.eclipse.jface.resource.*;

public class HelloAction extends Action {
  private final StatusLineManager statusLineManager;

  private AtomicLong counter = new AtomicLong(0);

  public HelloAction(StatusLineManager statusLineManager) {
    super("&Trigger@Ctrl+T", AS_PUSH_BUTTON);
    this.statusLineManager = statusLineManager;
    this.setToolTipText("Hello");
  }

  @Override
  public void run() {
    long value = this.counter.incrementAndGet();
    this.statusLineManager.setMessage(String.format("Hello Counter=%s", value));
  }
}
