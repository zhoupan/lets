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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import lets.core.StringUtils;

/**
 * Enum constants for most common operating systems.
 *
 * @author harald
 */
public enum OperatingSystem {

  // the order is important since the agent string is being compared with the
  // aliases
  /** Windows Mobile / Windows CE. Exact version unknown. */
  WINDOWS(
      Manufacturer.MICROSOFT,
      null,
      1,
      "Windows",
      new String[] {"Windows"},
      new String[] {"Palm", "ggpht.com"},
      DeviceType.COMPUTER,
      null), // catch the rest of older
  // Windows systems (95,
  /** The windows 10. */
  // NT,...)
  WINDOWS_10(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      24,
      "Windows 10",
      new String[] {"Windows NT 6.4", "Windows NT 10"},
      null,
      DeviceType.COMPUTER,
      null), // before
  // Win,
  // yes,
  // Windows
  // 10 is
  // called
  // 6.4
  /** The windows 81. */
  // LOL
  WINDOWS_81(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      23,
      "Windows 8.1",
      new String[] {"Windows NT 6.3"},
      null,
      DeviceType.COMPUTER,
      null), // before Win, yes,
  // Windows 8.1 is called
  /** The windows 8. */
  // 6.3 LOL
  WINDOWS_8(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      22,
      "Windows 8",
      new String[] {"Windows NT 6.2"},
      new String[] {"Xbox", "Xbox One"},
      DeviceType.COMPUTER,
      null),
  /** The windows 7. */
  // before Win, yes, Windows 8 is called 6.2 LOL
  WINDOWS_7(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      21,
      "Windows 7",
      new String[] {"Windows NT 6.1"},
      new String[] {"Xbox", "Xbox One"},
      DeviceType.COMPUTER,
      null),
  /** The windows vista. */
  // before Win, yes, Windows 7 is called 6.1 LOL
  WINDOWS_VISTA(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      20,
      "Windows Vista",
      new String[] {"Windows NT 6"},
      new String[] {"Xbox", "Xbox One"},
      DeviceType.COMPUTER,
      null),
  /** The windows 2000. */
  // before Win
  WINDOWS_2000(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      15,
      "Windows 2000",
      new String[] {"Windows NT 5.0"},
      null,
      DeviceType.COMPUTER,
      null),
  /** The windows xp. */
  // before Win
  WINDOWS_XP(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      10,
      "Windows XP",
      new String[] {"Windows NT 5"},
      new String[] {"ggpht.com"},
      DeviceType.COMPUTER,
      null), // before
  // Win,
  // 5.1
  // and
  // 5.2
  // are
  // basically
  // XP
  /** The windows 10 mobile. */
  // systems
  WINDOWS_10_MOBILE(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      54,
      "Windows 10 Mobile",
      new String[] {"Windows Phone 10"},
      null,
      DeviceType.MOBILE,
      null),

  /** The windows phone8 1. */
  WINDOWS_PHONE8_1(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      53,
      "Windows Phone 8.1",
      new String[] {"Windows Phone 8.1"},
      null,
      DeviceType.MOBILE,
      null),
  /** The windows phone8. */
  // before Win
  WINDOWS_PHONE8(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      52,
      "Windows Phone 8",
      new String[] {"Windows Phone 8"},
      null,
      DeviceType.MOBILE,
      null),
  /** The windows mobile7. */
  // before Win
  WINDOWS_MOBILE7(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      51,
      "Windows Phone 7",
      new String[] {"Windows Phone OS 7"},
      null,
      DeviceType.MOBILE,
      null), // should be Windows
  // Phone 7 but to keep
  // it compatible we'll
  // leave the name as
  /** The windows mobile. */
  // is.
  WINDOWS_MOBILE(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      50,
      "Windows Mobile",
      new String[] {"Windows CE"},
      null,
      DeviceType.MOBILE,
      null),
  /** The windows 98. */
  // before Win
  WINDOWS_98(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      5,
      "Windows 98",
      new String[] {"Windows 98", "Win98"},
      new String[] {"Palm"},
      DeviceType.COMPUTER,
      null), // before
  /** The xbox os. */
  // Win
  XBOX_OS(
      Manufacturer.MICROSOFT,
      OperatingSystem.WINDOWS,
      62,
      "Xbox OS",
      new String[] {"xbox"},
      new String[] {},
      DeviceType.GAME_CONSOLE,
      null),

  // for Google user-agent, see
  /** The android. */
  // https://developer.chrome.com/multidevice/user-agent
  ANDROID(
      Manufacturer.GOOGLE,
      null,
      0,
      "Android",
      new String[] {"Android"},
      new String[] {"Ubuntu"},
      DeviceType.MOBILE,
      null),

