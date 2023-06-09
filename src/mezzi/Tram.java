package mezzi;

import java.util.List;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import biglietto.Biglietto;
import stato.Stato;
import tappa_mezzo.Tappa_mezzo;
import tratta.Tratta;

@Entity
@DiscriminatorValue("tram")
public class Tram extends Mezzo {
	
	
	private static Integer capienza = 60;

	public Tram() {
		super();
	}

	
	
	public Tram(List<Biglietto> biglietti_timbrati, List<Stato> stato) {
		super(biglietti_timbrati, stato);
	}



	public static Integer getCapienza() {
		return capienza;
	}

	public static void setCapienza(Integer capienza) {
		Tram.capienza = capienza;
	}

	@Override
	public String toString() {
		return "Tram [Biglietti_timbrati=" + getBiglietti_timbrati() + ", Stato=" + getStato() + ", Id="
				+ getId() +"Capienza=" + getCapienza() +  "]";
	}
	
	
	
	
	
	

}
