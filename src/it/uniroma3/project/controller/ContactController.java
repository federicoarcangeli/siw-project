package it.uniroma3.project.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import it.uniroma3.project.services.mail.EmailManager;

@ManagedBean(name="contactController")
@RequestScoped
public class ContactController {

	private String nome;
	private String email;
	private String subject;
	private String body;

	public String sendMessage() {
		EmailManager emailManager = new EmailManager();
		emailManager.contactMail(this.email, this.nome, this.subject, this.body);
		SessionAndRequestManager.setInRequest("emailConfirm","Email inviata con successo. " + this.nome + " Le invieremo una mail di riepilogo a breve.");
		return "contact";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}



}
