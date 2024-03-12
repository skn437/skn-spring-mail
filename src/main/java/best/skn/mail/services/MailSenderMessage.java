package best.skn.mail.services;

//? Java::Library
import best.skn.utils.message.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * Mail Sender Output Message Class
 *
 * @author SKN
 * @version 1.2.2
 * @since 2024-03-07
 * @use.case Spring Boot Reactive
 * @dedicated.to Trina, Logno and Atoshi
 */
@Component
public class MailSenderMessage {

  /**
   * Protected method to return an error message for null parameter
   *
   * @return a String containing the error message for null parameter
   * @since v1.0.0
   */
  protected static String parameterError() {
    return Message.errorServer("A parameter is null!");
  }

  /**
   * Protected method to return an error message for null HTML content
   *
   * @return a String containing the error message for null HTML content
   * @since v1.0.0
   */
  protected static String htmlContentError() {
    return Message.errorServer("HTML content is null!");
  }

  /**
   * Protected method to return an error message for messaging exception
   * <div>
   *  <p>When mail is not sent successfully then this method returns the proper error message</p>
   *  <p>The error type is 'MessagingException'</p>
   * </div>
   *
   * @param error a String to hold the messaging exception error message
   * @return a String containing the new and formatted messaging exception error message
   * @since v1.0.0
   */
  protected static Mono<String> exceptionError(String error) {
    String errorMessage = String.format(
      "%s: Problem occured sending mail!",
      error
    );

    Mono<String> exceptionError = Message.errorMono(errorMessage);
    return exceptionError;
  }

  /**
   * Protected method to return a success message for sending basic mail
   *
   * @return a String containing success message for sending basic mail
   * @since v1.0.0
   */
  protected static Mono<String> sendMailSuccess() {
    Mono<String> message = Message.successMono("Mail sent successfully!");
    return message;
  }

  /**
   * Protected method to return a success message for sending basic mail with attachment
   *
   * @return a String containing success message for sending basic mail with attachment
   * @since v1.0.0
   */
  protected static Mono<String> sendMailWithAttachmentSuccess() {
    Mono<String> message = Message.successMono(
      "Mail with attachment sent successfully!"
    );
    return message;
  }

  /**
   * Protected method to return a success message for sending mail with HTML template
   *
   * @return a String containing success message for sending mail with HTML template
   * @since v1.0.0
   */
  protected static Mono<String> sendMailWithHtmlTemplateSuccess() {
    Mono<String> message = Message.successMono(
      "Mail with HTML template sent successfully!"
    );
    return message;
  }

  /**
   * Protected method to return a success message for sending mail with HTML template and attachment
   *
   * @return a String containing success message for sending mail with HTML template and attachment
   * @since v1.0.0
   */
  protected static Mono<String> sendMailWithHtmlTemplateAndAttachmentSuccess() {
    Mono<String> message = Message.successMono(
      "Mail with HTML template and attachment sent successfully!"
    );
    return message;
  }
}
