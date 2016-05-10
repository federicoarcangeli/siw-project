package it.uniroma3.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tavolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * numero del tavolo univoco? 
	 */
	
	@Column(nullable = false)
	private int coperti;
	
	/**
	 * ad uno stesso tavolo non è associato un solo ordine?
	 */
	@ManyToMany
	private List<Ordine> ordini;
	
	public Tavolo(int coperti) {
		this.coperti = coperti;
		this.ordini = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCoperti() {
		return coperti;
	}

	public void setCoperti(int coperti) {
		this.coperti = coperti;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coperti;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ordini == null) ? 0 : ordini.hashCode());
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
		if (coperti != other.coperti)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ordini == null) {
			if (other.ordini != null)
				return false;
		} else if (!ordini.equals(other.ordini))
			return false;
		return true;
	}
	
	

}