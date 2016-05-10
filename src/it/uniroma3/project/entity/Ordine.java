package it.uniroma3.project.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ordine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	@Column(nullable = false)
	private double priceTotal;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Operatore operatore;
	
//	@ManyToMany(mappedBy = "ordini", fetch = FetchType.LAZY)
//	private List<Tavolo> tavoli;

	@ManyToMany(mappedBy = "ordini", fetch = FetchType.LAZY)
	private List<Tavolo> tavoli;
	
	
	public Ordine() {
	}

	public Ordine(Date timestamp, double priceTotal) {
		super();
		this.timestamp = timestamp;
		this.priceTotal = priceTotal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public double getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}

	public Operatore getOperatore() {
		return operatore;
	}

	public void setOperatore(Operatore operatore) {
		this.operatore = operatore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		long temp;
		temp = Double.doubleToLongBits(priceTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		Ordine other = (Ordine) obj;
		if (id != other.id)
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		if (Double.doubleToLongBits(priceTotal) != Double.doubleToLongBits(other.priceTotal))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}
	
	

}
