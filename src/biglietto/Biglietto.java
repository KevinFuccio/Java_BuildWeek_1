package biglietto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import mezzi.Mezzo;
import rivenditore.Rivenditore_autorizzato;
import utente.Utente;

@Entity
@NamedQuery(name = "Biglietto.findAll", query = "SELECT u FROM Biglietto u")

public class Biglietto implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private boolean scaduto;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Rivenditore_autorizzato rivenditore;
	private LocalDate data_emissione_biglietto;
	@ManyToOne
	private Mezzo mezzo_timbrante;
	
	public LocalDate getData_emissione_biglietto() {
		return data_emissione_biglietto;
	}
	public Biglietto() {
		super();
	}
	public boolean isScaduto() {
		return scaduto;
	}
	public void setScaduto(boolean scaduto) {
		this.scaduto = scaduto;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Rivenditore_autorizzato getRivenditore() {
		return rivenditore;
	}
	public void setRivenditore(Rivenditore_autorizzato rivenditore) {
		this.rivenditore = rivenditore;
	}
	
	public Biglietto(boolean scaduto, Utente utente, Rivenditore_autorizzato rivenditore,
			LocalDate data_emissione_biglietto) {
		super();
		this.scaduto = scaduto;
		this.utente = utente;
		this.rivenditore = rivenditore;
		this.data_emissione_biglietto = data_emissione_biglietto;
	}
	@Override
	public String toString() {
		return "Biglietto [isScaduto()=" + isScaduto() + ", Utente()=" + getUtente() + ", Rivenditore()="
				+ getRivenditore() + "]";
	}
	
}
