package abhi;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class send2 {
 static int random;
    private String msgSubject = new String();
    private String msgText = new String();
    private  String USER_NAME;   // Reasever Mail (User Mail)

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }
    final String PASSSWORD = "tvgl mnlb tvqq ejdw";  //Password of the Goole(gmail) account
    final static String SENDER = "abhishekh0456@gmail.com";  // Sender gmail addresss
    
    public static void main(String[] args) {
        send2 email = new send2();
        //Sending test email
        int otp = otpGenerat();
        
        email.createAndSendEmail(SENDER, "Bharat Tourism Hub", " Dear user. ,\n the one time OTP to reset your password at (Passwodr Resete) is " + otp + ".\n \n This OTP will expire in 5 minutes. ");
    }

    public void createAndSendEmail(String emailAddressTo, String msgSubject, String msgText) {
        this.msgSubject = msgSubject;
        this.msgText = msgText;
        sendEmailMessage();
    }

    private void sendEmailMessage() {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER, PASSSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER)); //Set from address of the email
            message.setContent(msgText, "text/html"); //set content type of the email

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(USER_NAME));

            message.setSubject(msgSubject); //Set email message subject
            Transport.send(message); //Send email message

            System.out.println("sent email successfully!");

        } catch (MessagingException e) {

            System.out.println(e);
        }
    }

    public static int otpGenerat() {
         random = (int) (Math.random() * 999999);
        System.out.println("rendom num is: " + random);
        return random;
    }
    public boolean a(int r){
      boolean b=false;
      if(random==r){
      b=true;
      }
      return b;
    }
}

