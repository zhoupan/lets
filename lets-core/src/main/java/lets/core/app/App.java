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
package lets.core.app;

import lets.core.StringUtils;
import lets.core.SystemUtils;
import lets.core.preference.SharedPreferences;
import lets.core.preference.SharedPreferences.OnSharedPreferenceChangeListener;

public class App implements OnSharedPreferenceChangeListener {

  /** The package name. */
  private String packageName;

  /** The db migration locations. */
  private String[] dbMigrationLocations = new String[] {"db/migration"};

  /** The db dir. */
  private String dbDir = "databases";

  /** The db name. */
  private String dbName = "app";

  /** The preferences dir. */
  private String preferencesDir = "preferences";

  /** The preferences name. */
  private String preferencesName = "app.properties";

  /** The build config. */
  public final AppBuildConfig buildConfig = new AppBuildConfig();

  /** The device. */
  public final AppDevice device = new AppDevice();

  /** Instantiates a new app. */
  public App() {
    super();
    this.setPackageName(this.getClass().getPackage().getName());
  }

  /**
   * Gets the package name.
   *
   * @return the package name
   */
  public String getPackageName() {
    return packageName;
  }

  /**
   * Sets the package name.
   *
   * @param packageName the new package name
   */
  public void setPackageName(String packageName) {
    this.packageName = packageName;
    if (!SystemUtils.isAndroid()) {
      this.setDbMigrationLocationsUnderPackage();
    }
  }

  /**
   * Gets the db migration locations.
   *
   * @return the db migration locations
   */
  public String[] getDbMigrationLocations() {
    return dbMigrationLocations;
  }

  /**
   * Sets the db migration locations.
   *
   * @param dbMigrationLocations the new db migration locations
   */
  public void setDbMigrationLocations(String[] dbMigrationLocations) {
    this.dbMigrationLocations = dbMigrationLocations;
  }

  /** Sets the db migration locations under package. */
  public void setDbMigrationLocationsUnderPackage() {
    String pkgName = this.getPackageName();
    String pkgResource = StringUtils.replace(pkgName, ".", "/");
    this.setDbMigrationLocations(new String[] {pkgResource + "/db/migration"});
  }

  /**
   * Gets the db dir.
   *
   * @return the db dir
   */
  public String getDbDir() {
    return dbDir;
  }

  /**
   * Sets the db dir.
   *
   * @param dbDir the new db dir
   */
  public void setDbDir(String dbDir) {
    this.dbDir = dbDir;
  }

  /**
   * Gets the db name.
   *
   * @return the db name
   */
  public String getDbName() {
    return dbName;
  }

  /**
   * Sets the db name.
   *
   * @param dbName the new db name
   */
  public void setDbName(String dbName) {
    this.dbName = dbName;
  }

  /**
   * On shared preference changed.
   *
   * @param sharedPreferences the shared preferences
   * @param key the key
   * @param value the value
   */
  @Override
  public void onSharedPreferenceChanged(
      SharedPreferences sharedPreferences, String key, Object value) {
    // LoggerSupport.info("onSharedPreferenceChanged: key={} value={}", key, value);
  }

  /**
   * Gets the preferences dir.
   *
   * @return the preferences dir
   */
  public String getPreferencesDir() {
    return preferencesDir;
  }

  /**
   * Sets the preferences dir.
   *
   * @param preferencesDir the new preferences dir
   */
  public void setPreferencesDir(String preferencesDir) {
    this.preferencesDir = preferencesDir;
  }

  /**
   * Gets the preferences name.
   *
   * @return the preferences name
   */
  public String getPreferencesName() {
    return preferencesName;
  }

  /**
   * Sets the preferences name.
   *
   * @param preferencesName the new preferences name
   */
  public void setPreferencesName(String preferencesName) {
    this.preferencesName = preferencesName;
  }
}
