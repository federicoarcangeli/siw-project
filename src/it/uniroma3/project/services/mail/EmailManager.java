package it.uniroma3.project.services.mail;

import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EmailManager {
	private static Properties mailServerProperties;
	private static Session getMailSession;
	private static MimeMessage generateMailMessage;

	public EmailManager() {
	}


	/**
	 * Invia una mail di conferma all'utente con i suoi dati una volta che ha
	 * effettuato la registrazione
	 * 
	 * @param receiver
	 * @throws MessagingException
	 * @throws AddressException
	 */

	public void sendMail(String receiver) {
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", 587);
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		Properties senderAccountProp = new Properties();

		getMailSession = Session.getDefaultInstance(mailServerProperties);
		generateMailMessage = new MimeMessage(getMailSession);
		try {
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			generateMailMessage.setSubject("Conferma di iscrizione");
			String emailBody = "Grazie per esserti registrato! <br><br> Lo Staff";
			generateMailMessage.setContent(emailBody, "text/html");

			Transport transport;
			transport = getMailSession.getTransport("smtp");

			InputStream input = EmailManager.class.getResourceAsStream("./accountProperties.prop");
			senderAccountProp.load(input);

			transport.connect("smtp.gmail.com", senderAccountProp.getProperty("mail"),
					senderAccountProp.getProperty("password"));
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();

		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
