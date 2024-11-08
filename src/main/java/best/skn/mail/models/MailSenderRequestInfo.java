package best.skn.mail.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Mail sender request info class for @RequestBody/@RequestPart annotated params in controllers
 *
 * @author SKN Shukhan
 * @version 2.2.0
 * @since 2024-05-29
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
public class MailSenderRequestInfo {

  /**
   * private String property for containing mail sender email address
   *
   * @since v2.0.0
   */
  @JsonProperty("from")
  private String from;

  /**
   * private String property for containing mail receiver email address
   *
   * @since v2.0.0
   */
  @JsonProperty("to")
  private String to;

  /**
   * private String property for containing mail subject
   *
   * @since v2.0.0
   */
  @JsonProperty("subject")
  private String subject;

  /**
   * private String property for containing mail body
   *
   * @since v2.0.0
   */
  @JsonProperty("body")
  private String body;

  /**
   * Public Constructor with all private properties
   *
   * @param from String for containing mail sender email address
   * @param to String for containing mail receiver email address
   * @param subject String for containing mail subject
   * @param body String for containing mail body
   *
   * @since v2.1.0
   */
  public MailSenderRequestInfo(String from, String to, String subject, String body) {
    this.from = from;
    this.to = to;
    this.subject = subject;
    this.body = body;
  }

  /**
   * Getter method for `from` field
   *
   * @return String for `from` field
   *
   * @since v2.1.0
   */
  public String getFrom() {
    return this.from;
  }

  /**
   * Setter method for `from` field
   *
   * @param value String for `from` field
   *
   * @since v2.1.0
   */
  public void setFrom(String value) {
    this.from = value;
  }

  /**
   * Getter method for `to` field
   *
   * @return String for `to` field
   *
   * @since v2.1.0
   */
  public String getTo() {
    return this.to;
  }

  /**
   * Setter method for `to` field
   *
   * @param value String for `to` field
   *
   * @since v2.1.0
   */
  public void setTo(String value) {
    this.to = value;
  }

  /**
   * Getter method for `subject` field
   *
   * @return String for `subject` field
   *
   * @since v2.1.0
   */
  public String getSubject() {
    return this.subject;
  }

  /**
   * Setter method for `subject` field
   *
   * @param value String for `subject` field
   *
   * @since v2.1.0
   */
  public void setSubject(String value) {
    this.subject = value;
  }

  /**
   * Getter method for `body` field
   *
   * @return String for `body` field
   *
   * @since v2.1.0
   */
  public String getBody() {
    return this.body;
  }

  /**
   * Setter method for `body` field
   *
   * @param value String for `body` field
   *
   * @since v2.1.0
   */
  public void setBody(String value) {
    this.body = value;
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
      "%s(from = '%s', to = '%s', subject = '%s', body = '%s')",
      this.getClass().getSimpleName(),
      this.from,
      this.to,
      this.subject,
      this.body
    );
  }
}
