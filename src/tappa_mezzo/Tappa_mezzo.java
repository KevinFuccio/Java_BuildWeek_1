package tappa_mezzo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import mezzi.Mezzo;
import stato.Stato;
import stato.Tipologia_stato;
import tratta.Tratta;

@Entity
@NamedQuery(name="Tappa_mezzo.findAll",query="SELECT m FROM Tappa_mezzo m")
public class Tappa_mezzo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Mezzo mezzi;
	@ManyToOne(cascade = CascadeType.ALL)
	private Tratta tratta;
	private LocalDate inizio_tappa;
	private LocalDate fine_tappa;
	
	
	public Tappa_mezzo() {
		super();
	}


	public Tappa_mezzo(Mezzo mezzi, Tratta tratta, LocalDate inizio_tappa, LocalDate fine_tappa) {
		super();
//		List<Mezzo> mezziFiltrati = this.mezzi.stream().forEach(e).collect(Collectors.toList());
//		if(!mezziFiltrati.isEmpty()) {			
			this.mezzi = mezzi;
			List<Tappa_mezzo> tm = new ArrayList();
			tm.add(this);
			this.mezzi.setTappa_mezzo(tm);
			this.tratta = tratta;
			this.tratta.setTappa_mezzo(tm);
//		}
		this.inizio_tappa = inizio_tappa;
		this.fine_tappa = fine_tappa;
	}


	public Mezzo getMezzi() {
		return mezzi;
	}


	public void setMezziMezzo (Mezzo mezzi) {
		this.mezzi = mezzi;
	}


	public Tratta getTratta() {
		return tratta;
	}


	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}


	public LocalDate getInizio_tappa() {
		return inizio_tappa;
	}


	public void setInizio_tappa(LocalDate inizio_tappa) {
		this.inizio_tappa = inizio_tappa;
	}


	public LocalDate getFine_tappa() {
		return fine_tappa;
	}


	public void setFine_tappa(LocalDate fine_tappa) {
		this.fine_tappa = fine_tappa;
	}


	public Integer getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Tappa_mezzo [Mezzi=" + getMezzi() + ", Tratta=" + getTratta() + ", Inizio_tappa="
				+ getInizio_tappa() + ", Fine_tappa=" + getFine_tappa() + ", id=" + getId() + "]";
	}
	
	
	
	
	
	
	
	
	
}
