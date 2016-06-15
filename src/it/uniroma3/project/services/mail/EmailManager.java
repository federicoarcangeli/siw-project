package it.uniroma3.project.services.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailManager {
	private static final String PASSWORD = "DaPeppeRestaurant123";
	private static final String EMAIL = "dapepperestaurant@gmail.com";
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

	public void sendMail(String receiver, String username) {
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", 587);
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		getMailSession = Session.getDefaultInstance(mailServerProperties);
		generateMailMessage = new MimeMessage(getMailSession);
		try {
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			generateMailMessage.setSubject("Conferma di iscrizione");
			String emailBody = "Grazie per esserti registrato! <br><br> " + "Il tuo nome utente è " + username + "<br>"
					+ "Lo Staff";
			generateMailMessage.setContent(emailBody, "text/html");

			Transport transport;
			transport = getMailSession.getTransport("smtp");

			transport.connect("smtp.gmail.com", EMAIL, PASSWORD);
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public void sendMailReservation(String receiver, String username, String data, String ora, int coperti) {
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", 587);
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		getMailSession = Session.getDefaultInstance(mailServerProperties);
		generateMailMessage = new MimeMessage(getMailSession);
		try {
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			generateMailMessage.setSubject("Conferma prenotazione");
			String emailBody = "Ciao " + username + "! <br><br> " + "Grazie per aver scelto il nostro Ristorante <br>"
					+ "Hai riservato un tavolo per " + coperti + " il giorno " + data + " per le ore " + ora + ".<br>"
					+ "Lo Staff";
			generateMailMessage.setContent(emailBody, "text/html");

			Transport transport;
			transport = getMailSession.getTransport("smtp");

			transport.connect("smtp.gmail.com", EMAIL, PASSWORD);
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void contactMail(String receiver, String username, String subject, String body) {
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", 587);
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		getMailSession = Session.getDefaultInstance(mailServerProperties);
		generateMailMessage = new MimeMessage(getMailSession);
		try {
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			generateMailMessage.setSubject(subject);
			generateMailMessage.setContent("Conferma inoltro del messaggio:<br>"+body, "text/html");

			Transport transport;
			transport = getMailSession.getTransport("smtp");

			transport.connect("smtp.gmail.com", EMAIL, PASSWORD);
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
