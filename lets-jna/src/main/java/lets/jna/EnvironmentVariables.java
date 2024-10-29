package lets.jna;

import lets.core.DataResultSupport;
import lets.core.ResultSupport;

public interface EnvironmentVariables {

  /**
   * Returns the value of the specified variable
   *
   * @param variable The name of the variable.
   * @return a value for the variable.
   */
  DataResultSupport<String> getValue(String variable);

  /**
   * Returns the value of the specified variable
   *
   * @param variable The name of the variable.
   * @param isExpanded Expanded variable.
   * @return a value for the variable.
   */
  DataResultSupport<String> getValue(String variable, boolean isExpanded);



  /**
   * Sets the value of the specified variable.
   *
   * @param variable The name of the variable.
   * @param value The value of the variable.
   * @param isExpanded Expanded the value.
   */
  ResultSupport setValue(String variable, String value, boolean isExpanded);

  /**
   * Removes specified variable.
   *
   * @param variable The name of the variable.
   */
  ResultSupport removeVariable(String variable);

  /**
   * Verifies if there is a specified variable in the environment.
   *
   * @param variable The name of the variable.
   * @return TRUE, if the specified variable exists in the environment; otherwise FALSE.
   */
  DataResultSupport<Boolean> contains(String variable);

  /**
   * Returns an array of the variable names.
   *
   * @return An array of the variable names.
   */
  DataResultSupport<String[]> getVariableNames();
}
