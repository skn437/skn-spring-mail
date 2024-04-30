package best.skn.mail.services.impls;

//? Java::Source
import best.skn.mail.models.MailSenderHtmlTemplate;
import best.skn.mail.models.MailSenderInputStream;
import best.skn.mail.models.MailSenderRequestInfo;
import best.skn.mail.services.MailSenderService;
//? Java::Library
import jakarta.mail.MessagingException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import reactor.core.publisher.Mono;

/**
 * Mail Sender Service Implementation Class
 *
 * @author SKN Shukhan
 * @version 2.0.1
 * @since 2024-05-29
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
@Service
public class MailSenderServiceImpl implements MailSenderService {

  /**
   * Private Java Mail Sender object
   *
   * @since v2.0.0
   */
  @Autowired
  private JavaMailSender mailSender;

  /**
   * private Thymeleaf Template Engine object
   *
   * @since v2.0.0
   */
  @Autowired
  private TemplateEngine templateEngine;

  @Override
  public Mono<String> sendMail(MailSenderRequestInfo info)
    throws MessagingException {
    try {
      if (
        info.getFrom() == null ||
        info.getTo() == null ||
        info.getSubject() == null ||
        info.getBody() == null
      ) {
        return Mono.just(MailSenderMessage.parameterError());
      }

      MailSenderInitializer mailSenderInitializer = new MailSenderInitializer(
        this.mailSender
      );

      mailSenderInitializer.sendMail(info);

      return MailSenderMessage.sendMailSuccess();
    } catch (MessagingException e) {
      return MailSenderMessage.exceptionErrorMessaging(e.getMessage());
    }
  }

  @Override
  public Mono<String> sendMailWithAttachment(
    MailSenderRequestInfo info,
    MailSenderInputStream stream
  ) throws MessagingException, IOException {
    try {
      if (
        info.getFrom() == null ||
        info.getTo() == null ||
        info.getSubject() == null ||
        info.getBody() == null ||
        stream.getInputStream() == null
      ) {
        return Mono.just(MailSenderMessage.parameterError());
      }

      MailSenderInitializer mailSenderInitializer = new MailSenderInitializer(
        mailSender
      );

      mailSenderInitializer.sendMailWithAttachment(info, stream);

      return MailSenderMessage.sendMailWithAttachmentSuccess();
    } catch (MessagingException e) {
      return MailSenderMessage.exceptionErrorMessaging(e.getMessage());
    } catch (IOException e) {
      return MailSenderMessage.exceptionErrorIO(e.getMessage());
    }
  }

  @Override
  public Mono<String> sendMailWithHtmlTemplate(
    MailSenderRequestInfo info,
    MailSenderHtmlTemplate template
  ) throws MessagingException {
    try {
      if (
        info.getFrom() == null ||
        info.getTo() == null ||
        info.getSubject() == null ||
        info.getBody() == null ||
        template.getTemplateName() == null ||
        template.getVariableName() == null
      ) {
        return Mono.just(MailSenderMessage.parameterError());
      }

      MailSenderInitializer mailSenderInitializer = new MailSenderInitializer(
        this.mailSender,
        this.templateEngine
      );

      mailSenderInitializer.sendMailWithHtmlTemplate(info, template);

      return MailSenderMessage.sendMailWithHtmlTemplateSuccess();
    } catch (MessagingException e) {
      return MailSenderMessage.exceptionErrorMessaging(e.getMessage());
    }
  }

  @Override
  public Mono<String> sendMailWithHtmlTemplateAndAttachment(
    MailSenderRequestInfo info,
    MailSenderHtmlTemplate template,
    MailSenderInputStream stream
  ) throws MessagingException, IOException {
    try {
      if (
        info.getFrom() == null ||
        info.getTo() == null ||
        info.getSubject() == null ||
        info.getBody() == null ||
        template.getTemplateName() == null ||
        template.getVariableName() == null ||
        stream.getInputStream() == null
      ) {
        return Mono.just(MailSenderMessage.parameterError());
      }

      MailSenderInitializer mailSenderInitializer = new MailSenderInitializer(
        this.mailSender,
        this.templateEngine
      );

      mailSenderInitializer.sendMailWithHtmlTemplateAndAttachment(
        info,
        template,
        stream
      );

      return MailSenderMessage.sendMailWithHtmlTemplateAndAttachmentSuccess();
    } catch (MessagingException e) {
      return MailSenderMessage.exceptionErrorMessaging(e.getMessage());
    } catch (IOException e) {
      return MailSenderMessage.exceptionErrorIO(e.getMessage());
    }
  }
}
