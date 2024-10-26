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

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import lets.core.CoreUtils;
import lets.core.DataResultSupport;
import lets.core.LoggerService;
import lets.core.ResultSupport;
import lets.core.app.App;
import lets.core.file.FileBackupSupport;
import lets.core.file.FileRestoreSupport;
import lets.core.io.FileUtils;
import lets.core.json.JsonService;
import lets.core.preference.SharedPreferences;
import lets.core.storage.StorageService;
import org.slf4j.Logger;

/** DefaultSharedPreferences. */
public class DefaultSharedPreferences
    implements SharedPreferences, FileBackupSupport, FileRestoreSupport {

  /** The properties. */
  private final Properties properties = new Properties();

  /** The logger service. */
  LoggerService loggerService;

  /** The json service. */
  JsonService jsonService;

  /** The logger. */
  transient Logger logger;

  /** The listeners. */
  List<OnSharedPreferenceChangeListener> listeners =
      new ArrayList<OnSharedPreferenceChangeListener>();

  /** The app. */
  App app;

  /** The storage service. */
  StorageService storageService;

  /**
   * Instantiates a new default shared preferences.
   *
   * @param app the app
   * @param storageService the storage service
   * @param loggerService the logger service
   * @param jsonService the json service
   */
  public DefaultSharedPreferences(
      App app,
      StorageService storageService,
      LoggerService loggerService,
      JsonService jsonService) {
    this.app = app;
    this.storageService = storageService;
    this.loggerService = loggerService;
    this.jsonService = jsonService;
    this.logger = loggerService.getLogger(this.getClass());
    this.registerOnSharedPreferenceChangeListener(this.app);
  }

  /**
   * Gets the string.
   *
   * @param key the key
   * @param defValue the def value
   * @return the string
   */
  @Override
  public String getString(String key, String defValue) {
    return this.getObject(key, defValue, String.class);
  }

  /**
   * Gets the string set.
   *
   * @param key the key
   * @param defValues the def values
   * @return the string set
   */
  @Override
  public synchronized Set<String> getStringSet(String key, Set<String> defValues) {
    if (this.contains(key)) {
      String json = this.properties.getProperty(key);
      try {
        List<String> list = this.jsonService.listFromJson(json, String.class);
        return new HashSet<String>(list);
      } catch (Throwable e) {
        this.logger.error("getStringSet key={} error={}", key, e.getMessage());
      }
    }
    return defValues;
  }

  /**
   * Gets the object.
   *
   * @param <T> the generic type
   * @param key the key
   * @param defValue the def value
   * @param objectClass the object class
   * @return the object
   */
  @Override
  public synchronized <T> T getObject(String key, T defValue, Class<T> objectClass) {
    if (this.contains(key)) {
      String json = this.properties.getProperty(key);
      this.logger.debug("getObject key={} json={}", key, json);
      try {
        return this.jsonService.fromJson(json, objectClass);
      } catch (Throwable e) {
        this.logger.error("getObject key={} error={}", key, e.getMessage());
      }
    }
    return defValue;
  }

  /**
   * Gets the object.
   *
   * @param <T> the generic type
   * @param props the props
   * @param key the key
   * @param objectClass the object class
   * @return the object
   */
  public synchronized <T> DataResultSupport<T> getObject(
      Properties props, String key, Class<T> objectClass) {
    DataResultSupport<T> result = new DataResultSupport<T>();
    try {
      CoreUtils.checkNotNull(props, "props not allow null.");
      CoreUtils.checkNotNull(key, "Key not allow null.");
      CoreUtils.checkNotNull(objectClass, "object class not allow null.");
      CoreUtils.checkState(props.containsKey(key), "props not contains key:%s", key);
      String json = props.getProperty(key);
      result.setData(this.jsonService.fromJson(json, objectClass));
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Gets the objects.
   *
   * @param <T> the generic type
   * @param key the key
   * @param defValues the def values
   * @param objectClass the object class
   * @return the objects
   */
  @Override
  public synchronized <T> List<T> getObjects(String key, List<T> defValues, Class<T> objectClass) {
    if (this.contains(key)) {
      String json = this.properties.getProperty(key);
      try {
        return this.jsonService.listFromJson(json, objectClass);
      } catch (Throwable e) {
        this.logger.info("getObjects key={} error={}", key, e.getMessage());
      }
    }
    return defValues;
  }

  /**
   * Gets the int.
   *
   * @param key the key
   * @param defValue the def value
   * @return the int
   */
  @Override
  public int getInt(String key, int defValue) {
    return this.getObject(key, defValue, Integer.class);
  }

  /**
   * Gets the long.
   *
   * @param key the key
   * @param defValue the def value
   * @return the long
   */
  @Override
  public long getLong(String key, long defValue) {
    return this.getObject(key, defValue, Long.class);
  }

  /**
   * Gets the float.
   *
   * @param key the key
   * @param defValue the def value
   * @return the float
   */
  @Override
  public float getFloat(String key, float defValue) {
    return this.getObject(key, defValue, Float.class);
  }

  /**
   * Gets the boolean.
   *
   * @param key the key
   * @param defValue the def value
   * @return the boolean
   */
  @Override
  public boolean getBoolean(String key, boolean defValue) {
    return this.getObject(key, defValue, Boolean.class);
  }

  /**
   * Contains.
   *
   * @param key the key
   * @return true, if successful
   */
  @Override
  public synchronized boolean contains(String key) {
    return this.properties.containsKey(key);
  }

  /**
   * Edits the.
   *
   * @return the editor
   */
  @Override
  public Editor edit() {
    return new DefaultSharedPreferencesEditor(this, this.jsonService, this.loggerService);
  }

  /**
   * Register on shared preference change listener.
   *
   * @param listener the listener
   */
  @Override
  public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
    this.listeners.add(listener);
  }

  /**
   * Unregister on shared preference change listener.
   *
   * @param listener the listener
   */
  @Override
  public void unregisterOnSharedPreferenceChangeListener(
      OnSharedPreferenceChangeListener listener) {
    this.listeners.remove(listener);
  }

  /**
   * On shared preference changed.
   *
   * @param key the key
   * @param value the value
   */
  public void onSharedPreferenceChanged(String key, Object value) {
    for (OnSharedPreferenceChangeListener listener : this.listeners) {
      try {
        listener.onSharedPreferenceChanged(this, key, value);
      } catch (Throwable e) {
        this.logger.error("onSharedPreferenceChanged key={} error={}", key, e);
      }
    }
  }

  /**
   * Gets the properties.
   *
   * @return the properties
   */
  public Properties getProperties() {
    return properties;
  }

  /**
   * Gets the json service.
   *
   * @return the json service
   */
  public JsonService getJsonService() {
    return jsonService;
  }

  /**
   * Gets the logger.
   *
   * @return the logger
   */
  public Logger getLogger() {
    return logger;
  }

  /**
   * Commit.
   *
   * @param editorProperties the editor properties
   * @return true, if successful
   */
  public synchronized boolean commit(Properties editorProperties) {
    try {
      this.apply(editorProperties);
      File preferencesFile = this.getPreferencesFile();
      this.logger.debug("commit write to file:{}", preferencesFile);
      CoreUtils.writeProperties(this.properties, preferencesFile);
    } catch (Throwable e) {
      this.logger.error("commit error:{}", e);
      return false;
    }
    return true;
  }

  /**
   * Commit.
   *
   * @param editorProperties the editor properties
   * @param sync the sync
   * @return true, if successful
   */
  public synchronized boolean commit(Properties editorProperties, boolean sync) {
    try {
      this.apply(editorProperties);
      File preferencesFile = this.getPreferencesFile();
      this.logger.debug("commit write to file:{} sync:{}", preferencesFile, sync);
      CoreUtils.writeProperties(this.properties, preferencesFile, sync);
    } catch (Throwable e) {
      this.logger.error("commit error:{}", e);
      return false;
    }
    return true;
  }

  /**
   * Backup.
   *
   * @param preferencesFile the preferences file
   * @param sync the sync
   * @return true, if successful
   */
  public synchronized boolean backup(File preferencesFile, boolean sync) {
    try {
      this.logger.debug("backup write to file:{} sync:{}", preferencesFile, sync);
      CoreUtils.writeProperties(this.properties, preferencesFile, sync);
    } catch (Throwable e) {
      this.logger.error("commit error:{}", e);
      return false;
    }
    return true;
  }

  /**
   * Apply.
   *
   * @param editorProperties the editor properties
   */
  public synchronized void apply(Properties editorProperties) {
    this.properties.clear();
    this.properties.putAll(editorProperties);
  }

  /**
   * Gets the preferences file.
   *
   * @return the preferences file
   */
  public synchronized File getPreferencesFile() {
    File preferencesDir = this.storageService.getPrivateStorage(this.app.getPreferencesDir()).get();
    if (!preferencesDir.exists()) {
      preferencesDir.mkdirs();
    }
    File preferencesFile = new File(preferencesDir, this.app.getPreferencesName());
    return preferencesFile;
  }

  /**
   * Gets the preferences file backup.
   *
   * @param preferencesFile the preferences file
   * @param n the n
   * @return the preferences file backup
   */
  public synchronized File getPreferencesFileBackup(File preferencesFile, int n) {
    File dir = preferencesFile.getParentFile();
    String backupFilename = String.format("%s.backup.%s", preferencesFile.getName(), n);
    return new File(dir, backupFilename);
  }

  /**
   * Gets the preferences file temp.
   *
   * @param preferencesFile the preferences file
   * @param n the n
   * @return the preferences file temp
   */
  public synchronized File getPreferencesFileTemp(File preferencesFile, int n) {
    File dir = preferencesFile.getParentFile();
    String backupFilename = String.format("%s.temp.%s", preferencesFile.getName(), n);
    return new File(dir, backupFilename);
  }

  /**
   * Load.
   *
   * @return true, if successful
   */
  public synchronized boolean load() {
    try {
      File preferencesFile = this.getPreferencesFile();
      Properties props = CoreUtils.readProperties(preferencesFile);
      this.properties.clear();
      this.properties.putAll(props);
    } catch (Throwable e) {
      this.logger.error("load error:{}", e.getMessage());
      return false;
    }
    return true;
  }

  /**
   * Load.
   *
   * @param preferencesFile the preferences file
   * @return true, if successful
   */
  public synchronized boolean load(File preferencesFile) {
    try {
      Properties props = CoreUtils.readProperties(preferencesFile);
      this.properties.clear();
      this.properties.putAll(props);
    } catch (Throwable e) {
      this.logger.error("load error:{}", e.getMessage());
      return false;
    }
    return true;
  }

  /**
   * Load.
   *
   * @param props the props
   * @return true, if successful
   */
  public synchronized boolean load(Properties props) {
    try {
      CoreUtils.checkNotNull(props, "load props not allow null");
      this.properties.clear();
      this.properties.putAll(props);
    } catch (Throwable e) {
      this.logger.error("load error:{}", e.getMessage());
      return false;
    }
    return true;
  }

  /**
   * Load properties.
   *
   * @param preferencesFile the preferences file
   * @return the data result support
   */
  public synchronized DataResultSupport<Properties> loadProperties(File preferencesFile) {
    DataResultSupport<Properties> result = new DataResultSupport<Properties>();
    try {
      CoreUtils.checkState(preferencesFile.exists());
      Properties props = CoreUtils.readProperties(preferencesFile);
      result.setData(props);
    } catch (Throwable e) {
      this.logger.error("loadProperties error:{}", e);
      result.onException(e);
    }
    return result;
  }

  /**
   * Backup to dir.
   *
   * @param targetDir the target dir
   * @return the data result support
   */
  @Override
  public synchronized DataResultSupport<List<File>> backupToDir(File targetDir) {
    DataResultSupport<List<File>> result = new DataResultSupport<List<File>>();
    try {
      result.setData(new ArrayList<File>());
      File targetFile = new File(targetDir, this.app.getPreferencesName());
      FileUtils.copyFile(this.getPreferencesFile(), targetFile, true);
      result.getData().add(targetFile);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Backup to dirs.
   *
   * @param targetDirs the target dirs
   * @return the result support
   */
  @Override
  public synchronized ResultSupport backupToDirs(File... targetDirs) {
    ResultSupport result = new ResultSupport();
    result.setSuccess(false);
    for (File targetDir : targetDirs) {
      ResultSupport targetResult = this.backupToDir(targetDir);
      if (targetResult.isSuccess()) {
        result.onSuccess("备份成功");
      }
    }
    return result;
  }

  /**
   * Restore from dir.
   *
   * @param targetDir the target dir
   * @return the data result support
   */
  @Override
  public synchronized DataResultSupport<List<File>> restoreFromDir(File targetDir) {
    DataResultSupport<List<File>> result = new DataResultSupport<List<File>>();
    try {
      result.setData(new ArrayList<File>());
      File sourceFile = new File(targetDir, this.app.getPreferencesName());
      File targetFile = this.getPreferencesFile();
      CoreUtils.checkState(sourceFile.exists(), "文件%s不存在", sourceFile.getAbsolutePath());
      CoreUtils.checkState(sourceFile.canRead(), "文件%s无读取权限", sourceFile.getAbsolutePath());
      this.logger.debug("restoreFromDir:{} copy {}-> {} ", targetDir, sourceFile, targetFile);
      FileUtils.copyFile(sourceFile, targetFile, true);
      this.load();
      result.getData().add(sourceFile);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Restore from dirs.
   *
   * @param targetDirs the target dirs
   * @return the result support
   */
  @Override
  public synchronized ResultSupport restoreFromDirs(File... targetDirs) {
    ResultSupport result = new ResultSupport();
    result.setSuccess(false);
    for (File targetDir : targetDirs) {
      ResultSupport targetResult = this.restoreFromDir(targetDir);
      if (targetResult.isSuccess()) {
        result.onSuccess(targetResult.getMessage());
        return result;
      }
    }
    return result;
  }
}
