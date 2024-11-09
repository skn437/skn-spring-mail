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

/**
 * Mail Sender Initializer Class
 *
 * @author SKN Shukhan
 * @version 2.3.0
 * @since 2024-05-29
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
class MailSenderInitializer {

  /**
   * Private Java Mail Sender property
   *
   * @since v2.0.0
   */
  private JavaMailSender mailSender;
  /**
   * private Thymeleaf Template Engine property
   *
   * @since v2.0.0
   */
  private TemplateEngine templateEngine;
  /**
   * private Mime Message property
   *
   * @since v2.0.0
   */
  private MimeMessage message;
  /**
   * private Mime Message Helper property
   *
   * @since v2.0.0
   */
  private MimeMessageHelper helper;

  /**
   * Constructor for this class with one parameter
   *
   * @param mailSender Java Mail Sender object for sending mails
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @since v2.0.0
   */
  public MailSenderInitializer(JavaMailSender mailSender) throws MessagingException {
    this.mailSender = mailSender;

    this.message = this.mailSender.createMimeMessage();
    this.helper =
      new MimeMessageHelper(
        this.message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name()
      );
  }

  /**
   * Constructor for this class with two parameters
   *
   * @param mailSender Java Mail Sender object for sending mails
   * @param templateEngine Thmeleaf Template Engine object for processing HTML templates
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @since v2.0.0
   */
  public MailSenderInitializer(JavaMailSender mailSender, TemplateEngine templateEngine) throws MessagingException {
    this(mailSender);
    this.templateEngine = templateEngine;
  }

  /**
   * Private method to set the required info to send a mail and then send it
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @param isHtml Boolean parameter to set if a mail body will contain HTML template or not
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @since v2.0.0
   */
  private void sendMessage(MailSenderRequestInfo info, boolean isHtml) throws MessagingException {
    this.helper.setFrom(info.getFrom());
    this.helper.setTo(info.getTo());
    this.helper.setSubject(info.getSubject());
    this.helper.setText(info.getBody(), isHtml);

    this.mailSender.send(this.message);
  }

  /**
   * Protected method to send basic mail
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @since v2.0.0
   */
  protected void sendMail(MailSenderRequestInfo info) throws MessagingException {
    this.sendMessage(info, false);
  }

  /**
   * Private method to set the required configuration regarding file attachment
   *
   * @param stream MailSenderInputStream object that contains all the information regarding input stream
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @throws IOException an exception is thrown if an error occurs in file attachment
   * @since v2.0.0
   */
  private void streamAttachement(MailSenderInputStream stream) throws MessagingException, IOException {
    File file = new File(stream.getFileLocation());

    Files.copy(stream.getInputStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);

    FileSystemResource fileSystemResource = new FileSystemResource(file);
    this.helper.addAttachment(fileSystemResource.getFilename(), file);
  }

  /**
   * Protected method to send mail with attachment
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @param stream MailSenderInputStream object that contains all the information regarding input stream
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @throws IOException an exception is thrown if an error occurs in file attachment
   * @since v2.0.0
   */
  protected void sendMailWithAttachment(MailSenderRequestInfo info, MailSenderInputStream stream)
    throws MessagingException, IOException {
    this.streamAttachement(stream);
    this.sendMail(info);
  }

  /**
   * Protected method to send mail with HTML template
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @param template MailSenderHtmlTemplate object that contains all the information regarding thymeleaf
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @since v2.0.0
   */
  protected void sendMailWithHtmlTemplate(MailSenderRequestInfo info, MailSenderHtmlTemplate template)
    throws MessagingException {
    Context context = new Context();
    context.setVariable(template.getVariableName(), info.getBody());

    String htmlContent = this.templateEngine.process(template.getTemplateName(), context);

    info.setBody(htmlContent);

    this.sendMessage(info, true);
  }

  /**
   * Protected method to send mail with HTML template and attachment
   *
   * @param info MailSenderRequestInfo object that contains all the information regarding sending mail
   * @param template MailSenderHtmlTemplate object that contains all the information regarding thymeleaf
   * @param stream MailSenderInputStream object that contains all the information regarding input stream
   * @throws MessagingException an exception is thrown if an error occurs while sending mail
   * @throws IOException an exception is thrown if an error occurs in file attachment
   * @since v2.0.0
   */
  protected void sendMailWithHtmlTemplateAndAttachment(
    MailSenderRequestInfo info,
    MailSenderHtmlTemplate template,
    MailSenderInputStream stream
  ) throws MessagingException, IOException {
    this.streamAttachement(stream);
    this.sendMailWithHtmlTemplate(info, template);
  }
}
