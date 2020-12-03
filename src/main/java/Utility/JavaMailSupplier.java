package Utility;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailSupplier {
     public static void sendMail(String recepient, String PartName) throws Exception{
        System.out.println("Preparing to send email");//Joption
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "rustrepairscenter@gmail.com";
        String password = "rust1234";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);

            }
        });

        Message message = prepareMesssage(session,myAccountEmail,recepient, PartName);
        
        Transport.send(message);
        System.out.println("Message sente successfully");//Joption
    }

    private static Message prepareMesssage(Session session,String myAccountEmail,String recepient,String PartName) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("RustRepairs: Order for supplies");
            message.setText("Dear Supplier,\n We would like reorder "+PartName+" supplies from your company to restock our inventory. \n Thank You.\n RustRepairs");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
