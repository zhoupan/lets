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

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class HelloJFace extends ApplicationWindow {
  public HelloJFace(Shell parentShell) {
    super(parentShell);
  }

  @Override
  protected Control createContents(Composite parent) {
    Text helloText = new Text(parent, SWT.CENTER);
    helloText.setText("Hello SWT and JFace!");
    parent.pack();
    return parent;
  }

  public static void main(String[] args) {
    HelloJFace window = new HelloJFace(null);
    // After allocating resources for the ApplicationWindow,
    // this method configures the window to appear until closed by invoking
    // the setBlockOnOpen() method with a TRUE argument
    window.setBlockOnOpen(true);
    window.open();
    Display.getCurrent().dispose();
  }
}
