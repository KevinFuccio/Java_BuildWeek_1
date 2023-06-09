package mezzi;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import biglietto.Biglietto;
import stato.Stato;
import tappa_mezzo.Tappa_mezzo;
import tratta.Tratta;

@Entity
@DiscriminatorValue("autobus")
public class Autobus extends Mezzo {
	private static Integer capienza = 40;

	public Autobus() {
		super();
	}

	

	public Autobus(List<Biglietto> biglietti_timbrati, List<Stato> stato) {
		super(biglietti_timbrati, stato);
		// TODO Auto-generated constructor stub
	}



	public static Integer getCapienza() {
		return capienza;
	}

	public static void setCapienza(Integer capienza) {
		Autobus.capienza = capienza;
	}

	@Override
	public String toString() {
		return "Autobus [Biglietti_timbrati=" + getBiglietti_timbrati() + ", Stato=" + getStato()
				+ ", Id=" + getId() + "Capienza=" + getCapienza() + "]";
	}

	

	
	
	
}
