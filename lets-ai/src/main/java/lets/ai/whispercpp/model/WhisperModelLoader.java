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
package lets.ai.whispercpp.model;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class WhisperModelLoader extends Structure {
  public Pointer context;
  public ReadFunction read;
  public EOFFunction eof;
  public CloseFunction close;

  public static class ReadFunction implements Callback {
    public Pointer invoke(Pointer ctx, Pointer output, int readSize) {
      // TODO
      return ctx;
    }
  }

  public static class EOFFunction implements Callback {
    public boolean invoke(Pointer ctx) {
      // TODO
      return false;
    }
  }

  public static class CloseFunction implements Callback {
    public void invoke(Pointer ctx) {
      // TODO
    }
  }

  //    public WhisperModelLoader(Pointer p) {
  //        super(p);
  //        read = new ReadFunction();
  //        eof = new EOFFunction();
  //        close = new CloseFunction();
  //        read.setCallback(this);
  //        eof.setCallback(this);
  //        close.setCallback(this);
  //        read.write();
  //        eof.write();
  //        close.write();
  //    }

  public WhisperModelLoader() {
    super();
  }

  public interface ReadCallback extends Callback {
    Pointer invoke(Pointer ctx, Pointer output, int readSize);
  }

  public interface EOFCallback extends Callback {
    boolean invoke(Pointer ctx);
  }

  public interface CloseCallback extends Callback {
    void invoke(Pointer ctx);
  }
}