  /** The android8. */
  ANDROID8(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID,
      8,
      "Android 8.x",
      new String[] {"Android 8", "Android-8"},
      new String[] {"glass"},
      DeviceType.MOBILE,
      null),

  /** The android8 tablet. */
  ANDROID8_TABLET(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID8,
      80,
      "Android 8.x Tablet",
      new String[] {"Android 8", "Android-8"},
      new String[] {"mobile", "glass"},
      DeviceType.TABLET,
      null),

  /** The android7. */
  ANDROID7(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID,
      7,
      "Android 7.x",
      new String[] {"Android 7", "Android-7"},
      new String[] {"glass"},
      DeviceType.MOBILE,
      null),

  /** The android7 tablet. */
  ANDROID7_TABLET(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID7,
      70,
      "Android 7.x Tablet",
      new String[] {"Android 7", "Android-7"},
      new String[] {"mobile", "glass"},
      DeviceType.TABLET,
      null),

  /** The android6. */
  ANDROID6(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID,
      6,
      "Android 6.x",
      new String[] {"Android 6", "Android-6"},
      new String[] {"glass"},
      DeviceType.MOBILE,
      null),

  /** The android6 tablet. */
  ANDROID6_TABLET(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID6,
      60,
      "Android 6.x Tablet",
      new String[] {"Android 6", "Android-6"},
      new String[] {"mobile", "glass"},
      DeviceType.TABLET,
      null),

  /** The android5. */
  ANDROID5(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID,
      5,
      "Android 5.x",
      new String[] {"Android 5", "Android-5"},
      new String[] {"glass"},
      DeviceType.MOBILE,
      null),

  /** The android5 tablet. */
  ANDROID5_TABLET(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID5,
      50,
      "Android 5.x Tablet",
      new String[] {"Android 5", "Android-5"},
      new String[] {"mobile", "glass"},
      DeviceType.TABLET,
      null),

  /** The android4. */
  ANDROID4(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID,
      4,
      "Android 4.x",
      new String[] {"Android 4", "Android-4"},
      new String[] {"glass", "ubuntu"},
      DeviceType.MOBILE,
      null),

  /** The android4 tablet. */
  ANDROID4_TABLET(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID4,
      40,
      "Android 4.x Tablet",
      new String[] {"Android 4", "Android-4"},
      new String[] {"mobile", "glass", "ubuntu"},
      DeviceType.TABLET,
      null),

  /** The android4 wearable. */
  ANDROID4_WEARABLE(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID,
      400,
      "Android 4.x",
      new String[] {"Android 4"},
      new String[] {"ubuntu"},
      DeviceType.WEARABLE,
      null),

  /** The android3 tablet. */
  ANDROID3_TABLET(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID,
      30,
      "Android 3.x Tablet",
      new String[] {"Android 3"},
      null,
      DeviceType.TABLET,
      null), // as long as there are not
  // Android 3.x phones this
  /** The android2. */
  // should be enough
  ANDROID2(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID,
      2,
      "Android 2.x",
      new String[] {"Android 2"},
      null,
      DeviceType.MOBILE,
      null),

  /** The android2 tablet. */
  ANDROID2_TABLET(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID2,
      20,
      "Android 2.x Tablet",
      new String[] {"Kindle Fire", "GT-P1000", "SCH-I800"},
      null,
      DeviceType.TABLET,
      null),

  /** The android1. */
  ANDROID1(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID,
      1,
      "Android 1.x",
      new String[] {"Android 1"},
      null,
      DeviceType.MOBILE,
      null),

  /** Generic Android mobile device without OS version number information. */
  ANDROID_MOBILE(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID,
      11,
      "Android Mobile",
      new String[] {"Mobile"},
      new String[] {"ubuntu"},
      DeviceType.MOBILE,
      null),

  /** Generic Android tablet device without OS version number information. */
  ANDROID_TABLET(
      Manufacturer.GOOGLE,
      OperatingSystem.ANDROID,
      12,
      "Android Tablet",
      new String[] {"Tablet"},
      null,
      DeviceType.TABLET,
      null),

  /** Chrome OS by Google, mostly used on Chromebooks and Chromeboxes. */
  CHROME_OS(
      Manufacturer.GOOGLE,
      null,
      1000,
      "Chrome OS",
      new String[] {"CrOS"},
      null,
      DeviceType.COMPUTER,
      null),

  /** PalmOS, exact version unkown. */
  WEBOS(Manufacturer.HP, null, 11, "WebOS", new String[] {"webOS"}, null, DeviceType.MOBILE, null),

  /** The palm. */
  PALM(Manufacturer.HP, null, 10, "PalmOS", new String[] {"Palm"}, null, DeviceType.MOBILE, null),

  /** The meego. */
  MEEGO(
      Manufacturer.NOKIA, null, 3, "MeeGo", new String[] {"MeeGo"}, null, DeviceType.MOBILE, null),

