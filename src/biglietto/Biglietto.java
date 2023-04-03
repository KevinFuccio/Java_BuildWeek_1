package biglietto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import rivenditore.Rivenditore_autorizzato;
import utente.Utente;

@Entity
public class Biglietto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private boolean scaduto;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Rivenditore_autorizzato rivenditore;
	
}
