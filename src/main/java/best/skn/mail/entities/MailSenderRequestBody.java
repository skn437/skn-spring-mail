package best.skn.mail.entities;

//? Java::Library
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mail sender request body class for @RequestBody annotated params in controllers
 *
 * @author SKN
 * @version 1.2.3
 * @since 2024-03-07
 * @use.case Spring Boot Reactive
 * @dedicated.to Trina, Logno, Atoshi and My Parents
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
public class MailSenderRequestBody implements MailSenderRequestBodyInterface {

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
  /**
   * private String property for containing the file path to the attachment
   *
   * @since v1.0.0
   */
  private String filePath;
  /**
   * private String property for containing the template name for the HTML template
   *
   * @since v1.0.0
   */
  private String templateName;

  @Override
  public String getFrom() {
    return this.from;
  }

  @Override
  public String getTo() {
    return this.to;
  }

  @Override
  public String getSubject() {
    return this.subject;
  }

  @Override
  public String getBody() {
    return this.body;
  }

  @Override
  public String getFilePath() {
    return this.filePath;
  }

  @Override
  public String getTemplateName() {
    return this.templateName;
  }
}
