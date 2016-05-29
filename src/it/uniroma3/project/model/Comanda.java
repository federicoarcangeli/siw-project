package it.uniroma3.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="Comanda.findAll", query="select c from Comanda c")
public class Comanda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOraEmissione;

	@Column(nullable = false)
	private double prezzoTotale;

	@Column
	private boolean completata;

	@ManyToOne(fetch = FetchType.EAGER)
	private Utente operatore;

	@ManyToOne(fetch = FetchType.EAGER)
	private Tavolo tavolo;

	@OneToMany(mappedBy="comanda", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<LineaComanda> lineeComanda;


	public Comanda() {
		this.lineeComanda = new ArrayList<>();
		this.dataOraEmissione = new Date();
		this.prezzoTotale=0.0;
		this.completata=false;
	}

	public Comanda(Date timestamp, double priceTotal) {
		super();
		this.dataOraEmissione = timestamp;
		this.prezzoTotale = priceTotal;
		this.completata=false;
		this.lineeComanda = new ArrayList<>();
	}

	public List<LineaComanda> getLineeComanda() {
		return lineeComanda;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isCompletata() {
		return completata;
	}

	public void setCompletata(boolean completata) {
		this.completata = completata;
	}

	public void setLineeComanda(List<LineaComanda> lineeComanda) {
		this.lineeComanda = lineeComanda;
	}



	public void addLineeComanda(LineaComanda lineaComanda) {
		this.lineeComanda.add(lineaComanda);
	}

	//	public Map<LineaComanda, Double> prezzoLinea() {
	//		Map<LineaComanda, Double> map = new HashMap<>();
	//		for(LineaComanda linea : this.lineeComanda) {
	//
	//		}
	//		return map;
	//	}

	public Map<LineaComanda, Integer> quantitaLinea() {
		Map<LineaComanda, Integer> map = new HashMap<>();
		for(LineaComanda linea : this.lineeComanda) {		
			if(map.containsKey(linea)) {
				int quantity = map.get(linea)+1;
				map.put(linea, quantity);
			} else {
				map.put(linea, 1);
			}
		}
		return map;
	}

	public List<LineaComanda> toList(Map<LineaComanda, Integer> quantity) {
		List<LineaComanda> result = new ArrayList<>();
		for(LineaComanda linea : quantity.keySet()) {
			linea.setQuantita(quantity.get(linea));
			result.add(linea);
		}
		return result;
	}

	public void updateQuantita() {
		//		Map<LineaComanda, Integer> map = this.quantitaLinea();
		//		this.lineeComanda = this.toList(map);

	}


	public LineaComanda updateNumberLine(LineaComanda lineaComanda) {
		for(int i = 0; i<this.lineeComanda.size(); i++) {
			lineaComanda.updateNumeroLinea();
		}
		return lineaComanda;
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

	public Utente getOperatore() {
		return operatore;
	}

	public void setOperatore(Utente operatore) {
		this.operatore = operatore;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public void updatePrice(double price) {
		this.setPrezzoTotale(this.getPrezzoTotale() + price);
	}

	public void setTotal() {
		double totalPrice = 0;
		for(LineaComanda linea : this.lineeComanda) {
			for(int i = 0; i < linea.getQuantita(); i++) {
				totalPrice += linea.getPiatto().getDescrizionePiatto().getPrezzo();
			}
		}
		this.setPrezzoTotale(totalPrice);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (completata ? 1231 : 1237);
		result = prime * result + ((dataOraEmissione == null) ? 0 : dataOraEmissione.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lineeComanda == null) ? 0 : lineeComanda.hashCode());
		result = prime * result + ((operatore == null) ? 0 : operatore.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prezzoTotale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tavolo == null) ? 0 : tavolo.hashCode());
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
		if (completata != other.completata)
			return false;
		if (dataOraEmissione == null) {
			if (other.dataOraEmissione != null)
				return false;
		} else if (!dataOraEmissione.equals(other.dataOraEmissione))
			return false;
		if (id != other.id)
			return false;
		if (lineeComanda == null) {
			if (other.lineeComanda != null)
				return false;
		} else if (!lineeComanda.equals(other.lineeComanda))
			return false;
		if (operatore == null) {
			if (other.operatore != null)
				return false;
		} else if (!operatore.equals(other.operatore))
			return false;
		if (Double.doubleToLongBits(prezzoTotale) != Double.doubleToLongBits(other.prezzoTotale))
			return false;
		if (tavolo == null) {
			if (other.tavolo != null)
				return false;
		} else if (!tavolo.equals(other.tavolo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comanda [id=" + id + ", dataOraEmissione=" + dataOraEmissione + ", prezzoTotale=" + prezzoTotale
				+ ", operatore=" + operatore + ", tavolo=" + tavolo + ", lineeComanda=" + lineeComanda + "]";
	}
}
