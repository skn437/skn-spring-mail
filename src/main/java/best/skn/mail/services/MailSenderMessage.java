package best.skn.mail.services;

import org.springframework.stereotype.Component;

/**
 * Mail sender output message class
 *
 * @author SKN
 * @version 1.0.0
 * @since 07-03-2024
 * @dedicated.to Trina, Logno and Atoshi
 */
@Component
public class MailSenderMessage {

  /**
   * Method to return an error message for null parameter
   *
   * @return a String containing the error message for null parameter
   * @since v1.0.0
   */
  protected static String parameterError() {
    return "Error: a parameter is null! ❌";
  }

  /**
   * Method to return an error message for null HTML content
   *
   * @return a String containing the error message for null HTML content
   * @since v1.0.0
   */
  protected static String htmlContentError() {
    return "Error: HTML content is null! ❌";
  }

  /**
   * Method to return an error message for messaging exception
   * <div>
   *  <p>When mail is not sent successfully then this method returns the proper error message</p>
   *  <p>The error type is 'MessagingException'</p>
   * </div>
   *
   * @param error a String to hold the messaging exception error message
   * @return a String containing the new and formatted messaging exception error message
   * @since v1.0.0
   */
  protected static String exceptionError(String error) {
    String formattedString = String.format("%s \n", error);
    formattedString += "Error occured sending mail! ❌";

    return formattedString;
  }

  /**
   * Method to return a success message for sending basic mail
   *
   * @return a String containing success message for sending basic mail
   * @since v1.0.0
   */
  protected static String sendMailSuccess() {
    return "Mail sent successfully! ✅";
  }

  /**
   * Method to return a success message for sending basic mail with attachment
   *
   * @return a String containing success message for sending basic mail with attachment
   * @since v1.0.0
   */
  protected static String sendMailWithAttachmentSuccess() {
    return "Mail with attachment sent successfully! ✅";
  }

  /**
   * Method to return a success message for sending mail with HTML template
   *
   * @return a String containing success message for sending mail with HTML template
   * @since v1.0.0
   */
  protected static String sendMailWithHtmlTemplateSuccess() {
    return "Mail with HTML template sent successfully! ✅";
  }

  /**
   * Method to return a success message for sending mail with HTML template and attachment
   *
   * @return a String containing success message for sending mail with HTML template and attachment
   * @since v1.0.0
   */
  protected static String sendMailWithHtmlTemplateAndAttachmentSuccess() {
    return "Mail with HTML template and attachment sent successfully! ✅";
  }
}
