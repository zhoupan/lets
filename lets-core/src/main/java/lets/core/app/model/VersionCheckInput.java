/*
 * Copyright (c) 2021 zhoupan (https://github.com/zhoupan).
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
package lets.core.app.model;

import java.util.ArrayList;
import java.util.List;

/**
 * VersionCheck.
 *
 * @author zhoupan
 */
public class VersionCheckInput implements java.io.Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;

  /** The app id. */
  private String appId;

  /** The useragent. */
  private String useragent;

  /** The option items. */
  private List<OptionItem> optionItems = new ArrayList<OptionItem>();

  /**
   * With app id.
   *
   * @param value the value
   * @return the version check input
   */
  public VersionCheckInput withAppId(String value) {
    this.setAppId(value);
    return this;
  }

  /**
   * With useragent.
   *
   * @param value the value
   * @return the version check input
   */
  public VersionCheckInput withUseragent(String value) {
    this.setUseragent(value);
    return this;
  }

  /**
   * With option item.
   *
   * @param name the name
   * @param value the value
   * @return the version check input
   */
  public VersionCheckInput withOption(String name, String value) {
    this.optionItems.add(new OptionItem().withName(name).withValue(value));
    return this;
  }

  /**
   * Gets the app id.
   *
   * @return the app id
   */
  public String getAppId() {
    return appId;
  }

  /**
   * Sets the app id.
   *
   * @param appId the new app id
   */
  public void setAppId(String appId) {
    this.appId = appId;
  }

  /**
   * Gets the useragent.
   *
   * @return the useragent
   */
  public String getUseragent() {
    return useragent;
  }

  /**
   * Sets the useragent.
   *
   * @param useragent the new useragent
   */
  public void setUseragent(String useragent) {
    this.useragent = useragent;
  }

  /**
   * Gets the option items.
   *
   * @return the option items
   */
  public List<OptionItem> getOptionItems() {
    return optionItems;
  }

  /**
   * Sets the option items.
   *
   * @param optionItems the new option items
   */
  public void setOptionItems(List<OptionItem> optionItems) {
    this.optionItems = optionItems;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "VersionCheckInput [appId=" + appId + ", useragent=" + useragent + "]";
  }
}
