package it.uniroma3.project.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOraEmissione;
	
	@Column(nullable = false)
	private double prezzoTotale;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Operatore operatore;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.LAZY)
	private Tavolo tavolo;
	
	
	public Comanda() {
	}

	public Comanda(Date timestamp, double priceTotal) {
		super();
		this.dataOraEmissione = timestamp;
		this.prezzoTotale = priceTotal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return dataOraEmissione;
	}

	public void setTimestamp(Date timestamp) {
		this.dataOraEmissione = timestamp;
	}

	public double getPriceTotal() {
		return prezzoTotale;
	}

	public void setPriceTotal(double priceTotal) {
		this.prezzoTotale = priceTotal;
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
		temp = Double.doubleToLongBits(prezzoTotale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dataOraEmissione == null) ? 0 : dataOraEmissione.hashCode());
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
		Comanda other = (Comanda) obj;
		if (id != other.id)
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		if (Double.doubleToLongBits(prezzoTotale) != Double.doubleToLongBits(other.prezzoTotale))
			return false;
		if (dataOraEmissione == null) {
			if (other.dataOraEmissione != null)
				return false;
		} else if (!dataOraEmissione.equals(other.dataOraEmissione))
			return false;
		return true;
	}
	
	

}
