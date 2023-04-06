package utente;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import biglietto.Biglietto;
import tessera.Tessera;

@Entity
@NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
public class Utente implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy = "utente")
	private List<Biglietto>biglietto;
	@OneToOne
	private Tessera tessera;
	public Utente() {
		super();
	}
	public List<Biglietto> getBiglietto() {
		return biglietto;
	}
	public void setBiglietto(List<Biglietto> biglietto) {
		this.biglietto = biglietto;
	}
	public Tessera getTessera() {
		return tessera;
	}
	public Integer getId() {
		return id;
	}
	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}
	public Utente(List<Biglietto> biglietto, Tessera tessera) {
		super();
		this.biglietto = biglietto;
		this.biglietto.forEach(e -> e.setUtente(this));
		this.tessera = tessera;
		this.tessera.setUtente(this);
	}
	

	@Override
	public String toString() {
		return "Utente [Tessera=" + getTessera() + ", Id=" + getId()
				+ "]";
	}

	
}
