package it.uniroma3.project.facade;

import javax.ejb.Stateless;

import it.uniroma3.project.model.DescrizionePiatto;

@Stateless
public class DescrizionePiattoFacade {
	
	
	
	public DescrizionePiatto create(String descrizione, double prezzo, boolean surgelato, boolean allergizzante) {
		DescrizionePiatto descrizionePiatto = new DescrizionePiatto(descrizione, prezzo);
		descrizionePiatto.setProdottiAllergizzanti(allergizzante);
		descrizionePiatto.setProdottiSurgelati(surgelato);
		return descrizionePiatto;
	}
	
	
}
