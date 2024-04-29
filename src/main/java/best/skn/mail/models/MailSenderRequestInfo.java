package best.skn.mail.models;

//? Java::Library
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Mail sender request body class for @RequestBody annotated params in controllers
 *
 * @author SKN
 * @version 1.2.4
 * @since 2024-03-07
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MailSenderRequestInfo {

  /**
   * private String property for containing mail sender email address
   *
   * @since v1.0.0
   */
  private String from;
  /**
   * private String property for containing mail receiver email address
   *
   * @since v1.0.0
   */
  private String to;
  /**
   * private String property for containing mail subject
   *
   * @since v1.0.0
   */
  private String subject;
  /**
   * private String property for containing mail body
   *
   * @since v1.0.0
   */
  private String body;
}
