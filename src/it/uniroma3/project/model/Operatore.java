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
public class Operatore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String codice;

	@Column(nullable = false)
	private String password;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch =FetchType.EAGER)
	@JoinColumn(name = "operatore_id")
	private List<Ordine> orders;

	public Operatore() {
	}

}
