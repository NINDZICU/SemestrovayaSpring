package ru.kpfu.models.forms;

/**
 *
 * @author Alexander Ferenets <istamendil.info>
 */
public class LoginForm {

  private String password;
  private String name;

  /**
   * Get the value of password
   *
   * @return the value of password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set the value of password
   *
   * @param password new value of password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Get the value of username
   *
   * @return the value of username
   */
  public String getName() {
    return name;
  }

  /**
   * Set the value of username
   *
   * @param name new value of username
   */
  public void setName(String name) {
    this.name = name;
  }

}
