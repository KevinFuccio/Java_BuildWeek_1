package abbonamento;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import rivenditore.Rivenditore_autorizzato;
import tessera.Tessera;

@Entity
@NamedQuery(name = "Abbonamento.findAll", query = "SELECT u FROM Abbonamento u")
public class Abbonamento implements Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Enumerated(EnumType.STRING)
		private Tipologia_abbonamento tipologia_abbonamento;
		private LocalDate data_inizio_abbonamento;
		private LocalDate data_fine_abbonamento;
		public LocalDate getData_inizio_abbonamento() {
			return data_inizio_abbonamento;
		}
		public LocalDate getData_fine_abbonamento() {
			return data_fine_abbonamento;
		}
		@ManyToOne
		private Tessera tessera;
		@ManyToOne
		private Rivenditore_autorizzato rivenditore;
		public Abbonamento() {
			super();
		}
		public Abbonamento(Tipologia_abbonamento tipologia_abbonamento,LocalDate data_inizio_abbonamento, Tessera tessera,
				Rivenditore_autorizzato rivenditore) {
			super();
			this.tipologia_abbonamento = tipologia_abbonamento;
			this.tessera = tessera;
			this.rivenditore = rivenditore;
			if(tipologia_abbonamento == Tipologia_abbonamento.Settimanale) {
				
				data_fine_abbonamento = data_inizio_abbonamento.plusDays(7);
				
			}else if(tipologia_abbonamento == Tipologia_abbonamento.Mensile) {
				
				data_fine_abbonamento = data_inizio_abbonamento.plusMonths(1);
			}
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Tipologia_abbonamento getTipologia_abbonamento() {
			return tipologia_abbonamento;
		}
		public void setTipologia_abbonamento(Tipologia_abbonamento tipologia_abbonamento) {
			this.tipologia_abbonamento = tipologia_abbonamento;
		}
		public Tessera getTessera() {
			return tessera;
		}
		public void setTessera(Tessera tessera) {
			this.tessera = tessera;
		}
		public Rivenditore_autorizzato getRivenditore() {
			return rivenditore;
		}
		public void setRivenditore(Rivenditore_autorizzato rivenditore) {
			this.rivenditore = rivenditore;
		}
		@Override
		public String toString() {
			return "Abbonamento [Id=" + getId() + ", Tipologia_abbonamento=" + getTipologia_abbonamento()
					+ ", Tessera=" + getTessera() + ", Rivenditore=" + getRivenditore() + "]";
		}
		
}
