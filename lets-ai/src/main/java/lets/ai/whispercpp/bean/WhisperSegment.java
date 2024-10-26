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
package lets.ai.whispercpp.bean;

/** Created by litonglinux@qq.com on 10/21/2023_7:48 AM */
public class WhisperSegment {
  private long start, end;
  private String sentence;

  public WhisperSegment() {}

  public WhisperSegment(long start, long end, String sentence) {
    this.start = start;
    this.end = end;
    this.sentence = sentence;
  }

  public long getStart() {
    return start;
  }

  public long getEnd() {
    return end;
  }

  public String getSentence() {
    return sentence;
  }

  public void setStart(long start) {
    this.start = start;
  }

  public void setEnd(long end) {
    this.end = end;
  }

  public void setSentence(String sentence) {
    this.sentence = sentence;
  }

  @Override
  public String toString() {
    return "[" + start + " --> " + end + "]:" + sentence;
  }
}
