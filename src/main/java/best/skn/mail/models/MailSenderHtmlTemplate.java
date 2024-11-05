package best.skn.mail.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mail sender HTML template class for processing proper thymeleaf HTML template info in controllers
 *
 * @author SKN Shukhan
 * @version 2.1.0
 * @since 2024-05-29
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
