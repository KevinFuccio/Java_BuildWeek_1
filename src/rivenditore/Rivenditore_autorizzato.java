package rivenditore;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import abbonamento.Abbonamento;
import biglietto.Biglietto;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "Rivenditore_autorizzato.findAll", query = "SELECT u FROM Rivenditore_autorizzato u")
public class Rivenditore_autorizzato implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy = "rivenditore")
	private List<Abbonamento> abbonamenti;
	@OneToMany(mappedBy = "rivenditore")
	private List<Biglietto> biglietti;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Abbonamento> getAbbonamenti() {
		return abbonamenti;
	}
	public void setAbbonamenti(List<Abbonamento> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}
	public List<Biglietto> getBiglietti() {
		return biglietti;
	}
	public void setBiglietti(List<Biglietto> biglietti) {
		this.biglietti = biglietti;
	}
	public Rivenditore_autorizzato(List<Abbonamento> abbonamenti, List<Biglietto> biglietti) {
		super();
		this.abbonamenti = abbonamenti;
		this.abbonamenti.forEach(e-> e.setRivenditore(this));
		this.biglietti = biglietti;
		this.biglietti.forEach(e-> e.setRivenditore(this));
	}
	
	public Rivenditore_autorizzato() {
		super();
	}
	@Override
	public String toString() {
		return "Rivenditore_autorizzato [Id=" + getId() + ", Abbonamenti=" + getAbbonamenti()
				+ ", Biglietti=" + getBiglietti() + "]";
	}
	

}
