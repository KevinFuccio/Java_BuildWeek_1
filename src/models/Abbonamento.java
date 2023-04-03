package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Abbonamento {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Enumerated(EnumType.STRING)
		private Tipologia_abbonamento tipologia_abbonamento;
		@ManyToOne
		private Tessera tessera;
		@ManyToOne
		private Rivenditore_autorizzato rivenditore;
}
