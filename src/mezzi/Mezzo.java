package mezzi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import biglietto.Biglietto;
import stato.Stato;
import stato.Tipologia_stato;
import tappa_mezzo.Tappa_mezzo;
import tratta.Tratta;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipologia",discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "Mezzo.findAll",query="SELECT m FROM Mezzo m")
public class Mezzo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	@OneToMany(mappedBy = "mezzo_timbrante")
	private List<Biglietto> biglietti_timbrati;
	@OneToMany(mappedBy = "mezzo")
	private List<Stato> stato;
	@ManyToMany(mappedBy= "mezzi")
	private List<Tappa_mezzo> tappa_mezzo;
	
	public Mezzo() {
		
	}
	
	public Mezzo(List<Biglietto> biglietti_timbrati, List<Stato> stato) {
		super();
		this.biglietti_timbrati = biglietti_timbrati;
		this.biglietti_timbrati.forEach(e-> e.setMezzo_timbrante(this));
		this.stato = stato;
		this.stato.forEach(e-> e.setMezzo(this));
		List<Stato> stato_servizio_attuale = this.stato.stream().filter(e -> e.getStato() == Tipologia_stato.Servizio && e.getFine() == null).collect(Collectors.toList());
		if(!stato_servizio_attuale.isEmpty()) {
			List<Mezzo> m = new ArrayList();
			m.add(this);
			if(this.tappa_mezzo != null) {				
				this.tappa_mezzo.forEach(e-> e.setMezzi(m));
			}
		}else {
			System.out.println("il mezzo e in manutenzione.");
		}
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
	

	public List<Tappa_mezzo> getTappa_mezzo() {
		return tappa_mezzo;
	}

	public void setTappa_mezzo(List<Tappa_mezzo> tappa_mezzo) {
		tappa_mezzo = tappa_mezzo;
	}

	@Override
	public String toString() {
		return "Mezzo [Biglietti_timbrati=" + getBiglietti_timbrati() + ", Stato=" + getStato() + ", Id="
				+ getId() + "]";
	}

	
}
