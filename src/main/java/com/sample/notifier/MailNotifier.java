package com.sample.notifier;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sample.entities.Investitor;

import java.util.Date;
import java.util.Properties;

public class MailNotifier {

    public static boolean sendMail(Investitor investitor, String mailText) {

        Properties properties = new java.util.Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        try {
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("personal.investing.advice@gmail.com", "personal.investing.advice1");
                }
            };
            Session session = Session.getInstance(properties, auth);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("personal.investing.advice@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(investitor.getEmail()));
            message.setSentDate(new Date());
            message.setSubject("Sugestii Plasamente Financiare");
            message.setText(mailText);

            Transport.send(message);

            System.out.println(String.format("Am trimis cu succes sugestiile de plasament financiar catre: %s", investitor.toString()));
            return true;

        } catch (Exception e) {
            System.out.println("Nu am putut trimite notificare prin email!");
            e.printStackTrace();
            return false;
        }
    }
}
