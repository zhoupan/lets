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

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Objects;
import lets.core.CoreUtils;
import lets.core.DataResultSupport;
import lets.core.StringUtils;
import lets.core.image.io.OutputStreamImageTarget;
import lets.core.mimetypes.MimeType;
import lets.core.mimetypes.MimeTypes;

/**
 * 实现Base64Image编码和解码
 *
 * @author zhoupan
 */
public class Base64Image {

  /** The Constant FLAG_DATA. */
  private static final String FLAG_DATA = "data:";

  /** The Constant FLAG_BASE64. */
  private static final String FLAG_BASE64 = ";base64,";

  /** The data. */
  private String data;

  /** The width. */
  private int width;

  /** The height. */
  private int height;

  /** The type. */
  private MimeType type;

  /** Instantiates a new base 64 image. */
  public Base64Image() {}

  /**
   * Decode.
   *
   * @param data the data
   * @return the data result support
   */
  public static DataResultSupport<Image> decode(String data) {
    DataResultSupport<Image> result = new DataResultSupport<Image>();
    try {
      CoreUtils.checkState(StringUtils.startsWith(data, FLAG_DATA), "starts with data: required.");
      String base64 = StringUtils.substringAfter(data, FLAG_BASE64);
      CoreUtils.checkState(StringUtils.isNotEmpty(base64), "base64 required.");
      byte[] bytes = Base64.getDecoder().decode(base64);
      BytesImage image = new BytesImage(bytes);
      DataResultSupport<ImageInfo> getImageInfo = image.getImageInfo();
      CoreUtils.checkState(
          getImageInfo.isSuccess(), "read image error:%s", getImageInfo.getMessage());
      String type = StringUtils.substringBefore(data, FLAG_BASE64);
      if (StringUtils.isNotEmpty(type)) {
        type = StringUtils.substringAfter(type, FLAG_DATA);
        image.setType(MimeTypes.getInstance().getByType(type));
      }
      result.setData(image);
    } catch (Throwable e) {
      result.onException(e);
    }
    return result;
  }

  /**
   * Encode jpg.
   *
   * @param image the image
   * @return the data result support
   */
  public static DataResultSupport<Base64Image> encodeJpg(BufferedImage image) {
    return encode(image, "jpg");
  }

  /**
   * Encode png.
   *
   * @param image the image
   * @return the data result support
   */
  public static DataResultSupport<Base64Image> encodePng(BufferedImage image) {
    return encode(image, "png");
  }

  /**
   * Encode.
   *
   * @param image the image
   * @param format the format
   * @return the data result support
   */
  public static DataResultSupport<Base64Image> encode(BufferedImage image, String format) {
    DataResultSupport<Base64Image> result = new DataResultSupport<Base64Image>();
    Base64Image base64Image = new Base64Image();
    result.setData(base64Image);

    ByteArrayOutputStream baos = null;
    try {
      // 图片:基本信息
      base64Image.type = MimeTypes.getInstance().getByExtension(format);
      base64Image.width = image.getWidth();
      base64Image.height = image.getHeight();
      // 写图片数据
      baos = new ByteArrayOutputStream();
      OutputStreamImageTarget stream = new OutputStreamImageTarget(baos);
      stream.setOutputFormatName(format);
      stream.write(image);
      // 图片:Base64编码
      StringBuilder sb = new StringBuilder();
      sb.append(FLAG_DATA);
      sb.append(base64Image.type.getMimeType());
      sb.append(FLAG_BASE64);
      sb.append(Base64.getEncoder().encodeToString(baos.toByteArray()));
      base64Image.data = sb.toString();
    } catch (Throwable e) {
      result.onException(e);
    } finally {
      CoreUtils.closeQuietly(baos);
    }
    return result;
  }

  /**
   * Gets the data.
   *
   * @return the data
   */
  public String getData() {
    return data;
  }

  /**
   * Gets the width.
   *
   * @return the width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Gets the height.
   *
   * @return the height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Gets the type.
   *
   * @return the type
   */
  public MimeType getType() {
    return type;
  }

  /**
   * Hash code.
   *
   * @return the int
   */
  @Override
  public int hashCode() {
    return Objects.hash(data, height, type, width);
  }

  /**
   * Equals.
   *
   * @param obj the obj
   * @return true, if successful
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Base64Image other = (Base64Image) obj;
    return Objects.equals(data, other.data)
        && height == other.height
        && Objects.equals(type, other.type)
        && width == other.width;
  }

  /**
   * To string.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "Base64Image [width="
        + width
        + ", height="
        + height
        + ", type="
        + type
        + ", data="
        + data
        + "]";
  }
}
