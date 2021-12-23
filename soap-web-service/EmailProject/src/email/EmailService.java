package email;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Simple Jakarta Mail (JavaMail) message via an SMTP server.
 *
 * URL: http://localhost:7101/EmailProject-send-email/MyEmailServicePort
 * WSDL URL: http://localhost:7101/EmailProject-send-email/MyEmailServicePort?WSDL
 */
@WebService(name = "MyEmailService", serviceName = "MyEmailService", portName = "MyEmailServicePort")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class EmailService {

    /**
     *
     * @param toEmail
     * @param message
     * @return
     */
    @WebMethod
    public String sendEmail(@WebParam(name = "toEmail") String toEmail, @WebParam(name = "message") String message) {
        Properties props = new Properties();
        try (InputStream input = EmailService.class.getClassLoader().getResourceAsStream("/config.properties")) {
            props.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String username = (String) props.get("USERNAME");
        String password = (String) props.get("PASSWORD");
        String fromEmail = "no-reply@example.com";

        Properties smptProps = new Properties();
        smptProps.put("mail.smtp.auth", "true");
        smptProps.put("mail.smtp.starttls.enable", "true");
        smptProps.put("mail.smtp.ssl.enable", "false");
        smptProps.put("mail.smtp.ssl.trust", "*"); //
        smptProps.put("mail.smtp.host", props.get("HOST"));
        smptProps.put("mail.smtp.port", props.get("PORT"));

        // Get the Session object.
        Session session = Session.getInstance(smptProps, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(fromEmail));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            mimeMessage.setSubject("ORDER #" + System.currentTimeMillis() + " from BPEL Process");
            mimeMessage.setText(message);

            // Send message
            Transport.send(mimeMessage);
            System.out.println("====> Sent successfully <====");

            return "Sent successfully";

        } catch (MessagingException e) {
            System.out.println(new RuntimeException(e).toString());
            
            return "Sent failed";
            //throw new RuntimeException(e);
        }
    }
}
