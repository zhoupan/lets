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
package lets.core.component;

import lets.core.ResultSupport;
import lets.core.StringUtils;
import lets.core.event.DataEvent;

/** ToastModel. */
public class ToastModel {

  /** ToastEvent. */
  public static class ToastEvent extends DataEvent<ToastModel> {

    public static ToastEvent from(
        ResultSupport result, String successMessage, String errorMessage) {
      ToastModel model = new ToastModel();
      if (result.isSuccess()) {
        model.success();
        if (StringUtils.isNotEmpty(successMessage)) {
          model.title(successMessage);
        } else {
          model.title(result.getMessage());
        }
      } else {
        model.error();
        if (StringUtils.isNotEmpty(errorMessage)) {
          model.title(errorMessage);
          model.subtitle(result.getMessage());
        } else {
          model.title(result.getMessage());
        }
      }
      return new ToastEvent(model);
    }

    public static ToastEvent fromMessage(String message) {
      ToastModel model = new ToastModel();
      model.title(message);
      return new ToastEvent(model);
    }

    public ToastEvent(ToastModel data) {
      super(data);
    }

    @Override
    public String toString() {
      return "ToastEvent [data=" + data + "]";
    }
  }

  /**
   * Show the view or text notification for a short period of time. This time could be
   * user-definable. This is the default.
   */
  public static final int LENGTH_SHORT = 0;

  /**
   * Show the view or text notification for a long period of time. This time could be
   * user-definable.
   */
  public static final int LENGTH_LONG = 1;

  /** The Constant TYPE_SUCCESS. */
  public static final int TYPE_SUCCESS = 0;

  /** The Constant TYPE_INFO. */
  public static final int TYPE_INFO = 1;

  /** The Constant TYPE_ERROR. */
  public static final int TYPE_ERROR = 2;

  /** Set how long to show the view. */
  public int duration = LENGTH_SHORT;

  /** The title. */
  public String title;

  /** The subtitle. */
  public String subtitle;

  /** The type. */
  public int type = TYPE_SUCCESS;

  public ToastModel title(String title) {
    this.title = title;
    return this;
  }

  public ToastModel subtitle(String subtitle) {
    this.subtitle = subtitle;
    return this;
  }

  public ToastModel success() {
    this.type = TYPE_SUCCESS;
    return this;
  }

  public ToastModel info() {
    this.type = TYPE_INFO;
    return this;
  }

  public ToastModel error() {
    this.type = TYPE_ERROR;
    return this;
  }

  public ToastModel duration(boolean isLong) {
    if (isLong) {
      this.duration = LENGTH_LONG;
    } else {
      this.duration = LENGTH_SHORT;
    }
    return this;
  }

  @Override
  public String toString() {
    return "ToastModel [duration="
        + duration
        + ", title="
        + title
        + ", subtitle="
        + subtitle
        + ", type="
        + type
        + "]";
  }
}
