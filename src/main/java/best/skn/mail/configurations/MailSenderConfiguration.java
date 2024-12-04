package best.skn.mail.configurations;

import best.skn.mail.services.MailSenderService;
import best.skn.mail.services.impls.MailSenderServiceImpl;
import best.skn.utils.message.Message;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mail sender configuration class for auto-configuring mail sender service
 *
 * @author SKN Shukhan
 * @version 2.4.0
 * @since 2024-03-15
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
@Configuration
public class MailSenderConfiguration {

  /**
   * Configuration bean for mail sender service
   *
   * @return MailSenderService object for auto-configuration
   * @throws BeanCreationException an exception is thrown if an error occurs while creating bean
   * @throws BeanInstantiationException an exception is thrown if an error occurs while instantiating bean
   * @throws NullPointerException an exception is thrown if null pointer is found
   *
   * @since v2.2.0
   */
  @Bean
  MailSenderService mailSenderService() throws BeanCreationException, BeanInstantiationException, NullPointerException {
    try {
      MailSenderService mailSenderService = new MailSenderServiceImpl();

      System.out.printf("%s", Message.successConsole("Mail Sender Configuration Initiated Successfully!"));

      return mailSenderService;
    } catch (BeanCreationException e) {
      System.out.printf(
        "Mail Sender Configuration Error: Bean Creation Exception: %s",
        Message.errorConsole(e.getMessage())
      );
      return null;
    } catch (BeanInstantiationException e) {
      System.out.printf(
        "Mail Sender Configuration Error: Bean Instantiation Exception: %s",
        Message.errorConsole(e.getMessage())
      );
      return null;
    } catch (NullPointerException e) {
      System.out.printf(
        "Mail Sender Configuration Error: Null Pointer Exception: %s",
        Message.errorConsole(e.getMessage())
      );
      return null;
    } catch (Exception e) {
      System.out.printf("Mail Sender Configuration Error: Exception: %s", Message.errorConsole(e.getMessage()));
      return null;
    }
  }
}
