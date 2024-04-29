package best.skn.mail.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MailSenderHtmlTemplate {

  private String templateName;
  private String variableName;
}