  /** iOS4, with the release of the iPhone 4, Apple renamed the OS to iOS. */
  IOS(
      Manufacturer.APPLE,
      null,
      2,
      "iOS",
      new String[] {"iPhone", "like Mac OS X"},
      null,
      DeviceType.MOBILE,
      null),
  /** The i OS 11 IPHONE. */
  // before MAC_OS_X_IPHONE for all older versions
  iOS11_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      92,
      "iOS 11 (iPhone)",
      new String[] {"iPhone OS 11"},
      null,
      DeviceType.MOBILE,
      null), // before MAC_OS_X_IPHONE for
  /** The i OS 10 IPHONE. */
  // all older versions
  iOS10_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      91,
      "iOS 10 (iPhone)",
      new String[] {"iPhone OS 10"},
      null,
      DeviceType.MOBILE,
      null), // before MAC_OS_X_IPHONE for
  /** The i OS 9 IPHONE. */
  // all older versions
  iOS9_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      90,
      "iOS 9 (iPhone)",
      new String[] {"iPhone OS 9"},
      null,
      DeviceType.MOBILE,
      null), // before MAC_OS_X_IPHONE for
  /** The i OS 8 4 IPHONE. */
  // all older versions
  iOS8_4_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      49,
      "iOS 8.4 (iPhone)",
      new String[] {"iPhone OS 8_4"},
      null,
      DeviceType.MOBILE,
      null), // before MAC_OS_X_IPHONE
  /** The i OS 8 3 IPHONE. */
  // for all older versions
  iOS8_3_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      48,
      "iOS 8.3 (iPhone)",
      new String[] {"iPhone OS 8_3"},
      null,
      DeviceType.MOBILE,
      null), // before MAC_OS_X_IPHONE
  /** The i OS 8 2 IPHONE. */
  // for all older versions
  iOS8_2_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      47,
      "iOS 8.2 (iPhone)",
      new String[] {"iPhone OS 8_2"},
      null,
      DeviceType.MOBILE,
      null), // version that added Apple
  /** The i OS 8 1 IPHONE. */
  // Watch support
  iOS8_1_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      46,
      "iOS 8.1 (iPhone)",
      new String[] {"iPhone OS 8_1"},
      null,
      DeviceType.MOBILE,
      null), // before MAC_OS_X_IPHONE
  /** The i OS 8 IPHONE. */
  // for all older versions
  iOS8_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      45,
      "iOS 8 (iPhone)",
      new String[] {"iPhone OS 8"},
      null,
      DeviceType.MOBILE,
      null), // before MAC_OS_X_IPHONE for
  /** The i OS 7 IPHONE. */
  // all older versions
  iOS7_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      44,
      "iOS 7 (iPhone)",
      new String[] {"iPhone OS 7"},
      null,
      DeviceType.MOBILE,
      null), // before MAC_OS_X_IPHONE for
  /** The i OS 6 IPHONE. */
  // all older versions
  iOS6_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      43,
      "iOS 6 (iPhone)",
      new String[] {"iPhone OS 6"},
      null,
      DeviceType.MOBILE,
      null), // before MAC_OS_X_IPHONE for
  /** The i OS 5 IPHONE. */
  // all older versions
  iOS5_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      42,
      "iOS 5 (iPhone)",
      new String[] {"iPhone OS 5"},
      null,
      DeviceType.MOBILE,
      null), // before MAC_OS_X_IPHONE for
  /** The i OS 4 IPHONE. */
  // all older versions
  iOS4_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      41,
      "iOS 4 (iPhone)",
      new String[] {"iPhone OS 4"},
      null,
      DeviceType.MOBILE,
      null), // before MAC_OS_X_IPHONE for
  /** The mac os x ipad. */
  // all older versions
  MAC_OS_X_IPAD(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      50,
      "Mac OS X (iPad)",
      new String[] {"iPad"},
      null,
      DeviceType.TABLET,
      null),
  /** The i OS 11 IPAD. */
  // before Mac OS X
  iOS11_IPAD(
      Manufacturer.APPLE,
      OperatingSystem.MAC_OS_X_IPAD,
      60,
      "iOS 11 (iPad)",
      new String[] {"OS 11"},
      null,
      DeviceType.TABLET,
      null),
  /** The i OS 10 IPAD. */
  // before Mac OS X
  iOS10_IPAD(
      Manufacturer.APPLE,
      OperatingSystem.MAC_OS_X_IPAD,
      59,
      "iOS 10 (iPad)",
      new String[] {"OS 10"},
      null,
      DeviceType.TABLET,
      null),
  /** The i OS 9 IPAD. */
  // before Mac OS X
  iOS9_IPAD(
      Manufacturer.APPLE,
      OperatingSystem.MAC_OS_X_IPAD,
      58,
      "iOS 9 (iPad)",
      new String[] {"OS 9"},
      null,
      DeviceType.TABLET,
      null),
  /** The i OS 8 4 IPAD. */
  // before Mac OS X
  iOS8_4_IPAD(
      Manufacturer.APPLE,
      OperatingSystem.MAC_OS_X_IPAD,
      57,
      "iOS 8.4 (iPad)",
      new String[] {"OS 8_4"},
      null,
      DeviceType.TABLET,
      null),
  /** The i OS 8 3 IPAD. */
  // before Mac OS X
  iOS8_3_IPAD(
      Manufacturer.APPLE,
      OperatingSystem.MAC_OS_X_IPAD,
      56,
      "iOS 8.3 (iPad)",
      new String[] {"OS 8_3"},
      null,
      DeviceType.TABLET,
      null),
  /** The i OS 8 2 IPAD. */
  // before Mac OS X
  iOS8_2_IPAD(
      Manufacturer.APPLE,
      OperatingSystem.MAC_OS_X_IPAD,
      55,
      "iOS 8.2 (iPad)",
      new String[] {"OS 8_2"},
      null,
      DeviceType.TABLET,
      null),
  /** The i OS 8 1 IPAD. */
  // before Mac OS X
  iOS8_1_IPAD(
      Manufacturer.APPLE,
      OperatingSystem.MAC_OS_X_IPAD,
      54,
      "iOS 8.1 (iPad)",
      new String[] {"OS 8_1"},
      null,
      DeviceType.TABLET,
      null),
  /** The i OS 8 IPAD. */
  // before Mac OS X
  iOS8_IPAD(
      Manufacturer.APPLE,
      OperatingSystem.MAC_OS_X_IPAD,
      53,
      "iOS 8 (iPad)",
      new String[] {"OS 8_0"},
      null,
      DeviceType.TABLET,
      null),
  /** The i OS 7 IPAD. */
  // before Mac OS X
  iOS7_IPAD(
      Manufacturer.APPLE,
      OperatingSystem.MAC_OS_X_IPAD,
      52,
      "iOS 7 (iPad)",
      new String[] {"OS 7"},
      null,
      DeviceType.TABLET,
      null),
  /** The i OS 6 IPAD. */
  // before Mac OS X
  iOS6_IPAD(
      Manufacturer.APPLE,
      OperatingSystem.MAC_OS_X_IPAD,
      51,
      "iOS 6 (iPad)",
      new String[] {"OS 6"},
      null,
      DeviceType.TABLET,
      null),
  /** The mac os x iphone. */
  // before Mac OS X
  MAC_OS_X_IPHONE(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      40,
      "Mac OS X (iPhone)",
      new String[] {"iPhone"},
      null,
      DeviceType.MOBILE,
      null),
  /** The mac os x ipod. */
  // before Mac OS X
  MAC_OS_X_IPOD(
      Manufacturer.APPLE,
      OperatingSystem.IOS,
      30,
      "Mac OS X (iPod)",
      new String[] {"iPod"},
      null,
      DeviceType.MOBILE,
      null), // before Mac OS X

  /** The mac os x. */
  MAC_OS_X(
      Manufacturer.APPLE,
      null,
      10,
      "Mac OS X",
      new String[] {"Mac OS X", "CFNetwork"},
      null,
      DeviceType.COMPUTER,
      null), // before Mac

  /** Older Mac OS systems before Mac OS X. */
  MAC_OS(
      Manufacturer.APPLE,
      null,
      1,
      "Mac OS",
      new String[] {"Mac"},
      null,
      DeviceType.COMPUTER,
      null), // older Mac OS systems

  /**
   * Linux based Maemo software platform by Nokia. Used in the N900 phone. http://maemo.nokia.com/
   */
  MAEMO(
      Manufacturer.NOKIA, null, 2, "Maemo", new String[] {"Maemo"}, null, DeviceType.MOBILE, null),

  /** Bada is a mobile operating system being developed by Samsung Electronics. */
  BADA(Manufacturer.SAMSUNG, null, 2, "Bada", new String[] {"Bada"}, null, DeviceType.MOBILE, null),

  /** Google TV uses Android 2.x or 3.x but doesn't identify itself as Android. */
  GOOGLE_TV(
      Manufacturer.GOOGLE,
      null,
      100,
      "Android (Google TV)",
      new String[] {"GoogleTV"},
      null,
      DeviceType.DMR,
      null),

  /**
   * Tizen is a Linux Foundation project. Mostly used by various Samsung devices.
   *
   * @see <a href="https://wiki.tizen.org/Tizen_Browser">Tizen Browser user-agent format</a>
   * @see <a href= "http://developer.samsung.com/technical-doc/view.do?v=T000000203">Samsung
   *     Internet User-Agent String Format</a> Not specified how devices like car display or a
   *     fridge would identify themselves.
   */
  TIZEN(
      Manufacturer.LINUX_FOUNDATION,
      null,
      101,
      "Tizen",
      new String[] {"Tizen"},
      null,
      DeviceType.UNKNOWN,
      null),

  /** The tizen3. */
  TIZEN3(
      Manufacturer.LINUX_FOUNDATION,
      OperatingSystem.TIZEN,
      30,
      "Tizen 3",
      new String[] {"Tizen 3."},
      null,
      DeviceType.UNKNOWN,
      null),

  /** The tizen3 mobile. */
  TIZEN3_MOBILE(
      Manufacturer.LINUX_FOUNDATION,
      OperatingSystem.TIZEN3,
      31,
      "Tizen 3 (Mobile)",
      new String[] {"mobile"},
      null,
      DeviceType.MOBILE,
      null),

  /** The tizen3 tv. */
  TIZEN3_TV(
      Manufacturer.LINUX_FOUNDATION,
      OperatingSystem.TIZEN3,
      32,
      "Tizen 3 (SmartTV)",
      new String[] {"Smart-TV", " TV "},
      null,
      DeviceType.DMR,
      null),

  /** The tizen2. */
  TIZEN2(
      Manufacturer.LINUX_FOUNDATION,
      OperatingSystem.TIZEN,
      20,
      "Tizen 2",
      new String[] {"Tizen 2."},
      null,
      DeviceType.UNKNOWN,
      null),

  /** The tizen2 mobile. */
  TIZEN2_MOBILE(
      Manufacturer.LINUX_FOUNDATION,
      OperatingSystem.TIZEN2,
      21,
      "Tizen 2 (Mobile)",
      new String[] {"mobile"},
      null,
      DeviceType.MOBILE,
      null),

  /** The tizen2 tv. */
  TIZEN2_TV(
      Manufacturer.LINUX_FOUNDATION,
      OperatingSystem.TIZEN2,
      22,
      "Tizen 2 (SmartTV)",
      new String[] {"Smart-TV", " TV "},
      null,
      DeviceType.DMR,
      null),

  /** The tizen mobile. */
  TIZEN_MOBILE(
      Manufacturer.LINUX_FOUNDATION,
      OperatingSystem.TIZEN,
      10,
      "Tizen (mobile)",
      new String[] {"mobile"},
      null,
      DeviceType.MOBILE,
      null),

  /** Various Linux based operating systems. */
  KINDLE(
      Manufacturer.AMAZON,
      null,
      1,
      "Linux (Kindle)",
      new String[] {"Kindle"},
      null,
      DeviceType.TABLET,
      null),

  /** The kindle3. */
  KINDLE3(
      Manufacturer.AMAZON,
      OperatingSystem.KINDLE,
      30,
      "Linux (Kindle 3)",
      new String[] {"Kindle/3"},
      null,
      DeviceType.TABLET,
      null),

  /** The kindle2. */
  KINDLE2(
      Manufacturer.AMAZON,
      OperatingSystem.KINDLE,
      20,
      "Linux (Kindle 2)",
      new String[] {"Kindle/2"},
      null,
      DeviceType.TABLET,
      null),

  /** The linux. */
  LINUX(
      Manufacturer.OTHER,
      null,
      2,
      "Linux",
      new String[] {"Linux", "CamelHttpStream"},
      null,
      DeviceType.COMPUTER,
      null), // CamelHttpStream is being used by Evolution, an email client for
  /** The ubuntu. */
  // Linux
  UBUNTU(
      Manufacturer.CONONICAL,
      OperatingSystem.LINUX,
      1,
      "Ubuntu",
      new String[] {"ubuntu"},
      null,
      DeviceType.COMPUTER,
      null),

  /** The ubuntu touch mobile. */
  UBUNTU_TOUCH_MOBILE(
      Manufacturer.CONONICAL,
      OperatingSystem.UBUNTU,
      200,
      "Ubuntu Touch (mobile)",
      new String[] {"mobile"},
      null,
      DeviceType.MOBILE,
      null),

  /** The linux smart tv. */
  LINUX_SMART_TV(
      Manufacturer.OTHER,
      OperatingSystem.LINUX,
      21,
      "Linux (SmartTV)",
      new String[] {"SmartTv"},
      null,
      DeviceType.DMR,
      null),

  /** Other Symbian OS versions. */
  SYMBIAN(
      Manufacturer.SYMBIAN,
      null,
      1,
      "Symbian OS",
      new String[] {"Symbian", "Series60"},
      null,
      DeviceType.MOBILE,
      null),
  /** Symbian OS 9.x versions. Being used by Nokia (N71, N73, N81, N82, N91, N92, N95, ...) */
  SYMBIAN9(
      Manufacturer.SYMBIAN,
      OperatingSystem.SYMBIAN,
      20,
      "Symbian OS 9.x",
      new String[] {"SymbianOS/9", "Series60/3"},
      null,
      DeviceType.MOBILE,
      null),
  /** Symbian OS 8.x versions. Being used by Nokia (6630, 6680, 6681, 6682, N70, N72, N90). */
  SYMBIAN8(
      Manufacturer.SYMBIAN,
      OperatingSystem.SYMBIAN,
      15,
      "Symbian OS 8.x",
      new String[] {"SymbianOS/8", "Series60/2.6", "Series60/2.8"},
      null,
      DeviceType.MOBILE,
      null),
  /**
   * Symbian OS 7.x versions. Being used by Nokia (3230, 6260, 6600, 6620, 6670, 7610), Panasonic
   * (X700, X800), Samsung (SGH-D720, SGH-D730) and Lenovo (P930).
   */
  SYMBIAN7(
      Manufacturer.SYMBIAN,
      OperatingSystem.SYMBIAN,
      10,
      "Symbian OS 7.x",
      new String[] {"SymbianOS/7"},
      null,
      DeviceType.MOBILE,
      null),
  /** Symbian OS 6.x versions. */
  SYMBIAN6(
      Manufacturer.SYMBIAN,
      OperatingSystem.SYMBIAN,
      5,
      "Symbian OS 6.x",
      new String[] {"SymbianOS/6"},
      null,
      DeviceType.MOBILE,
      null),
  /** Nokia's Series 40 operating system. Series 60 (S60) uses the Symbian OS. */
  SERIES40(
      Manufacturer.NOKIA,
      null,
      1,
      "Series 40",
      new String[] {"Nokia6300"},
      null,
      DeviceType.MOBILE,
      null),
  /** Proprietary operating system used for many Sony Ericsson phones. */
  SONY_ERICSSON(
      Manufacturer.SONY_ERICSSON,
      null,
      1,
      "Sony Ericsson",
      new String[] {"SonyEricsson"},
      null,
      DeviceType.MOBILE,
      null), // after symbian, some SE
  /** The sun os. */
  // phones use symbian
  SUN_OS(
      Manufacturer.SUN, null, 1, "SunOS", new String[] {"SunOS"}, null, DeviceType.COMPUTER, null),

  /** The psp. */
  PSP(
      Manufacturer.SONY,
      null,
      1,
      "Sony Playstation",
      new String[] {"Playstation"},
      null,
      DeviceType.GAME_CONSOLE,
      null),
  /** Nintendo Wii game console. */
  WII(
      Manufacturer.NINTENDO,
      null,
      1,
      "Nintendo Wii",
      new String[] {"Wii"},
      null,
      DeviceType.GAME_CONSOLE,
      null),
  /**
   * BlackBerryOS. The BlackBerryOS exists in different version. How relevant those versions are, is
   * not clear.
   */
  BLACKBERRY(
      Manufacturer.BLACKBERRY,
      null,
      1,
      "BlackBerryOS",
      new String[] {"BlackBerry"},
      null,
      DeviceType.MOBILE,
      null),

  /** The blackberry7. */
  BLACKBERRY7(
      Manufacturer.BLACKBERRY,
      OperatingSystem.BLACKBERRY,
      7,
      "BlackBerry 7",
      new String[] {"Version/7"},
      null,
      DeviceType.MOBILE,
      null),

  /** The blackberry6. */
  BLACKBERRY6(
      Manufacturer.BLACKBERRY,
      OperatingSystem.BLACKBERRY,
      6,
      "BlackBerry 6",
      new String[] {"Version/6"},
      null,
      DeviceType.MOBILE,
      null),

  /** The blackberry tablet. */
  BLACKBERRY_TABLET(
      Manufacturer.BLACKBERRY,
      null,
      100,
      "BlackBerry Tablet OS",
      new String[] {"RIM Tablet OS"},
      null,
      DeviceType.TABLET,
      null),

  /** The roku. */
  ROKU(Manufacturer.ROKU, null, 1, "Roku OS", new String[] {"Roku"}, null, DeviceType.DMR, null),

  /** Proxy server that hides the original user-agent. ggpht.com = Gmail proxy server */
  PROXY(
      Manufacturer.OTHER,
      null,
      10,
      "Proxy",
      new String[] {"ggpht.com"},
      null,
      DeviceType.UNKNOWN,
      null),

  /** The unknown mobile. */
  UNKNOWN_MOBILE(
      Manufacturer.OTHER,
      null,
      3,
      "Unknown mobile",
      new String[] {"Mobile"},
      null,
      DeviceType.MOBILE,
      null),

  /** The unknown tablet. */
  UNKNOWN_TABLET(
      Manufacturer.OTHER,
      null,
      4,
      "Unknown tablet",
      new String[] {"Tablet"},
      null,
      DeviceType.TABLET,
      null),

  /** The unknown. */
  UNKNOWN(Manufacturer.OTHER, null, 1, "Unknown", new String[0], null, DeviceType.UNKNOWN, null);

  /** The id. */
  private final short id;

  /** The name. */
  private final String name;

  /** The aliases. */
  private final String[] aliases;

  /** The exclude list. */
  private final String[] excludeList; // don't match when these values are in the agent-string

  /** The manufacturer. */
  private final Manufacturer manufacturer;

  /** The device type. */
  private final DeviceType deviceType;

  /** The parent. */
  private final OperatingSystem parent;

  /** The children. */
  private List<OperatingSystem> children;

  /** The version reg ex. */
  private Pattern versionRegEx;

  /** The top level operating systems. */
  private static List<OperatingSystem> topLevelOperatingSystems;

  /**
   * Instantiates a new operating system.
   *
   * @param manufacturer the manufacturer
   * @param parent the parent
   * @param versionId the version id
   * @param name the name
   * @param aliases the aliases
   * @param exclude the exclude
   * @param deviceType the device type
   * @param versionRegexString the version regex string
   */
  OperatingSystem(
      Manufacturer manufacturer,
      OperatingSystem parent,
      int versionId,
      String name,
      String[] aliases,
      String[] exclude,
      DeviceType deviceType,
      String versionRegexString) {
    this.manufacturer = manufacturer;
    this.parent = parent;
    this.children = new ArrayList<OperatingSystem>();
    // combine manufacturer and version id to one unique id.
    this.id = (short) ((manufacturer.getId() << 8) + (byte) versionId);
    this.name = name;
    this.aliases = Utils.toLowerCase(aliases);
    this.excludeList = Utils.toLowerCase(exclude);
    this.deviceType = deviceType;
    if (versionRegexString != null) { // not implemented yet
      this.versionRegEx = Pattern.compile(versionRegexString);
    }
    if (this.parent == null) {
      addTopLevelOperatingSystem(this);
    } else {
      this.parent.children.add(this);
    }
  }

  /**
   * Adds the top level operating system.
   *
   * @param os the os
   */
  // create collection of top level operating systems during initialization
  private static void addTopLevelOperatingSystem(OperatingSystem os) {
    if (topLevelOperatingSystems == null) {
      topLevelOperatingSystems = new ArrayList<OperatingSystem>();
    }
    topLevelOperatingSystems.add(os);
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public short getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the short name.
   *
   * @return the short name
   */
  public String getShortName() {
    if (StringUtils.contains(this.name, " ")) {
      return StringUtils.substringBefore(this.name, " ");
    }
    return this.name;
  }

  /**
   * Checks if is device.
   *
   * @param deviceType the device type
   * @return true, if is device
   */
  public boolean isDeviceType(DeviceType deviceType) {
    return this.deviceType.equals(deviceType);
  }

  /**
   * Checks if is mobile device.
   *
   * @return true, if is mobile device
   */
  /*
   * Shortcut to check of an operating system is a mobile device. Left in here for
   * backwards compatibility. Use .getDeviceType() instead.
   */
  public boolean isMobileDevice() {
    return this.isDeviceType(DeviceType.MOBILE);
  }

  /**
   * Checks if is tablet device.
   *
   * @return true, if is tablet device
   */
  public boolean isTabletDevice() {
    return this.isDeviceType(DeviceType.TABLET);
  }

  /**
   * Checks if is computer.
   *
   * @return true, if is computer
   */
  public boolean isComputer() {
    return this.isDeviceType(DeviceType.COMPUTER);
  }

  /**
   * Gets the device type.
   *
   * @return the device type
   */
  public DeviceType getDeviceType() {
    return deviceType;
  }

  /**
   * Gets the group.
   *
   * @return the group
   */
  /*
   * Gets the top level grouping operating system
   */
  public OperatingSystem getGroup() {
    if (this.parent != null) {
      return parent.getGroup();
    }
    return this;
  }

  /**
   * Returns the manufacturer of the operating system.
   *
   * @return the manufacturer
   */
  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  /**
   * Checks if the given user-agent string matches to the operating system. Only checks for one
   * specific operating system.
   *
   * @param agentString User-agent string as provided in the request.
   * @return boolean
   */
  public boolean isInUserAgentString(String agentString) {
    if (agentString == null) {
      return false;
    }
    final String agentLowerCaseString = agentString.toLowerCase();
    return this.isInUserAgentStringLowercase(agentLowerCaseString);
  }

  /**
   * Checks if is in user agent string lowercase.
   *
   * @param agentLowerCaseString the agent lower case string
   * @return true, if is in user agent string lowercase
   */
  private boolean isInUserAgentStringLowercase(final String agentLowerCaseString) {
    return Utils.contains(agentLowerCaseString, aliases);
  }

  /**
   * Checks if is android.
   *
   * @return true, if is android
   */
  public boolean isAndroid() {
    return StringUtils.containsIgnoreCase(this.getName(), "Android");
  }

  /**
   * Checks if is i OS.
   *
   * @return true, if is i OS
   */
  public boolean isiOS() {
    return StringUtils.containsIgnoreCase(this.getName(), "iOS");
  }

  /**
   * Checks if is windows.
   *
   * @return true, if is windows
   */
  public boolean isWindows() {
    return StringUtils.containsIgnoreCase(this.getName(), "Windows");
  }

  /**
   * Checks if is linux.
   *
   * @return true, if successful
   */
  public boolean isLinux() {
    return StringUtils.containsIgnoreCase(this.getName(), "Linux");
  }

  /**
   * Checks if the given user-agent does not contain one of the tokens which should not match. In
   * most cases there are no excluding tokens, so the impact should be small.
   *
   * @param agentLowerCaseString Lower case version of the user-agent string
   * @return true or false
   */
  private boolean containsExcludeTokenLowercase(final String agentLowerCaseString) {
    return Utils.contains(agentLowerCaseString, excludeList);
  }

  /**
   * Check user agent lowercase.
   *
   * @param agentStringLowercase the agent string lowercase
   * @return the operating system
   */
  private OperatingSystem checkUserAgentLowercase(String agentStringLowercase) {
    if (this.isInUserAgentStringLowercase(agentStringLowercase)) {
      if (this.children.size() > 0) {
        for (OperatingSystem childOperatingSystem : this.children) {
          OperatingSystem match =
              childOperatingSystem.checkUserAgentLowercase(agentStringLowercase);
          if (match != null) {
            return match;
          }
        }
      }
      // if children didn't match we continue checking the current to prevent false
      // positives
      if (!this.containsExcludeTokenLowercase(agentStringLowercase)) {
        return this;
      }
    }
    // match by name
    if (StringUtils.containsIgnoreCase(agentStringLowercase, this.getName())) {
      return this;
    }
    return null;
  }

  /**
   * Parses user agent string and returns the best match. Returns OperatingSystem.UNKNOWN if there
   * is no match.
   *
   * @param agentString User-agent string as provided in the request.
   * @return OperatingSystem enum
   */
  public static OperatingSystem parseUserAgentString(String agentString) {
    return parseUserAgentString(agentString, topLevelOperatingSystems);
  }

  /**
   * Parses the user agent lowercase string.
   *
   * @param agentString the agent string
   * @return the operating system
   */
  public static OperatingSystem parseUserAgentLowercaseString(String agentString) {
    if (agentString == null) {
      return OperatingSystem.UNKNOWN;
    }
    return parseUserAgentLowercaseString(agentString, topLevelOperatingSystems);
  }

  /**
   * Parses the user agent string and returns the best match for the given operating systems.
   * Returns OperatingSystem.UNKNOWN if there is no match. Be aware that if the order of the
   * provided operating systems is incorrect or the set is too limited it can lead to false matches!
   *
   * @param agentString User-agent string as provided in the request.
   * @param operatingSystems the operating systems
   * @return OperatingSystem enum
   */
  public static OperatingSystem parseUserAgentString(
      String agentString, List<OperatingSystem> operatingSystems) {
    if (agentString != null) {
      final String agentLowercaseString = agentString.toLowerCase();
      return parseUserAgentLowercaseString(agentLowercaseString, operatingSystems);
    }
    return OperatingSystem.UNKNOWN;
  }

  /**
   * Parses the user agent lowercase string.
   *
   * @param agentLowercaseString the agent lowercase string
   * @param operatingSystems the operating systems
   * @return the operating system
   */
  private static OperatingSystem parseUserAgentLowercaseString(
      final String agentLowercaseString, List<OperatingSystem> operatingSystems) {
    for (OperatingSystem operatingSystem : operatingSystems) {
      OperatingSystem match = operatingSystem.checkUserAgentLowercase(agentLowercaseString);
      if (match != null) {
        return match; // either current operatingSystem or a child object
      }
    }
    return OperatingSystem.UNKNOWN;
  }

  /**
   * Returns the enum constant of this type with the specified id. Throws IllegalArgumentException
   * if the value does not exist.
   *
   * @param id Id value of the operating system.
   * @return OperatingSystem enum
   */
  public static OperatingSystem valueOf(short id) {
    for (OperatingSystem operatingSystem : OperatingSystem.values()) {
      if (operatingSystem.getId() == id) {
        return operatingSystem;
      }
    }

    // same behavior as standard valueOf(string) method
    throw new IllegalArgumentException("No enum const for id " + id);
  }
}
