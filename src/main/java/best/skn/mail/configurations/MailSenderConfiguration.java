package best.skn.mail.configurations;

import best.skn.mail.services.MailSenderService;
import best.skn.mail.services.impls.MailSenderServiceImpl;
import best.skn.utils.message.Message;
import java.util.Optional;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mail sender configuration class for auto-configuring mail sender service
 *
 * @author SKN Shukhan
 * @version 2.3.0
 * @since 2024-03-15
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
@Configuration
public class MailSenderConfiguration {

  /**
   * Configuration bean for mail sender service
   *
   * @return an Optional of MailSenderService object for auto-configuration
   * @throws BeanCreationException an exception is thrown if an error occurs while creating bean
   * @throws BeanInstantiationException an exception is thrown if an error occurs while instantiating bean
   * @throws NullPointerException an exception is thrown if null pointer is found
   *
   * @since v2.2.0
   */
  @Bean
  Optional<MailSenderService> mailSenderService()
    throws BeanCreationException, BeanInstantiationException, NullPointerException {
    try {
      MailSenderService mailSenderService = new MailSenderServiceImpl();

      System.out.print(Message.successConsole("Mail Sender Configuration Initiated Successfully!"));

      return Optional.of(mailSenderService);
    } catch (BeanCreationException e) {
      System.out.printf("Bean Creation Exception: %s", Message.errorConsole(e.getMessage()));
      return Optional.empty();
    } catch (BeanInstantiationException e) {
      System.out.printf("Bean Instantiation Exception: %s", Message.errorConsole(e.getMessage()));
      return Optional.empty();
    } catch (NullPointerException e) {
      System.out.printf("Null Pointer Exception: %s", Message.errorConsole(e.getMessage()));
      return Optional.empty();
    }
  }
}
