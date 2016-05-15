package it.uniroma3.project.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@ManyToOne(fetch = FetchType.LAZY)
	private String codiceOperatore;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},fetch = FetchType.LAZY)
	private String numeroTavolo;
	
	@OneToMany(mappedBy="comanda")
	private List<LineaComanda> lineeComanda;


	public Comanda() {
		this.lineeComanda = new ArrayList<>();
	}

	public Comanda(Date timestamp, double priceTotal) {
		super();
		this.dataOraEmissione = timestamp;
		this.prezzoTotale = priceTotal;
	}

	public Date getDataOraEmissione() {
		return dataOraEmissione;
	}

	public void setDataOraEmissione(Date dataOraEmissione) {
		this.dataOraEmissione = dataOraEmissione;
	}

	public double getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	public String getOperatore() {
		return codiceOperatore;
	}

	public void setOperatore(String operatore) {
		this.codiceOperatore = operatore;
	}

	public String getTavolo() {
		return numeroTavolo;
	}

	public void setTavolo(String tavolo) {
		this.numeroTavolo = tavolo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((codiceOperatore == null) ? 0 : codiceOperatore.hashCode());
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
		if (codiceOperatore == null) {
			if (other.codiceOperatore != null)
				return false;
		} else if (!codiceOperatore.equals(other.codiceOperatore))
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
