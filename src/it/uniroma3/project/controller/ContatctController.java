package it.uniroma3.project.controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import it.uniroma3.project.services.mail.EmailManager;

@ManagedBean(name="contactController")
@RequestScoped
public class ContatctController {
	
	private String nome;
	private String email;
	private String subject;
	private String body;
	
	public String sendMessage() {
		EmailManager emailManager = new EmailManager();
		emailManager.contactMail(this.email, this.nome, this.subject, this.body);
		return "index_parallax?faces-redirect=true";
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
