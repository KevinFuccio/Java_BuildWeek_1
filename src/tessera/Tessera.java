package tessera;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import abbonamento.Abbonamento;
import utente.Utente;

@Entity
public class Tessera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate data_inizio_abbonamento;
	private LocalDate data_fine_abbonamento;
	@OneToOne
	private Utente utente;
	@OneToMany(mappedBy = "tessera")
	private List<Abbonamento> abbonamenti;
	
	
}
