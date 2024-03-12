package best.skn.mail.services;

//? Java::Library
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import java.nio.charset.StandardCharsets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import reactor.core.publisher.Mono;

/**
 * Mail Sender Service Class
 *
 * @author SKN
 * @version 1.2.2
 * @since 2024-03-07
 * @use.case Spring Boot Reactive
 * @dedicated.to Trina, Logno and Atoshi
 */
@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MailSenderService implements MailSenderInterface {

  /**
   * Private Java Mail Sender object
   *
   * @since v1.0.0
   */
  @Autowired
  private JavaMailSender mailSender;

  /**
   * private Thymeleaf Template Engine object
   *
   * @since v1.0.0
   */
  @Autowired
  private TemplateEngine templateEngine;

  @Override
  public Mono<String> sendMail(
    String from,
    String to,
    String subject,
    String body
  ) throws MessagingException {
    try {
      if (from == null || to == null || subject == null || body == null) {
        return Mono.just(MailSenderMessage.parameterError());
      }

      MimeMessage message = this.mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(
        message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name()
      );

      helper.setFrom(from);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(body);

      this.mailSender.send(message);

      return MailSenderMessage.sendMailSuccess();
    } catch (MessagingException e) {
      return MailSenderMessage.exceptionError(e.getMessage());
    }
  }

  @Override
  public Mono<String> sendMailWithAttachment(
    String from,
    String to,
    String subject,
    String body,
    String filePath
  ) throws MessagingException {
    try {
      if (
        from == null ||
        to == null ||
        subject == null ||
        body == null ||
        filePath == null
      ) {
        return Mono.just(MailSenderMessage.parameterError());
      }

      FileSystemResource file = new FileSystemResource(new File(filePath));

      MimeMessage message = this.mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(
        message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name()
      );

      helper.setFrom(from);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(body);
      helper.addAttachment(file.getFilename(), file);

      this.mailSender.send(message);

      return MailSenderMessage.sendMailWithAttachmentSuccess();
    } catch (MessagingException e) {
      return MailSenderMessage.exceptionError(e.getMessage());
    }
  }

  @Override
  public Mono<String> sendMailWithHtmlTemplate(
    String from,
    String to,
    String subject,
    String templateName,
    Context context
  ) throws MessagingException {
    try {
      if (
        from == null ||
        to == null ||
        subject == null ||
        templateName == null ||
        context == null
      ) {
        return Mono.just(MailSenderMessage.parameterError());
      }

      String htmlContent = this.templateEngine.process(templateName, context);

      if (htmlContent == null) {
        return Mono.just(MailSenderMessage.htmlContentError());
      }

      MimeMessage message = this.mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(
        message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name()
      );

      helper.setFrom(from);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(htmlContent, true);

      this.mailSender.send(message);

      return MailSenderMessage.sendMailWithHtmlTemplateSuccess();
    } catch (MessagingException e) {
      return MailSenderMessage.exceptionError(e.getMessage());
    }
  }

  @Override
  public Mono<String> sendMailWithHtmlTemplateAndAttachment(
    String from,
    String to,
    String subject,
    String templateName,
    Context context,
    String filePath
  ) throws MessagingException {
    try {
      if (
        from == null ||
        to == null ||
        subject == null ||
        templateName == null ||
        context == null ||
        filePath == null
      ) {
        return Mono.just(MailSenderMessage.parameterError());
      }

      String htmlContent = this.templateEngine.process(templateName, context);
      FileSystemResource file = new FileSystemResource(new File(filePath));

      if (htmlContent == null) {
        return Mono.just(MailSenderMessage.htmlContentError());
      }

      MimeMessage message = this.mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(
        message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name()
      );

      helper.setFrom(from);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(htmlContent, true);
      helper.addAttachment(file.getFilename(), file);

      this.mailSender.send(message);

      return MailSenderMessage.sendMailWithHtmlTemplateAndAttachmentSuccess();
    } catch (MessagingException e) {
      return MailSenderMessage.exceptionError(e.getMessage());
    }
  }
}
