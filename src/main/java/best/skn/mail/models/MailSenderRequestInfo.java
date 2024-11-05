package best.skn.mail.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Mail sender request info class for @RequestBody/@RequestPart annotated params in controllers
 *
 * @author SKN Shukhan
 * @version 2.1.0
 * @since 2024-05-29
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
