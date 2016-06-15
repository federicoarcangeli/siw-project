package it.uniroma3.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "Piatto.findAll", query = "select p from Piatto p order by p.categoriaPiatto")
public class Piatto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private DescrizionePiatto descrizionePiatto;

	@ManyToOne
	private CategoriaPiatto categoriaPiatto;

	@OneToMany(mappedBy="piatto",cascade = {CascadeType.REMOVE} ,orphanRemoval = true)
	private List<LineaComanda> orderLines;

	public Piatto(){
	}

	public Piatto(String nome , DescrizionePiatto descrizionePiatto, CategoriaPiatto categoria) {
		this.nome=nome;
		this.descrizionePiatto = descrizionePiatto;
		this.categoriaPiatto = categoria;
	}

	public Piatto(DescrizionePiatto descrizionePiatto) {
		this.descrizionePiatto=descrizionePiatto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DescrizionePiatto getDescrizionePiatto() {
		return descrizionePiatto;
	}

	public void setDescrizionePiatto(DescrizionePiatto descrizionePiatto) {
		this.descrizionePiatto = descrizionePiatto;
	}

	public CategoriaPiatto getPortata() {
		return categoriaPiatto;
	}

	public void setPortata(CategoriaPiatto portata) {
		this.categoriaPiatto = portata;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	@Override
	public String toString() {
		return "Piatto [id=" + id + ", nome=" + nome + ", descrizionePiatto=" + descrizionePiatto + ", categoriaPiatto="
				+ categoriaPiatto + ", orderLines=" + orderLines + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizionePiatto == null) ? 0 : descrizionePiatto.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Piatto other = (Piatto) obj;
		if (descrizionePiatto == null) {
			if (other.descrizionePiatto != null)
				return false;
		} else if (!descrizionePiatto.equals(other.descrizionePiatto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
