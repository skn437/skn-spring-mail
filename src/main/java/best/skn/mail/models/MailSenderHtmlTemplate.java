package best.skn.mail.models;

//? Java::Library
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Mail sender HTML template class for processing proper thymeleaf HTML template info in controllers
 *
 * @author SKN Shukhan
 * @version 2.0.2
 * @since 2024-05-29
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
