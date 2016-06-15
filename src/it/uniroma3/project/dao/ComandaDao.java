package it.uniroma3.project.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import it.uniroma3.project.model.Comanda;

public class ComandaDao extends AbstractDao<Comanda> {

	public ComandaDao(EntityManager em) {
		super(em);
	}

	@Override
	public Comanda findById(long id) {
		return getEM().find(Comanda.class, id);
	}

	public void deleteById(long id) {
		Comanda comanda = this.findById(id);
		if (comanda != null) {
			Comanda toRemove = getEM().merge(comanda);
			getEM().remove(toRemove);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comanda> findAll() {
		return getEM().createNamedQuery("Comanda.findAll").getResultList();
	}

	public Comanda findComandaByTavolo(Long param) {
		try {
			Query query = getEM().createNativeQuery(
					"select c.* from comanda c where c.tavolo_id = ?1 and c.completata='false'", Comanda.class);
			query.setParameter(1, param);
			return (Comanda) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Comanda> findAllInCorso() {
		TypedQuery<Comanda> query = getEM()
				.createQuery("select c from Comanda c where c.completata= false ", Comanda.class);
		return query.getResultList();
	}

	public List<Comanda> findAllCompletate() {
		TypedQuery<Comanda> query = getEM().createQuery("select c from Comanda c where c.completata = true order by c.dataOraEmissione",
				Comanda.class);
		return query.getResultList();
	}

	public List<Comanda> findAllCompletateToday() {
		TypedQuery<Comanda> query = getEM().createQuery("select c from Comanda c where c.completata = true and  c.dataOraEmissione > CURRENT_DATE",
				Comanda.class);
		return query.getResultList();
	}

	public List<Comanda> findAllCompletateInThisDay(Date date) {
		TypedQuery<Comanda> query = getEM().createQuery("select c from Comanda c where c.completata = true and c.dataOraEmissione = :date",
				Comanda.class);
		query.setParameter("date", date,TemporalType.DATE);
		return query.getResultList();
	}

	public Map<String, List<String>> findAllOperatoriInServizio() {
		TypedQuery<Comanda> query = getEM()
				.createQuery("select c from Comanda c where c.dataOraEmissione > CURRENT_DATE and c.completata=false", Comanda.class);
		List<Comanda> comande = query.getResultList();
		HashMap<String,List<String>> OperatoriInServizio = new HashMap<>();
		for(Comanda c : comande){
			if(OperatoriInServizio.containsKey(c.getOperatore().getUsername())){
				OperatoriInServizio.get(c.getOperatore().getUsername()).add(c.getTavolo().getCodiceTavolo());
			}
			else{
				OperatoriInServizio.put(c.getOperatore().getUsername(), new ArrayList<String>());
				OperatoriInServizio.get(c.getOperatore().getUsername()).add(c.getTavolo().getCodiceTavolo());
			}
		}
		return OperatoriInServizio;
	}
}
