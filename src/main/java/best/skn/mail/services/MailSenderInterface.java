package best.skn.mail.services;

//? Java::Library
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import reactor.core.publisher.Mono;

/**
 * Mail Sender Service Interface
 *
 * @author SKN
 * @version 1.2.4
 * @since 2024-03-07
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
@Component
public interface MailSenderInterface {
  /**
   * Method to send basic mail
   *
   * @param from a String which must be a valid email address from whom the mail will be sent
   * @param to a String which must be a valid email address to whom the mail will be sent
   * @param subject a String containing the subject of the mail
   * @param body a String containing the main body of the mail
   * @return a Mono of String as a response
   * @throws MessagingException a messaging exception if the mail is not sent successfully
   * @since v1.0.0
   */
  public Mono<String> sendMail(
    String from,
    String to,
    String subject,
    String body
  ) throws MessagingException;

  /**
   * Method to send basic mail with attachment
   *
   * @param from a String which must be a valid email address from whom the mail will be sent
   * @param to a String which must be a valid email address to whom the mail will be sent
   * @param subject a String containing the subject of the mail
   * @param body a String containing the main body of the mail
   * @param filePath a String containing the file path to the attachment
   * @return a Mono of String as a response
   * @throws MessagingException a messaging exception if the mail is not sent successfully
   * @since v1.0.0
   */
  public Mono<String> sendMailWithAttachment(
    String from,
    String to,
    String subject,
    String body,
    String filePath
  ) throws MessagingException;

  /**
   * Method to send mail with HTML template
   *
   * @param from a String which must be a valid email address from whom the mail will be sent
   * @param to a String which must be a valid email address to whom the mail will be sent
   * @param subject a String containing the subject of the mail
   * @param templateName a String containing the template name for the HTML template
   * @param context a Thymeleaf Context for the HTML template
   * @return a Mono of String as a response
   * @throws MessagingException a messaging exception if the mail is not sent successfully
   * @since v1.0.0
   */
  public Mono<String> sendMailWithHtmlTemplate(
    String from,
    String to,
    String subject,
    String templateName,
    Context context
  ) throws MessagingException;

  /**
   * Method to send mail with HTML template and attachment
   *
   * @param from a String which must be a valid email address from whom the mail will be sent
   * @param to a String which must be a valid email address to whom the mail will be sent
   * @param subject a String containing the subject of the mail
   * @param templateName a String containing the template name for the HTML template
   * @param context a Thymeleaf Context for the HTML template
   * @param filePath a String containing the file path to the attachment
   * @return a Mono of String as a response
   * @throws MessagingException a messaging exception if the mail is not sent successfully
   * @since v1.0.0
   */
  public Mono<String> sendMailWithHtmlTemplateAndAttachment(
    String from,
    String to,
    String subject,
    String templateName,
    Context context,
    String filePath
  ) throws MessagingException;
}
