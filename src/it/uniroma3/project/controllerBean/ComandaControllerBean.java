package it.uniroma3.project.controllerBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBs;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

import it.uniroma3.project.facade.CategoriaPiattoFacade;
import it.uniroma3.project.facade.ComandaFacade;
import it.uniroma3.project.facade.PiattoFacade;
import it.uniroma3.project.model.CategoriaPiatto;
import it.uniroma3.project.model.Piatto;

@ManagedBean(name = "comandaController")
@RequestScoped
@EJBs(value = { @EJB(name = "cFacade", beanInterface = ComandaFacade.class),
		@EJB(name = "pFacade", beanInterface = PiattoFacade.class),
		@EJB(name = "cpFacade", beanInterface = CategoriaPiattoFacade.class) })
public class ComandaControllerBean {

	private List<CategoriaPiatto> categorie;
	private List<Piatto> piatti;

	@EJB
	private ComandaFacade cFacade;
	@EJB
	private PiattoFacade pFacade;
	@EJB
	private CategoriaPiattoFacade cpFacade;

	@PostConstruct
	public void init() {
	}

	public List<CategoriaPiatto> getCategorie() {
		return categorie;
	}

	public void setCategorie(List<CategoriaPiatto> categorie) {
		this.categorie = categorie;
	}

	public List<Piatto> getPiatti() {
		return piatti;
	}

	public void setPiatti(List<Piatto> piatti) {
		this.piatti = piatti;
	}

	public ComandaFacade getcFacade() {
		return cFacade;
	}

	public void setcFacade(ComandaFacade cFacade) {
		this.cFacade = cFacade;
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

}
