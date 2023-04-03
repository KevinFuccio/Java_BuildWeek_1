package rivenditore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import abbonamento.Abbonamento;
import biglietto.Biglietto;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Rivenditore_autorizzato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToMany(mappedBy = "rivenditore")
	private List<Abbonamento> abbonamenti;
	@OneToMany(mappedBy = "rivenditore")
	private List<Biglietto> biglietti;
	

}
