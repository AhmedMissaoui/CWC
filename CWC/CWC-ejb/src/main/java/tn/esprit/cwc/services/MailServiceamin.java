package tn.esprit.cwc.services;

import java.util.Properties;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailServiceamin {
	/**
     * Sends a subject and message to a recipient
     * @param recipient Internet address of the recipient
     * @param subject the subject of the message
     * @param message the message
     * @throws MessagingException
     */
	String a="ameni.meddeb@esprit.tn";
    public static void sendMessage(String recipient, String subject, String message) throws MessagingException {

        if ( theService == null ) {
            theService = new MailServiceamin();
        }

        MimeMessage mimeMessage = new MimeMessage(mailSession);

	mimeMessage.setFrom(new InternetAddress(FROM));
	mimeMessage.setSender(new InternetAddress(FROM));
	mimeMessage.setSubject(subject);
        mimeMessage.setContent(message, "text/plain");

        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("ameni.meddeb@esprit.tn"));

        Transport transport = mailSession.getTransport("smtps");
        transport.connect(HOST, PORT, USER, PASSWORD);

        transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
        transport.close();

    }

    private MailServiceamin() {
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", HOST);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.from", FROM);
        props.put("mail.smtps.quitwait", "false");

        mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
    }

    private static MailServiceamin theService = null;

    private static Session mailSession;

    private static final String HOST = "smtp.gmail.com";
    private static final int PORT = 465;
    private static final String USER = "ameni.meddeb@esprit.tn";   
    private static final String PASSWORD = "26678826"; 
    private static final String FROM = "ameni.meddeb@esprit.tn";    

}
