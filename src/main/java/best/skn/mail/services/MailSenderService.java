package best.skn.mail.services;

import best.skn.mail.models.MailSenderHtmlTemplate;
import best.skn.mail.models.MailSenderInputStream;
import best.skn.mail.models.MailSenderRequestInfo;
import jakarta.mail.MessagingException;
import java.io.IOException;
import reactor.core.publisher.Mono;

/**
 * Mail Sender Service Interface
 *
 * @author SKN Shukhan
 * @version 2.3.0
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
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @since v2.0.0
   */
  public Mono<String> sendMail(MailSenderRequestInfo info) throws MessagingException;

  /**
   * Method to send basic mail with attachment
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @param stream MailSenderInputStream object that contains all the information regarding input stream
   * @return a Mono of String as a response
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @throws IOException an exception is thrown if an error occurs in file attachment
   * @since v2.0.0
   */
  public Mono<String> sendMailWithAttachment(MailSenderRequestInfo info, MailSenderInputStream stream)
    throws MessagingException, IOException;

  /**
   * Method to send mail with HTML template
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @param template MailSenderHtmlTemplate object that contains all the information regarding thymeleaf
   * @return a Mono of String as a response
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @since v2.0.0
   */
  public Mono<String> sendMailWithHtmlTemplate(MailSenderRequestInfo info, MailSenderHtmlTemplate template)
    throws MessagingException;

  /**
   * Method to send mail with HTML template and attachment
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @param template MailSenderHtmlTemplate object that contains all the information regarding thymeleaf
   * @param stream MailSenderInputStream object that contains all the information regarding input stream
   * @return a Mono of String as a response
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @throws IOException an exception is thrown if an error occurs in file attachment
   * @since v2.0.0
   */
  public Mono<String> sendMailWithHtmlTemplateAndAttachment(
    MailSenderRequestInfo info,
    MailSenderHtmlTemplate template,
    MailSenderInputStream stream
  ) throws MessagingException, IOException;
}
