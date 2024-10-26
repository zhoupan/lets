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

import java.io.Serializable;

/**
 * Container class for user-agent information with operating system and browser details. Can decode
 * user-agent strings. <br>
 * <br>
 * Resources:<br>
 * <a href="http://www.useragentstring.com">User Agent String.Com</a><br>
 * <a href="http://www.myuseragentstring.com/">My User Agent String</a><br>
 * <a href="http://www.user-agents.org">List of User-Agents</a><br>
 * <a href="http://user-agent-string.info">user-agent-string.info</a><br>
 * <a href="http://www.zytrax.com/tech/web/browser_ids.htm">Browser ID (User-Agent) Strings</a><br>
 * <a href="http://www.zytrax.com/tech/web/mobile_ids.html">Mobile Browser ID (User-Agent)
 * Strings</a><br>
 * <a href="http://www.joergkrusesweb.de/internet/browser/user-agent.html">Browser-Kennungen</a><br>
 * <a href="http://deviceatlas.com/devices">Device Atlas - Mobile Device Intelligence</a><br>
 * <a href="http://mobileopera.com/reference/ua">Mobile Opera user-agent strings</a><br>
 * <a href="http://en.wikipedia.org/wiki/S60_platform">S60 platform</a><br>
 * <a href="http://msdn.microsoft.com/en-us/library/ms537503.aspx">Understanding User-Agent
 * Strings</a><br>
 * <a href="http://developer.sonyericsson.com/site/global/docstools/browsing/p_browsing.jsp">Sony
 * Ericsson Web Docs & Tools</a><br>
 * <a href="http://developer.apple.com/internet/safari/faq.html#anchor2">What is the Safari
 * user-agent string</a><br>
 * <a href="http://www.pgts.com.au/pgtsj/pgtsj0208c.html">List of User Agent Strings</a><br>
 * <a href="http://blogs.msdn.com/iemobile/archive/2006/08/03/Detecting_IE_Mobile.aspx">Detecting
 * Internet Explorer Mobile's User-Agent on the server</a>
 */

/**
 * @author harald
 */
public class UserAgent implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 7025462762784240212L;

  /** The operating system. */
  private OperatingSystem operatingSystem;

  /** The browser. */
  private Browser browser;

  /** The id. */
  private int id;

  /** The user agent string. */
  private String userAgentString;

  /**
   * This constructor is created for APIs that require default constructor and should never be used
   * directly.
   *
   * @deprecated Use {@link #UserAgent(OperatingSystem, Browser)}
   */
  @Deprecated
  public UserAgent() {
    this(OperatingSystem.UNKNOWN, Browser.UNKNOWN);
  }

  /**
   * Instantiates a new user agent.
   *
   * @param operatingSystem the operating system
   * @param browser the browser
   */
  public UserAgent(OperatingSystem operatingSystem, Browser browser) {
    this.operatingSystem = operatingSystem;
    this.browser = browser;
    this.id = ((operatingSystem.getId() << 16) + browser.getId());
  }

  /**
   * Instantiates a new user agent.
   *
   * @param userAgentString the user agent string
   */
  public UserAgent(String userAgentString) {
    String userAgentLowercaseString =
        userAgentString == null ? null : userAgentString.toLowerCase();
    Browser browser = Browser.parseUserAgentLowercaseString(userAgentLowercaseString);

    OperatingSystem operatingSystem = OperatingSystem.UNKNOWN;

    // BOTs don't have an interesting OS for us
    if (browser != Browser.BOT) {
      operatingSystem = OperatingSystem.parseUserAgentLowercaseString(userAgentLowercaseString);
    }
    this.operatingSystem = operatingSystem;
    this.browser = browser;
    this.id = ((operatingSystem.getId() << 16) + browser.getId());
    this.userAgentString = userAgentString;
  }

  /**
   * Parses the user agent string.
   *
   * @param userAgentString User-agent string as provided in the request.
   * @return UserAgent
   */
  public static UserAgent parseUserAgentString(String userAgentString) {
    return new UserAgent(userAgentString);
  }

  /**
   * Detects the detailed version information of the browser. Depends on the userAgent to be
   * available. Use it only after using UserAgent(String) or UserAgent.parseUserAgent(String).
   * Returns null if it can not detect the version information.
   *
   * @return Version
   */
  public Version getBrowserVersion() {
    return this.browser.getVersion(this.userAgentString);
  }

  /**
   * Gets the operating system.
   *
   * @return the system
   */
  public OperatingSystem getOperatingSystem() {
    return operatingSystem;
  }

  /**
   * Gets the browser.
   *
   * @return the browser
   */
  public Browser getBrowser() {
    return browser;
  }

  /**
   * Returns an unique integer value of the operating system and browser combination.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Combined string representation of both enums.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return this.operatingSystem.toString() + "-" + this.browser.toString();
  }

  /**
   * Returns UserAgent based on specified unique id.
   *
   * @param id Id value of the user agent.
   * @return UserAgent
   */
  public static UserAgent valueOf(int id) {
    OperatingSystem operatingSystem = OperatingSystem.valueOf((short) (id >> 16));
    Browser browser = Browser.valueOf((short) (id & 0x0FFFF));
    return new UserAgent(operatingSystem, browser);
  }

  /**
   * Returns UserAgent based on combined string representation.
   *
   * @param name Name of the user agent.
   * @return UserAgent
   */
  public static UserAgent valueOf(String name) {
    if (name == null) {
      throw new NullPointerException("Name is null");
    }

    String[] elements = name.split("-");

    if (elements.length == 2) {
      OperatingSystem operatingSystem = OperatingSystem.valueOf(elements[0]);
      Browser browser = Browser.valueOf(elements[1]);
      return new UserAgent(operatingSystem, browser);
    }

    throw new IllegalArgumentException("Invalid string for userAgent " + name);
  }

  /**
   * Hash code.
   *
   * @return the int
   */
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((browser == null) ? 0 : browser.hashCode());
    result = (prime * result) + id;
    result = (prime * result) + ((operatingSystem == null) ? 0 : operatingSystem.hashCode());
    return result;
  }

  /**
   * Equals.
   *
   * @param obj the obj
   * @return true, if successful
   */
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    final UserAgent other = (UserAgent) obj;
    if (browser == null) {
      if (other.browser != null) {
        return false;
      }
    } else if (!browser.equals(other.browser)) {
      return false;
    }
    if (id != other.id) {
      return false;
    }
    if (operatingSystem == null) {
      if (other.operatingSystem != null) {
        return false;
      }
    } else if (!operatingSystem.equals(other.operatingSystem)) {
      return false;
    }
    return true;
  }
}
