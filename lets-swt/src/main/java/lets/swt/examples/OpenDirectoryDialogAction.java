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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.widgets.DirectoryDialog;

public class OpenDirectoryDialogAction extends Action {
  private final StatusLineManager statusLineManager;
  private final IShellProvider shellProvider;

  public OpenDirectoryDialogAction(
      IShellProvider shellProvider, StatusLineManager statusLineManager) {
    super("&Open Directory@Ctrl+D");
    this.shellProvider = shellProvider;
    this.statusLineManager = statusLineManager;
  }

  @Override
  public void run() {
    DirectoryDialog dialog = new DirectoryDialog(this.shellProvider.getShell());
    String file = dialog.open();
    if (file != null) {
      this.statusLineManager.setMessage(String.format("Open Directory %s", file));
    } else {
      this.statusLineManager.setMessage("");
    }
  }
}
