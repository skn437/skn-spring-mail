package best.skn.mail.models;

//? Java::Library
import java.io.InputStream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Mail sender input stream class for processing proper input stream info in controllers
 *
 * @author SKN Shukhan
 * @version 2.0.1
 * @since 2024-05-29
 * @use.case Spring Boot Reactive
 * @dedicated.to Logno, Atoshi and My Parents
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MailSenderInputStream {

  /**
   * Private String property for containing the file location where the output copied file will be
   *
   * @since v2.0.0
   */
  private String fileLocation;

  /**
   * Private String property for containing input stream that will be sent to the API
   *
   * @since v2.0.0
   */
  private InputStream inputStream;
}
