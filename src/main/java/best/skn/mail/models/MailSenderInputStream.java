package best.skn.mail.models;

import java.io.InputStream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MailSenderInputStream {

  private String fileLocation;

  private InputStream inputStream;
}
