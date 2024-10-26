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

import lets.swt.SwtUtils;
import org.eclipse.jface.action.*;
import org.eclipse.jface.window.*;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class HelloApp extends ApplicationWindow {
  StatusLineManager statusLineManager = new StatusLineManager();
  HelloAction helloAction = new HelloAction(statusLineManager);
  OpenFileDialogAction openFileDialogAction;
  OpenDirectoryDialogAction openDirectoryDialogAction;
  ActionContributionItem openFileDialogItem;
  SaveFileDialogAction saveFileDialogAction;
  ActionContributionItem saveFileDialogItem;

  ActionContributionItem helloItem = new ActionContributionItem(helloAction);

  ActionContributionItem openDirectoryDialogItem;

  public HelloApp(Shell parentShell) {
    super(parentShell);
    this.openFileDialogAction = new OpenFileDialogAction(this, statusLineManager);
    this.openFileDialogItem = new ActionContributionItem(openFileDialogAction);
    this.openDirectoryDialogAction = new OpenDirectoryDialogAction(this, statusLineManager);
    this.openDirectoryDialogItem = new ActionContributionItem(openDirectoryDialogAction);
    this.saveFileDialogAction = new SaveFileDialogAction(this, statusLineManager);
    this.saveFileDialogItem = new ActionContributionItem(saveFileDialogAction);
    this.addStatusLine();
    this.addMenuBar();
    this.addToolBar(SWT.FLAT | SWT.WRAP);
  }

  protected Control createContents(Composite parent) {
    getShell().setText("Action/Contribution Example");
    parent.setSize(290, 150);
    helloItem.fill(parent);
    return parent;
  }

  protected MenuManager createMenuManager() {
    MenuManager mainMenu = new MenuManager(null);
    MenuManager fileMenu = new MenuManager("&File");
    mainMenu.add(fileMenu);
    this.buildFileMenu(fileMenu);
    MenuManager actionMenu = new MenuManager("Actions");
    mainMenu.add(actionMenu);
    this.buildActionsMenu(actionMenu);
    return mainMenu;
  }

  protected void buildFileMenu(MenuManager fileMenu) {
    fileMenu.add(openFileDialogAction);
    fileMenu.add(openDirectoryDialogAction);
    fileMenu.add(saveFileDialogAction);
  }

  protected void buildActionsMenu(MenuManager actionMenu) {
    actionMenu.add(this.helloAction);
  }

  protected ToolBarManager createToolBarManager(int style) {
    ToolBarManager toolBarManager = new ToolBarManager(style);
    toolBarManager.add(this.helloAction);
    return toolBarManager;
  }

  protected StatusLineManager createStatusLineManager() {
    return this.statusLineManager;
  }

  public static void main(String[] args) {
    HelloApp app = new HelloApp(null);
    SwtUtils.applicationWindowDisplay(app);
  }
}
