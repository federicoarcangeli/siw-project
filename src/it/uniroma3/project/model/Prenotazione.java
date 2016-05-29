package it.uniroma3.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@NamedQuery(name = "Prenotazione.findAll", query = "select p from Prenotazione p")
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date Ora;

	@Column(nullable = false)
	private int numeroOspiti;

	private String nominativo;

	@Column(nullable = false)
	private boolean completato;

	@ManyToOne
	private Utente utente;

	@ManyToOne(fetch = FetchType.EAGER)
	private Tavolo tavoloPrenotato;

	public Prenotazione(){
	}

	public Prenotazione(Date data,Date ora, int ospiti,String nominativo) {
		this.data=data;
		this.Ora=ora;
		this.numeroOspiti=ospiti;
		this.nominativo=nominativo;
		this.completato=false;
	}
	public Prenotazione(Date data,Date ora, int ospiti,Utente utente) {
		this.data=data;
		this.Ora=ora;
		this.numeroOspiti=ospiti;
		this.utente=utente;
		this.completato=false;
	}

	public Long getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getOra() {
		return Ora;
	}

	public void setOra(Date ora) {
		Ora = ora;
	}

	public int getNumeroOspiti() {
		return numeroOspiti;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public void setNumeroOspiti(int numeroOspiti) {
		this.numeroOspiti = numeroOspiti;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Tavolo getTavoloPrenotato() {
		return tavoloPrenotato;
	}

	public boolean isCompletato() {
		return completato;
	}

	public void setCompletato(boolean completato) {
		this.completato = completato;
	}

	public void setTavoloPrenotato(Tavolo tavoloPrenotato) {
		this.tavoloPrenotato = tavoloPrenotato;
		this.tavoloPrenotato.getPrenotazioni().add(this);
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ora == null) ? 0 : Ora.hashCode());
		result = prime * result + (completato ? 1231 : 1237);
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nominativo == null) ? 0 : nominativo.hashCode());
		result = prime * result + numeroOspiti;
		result = prime * result + ((tavoloPrenotato == null) ? 0 : tavoloPrenotato.hashCode());
		result = prime * result + ((utente == null) ? 0 : utente.hashCode());
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
		Prenotazione other = (Prenotazione) obj;
		if (Ora == null) {
			if (other.Ora != null)
				return false;
		} else if (!Ora.equals(other.Ora))
			return false;
		if (completato != other.completato)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nominativo == null) {
			if (other.nominativo != null)
				return false;
		} else if (!nominativo.equals(other.nominativo))
			return false;
		if (numeroOspiti != other.numeroOspiti)
			return false;
		if (tavoloPrenotato == null) {
			if (other.tavoloPrenotato != null)
				return false;
		} else if (!tavoloPrenotato.equals(other.tavoloPrenotato))
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		return true;
	}

}
