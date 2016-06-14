package it.uniroma3.project.model;

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
@NamedQuery(name = "Tavolo.findAll", query = "select t from Tavolo t order by t.id")
public class Tavolo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false,unique=true)
	private String codiceTavolo;

	@Column(nullable = false)
	private int coperti;

	/**
	 * tavolo libero = 0; (verde)
	 * tavolo prenotato = 1; (giallo)
	 * tavolo occupato = 2; (rosso)
	 * inizialmente un tavolo è libero;
	 */
	private int stato;

	@OneToMany(mappedBy="tavolo",fetch = FetchType.EAGER)
	private List<Comanda> comande;

	@OneToMany(mappedBy="tavoloPrenotato", fetch=FetchType.EAGER)
	private List<Prenotazione> prenotazioni;

	public Tavolo(){
		this.prenotazioni = new ArrayList<>();
		this.comande = new ArrayList<>();
		this.stato = 0;
	}

	public Tavolo(int coperti) {
		this.prenotazioni = new ArrayList<>();
		this.comande = new ArrayList<>();
		this.coperti = coperti;
		this.stato = 0;
	}

	public Tavolo(String codiceTavolo,int coperti) {
		this.prenotazioni = new ArrayList<>();
		this.comande = new ArrayList<>();
		this.codiceTavolo=codiceTavolo;
		this.coperti = coperti;
		this.stato = 0;
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

	public int getStato() {
		return this.stato;
	}

	public void setStato(int occupato) {
		this.stato = occupato;
	}

	public List<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}

	public void addPrenotazione(Prenotazione prenotazione) {
		if(prenotazione != null)
			this.getPrenotazioni().add(prenotazione);
	}

	public void addComanda(Comanda comanda) {
		if(comanda!=null)
			this.comande.add(comanda);
	}

	public List<Comanda> getComande() {
		return comande;
	}

	public void setComande(List<Comanda> comande) {
		this.comande = comande;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceTavolo == null) ? 0 : codiceTavolo.hashCode());
		result = prime * result + coperti;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + stato;
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
		Tavolo other = (Tavolo) obj;
		if (codiceTavolo == null) {
			if (other.codiceTavolo != null)
				return false;
		} else if (!codiceTavolo.equals(other.codiceTavolo))
			return false;
		if (coperti != other.coperti)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stato != other.stato)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[codiceTavolo=" + codiceTavolo + ", coperti=" + coperti + "]";
	}

}