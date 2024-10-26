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
package lets.core.preference.impl;

import java.util.Properties;
import java.util.Set;
import lets.core.LoggerService;
import lets.core.json.JsonService;
import lets.core.preference.SharedPreferences.Editor;
import org.slf4j.Logger;

/** The Class DefaultSharedPreferencesEditor. */
public class DefaultSharedPreferencesEditor implements Editor {

  /** The editor properties. */
  private final Properties editorProperties = new Properties();

  /** The json service. */
  JsonService jsonService;

  /** The logger. */
  transient Logger logger;

  /** The prefs. */
  private final DefaultSharedPreferences prefs;

  /**
   * Instantiates a new default shared preferences editor.
   *
   * @param prefs the prefs
   * @param jsonService the json service
   * @param loggerService the logger service
   */
  public DefaultSharedPreferencesEditor(
      DefaultSharedPreferences prefs, JsonService jsonService, LoggerService loggerService) {
    super();
    this.prefs = prefs;
    this.jsonService = jsonService;
    this.logger = loggerService.getLogger(this.getClass());
    this.editorProperties.putAll(prefs.getProperties());
  }

  /**
   * Put string.
   *
   * @param key the key
   * @param value the value
   * @return the editor
   */
  @Override
  public Editor putString(String key, String value) {
    return this.putObject(key, value);
  }

  /**
   * Put object.
   *
   * @param key the key
   * @param value the value
   * @return the editor
   */
  @Override
  public synchronized Editor putObject(String key, Object value) {
    try {
      this.logger.debug("putObject key={}", key);
      String json = this.jsonService.toJson(value);
      this.logger.debug("putObject json={}", json);
      this.editorProperties.put(key, json);
      this.prefs.onSharedPreferenceChanged(key, value);
    } catch (Throwable e) {
      this.logger.error("putObject key={} value={} exception={}", key, value, e);
      throw new RuntimeException(e);
    }
    return this;
  }

  /**
   * Put string set.
   *
   * @param key the key
   * @param values the values
   * @return the editor
   */
  @Override
  public Editor putStringSet(String key, Set<String> values) {
    return this.putObject(key, values);
  }

  /**
   * Put int.
   *
   * @param key the key
   * @param value the value
   * @return the editor
   */
  @Override
  public Editor putInt(String key, int value) {
    return this.putObject(key, value);
  }

  /**
   * Put long.
   *
   * @param key the key
   * @param value the value
   * @return the editor
   */
  @Override
  public Editor putLong(String key, long value) {
    return this.putObject(key, value);
  }

  /**
   * Put float.
   *
   * @param key the key
   * @param value the value
   * @return the editor
   */
  @Override
  public Editor putFloat(String key, float value) {
    return this.putObject(key, value);
  }

  /**
   * Put boolean.
   *
   * @param key the key
   * @param value the value
   * @return the editor
   */
  @Override
  public Editor putBoolean(String key, boolean value) {
    return this.putObject(key, value);
  }

  /**
   * Removes the.
   *
   * @param key the key
   * @return the editor
   */
  @Override
  public synchronized Editor remove(String key) {
    this.editorProperties.remove(key);
    return this;
  }

  /**
   * Clear.
   *
   * @return the editor
   */
  @Override
  public synchronized Editor clear() {
    this.editorProperties.clear();
    return this;
  }

  /**
   * Commit.
   *
   * @return true, if successful
   */
  @Override
  public synchronized boolean commit() {
    return this.prefs.commit(this.editorProperties);
  }

  /** Apply. */
  @Override
  public synchronized void apply() {
    this.prefs.apply(this.editorProperties);
  }
}
