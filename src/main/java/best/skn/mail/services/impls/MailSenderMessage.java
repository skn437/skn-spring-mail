package best.skn.mail.services.impls;

import best.skn.utils.message.Message;
import reactor.core.publisher.Mono;

/**
 * Mail Sender Output Message Class
 *
 * @author SKN Shukhan
 * @version 2.4.0
 * @since 2024-05-29
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
class MailSenderMessage {

  /**
   * Private constructor to make the class non-instantiable
   *
   * @since v2.0.0
   */
  private MailSenderMessage() {
    Message.throwInstantiationError();
  }

  /**
   * Protected static method to return an error message for null parameter
   *
   * @return a String containing the error message for null parameter
   * @since v2.0.0
   */
  protected static String parameterError() {
    return Message.errorServer("A parameter is null!");
  }

  /**
   * Protected static method to return an error message for messaging exception
   * <div>
   *  <p>When mail is not sent successfully then this method returns the proper error message</p>
   *  <p>The error type is 'MessagingException'</p>
   * </div>
   *
   * @param error a String to hold the messaging exception error message
   * @return a String containing the new and formatted messaging exception error message
   * @since v2.0.0
   */
  protected static Mono<String> exceptionErrorMessaging(String error) {
    String errorMessage = String.format("%s: Problem occured sending mail!", error);

    Mono<String> exceptionError = Message.errorMono(errorMessage);
    return exceptionError;
  }

  /**
   * Protected static method to return an error message for io exception
   * <div>
   *  <p>When any error occurs regarding file attachment then this method returns the proper error message</p>
   *  <p>The error type is 'IOException'</p>
   * </div>
   *
   * @param error a String to hold the io exception error message
   * @return a String containing the new and formatted io exception error message
   * @since v2.0.0
   */
  protected static Mono<String> exceptionErrorIO(String error) {
    String errorMessage = String.format("%s: Problem occured with file attachment!", error);

    Mono<String> exceptionError = Message.errorMono(errorMessage);
    return exceptionError;
  }

  /**
   * Protected static method to return a success message for sending basic mail
   *
   * @return a String containing success message for sending basic mail
   * @since v2.0.0
   */
  protected static Mono<String> sendMailSuccess() {
    Mono<String> message = Message.successMono("Mail sent successfully!");
    return message;
  }

  /**
   * Protected static method to return a success message for sending basic mail with attachment
   *
   * @return a String containing success message for sending basic mail with attachment
   * @since v2.0.0
   */
  protected static Mono<String> sendMailWithAttachmentSuccess() {
    Mono<String> message = Message.successMono("Mail with attachment sent successfully!");
    return message;
  }

  /**
   * Protected static method to return a success message for sending mail with HTML template
   *
   * @return a String containing success message for sending mail with HTML template
   * @since v2.0.0
   */
  protected static Mono<String> sendMailWithHtmlTemplateSuccess() {
    Mono<String> message = Message.successMono("Mail with HTML template sent successfully!");
    return message;
  }

  /**
   * Protected static method to return a success message for sending mail with HTML template and attachment
   *
   * @return a String containing success message for sending mail with HTML template and attachment
   * @since v2.0.0
   */
  protected static Mono<String> sendMailWithHtmlTemplateAndAttachmentSuccess() {
    Mono<String> message = Message.successMono("Mail with HTML template and attachment sent successfully!");
    return message;
  }
}
