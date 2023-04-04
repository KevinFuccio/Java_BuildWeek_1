package stato;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import mezzi.Mezzo;
@Entity
@NamedQuery(name="Stato.findAll", query="SELECT u FROM Stato u")
public class Stato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate inizio;
	private LocalDate fine;
	private Tipologia_stato stato;
	@ManyToOne
	private Mezzo mezzo;
	
	public Stato() {
		super();
	}

	public Stato(LocalDate inizio, LocalDate fine, Tipologia_stato stato) {
		super();
		this.inizio = inizio;
		this.fine = fine;
		this.stato = stato;
	}

	public LocalDate getInizio() {
		return inizio;
	}

	public void setInizio(LocalDate inizio) {
		this.inizio = inizio;
	}

	public LocalDate getFine() {
		return fine;
	}

	public void setFine(LocalDate fine) {
		this.fine = fine;
	}

	public Tipologia_stato getStato() {
		return stato;
	}

	public void setStato(Tipologia_stato stato) {
		this.stato = stato;
	}

	public Mezzo getMezzo() {
		return mezzo;
	}

	public void setMezzo(Mezzo mezzo) {
		this.mezzo = mezzo;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Stato [Inizio=" + getInizio() + ", Fine=" + getFine() + ", Stato=" + getStato()
				+ ", Mezzo=" + getMezzo() + ", Id=" + getId() + "]";
	}

	
	
}
