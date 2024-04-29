package best.skn.mail.models;

//? Java::Library
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Mail sender request info class for @RequestBody/@RequestPart annotated params in controllers
 *
 * @author SKN Shukhan
 * @version 2.0.0
 * @since 2024-05-29
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
   * @since v2.0.0
   */
  private String from;
  /**
   * private String property for containing mail receiver email address
   *
   * @since v2.0.0
   */
  private String to;
  /**
   * private String property for containing mail subject
   *
   * @since v2.0.0
   */
  private String subject;
  /**
   * private String property for containing mail body
   *
   * @since v2.0.0
   */
  private String body;
}
