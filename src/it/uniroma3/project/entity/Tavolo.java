package it.uniroma3.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Tavolo.findAll", query = "select t from Tavolo t")
public class Tavolo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String codiceTavolo;

	@Column(nullable = false)
	private int coperti;

	/**
	 * tavolo libero = 0; (verde)
	 * tavolo prenotato = 1; (giallo)
	 * tavolo occupato = 2; (rosso)
	 * inizialmente un tavolo è libero;
	 */
	private int occupato;

	@OneToMany(mappedBy="tavolo",fetch = FetchType.EAGER)
	private List<Comanda> comande;

	@OneToMany(mappedBy="tavoloPrenotato", fetch=FetchType.EAGER)
	private List<Prenotazione> prenotazioni;

	public Tavolo(){
		this.prenotazioni = new ArrayList<>();
		this.comande = new ArrayList<>();
		this.occupato = 0;
	}

	public Tavolo(int coperti) {
		this.prenotazioni = new ArrayList<>();
		this.coperti = coperti;
		this.occupato = 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodiceTavolo() {
		return codiceTavolo;
	}

	public void setCodiceTavolo(String codiceTavolo) {
		this.codiceTavolo = codiceTavolo;
	}

	public int getCoperti() {
		return coperti;
	}

	public void setCoperti(int coperti) {
		this.coperti = coperti;
	}

	public int getOccupato() {
		return this.occupato;
	}

	public void setOccupato(int occupato) {
		this.occupato = occupato;
	}
	
	public List<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}

	public void addPrenotazione(Prenotazione prenotazione) {
		if(prenotazione != null)
			this.prenotazioni.add(prenotazione);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceTavolo == null) ? 0 : codiceTavolo.hashCode());
		result = prime * result + ((comande == null) ? 0 : comande.hashCode());
		result = prime * result + coperti;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + occupato;
		result = prime * result + ((prenotazioni == null) ? 0 : prenotazioni.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Tavolo [id=" + id + ", codiceTavolo=" + codiceTavolo + ", coperti=" + coperti + ", occupato=" + occupato
				+ ", comande=" + comande + ", prenotazioni=" + prenotazioni + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (codiceTavolo == null) {
			if (other.codiceTavolo != null)
				return false;
		} else if (!codiceTavolo.equals(other.codiceTavolo))
			return false;
		if (comande == null) {
			if (other.comande != null)
				return false;
		} else if (!comande.equals(other.comande))
			return false;
		if (coperti != other.coperti)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (occupato != other.occupato)
			return false;
		if (prenotazioni == null) {
			if (other.prenotazioni != null)
				return false;
		} else if (!prenotazioni.equals(other.prenotazioni))
			return false;
		return true;
	}
}