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
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class HelloSwt {

  public static void main(String[] args) {
    // The first part begins by creating an instance of the Display and Shell classes.
    // As we’ll show shortly, this allows the GUI to access the resources of the underlying
    // platform and create a primary window for viewing widgets.
    Display display = new Display();
    Shell shell = new Shell(display);

    // The next section adds a Text widget to the shell.
    // Although this is simple in Hello-SWT,
    // this section usually requires the most effort in an SWT application.
    // It deals with adding and configuring the building blocks necessary to provide the GUI’s
    // function.
    // Widgets and groups of widgets (in containers) are added as children of the shell.
    // Listeners and events are defined for each widget that the user can act on.
    // The code in this section also sets the parameters for these widgets, containers, and
    // events to make sure they look and act as required. In this case, the pack() methods
    // tell the Shell and Text components to use only as much space as they need.
    Text helloText = new Text(shell, SWT.CENTER);
    helloText.setText("Hello SWT!");
    helloText.pack();
    // shell.pack();
    shell.open();
    // when the Shell’s open() method is invoked, the application’s main window takes shape
    // and its children are rendered in the display. So long as the Shell remains open,
    // the Display instance uses its readAndDispatch() method to keep track of relevant
    // user events in the platform’s event queue. When one of these actions involves closing
    // the window, the resources associated with the Display object (such as the
    // Shell and its children) are deallocated.
    SwtUtils.shellDisplay(shell);
  }
}
