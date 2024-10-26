/*
 * Copyright (c) 2022 zhoupan (https://github.com/zhoupan).
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
package lets.core.image;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import lets.core.CoreUtils;
import lets.core.LoggerSupport;

/**
 * ThumbnailsUtils.
 *
 * @author zhoupan
 */
public class ThumbnailsUtils {

  /**
   * Resize.
   *
   * @param srcFile the src file
   * @param destFile the dest file
   * @param boxWidth the box width
   * @param boxHeight the box height
   * @throws Exception the exception
   */
  public static void resize(File srcFile, File destFile, int boxWidth, int boxHeight)
      throws Exception {
    Images.of(srcFile).size(boxWidth, boxHeight).toFile(destFile);
  }

  /**
   * Resize.
   *
   * @param srcFile the src file
   * @param outputStream the output stream
   * @param boxWidth the box width
   * @param boxHeight the box height
   * @throws Exception the exception
   */
  public static void resize(File srcFile, OutputStream outputStream, int boxWidth, int boxHeight)
      throws Exception {
    Images.of(srcFile).size(boxWidth, boxHeight).toOutputStream(outputStream);
  }

  /**
   * Resize.
   *
   * @param inputStream the input stream
   * @param outputStream the output stream
   * @param boxWidth the box width
   * @param boxHeight the box height
   * @throws Exception the exception
   */
  public static void resize(
      InputStream inputStream, OutputStream outputStream, int boxWidth, int boxHeight)
      throws Exception {
    Images.of(inputStream).size(boxWidth, boxHeight).toOutputStream(outputStream);
  }

  /**
   * Resize.
   *
   * @param srcFile the src file
   * @param destFile the dest file
   * @param boxWidth the box width
   * @param boxHeight the box height
   * @param ignoreSmall the ignore small
   * @throws Exception the exception
   */
  public static void resize(
      File srcFile, File destFile, int boxWidth, int boxHeight, boolean ignoreSmall)
      throws Exception {
    if (ignoreSmall) {
      InputStream fis = null;
      try {
        ImageInfo info = new ImageInfo();
        fis = new FileInputStream(srcFile);
        info.setInput(fis);
        if (info.check()) {
          if (info.getWidth() < boxWidth) {
            boxWidth = info.getWidth();
          }
          if (info.getHeight() < boxHeight) {
            boxHeight = info.getHeight();
          }
        }
      } catch (Throwable e) {
        LoggerSupport.error("{}", e);
      } finally {
        CoreUtils.closeQuietly(fis);
      }
    }
    Images.of(srcFile).size(boxWidth, boxHeight).toFile(destFile);
  }

  /**
   * Resize.
   *
   * @param srcFile the src file
   * @param outputStream the output stream
   * @param boxWidth the box width
   * @param boxHeight the box height
   * @param ignoreSmall the ignore small
   * @throws Exception the exception
   */
  public static void resize(
      File srcFile, OutputStream outputStream, int boxWidth, int boxHeight, boolean ignoreSmall)
      throws Exception {
    if (ignoreSmall) {
      InputStream fis = null;
      try {
        ImageInfo info = new ImageInfo();
        fis = new FileInputStream(srcFile);
        info.setInput(fis);
        if (info.check()) {
          if (info.getWidth() < boxWidth) {
            boxWidth = info.getWidth();
          }
          if (info.getHeight() < boxHeight) {
            boxHeight = info.getHeight();
          }
        }
      } catch (Throwable e) {
        LoggerSupport.error("{}", e);
      } finally {
        CoreUtils.closeQuietly(fis);
      }
    }
    Images.of(srcFile).size(boxWidth, boxHeight).toOutputStream(outputStream);
  }

  /**
   * Scale.
   *
   * @param srcFile the src file
   * @param destFile the dest file
   * @param scale the scale
   * @throws Exception the exception
   */
  public static void scale(File srcFile, File destFile, double scale) throws Exception {
    Images.of(srcFile).scale(scale).toFile(destFile);
  }

  /**
   * Scale.
   *
   * @param srcFile the src file
   * @param outputStream the output stream
   * @param scale the scale
   * @throws Exception the exception
   */
  public static void scale(File srcFile, OutputStream outputStream, double scale) throws Exception {
    Images.of(srcFile).scale(scale).toOutputStream(outputStream);
  }

  /**
   * Support.
   *
   * @param file the file
   * @return true, if support
   */
  public static boolean support(File file) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try {
      resize(file, bos, 1, 1);
      return true;
    } catch (Throwable e) {
      return false;
    } finally {
      CoreUtils.closeQuietly(bos);
    }
  }

  /**
   * Support.
   *
   * @param bytes the bytes
   * @return true, if successful
   */
  public static boolean support(byte[] bytes) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    try {
      resize(bis, bos, 1, 1);
      bos.close();
      return true;
    } catch (Throwable e) {
      return false;
    }
  }
}
