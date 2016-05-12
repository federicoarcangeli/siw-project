package it.uniroma3.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@ManyToOne
	private Utente utente;
	
	@ManyToOne
	private Tavolo tavoloPrenotato;

	public Prenotazione() {
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

	public void setNumeroOspiti(int numeroOspiti) {
		this.numeroOspiti = numeroOspiti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ora == null) ? 0 : Ora.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numeroOspiti;
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
		if (numeroOspiti != other.numeroOspiti)
			return false;
		return true;
	}



}
