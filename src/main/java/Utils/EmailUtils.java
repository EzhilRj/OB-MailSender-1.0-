package Utils;

import Basefunctions.Setup;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.annotations.Test;

import java.io.IOException;

public class EmailUtils extends Setup {

    public static void mailsender(String file, String Email , String Projectname) throws EmailException, IOException {

        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(file);
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("TestingEmail");
        attachment.setName(Projectname  +Setup.Gettimestamp()+".csv");

        // Create the email message
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setSSLOnConnect(true);
        email.setAuthenticator(new DefaultAuthenticator("fieldlytics.test@gmail.com", "pkxyhjwptcmkdvbd"));
        email.addTo(Email, "Sudha");
        email.setFrom("fieldlytics.test@gmail.com", "Fieldlytics");
        email.setSubject("Selenium Test email");
        email.setMsg("This is the Selenium test Email");

        // add the attachment
        email.attach(attachment);

        // send the email
        email.send();
        System.out.println("Email Sent Successfully");
    }
}
