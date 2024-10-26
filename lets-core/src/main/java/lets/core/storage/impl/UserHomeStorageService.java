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
package lets.core.storage.impl;

import java.io.File;
import lets.core.LoggerService;
import lets.core.MutableValue;
import lets.core.StringUtils;
import lets.core.SystemUtils;
import lets.core.storage.StorageService;
import org.slf4j.Logger;

/**
 * An implementation of StorageService, it currently writes to the users home directory under
 * '${user.home}/${packageName}'
 */
public class UserHomeStorageService implements StorageService {

  /** The package name. */
  private final String packageName;

  /** The logger. */
  protected transient Logger logger;

  /** The Constant USER_HOME_DIR. */
  public static final MutableValue<File> USER_HOME_DIR = new MutableValue<File>();

  /** The Constant EXTERNAL_FILES_DIR. */
  public static final MutableValue<File> EXTERNAL_FILES_DIR = new MutableValue<File>();

  /**
   * Instantiates a new user home storage service.
   *
   * @param packageName the package name
   * @param loggerService the logger service
   */
  public UserHomeStorageService(String packageName, LoggerService loggerService) {
    super();
    this.packageName = packageName;
    this.logger = loggerService.getLogger(this.getClass());
  }

  /**
   * Gets the private storage.
   *
   * @return the private storage
   */
  @Override
  public MutableValue<File> getPrivateStorage() {
    try {
      File home = this.onResolveUserHome();
      if (StringUtils.equals(home.getName(), this.packageName)) {
        return MutableValue.of(home);
      }
      this.logger.info("home:{} packageName:{}", home, this.packageName);
      File pkgDir = new File(home, this.packageName);
      if (!pkgDir.exists()) {
        pkgDir.mkdirs();
      }
      return MutableValue.of(pkgDir);
    } catch (Exception e) {
      return MutableValue.empty();
    }
  }

  /**
   * On resolve user home.
   *
   * @return the file
   */
  public File onResolveUserHome() {
    if (USER_HOME_DIR.isPresent()) {
      return USER_HOME_DIR.getValue();
    }
    return SystemUtils.getUserHome();
  }

  /**
   * On resolve external files dir.
   *
   * @return the file
   */
  public File onResolveExternalFilesDir() {
    if (EXTERNAL_FILES_DIR.isPresent()) {
      return EXTERNAL_FILES_DIR.getValue();
    }
    return SystemUtils.getUserHome();
  }

  /**
   * Gets the public storage.
   *
   * @param subdirectory the subdirectory
   * @return the public storage
   */
  @Override
  public MutableValue<File> getPublicStorage(String subdirectory) {
    try {
      File home = this.onResolveExternalFilesDir();
      File file;
      if ((null == subdirectory) || subdirectory.isEmpty()) {
        file = home;
      } else {
        file = new File(home, subdirectory);
      }
      if (!file.exists()) {
        file.mkdirs();
      }
      return MutableValue.of(file);
    } catch (Throwable e) {
      this.logger.error("getPublicStorage({}) error:{}", subdirectory, e);
      return MutableValue.empty();
    }
  }

  /**
   * Checks if is external storage writable.
   *
   * @return true, if is external storage writable
   */
  @Override
  public boolean isExternalStorageWritable() {
    return this.onResolveExternalFilesDir().canWrite();
  }

  /**
   * Checks if is external storage readable.
   *
   * @return true, if is external storage readable
   */
  @Override
  public boolean isExternalStorageReadable() {
    return this.onResolveExternalFilesDir().canRead();
  }

  /**
   * Gets the private storage.
   *
   * @param subdirectory the subdirectory
   * @return the private storage
   */
  @Override
  public MutableValue<File> getPrivateStorage(String subdirectory) {
    try {
      File home = this.getPrivateStorage().get();
      File file;
      if ((null == subdirectory) || subdirectory.isEmpty()) {
        return MutableValue.of(home);
      }
      file = new File(home, subdirectory);
      if (!file.exists()) {
        file.mkdirs();
      }
      return MutableValue.of(file);
    } catch (Throwable e) {
      this.logger.error("getPublicStorage({}) error:{}", subdirectory, e);
      return MutableValue.empty();
    }
  }
}
