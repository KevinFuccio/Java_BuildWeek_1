package mezzi;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import biglietto.Biglietto;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public abstract class Mezzo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id ;
	@OneToMany(mappedBy = "mezzo_timbrante")
	private List<Biglietto> biglietti_timbrati;
	

	
	
}
