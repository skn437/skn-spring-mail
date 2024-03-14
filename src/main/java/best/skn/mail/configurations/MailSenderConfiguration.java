package best.skn.mail.configurations;

//? Java::Source
import best.skn.mail.services.MailSenderService;
//? Java::Library
import best.skn.utils.message.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mail sender configuration class for auto-configuring mail sender service
 *
 * @author SKN
 * @version 1.2.3
 * @since 2024-03-15
 * @use.case Spring Boot Reactive
 * @dedicated.to Trina, Logno, Atoshi and My Parents
 */
@Configuration
public class MailSenderConfiguration {

  /**
   * Configuration bean for mail sender service
   *
   * @return a MailSenderService object for auto-configuration
   * @since v1.2.3
   */
  @Bean
  MailSenderService mailSenderService() {
    MailSenderService mailSenderService = new MailSenderService();

    System.out.printf(
      Message.successConsole(
        "Mail Sender Configuration Initiated Successfully!"
      )
    );

    return mailSenderService;
  }
}
