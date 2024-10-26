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
package lets.core.storage;

import java.io.File;
import lets.core.MutableValue;

/** The Interface StorageService. */
public interface StorageService {

  /** The directory music. */
  String DIRECTORY_MUSIC = "Music";

  /** The directory pictures. */
  String DIRECTORY_PICTURES = "Pictures";

  /** The directory movies. */
  String DIRECTORY_MOVIES = "Movies";

  /** The directory downloads. */
  String DIRECTORY_DOWNLOADS = "Download";

  /** The directory documents. */
  String DIRECTORY_DOCUMENTS = "Documents";

  /**
   * Get a storage directory that is private to the environment that is calling this method. In the
   * case of iOS or Android, the returned directory is private to the enclosing application.
   *
   * @return an optional with a private storage directory for an application
   */
  MutableValue<File> getPrivateStorage();

  /**
   * Gets the private storage.
   *
   * @param subdirectory the subdirectory
   * @return the private storage
   */
  MutableValue<File> getPrivateStorage(String subdirectory);

  /**
   * Get a public storage directory location.
   *
   * <p>Note that on Android the public location could be mapped to a removable memory device and
   * may not always be available. Users of this method are advised to call {@link
   * #isExternalStorageWritable()} or {@link #isExternalStorageReadable()} to avoid surprises.
   *
   * <p>Note also that on Android, permissions will need to be set to access external storage. See:
   * <a href=
   * "https://developer.android.com/training/basics/data-storage/files.html">https://developer.android.com/training/basics/data-storage/files.html</a>.
   *
   * @param subdirectory under the root of public storage that is required. On Android the supplied
   *     subdirectory should not be null.
   * @return an MutableValue of a File representing the requested directory location. The location
   *     may not yet exist. It is the responsibility of the programmer to ensure that the location
   *     exists before using it.
   */
  MutableValue<File> getPublicStorage(String subdirectory);

  /**
   * Checks if external storage is available for read and write access.
   *
   * @return true if the externalStorage is writable (implies readable), false otherwise
   */
  boolean isExternalStorageWritable();

  /**
   * Checks if external storage is available for read access.
   *
   * @return true if the externalStorage is at least readable, false otherwise
   */
  boolean isExternalStorageReadable();
}
