package tratta;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import mezzi.Mezzo;
import tappa_mezzo.Tappa_mezzo;

@Entity
@NamedQuery(name="Tratta.findAll", query="SELECT u FROM Tratta u")
public class Tratta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String zona_partenza;
	private String capolinea;
	private Integer tempo_medio_percorrenza;
	@OneToMany(mappedBy= "tratta")
	private List<Tappa_mezzo> tappa_mezzo;
	
	
	
	
	public Tratta() {
		super();
	}
	public Tratta(String zona_partenza, String capolinea, Integer km) {
		super();
		this.zona_partenza = zona_partenza;
		this.capolinea = capolinea;
		this.tempo_medio_percorrenza =km;
	}
	
	public String getZona_partenza() {
		return zona_partenza;
	}
	public void setZona_partenza(String zona_partenza) {
		this.zona_partenza = zona_partenza;
	}
	public String getCapolinea() {
		return capolinea;
	}
	public void setCapolinea(String capolinea) {
		this.capolinea = capolinea;
	}
	public Integer getTempo_medio_percorrenza() {
		return tempo_medio_percorrenza;
	}
	public void setTempo_medio_percorrenza(Integer tempo_medio_percorrenza) {
		this.tempo_medio_percorrenza = tempo_medio_percorrenza;
	}
	
	
	public List<Tappa_mezzo> getTappa_mezzo() {
		return tappa_mezzo;
	}
	public void setTappa_mezzo(List<Tappa_mezzo> tappa_mezzo) {
		this.tappa_mezzo = tappa_mezzo;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Tratta [Zona_partenza=" + getZona_partenza() + ", Capolinea=" + getCapolinea()
				+ ", Tempo_medio_percorrenza=" + getTempo_medio_percorrenza() + ", Id=" + getId() + "]";
	}
	
	
	
}
