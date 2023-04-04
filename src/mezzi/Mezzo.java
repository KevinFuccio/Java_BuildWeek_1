package mezzi;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import biglietto.Biglietto;
import stato.Stato;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "Mezzo.findAll",query="SELECT m FROM Mezzo m")
public abstract class Mezzo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	@OneToMany(mappedBy = "mezzo_timbrante")
	private List<Biglietto> biglietti_timbrati;
	@OneToMany(mappedBy= "mezzo")
	private List<Stato> stato;
	
	public Mezzo() {
		
	}
	
	public Mezzo(List<Biglietto> biglietti_timbrati, List<Stato> stato) {
		super();
		this.biglietti_timbrati = biglietti_timbrati;
		this.biglietti_timbrati.forEach(e-> e.setMezzo_timbrante(this));
		this.stato = stato;
		this.stato.forEach(e-> e.setMezzo(this));
	}

	public List<Biglietto> getBiglietti_timbrati() {
		return biglietti_timbrati;
	}

	public void setBiglietti_timbrati(List<Biglietto> biglietti_timbrati) {
		this.biglietti_timbrati = biglietti_timbrati;
	}

	public List<Stato> getStato() {
		return stato;
	}

	public void setStato(List<Stato> stato) {
		this.stato = stato;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Mezzo [Biglietti_timbrati=" + getBiglietti_timbrati() + ", Stato=" + getStato() + ", Id="
				+ getId() + "]";
	}

	
}
