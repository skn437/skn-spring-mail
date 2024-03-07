package best.skn.mail;

import best.skn.utils.color.Color;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Class for mail package
 *
 * @author SKN
 * @version 1.0.0
 * @since 07-03-2024
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
      "%s 👋 \n",
      Color.blue(
        "Hello! I Am Wang So/SKN! Welcome To My Java Reactive Spring Boot Mail Library."
      )
    );
  }
}
