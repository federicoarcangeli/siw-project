package it.uniroma3.project.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.codec.binary.Base64;

import it.uniroma3.project.facade.CategoriaPiattoFacade;
import it.uniroma3.project.facade.PiattoFacade;
import it.uniroma3.project.model.CategoriaPiatto;
import it.uniroma3.project.model.DescrizionePiatto;
import it.uniroma3.project.model.Piatto;

@ManagedBean(name="menuController")
@RequestScoped
@EJBs(value = { @EJB(name = "pFacade", beanInterface = PiattoFacade.class),
		@EJB(name = "cpFacade", beanInterface = CategoriaPiattoFacade.class) })
public class MenuController {

	@EJB
	private PiattoFacade pFacade;

	@EJB
	private CategoriaPiattoFacade cpFacade;

	private List<CategoriaPiatto> categorie;

	private List<String> nomiCategorie;

	private List<Piatto> piatti;

	private byte[] img;

	@PostConstruct
	public void init() {
		this.categorie = this.cpFacade.findAll();
		this.nomiCategorie = new ArrayList<>();
		this.categorie = this.cpFacade.findAll();
		for (CategoriaPiatto c : this.categorie) {
			this.nomiCategorie.add(c.getNome());
		}
		this.piatti = this.pFacade.findAll();
	}

	public String getBase64Img(DescrizionePiatto descrizionePiatto) {

		byte[] encodeBase64 = Base64.encodeBase64(descrizionePiatto.getImg());
		String base64Encoded = null;
		try {
			base64Encoded = new String(encodeBase64, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return base64Encoded;
	}

	public String goToMenu() {
		return "menu";
	}

	public PiattoFacade getpFacade() {
		return pFacade;
	}

	public void setpFacade(PiattoFacade pFacade) {
		this.pFacade = pFacade;
	}

	public CategoriaPiattoFacade getCpFacade() {
		return cpFacade;
	}

	public void setCpFacade(CategoriaPiattoFacade cpFacade) {
		this.cpFacade = cpFacade;
	}

	public List<CategoriaPiatto> getCategorie() {
		return categorie;
	}

	public void setCategorie(List<CategoriaPiatto> categorie) {
		this.categorie = categorie;
	}

	public List<String> getNomiCategorie() {
		return nomiCategorie;
	}

	public void setNomiCategorie(List<String> nomiCategorie) {
		this.nomiCategorie = nomiCategorie;
	}

	public List<Piatto> getPiatti() {
		return piatti;
	}

	public void setPiatti(List<Piatto> piatti) {
		this.piatti = piatti;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}




}
