package it.uniroma3.project.controller.action;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import it.uniroma3.project.controller.facade.Facade;
import it.uniroma3.project.entity.Utente;
import it.uniroma3.security.MD5Encrypter;

public class RegistrazioneAction {

	private static Properties mailServerProperties;
	private static Session getMailSession;
	private static MimeMessage generateMailMessage;

	public RegistrazioneAction() {
	}

	public String execute(HttpServletRequest request) {
		Utente utente = new Utente();
		Facade facade = new Facade();
		MD5Encrypter encrypter = new MD5Encrypter();

		HttpSession session = request.getSession();

		utente.setUsername(request.getParameter("username"));
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setEmail(request.getParameter("email"));
		utente.setTelefono(request.getParameter("telefono"));
		utente.setPassword(encrypter.cryptWithMD5(request.getParameter("password")));
		utente.setRole("utente");
//		this.sendMail(request.getParameter("email"));

		facade.inserisciUtente(utente);

		session.setAttribute("utenteCorrente", utente);

		return "/home_Utente.jsp";
	}

//	/**
//	 * Invia una mail di conferma all'utente con i suoi dati una volta che ha
//	 * effettuato la registrazione
//	 * 
//	 * @param receiver
//	 * @throws MessagingException
//	 * @throws AddressException
//	 */
//	private void sendMail(String receiver) {
//		mailServerProperties = System.getProperties();
//		mailServerProperties.put("mail.smtp.port", 587);
//		mailServerProperties.put("mail.smtp.auth", "true");
//		mailServerProperties.put("mail.smtp.starttls.enable", "true");
//
//		Properties senderAccountProp = new Properties();
//
//		getMailSession = Session.getDefaultInstance(mailServerProperties);
//		generateMailMessage = new MimeMessage(getMailSession);
//		try {
//			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
//			generateMailMessage.setSubject("Conferma di iscrizione");
//			String emailBody = "Grazie per esserti registrato! <br><br> Lo Staff";
//			generateMailMessage.setContent(emailBody, "text/html");
//
//			Transport transport;
//			transport = getMailSession.getTransport("smtp");
//
//			InputStream input = RegistrazioneAction.class.getResourceAsStream("/accountProperties.prop");
//			senderAccountProp.load(input);
//
//			transport.connect("smtp.gmail.com", senderAccountProp.getProperty("mail"),
//					senderAccountProp.getProperty("password"));
//			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
//			transport.close();
//
//		} catch (NoSuchProviderException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.exit(1);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
}