package best.skn.mail.models;

/**
 * Mail sender HTML template class for processing proper thymeleaf HTML template info in controllers
 *
 * @author SKN Shukhan
 * @version 2.4.0
 * @since 2024-05-29
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
public class MailSenderHtmlTemplate {

  /**
   * Private String property for containing the Thymeleaf HTML Template name in the project
   *
   * @since v2.0.0
   */
  private String templateName;
  /**
   * Private String property for containing the variable name inside Thymeleaf HTML Template in the project
   *
   * @since v2.0.0
   */
  private String variableName;

  /**
   * Public Constructor with all private properties
   *
   * @param templateName String containing the Thymeleaf HTML Template name in the project
   * @param variableName String containing the variable name inside Thymeleaf HTML Template in the project
   *
   * @since v2.1.0
   */
  public MailSenderHtmlTemplate(String templateName, String variableName) {
    this.templateName = templateName;
    this.variableName = variableName;
  }

  /**
   * Getter method for `templateName` field
   *
   * @return String for `templateName` field
   *
   * @since v2.1.0
   */
  public String getTemplateName() {
    return this.templateName;
  }

  /**
   * Setter method for `templateName` field
   *
   * @param value String for `templateName` field
   *
   * @since v2.1.0
   */
  public void setTemplateName(String value) {
    this.templateName = value;
  }

  /**
   * Getter method for `variableName` field
   *
   * @return String for `variableName` field
   *
   * @since v2.1.0
   */
  public String getVariableName() {
    return this.variableName;
  }

  /**
   * Setter method for `variableName` field
   *
   * @param value String for `variableName` field
   *
   * @since v2.1.0
   */
  public void setVariableName(String value) {
    this.variableName = value;
  }

  /**
   * Overridden built-in `toString` method
   *
   * @return Formatted String to print out the class
   *
   * @since v2.1.0
   */
  @Override
  public String toString() {
    return String.format(
      "%s(templateName = '%s', variableName = '%s')",
      this.getClass().getSimpleName(),
      this.templateName,
      this.variableName
    );
  }
}
