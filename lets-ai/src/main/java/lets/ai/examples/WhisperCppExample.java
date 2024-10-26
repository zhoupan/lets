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
package lets.ai.examples;

import java.io.*;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import lets.ai.mp3.Sound;
import lets.ai.whispercpp.WhisperCpp;
import lets.ai.whispercpp.bean.WhisperSegment;
import lets.ai.whispercpp.params.CBool;
import lets.ai.whispercpp.params.WhisperFullParams;
import lets.ai.whispercpp.params.WhisperSamplingStrategy;
import lets.core.CoreUtils;
import lets.core.StringUtils;
import lets.core.io.FilenameUtils;

public class WhisperCppExample {
  public static void main(String[] args) {
    System.setProperty("jna.library.path", "e:\\WhisperDesktop\\whisper-cublas-12.2.0-bin-x64");
    WhisperCpp whisper = new WhisperCpp();
    AudioInputStream audioInputStream = null;
    Sound sound = null;
    try {

      // By default, models are loaded from ~/.cache/whisper/ and are usually named
      // "ggml-${name}.bin"
      // or you can provide the absolute path to the model file.
      whisper.initContext("e:\\WhisperDesktop\\ggml-medium.bin");
      // WhisperFullParams params =
      // whisper.getFullDefaultParams(WhisperSamplingStrategy.WHISPER_SAMPLING_GREEDY);
      // WhisperFullParams params =
      // whisper.getFullDefaultParams(WhisperSamplingStrategy.WHISPER_SAMPLING_BEAM_SEARCH);
      WhisperFullParams params =
          whisper.getFullDefaultParams(WhisperSamplingStrategy.WHISPER_SAMPLING_BEAM_SEARCH);
      // custom configuration if required
      // params.temperature_inc = 0f;
      // params.language = "zh";
      // Given
      // File file = new File("e:\\WhisperDesktop\\不够 - v1 - Produce.mp3");
      // File file = new File("e:\\WhisperDesktop\\jfk.wav");
      File file = new File("e:\\WhisperDesktop\\eng.mp3");
      String fileext = FilenameUtils.getExtension(file.getName());
      if (StringUtils.endsWithIgnoreCase(fileext, "mp3")) {
        sound = new Sound(new BufferedInputStream(new FileInputStream(file)));
        // We use an array to store the produced sound data (bad code style, but is okay for short
        // sounds)
        // (We have to store the data in order to get the number of samples in it, because of the
        // (dumb) Java sound API)
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // Read and decode the encoded sound data into the byte array output stream (blocking)
        int read = sound.decodeFullyInto(os);
        // A sample takes 2 bytes
        int samples = read / 2;
        audioInputStream =
            new AudioInputStream(
                new ByteArrayInputStream(os.toByteArray()), sound.getAudioFormat(), samples);
      } else {
        audioInputStream = AudioSystem.getAudioInputStream(file);
      }

      byte[] b = new byte[audioInputStream.available()];
      float[] floats = new float[b.length / 2];
      params.setProgressCallback(
          (ctx, state, progress, user_data) -> System.out.println("progress: " + progress));
      params.print_progress = CBool.FALSE;
      // params.initial_prompt = "and so my fellow Americans um, like";
      audioInputStream.read(b);

      for (int i = 0, j = 0; i < b.length; i += 2, j++) {
        int intSample = (int) (b[i + 1]) << 8 | (int) (b[i]) & 0xFF;
        floats[j] = intSample / 32767.0f;
      }
      // full
      String result = whisper.fullTranscribe(params, floats);
      System.err.println(result);
      List<WhisperSegment> segments = whisper.fullTranscribeWithTime(params, floats);
      for (WhisperSegment segment : segments) {
        System.out.println(segment);
      }

    } catch (Throwable e) {
      e.printStackTrace();
    } finally {
      CoreUtils.closeQuietlyAll(whisper, audioInputStream, sound);
    }
  }
}
