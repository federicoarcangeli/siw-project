package it.uniroma3.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LineaComanda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private int numeroLinea;

	@Column(nullable = false)
	private int quantita;

	@ManyToOne(fetch=FetchType.LAZY)
	private Comanda comanda;

	@ManyToOne
	private Piatto piatto;

	public LineaComanda(){
		this.quantita = 1;	
	}

	public LineaComanda(Comanda comanda, Piatto piatto) {
		this.comanda = comanda;
		this.piatto = piatto;
		this.quantita = 1;
		this.numeroLinea=0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroLinea() {
		return numeroLinea;
	}

	public void setNumeroLinea(int numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	public void updateNumeroLinea() {
		this.numeroLinea++;
	}

	public void plusQuantity() {
		this.quantita++;
	}

	public void minusQuantity() {
		this.quantita--;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Piatto getPiatto() {
		return piatto;
	}

	public void setPiatto(Piatto piatto) {
		this.piatto = piatto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comanda == null) ? 0 : comanda.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numeroLinea;
		result = prime * result + ((piatto == null) ? 0 : piatto.hashCode());
		result = prime * result + quantita;
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
		LineaComanda other = (LineaComanda) obj;
		if (comanda == null) {
			if (other.comanda != null)
				return false;
		} else if (!comanda.equals(other.comanda))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numeroLinea != other.numeroLinea)
			return false;
		if (piatto == null) {
			if (other.piatto != null)
				return false;
		} else if (!piatto.equals(other.piatto))
			return false;
		if (quantita != other.quantita)
			return false;
		return true;
	}
	
}
