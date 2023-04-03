package rivenditore;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import abbonamento.Abbonamento;
import biglietto.Biglietto;

@Entity
@NamedQuery(name = "Distributore_Automatico.findAll", query = "SELECT u FROM Distributore_Automatico u")
public class Distributore_Automatico extends Rivenditore_autorizzato implements Serializable{
	private boolean fuori_servizio;

	public boolean isFuori_servizio() {
		return fuori_servizio;
	}

	public void setFuori_servizio(boolean fuori_servizio) {
		this.fuori_servizio = fuori_servizio;
	}

	public Distributore_Automatico(List<Abbonamento> abbonamenti, List<Biglietto> biglietti, boolean fuori_servizio) {
		super(abbonamenti, biglietti);
		this.fuori_servizio = fuori_servizio;
	}

	public Distributore_Automatico() {
		super();
	
	}

	@Override
	public String toString() {
		return "Distributore_Automatico [Fuori_servizio=" + isFuori_servizio() + "]";
	}
	
}
