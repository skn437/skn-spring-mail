package best.skn.mail;

// import best.skn.mail.models.MailSenderHtmlTemplate;
// import best.skn.mail.models.MailSenderInputStream;
// import best.skn.mail.models.MailSenderRequestInfo;
// import best.skn.mail.services.MailSenderService;
// import jakarta.mail.MessagingException;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.IOException;
// import java.io.InputStream;
import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

  @Test
  void contextLoads() {}
  // @Autowired
  // private MailSenderService mailSenderService;

  // private MailSenderRequestInfo info = new MailSenderRequestInfo(
  //   "skn437physx@gmail.com",
  //   "skn7physx@gmail.com",
  //   "Mail Test",
  //   "This is a mail sending test"
  // );

  // private MailSenderHtmlTemplate template = new MailSenderHtmlTemplate(
  //   "mail.html",
  //   "message"
  // );

  // @Test
  // void sendMailSingleTest() throws MessagingException {
  //   this.mailSenderService.sendMail(info);
  // }

  // @Test
  // void sendMailSingleWithAttachment() throws MessagingException, IOException {
  //   File file = new File("/home/logno-atoshi/Downloads/Wang So.jpg");
  //   InputStream inputStream = new FileInputStream(file);

  //   MailSenderInputStream stream = new MailSenderInputStream(
  //     "wangso.jpg",
  //     inputStream
  //   );

  //   this.mailSenderService.sendMailWithAttachment(info, stream);
  // }

  // @Test
  // void sendMailSingleWithHtmlTemplateTest() throws MessagingException {
  //   this.mailSenderService.sendMailWithHtmlTemplate(info, template);
  // }

  // @Test
  // void sendMailSingleWithHtmlTemplateAndAttachment()
  //   throws MessagingException, IOException {
  //   File file = new File("/home/logno-atoshi/Downloads/Wang So.jpg");
  //   InputStream inputStream = new FileInputStream(file);

  //   MailSenderInputStream stream = new MailSenderInputStream(
  //     "wangso.jpg",
  //     inputStream
  //   );

  //   this.mailSenderService.sendMailWithHtmlTemplateAndAttachment(
  //       info,
  //       template,
  //       stream
  //     );
  // }
}
