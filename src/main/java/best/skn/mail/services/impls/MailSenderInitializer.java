package best.skn.mail.services.impls;

import best.skn.mail.models.MailSenderHtmlTemplate;
import best.skn.mail.models.MailSenderInputStream;
import best.skn.mail.models.MailSenderRequestInfo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

public class MailSenderInitializer {

  private JavaMailSender mailSender;
  private TemplateEngine templateEngine;
  private MimeMessage message;
  private MimeMessageHelper helper;

  public MailSenderInitializer(JavaMailSender mailSender)
    throws MessagingException {
    this.mailSender = mailSender;

    this.message = this.mailSender.createMimeMessage();
    this.helper =
      new MimeMessageHelper(
        this.message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name()
      );
  }

  public MailSenderInitializer(
    JavaMailSender mailSender,
    TemplateEngine templateEngine
  ) throws MessagingException {
    this(mailSender);
    this.templateEngine = templateEngine;
  }

  private void sendMessage(MailSenderRequestInfo info, boolean isHtml)
    throws MessagingException {
    this.helper.setFrom(info.getFrom());
    this.helper.setTo(info.getTo());
    this.helper.setSubject(info.getSubject());
    this.helper.setText(info.getBody(), isHtml);

    this.mailSender.send(this.message);
  }

  protected void sendMail(MailSenderRequestInfo info)
    throws MessagingException {
    this.sendMessage(info, false);
  }

  private void streamAttachement(MailSenderInputStream stream)
    throws MessagingException, IOException {
    File file = new File(stream.getFileLocation());

    Files.copy(
      stream.getInputStream(),
      file.toPath(),
      StandardCopyOption.REPLACE_EXISTING
    );

    FileSystemResource fileSystemResource = new FileSystemResource(file);
    this.helper.addAttachment(fileSystemResource.getFilename(), file);
  }

  protected void sendMailWithAttachment(
    MailSenderRequestInfo info,
    MailSenderInputStream stream
  ) throws MessagingException, IOException {
    this.streamAttachement(stream);

    this.sendMessage(info, false);
  }

  protected void sendMailWithHtmlTemplate(
    MailSenderRequestInfo info,
    MailSenderHtmlTemplate template
  ) throws MessagingException {
    Context context = new Context();
    context.setVariable(template.getVariableName(), info.getBody());

    String htmlContent =
      this.templateEngine.process(template.getTemplateName(), context);

    info.setBody(htmlContent);

    this.sendMessage(info, true);
  }

  protected void sendMailWithHtmlTemplateAndAttachment(
    MailSenderRequestInfo info,
    MailSenderHtmlTemplate template,
    MailSenderInputStream stream
  ) throws MessagingException, IOException {
    this.streamAttachement(stream);
    this.sendMailWithHtmlTemplate(info, template);
  }
}
