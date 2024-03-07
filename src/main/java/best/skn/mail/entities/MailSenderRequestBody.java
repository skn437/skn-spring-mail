package best.skn.mail.entities;

import org.springframework.stereotype.Component;

/**
 * Mail sender request body class for @RequestBody annotated params in controllers
 *
 * @author SKN
 * @version 1.0.0
 * @since 07-03-2024
 * @dedicated.to Trina, Logno and Atoshi
 */
@Component
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

  /**
   * no arg constructor for mail sender request body class for @RequestBody annotated params in controllers
   *
   * @since v1.0.0
   */
  public MailSenderRequestBody() {}

  /**
   * All args constructor for mail sender request body class for @RequestBody annotated params in controllers
   *
   * @param from a String containing the mail sender email address
   * @param to a String containing the mail receiver email address
   * @param subject a String containing the mail subject
   * @param body a String containing the mail body
   * @param filePath a String containing the file path to the attachment
   * @param templateName a String containing the template name for the HTML template
   * @since v1.0.0
   */
  public MailSenderRequestBody(
    String from,
    String to,
    String subject,
    String body,
    String filePath,
    String templateName
  ) {
    this.from = from;
    this.to = to;
    this.subject = subject;
    this.body = body;
    this.filePath = filePath;
    this.templateName = templateName;
  }

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
