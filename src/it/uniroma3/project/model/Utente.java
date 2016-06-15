package it.uniroma3.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "utente.findAll", query = "select u from Utente u")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique=true)
	private String username;

	/*ruoli possibili:
	 * utente
	 * operatore
	 * admin*/
	@Column(nullable = false)
	private String role;

	@Column
	private String nome;

	@Column
	private String cognome;

	@Column
	private String email;

	@Column
	private String telefono;

	@Column(nullable = false)
	private String password;

	@OneToMany(mappedBy="operatore",cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch =FetchType.EAGER)
	private List<Comanda> comanda;

	@OneToMany(mappedBy="utente" , fetch= FetchType.EAGER)
	List<Prenotazione> prenotazioni;

	public Utente() {
		prenotazioni = new ArrayList<>();
	}
	/**
	 * 
	 * @param nome
	 * @param cognome
	 * @param username
	 * @param telefono
	 * @param email
	 * @param password
	 * costruttore per utenti
	 */
	public Utente(String nome , String cognome ,String username, String telefono , String email, String password){
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.username=username;
		this.telefono=telefono;
		this.password=password;
		this.role="utente";
		prenotazioni = new ArrayList<>();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * costruttore per utente operatore
	 */
	public Utente(String username, String password){
		this.username=username;
		this.password=password;
		this.role="operatore";
		prenotazioni = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Comanda> getComanda() {
		return comanda;
	}

	public void setComanda(List<Comanda> comanda) {
		this.comanda = comanda;
	}
	public void addPrenotazione(Prenotazione prenotazione){
		this.prenotazioni.add(prenotazione);
	}
	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Utente other = (Utente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Utente [id=" + id + ", email=" + email + ", nome=" + nome + ", cognome=" + cognome + ", password="
				+ password + ", telefono=" + telefono + ", role=" + role + ", username=" + username + ", comanda="
				+ comanda + ", prenotazioni=" + prenotazioni + "]";
	}

}
