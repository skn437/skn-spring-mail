package best.skn.mail.entities;

//? Java::Library
import org.springframework.stereotype.Component;

/**
 * Mail sender request body interface for @RequestBody annotated params in controllers
 *
 * @author SKN
 * @version 1.2.3
 * @since 2024-03-07
 * @use.case Spring Boot Reactive
 * @dedicated.to Trina, Logno, Atoshi and My Parents
 */
@Component
public interface MailSenderRequestBodyInterface {
  /**
   * A getter method to get the mail sender email address
   *
   * @return a String containing the mail sender email address
   * @since v1.0.0
   */
  public String getFrom();

  /**
   * A getter method to get the mail receiver email address
   *
   * @return a String containing the mail receiver email address
   * @since v1.0.0
   */
  public String getTo();

  /**
   * A getter method to get the mail subject
   *
   * @return a String containing the mail subject
   * @since v1.0.0
   */
  public String getSubject();

  /**
   * a getter method to get the mail body
   *
   * @return a String containing the mail body
   * @since v1.0.0
   */
  public String getBody();

  /**
   * a getter method to get the file path to the attachment
   *
   * @return a String containing the file path to the attachment
   * @since v1.0.0
   */
  public String getFilePath();

  /**
   * a getter method to get the template name for the HTML template
   *
   * @return a String containing the template name for the HTML template
   * @since v1.0.0
   */
  public String getTemplateName();
}
