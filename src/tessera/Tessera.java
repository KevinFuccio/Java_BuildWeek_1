package tessera;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import abbonamento.Abbonamento;
import utente.Utente;

@Entity
@NamedQuery(name = "Tessera.findAll", query = "SELECT u FROM Tessera u")
public class Tessera implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate data_inizio_tessera;
	private LocalDate data_fine_tessera;
	@OneToOne
	private Utente utente;
	@OneToMany(mappedBy = "tessera")
	private List<Abbonamento> abbonamenti;
	
	
	
	public Tessera() {
		super();
	}
	
	
	public Tessera(LocalDate data_inizio_tessera, Utente utente,
			List<Abbonamento> abbonamenti) {
		super();
		this.data_inizio_tessera = data_inizio_tessera;
		this.data_fine_tessera = data_inizio_tessera.plusYears(1);
		this.utente = utente;
		this.abbonamenti = abbonamenti;
	}


	public LocalDate getData_inizio_tessera() {
		return data_inizio_tessera;
	}
	public void setData_inizio_tessera(LocalDate data_inizio_tessera) {
		this.data_inizio_tessera = data_inizio_tessera;
	}
	public LocalDate getData_fine_tessera() {
		return data_fine_tessera;
	}
	public void setData_fine_tessera(LocalDate data_fine_tessera) {
		this.data_fine_tessera = data_fine_tessera;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public List<Abbonamento> getAbbonamenti() {
		return abbonamenti;
	}
	public void setAbbonamenti(List<Abbonamento> abbonamenti) {
		this.abbonamenti = abbonamenti;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Tessera [Data_inizio_tessera=" + getData_inizio_tessera() + ", Data_fine_tessera="
				+ getData_fine_tessera() + ", Utente=" + getUtente() + ", Abbonamenti=" + getAbbonamenti()
				+ ", Id=" + getId() + "]";
	}
	
	
}
