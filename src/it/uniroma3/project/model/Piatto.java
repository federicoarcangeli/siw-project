package it.uniroma3.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Piatto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private DescrizionePiatto descrizionePiatto;

	@ManyToOne(fetch = FetchType.EAGER)
	private Portata portata;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "piatto_id")
	private List<LineaOrdine> orderLines;
	
	

	public Piatto(DescrizionePiatto descrizionePiatto, Portata portata) {
		super();
		this.descrizionePiatto = descrizionePiatto;
		this.portata = portata;
	}

	public Piatto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DescrizionePiatto getDescrizionePiatto() {
		return descrizionePiatto;
	}

	public void setDescrizionePiatto(DescrizionePiatto descrizionePiatto) {
		this.descrizionePiatto = descrizionePiatto;
	}

	public Portata getPortata() {
		return portata;
	}

	public void setPortata(Portata portata) {
		this.portata = portata;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizionePiatto == null) ? 0 : descrizionePiatto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((portata == null) ? 0 : portata.hashCode());
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
		Piatto other = (Piatto) obj;
		if (descrizionePiatto == null) {
			if (other.descrizionePiatto != null)
				return false;
		} else if (!descrizionePiatto.equals(other.descrizionePiatto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (portata == null) {
			if (other.portata != null)
				return false;
		} else if (!portata.equals(other.portata))
			return false;
		return true;
	}

}
