package best.skn.mail;

//? Java::Library
import best.skn.utils.message.Message;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Class
 *
 * @author SKN
 * @version 1.2.2
 * @since 07-03-2024
 * @use.case Spring Boot Reactive
 * @dedicated.to Trina, Logno and Atoshi
 */
@SpringBootApplication
public class MainApplication {

  /**
   * Static Method `main`
   *
   * @param args default parameter for the `main` static method
   * @since v1.0.0
   */
  public static void main(String[] args) {
    System.out.printf(
      Message.successConsole(
        "Spring Boot Reactive Mail Service Initiated Successfully!"
      )
    );
  }
}
