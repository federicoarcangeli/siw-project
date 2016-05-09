package it.uniroma3.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Portata {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	/**
	 * definisce il tipo corrispondente di portata
	 * 0: antipasti
	 * 1: primi
	 * 2: secondi
	 */
	@Column(nullable = false)
	private int type;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "portata_id")
	private List<Piatto> piatti;

}
