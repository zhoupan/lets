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
package lets.core.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lets.core.CoreUtils;
import lets.core.InputOutputResultSupport;
import lets.core.LoggerSupport;
import lets.core.StopWatch;
import lets.core.function.InputOutputCallback;

/**
 * 处理状态管理. 1.singleWork 限制某个方法同一时间只允许进入一次(例如:线程1调用了doWork方法，在doWork没有退出之前,任何线程再次调用doWork会触发异常)
 *
 * @author zhoupan
 */
public class ProcessStates {

  /** The Class ProcessState. */
  public static class ProcessState {

    /** The name. */
    public final String name;

    /** The state. */
    public final boolean state;

    /**
     * Instantiates a new process state.
     *
     * @param name the name
     * @param state the state
     */
    public ProcessState(String name, boolean state) {
      super();
      this.name = name;
      this.state = state;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = (prime * result) + ((name == null) ? 0 : name.hashCode());
      return result;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
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
      ProcessState other = (ProcessState) obj;
      if (name == null) {
        if (other.name != null) {
          return false;
        }
      } else if (!name.equals(other.name)) {
        return false;
      }
      return true;
    }
  }

  /** The states. */
  public final Map<String, ProcessState> states = new ConcurrentHashMap<String, ProcessState>();

  /**
   * 一次处理一个,多次请求被忽略.
   *
   * @param <Input> 输入类型
   * @param <Output> 输出类型
   * @param clasz 处理名称(通常是一个方法名或者一个类名)
   * @param input 输入
   * @param callback 处理输入输出
   * @return 成功,返回输出,否则返回错误消息.
   */
  public <Input, Output> InputOutputResultSupport<Input, Output> singleWork(
      Class<?> clasz, Input input, InputOutputCallback<Input, Output> callback) {
    return this.singleWork(clasz.getName(), input, callback);
  }

  /**
   * 一次处理一个,多次请求被忽略.
   *
   * @param <Input> 输入类型
   * @param <Output> 输出类型
   * @param processName 处理名称(通常是一个方法名或者一个类名)
   * @param input 输入
   * @param callback 处理输入输出
   * @return 成功,返回输出,否则返回错误消息.
   */
  public <Input, Output> InputOutputResultSupport<Input, Output> singleWork(
      String processName, Input input, InputOutputCallback<Input, Output> callback) {
    InputOutputResultSupport<Input, Output> result = new InputOutputResultSupport<Input, Output>();
    boolean state = false;
    StopWatch watch = new StopWatch();
    try {
      CoreUtils.checkArgument(!this.states.containsKey(processName), "正在处理,请稍后再试");
      state = true;
      watch.start();
      LoggerSupport.debug("{}:开始处理", processName);
      this.states.put(processName, new ProcessState(processName, state));
      result.setInput(input);
      result.setOutput(callback.callback(input));
    } catch (Throwable e) {
      result.onException(e);
    } finally {
      if (state) {
        watch.stop();
        LoggerSupport.debug("{}:结束处理 耗时:{}", processName, watch.formatTime());
        this.states.remove(processName);
      }
    }
    return result;
  }
}
