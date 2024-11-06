package best.skn.mail.models;

import java.io.InputStream;

/**
 * Mail sender input stream class for processing proper input stream info in controllers
 *
 * @author SKN Shukhan
 * @version 2.1.0
 * @since 2024-05-29
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
public class MailSenderInputStream {

  /**
   * Private String property for containing the file location where the output copied file will be
   *
   * @since v2.0.0
   */
  private String fileLocation;

  /**
   * Private InputStream property for containing input stream that will be sent to the API
   *
   * @since v2.0.0
   */
  private InputStream inputStream;

  /**
   * Public Constructor with all private properties
   *
   * @param fileLocation String containing the file location where the output copied file will be
   * @param inputStream InputStream for containing input stream that will be sent to the API
   *
   * @since v2.1.0
   */
  public MailSenderInputStream(String fileLocation, InputStream inputStream) {
    this.fileLocation = fileLocation;
    this.inputStream = inputStream;
  }

  /**
   * Getter method for `fileLocation` field
   *
   * @return String for `fileLocation` field
   *
   * @since v2.1.0
   */
  public String getFileLocation() {
    return this.fileLocation;
  }

  /**
   * Setter method for `fileLocation` field
   *
   * @param value String for `fileLocation` field
   *
   * @since v2.1.0
   */
  public void setFileLocation(String value) {
    this.fileLocation = value;
  }

  /**
   * Getter method for `inputStream` field
   *
   * @return InputStream for `inputStream` field
   *
   * @since v2.1.0
   */
  public InputStream getInputStream() {
    return this.inputStream;
  }

  /**
   * Setter method for `inputStream` field
   *
   * @param value InputStream for `inputStream` field
   *
   * @since v2.1.0
   */
  public void setInputStream(InputStream value) {
    this.inputStream = value;
  }

  /**
   * Overridden built-in `toString` method
   *
   * @return Formatted String to print out the class
   *
   * @since v2.1.0
   */
  @Override
  public String toString() {
    return String.format(
      "%s(fileLocation = '%s', inputStream = '%s')",
      this.getClass().getSimpleName(),
      this.fileLocation,
      this.inputStream.toString()
    );
  }
}
