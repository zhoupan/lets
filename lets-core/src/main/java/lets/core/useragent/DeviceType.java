/*
 * Copyright (c) 2008-2018 zhoupan (https://github.com/zhoupan).
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
package lets.core.useragent;

/**
 * Enum contact for the type of used device
 *
 * @author harald
 */
public enum DeviceType {

  /** Standard desktop or laptop computer */
  COMPUTER("Computer"),
  /** Mobile phone or similar small mobile device */
  MOBILE("Mobile"),
  /** Small tablet type computer. */
  TABLET("Tablet"),
  /** Game console like the Wii or Playstation. */
  GAME_CONSOLE("Game console"),
  /** Digital media receiver like the Google TV. */
  DMR("Digital media receiver"),
  /** Miniature device like a smart watch or interactive glasses */
  WEARABLE("Wearable computer"),
  /** Other or unknow type of device. */
  UNKNOWN("Unknown");

  String name;

  private DeviceType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
