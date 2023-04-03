package rivenditore;

import javax.persistence.Entity;

@Entity
public class Distributore_Automatico extends Rivenditore_autorizzato{
	private boolean fuori_servizio;
}
