package it.uniroma3.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "DescrizionePiattofindAll", query = "select d from DescrizionePiatto d")
public class DescrizionePiatto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String descrizione;
	
	@Column
	private boolean prodottiSurgelati;
	
	@Column 
	private boolean prodottiAllergizzanti;
	
	@Column
	private String urlImmagine;
	
	@Column(nullable = false)
	private double prezzo;

	public DescrizionePiatto(){
	}
	
	

	public DescrizionePiatto(String descrizione, double prezzo) {
		super();
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}



	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public boolean isProdottiSurgelati() {
		return prodottiSurgelati;
	}

	public void setProdottiSurgelati(boolean prodottiSurgelati) {
		this.prodottiSurgelati = prodottiSurgelati;
	}

	public boolean isProdottiAllergizzanti() {
		return prodottiAllergizzanti;
	}

	public void setProdottiAllergizzanti(boolean prodottiAllergizzanti) {
		this.prodottiAllergizzanti = prodottiAllergizzanti;
	}

	public String getUrlImmagine() {
		return urlImmagine;
	}

	public void setUrlImmagine(String urlImmagine) {
		this.urlImmagine = urlImmagine;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (prodottiAllergizzanti ? 1231 : 1237);
		result = prime * result + (prodottiSurgelati ? 1231 : 1237);
		result = prime * result + ((urlImmagine == null) ? 0 : urlImmagine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DescrizionePiatto other = (DescrizionePiatto) obj;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		if (prodottiAllergizzanti != other.prodottiAllergizzanti)
			return false;
		if (prodottiSurgelati != other.prodottiSurgelati)
			return false;
		if (urlImmagine == null) {
			if (other.urlImmagine != null)
				return false;
		} else if (!urlImmagine.equals(other.urlImmagine))
			return false;
		return true;
	}
}
