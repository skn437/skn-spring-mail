package best.skn.mail.services;

//? Java::Source
import best.skn.mail.models.MailSenderHtmlTemplate;
import best.skn.mail.models.MailSenderInputStream;
import best.skn.mail.models.MailSenderRequestInfo;
//? Java::Library
import jakarta.mail.MessagingException;
import java.io.IOException;
import reactor.core.publisher.Mono;

/**
 * Mail Sender Service Interface
 *
 * @author SKN Shukhan
 * @version 2.0.0
 * @since 2024-05-29
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
public interface MailSenderService {
  /**
   * Method to send basic mail
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @return a Mono of String as a response
   * @throws MessagingException
   * @since v2.0.0
   */
  public Mono<String> sendMail(MailSenderRequestInfo info)
    throws MessagingException;

  /**
   * Method to send basic mail with attachment
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @param stream MailSenderInputStream object that contains all the information regarding input stream
   * @return a Mono of String as a response
   * @throws MessagingException
   * @throws IOException
   * @since v2.0.0
   */
  public Mono<String> sendMailWithAttachment(
    MailSenderRequestInfo info,
    MailSenderInputStream stream
  ) throws MessagingException, IOException;

  /**
   * Method to send mail with HTML template
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @param template MailSenderHtmlTemplate object that contains all the information regarding thymeleaf
   * @return a Mono of String as a response
   * @throws MessagingException
   * @since v2.0.0
   */
  public Mono<String> sendMailWithHtmlTemplate(
    MailSenderRequestInfo info,
    MailSenderHtmlTemplate template
  ) throws MessagingException;

  /**
   * Method to send mail with HTML template and attachment
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @param template MailSenderHtmlTemplate object that contains all the information regarding thymeleaf
   * @param stream MailSenderInputStream object that contains all the information regarding input stream
   * @return a Mono of String as a response
   * @throws MessagingException
   * @throws IOException
   * @since v2.0.0
   */
  public Mono<String> sendMailWithHtmlTemplateAndAttachment(
    MailSenderRequestInfo info,
    MailSenderHtmlTemplate template,
    MailSenderInputStream stream
  ) throws MessagingException, IOException;
}
