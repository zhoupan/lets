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
 * Enum constants representing manufacturers of operating systems and client software. Manufacturer
 * could be used for specific handling of browser requests.
 *
 * @author harald
 */
public enum Manufacturer {

  /** Unknow or rare manufacturer */
  OTHER(1, "Other"),
  /** Microsoft Corporation */
  MICROSOFT(2, "Microsoft Corporation"),
  /** Apple Inc. */
  APPLE(3, "Apple Inc."),
  /** Sun Microsystems, Inc. */
  SUN(4, "Sun Microsystems, Inc."),
  /** Symbian Ltd. */
  SYMBIAN(5, "Symbian Ltd."),
  /** Nokia Corporation */
  NOKIA(6, "Nokia Corporation"),
  /** Research In Motion Limited */
  BLACKBERRY(7, "Research In Motion Limited"),
  /** Hewlett-Packard Company, previously Palm */
  HP(8, "Hewlett Packard"),
  /** Sony Ericsson Mobile Communications AB */
  SONY_ERICSSON(9, "Sony Ericsson Mobile Communications AB"),
  /** Samsung Electronics */
  SAMSUNG(20, "Samsung Electronics"),
  /** Sony Computer Entertainment, Inc. */
  SONY(10, "Sony Computer Entertainment, Inc."),
  /** Nintendo */
  NINTENDO(11, "Nintendo"),
  /** Opera Software ASA */
  OPERA(12, "Opera Software ASA"),
  /** Mozilla Foundation */
  MOZILLA(13, "Mozilla Foundation"),
  /** Google Inc. */
  GOOGLE(15, "Google Inc."),
  /** CompuServe Interactive Services, Inc. */
  COMPUSERVE(16, "CompuServe Interactive Services, Inc."),
  /** Yahoo Inc. */
  YAHOO(17, "Yahoo Inc."),
  /** AOL LLC. */
  AOL(18, "AOL LLC."),
  /** Mail.com Media Corporation */
  MMC(19, "Mail.com Media Corporation"),
  /** Amazon.com, Inc. */
  AMAZON(24, "Amazon.com, Inc."),
  /** Roku sells home digital media products */
  ROKU(21, "Roku, Inc."),
  /** Adobe Systems Inc. */
  ADOBE(23, "Adobe Systems Inc."),
  /** Canonical Ltd. */
  CONONICAL(25, "Canonical Ltd."),
  /** Linux Foundation, owner of the Tizen Project */
  LINUX_FOUNDATION(26, "Linux Foundation");

  private final short id;
  private final String name;

  private Manufacturer(int id, String name) {
    this.id = (byte) id;
    this.name = name;
  }

  /**
   * @return the id
   */
  public short getId() {
    return id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
}
