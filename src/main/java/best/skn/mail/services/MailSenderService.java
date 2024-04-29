package best.skn.mail.services;

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
 * @author SKN
 * @version 1.2.4
 * @since 2024-03-07
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
public interface MailSenderService {
  /**
   *
   * @param info
   * @return
   * @throws MessagingException
   */
  public Mono<String> sendMail(MailSenderRequestInfo info)
    throws MessagingException;

  /**
   *
   * @param info
   * @param stream
   * @return
   * @throws MessagingException
   * @throws IOException
   */
  public Mono<String> sendMailWithAttachment(
    MailSenderRequestInfo info,
    MailSenderInputStream stream
  ) throws MessagingException, IOException;

  /**
   *
   * @param info
   * @param template
   * @return
   * @throws MessagingException
   */
  public Mono<String> sendMailWithHtmlTemplate(
    MailSenderRequestInfo info,
    MailSenderHtmlTemplate template
  ) throws MessagingException;

  /**
   *
   * @param info
   * @param template
   * @param stream
   * @return
   * @throws MessagingException
   * @throws IOException
   */
  public Mono<String> sendMailWithHtmlTemplateAndAttachment(
    MailSenderRequestInfo info,
    MailSenderHtmlTemplate template,
    MailSenderInputStream stream
  ) throws MessagingException, IOException;
}
