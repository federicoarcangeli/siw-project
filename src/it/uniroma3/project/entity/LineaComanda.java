package it.uniroma3.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@GeneratedValue
	private int numeroLinea;
	
	@Column
	private String nota;
	
	@Column(nullable = false)
	private int quantità;
	
	@ManyToOne
	private Comanda comanda;
	
	@ManyToOne
	private Piatto piatto;

	public LineaComanda(){
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
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
		result = prime * result + ((nota == null) ? 0 : nota.hashCode());
		result = prime * result + numeroLinea;
		result = prime * result + ((piatto == null) ? 0 : piatto.hashCode());
		result = prime * result + quantità;
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
		if (nota == null) {
			if (other.nota != null)
				return false;
		} else if (!nota.equals(other.nota))
			return false;
		if (numeroLinea != other.numeroLinea)
			return false;
		if (piatto == null) {
			if (other.piatto != null)
				return false;
		} else if (!piatto.equals(other.piatto))
			return false;
		if (quantità != other.quantità)
			return false;
		return true;
	}
}
