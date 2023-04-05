package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import abbonamento.Abbonamento;
import abbonamento.AbbonamentoDAO;
import abbonamento.Tipologia_abbonamento;
import biglietto.Biglietto;
import biglietto.BigliettoDAO;
import mezzi.Autobus;
import mezzi.Mezzo;
import mezzi.MezzoDAO;
import mezzi.Tram;
import rivenditore.RivenditoreDAO;
import rivenditore.Rivenditore_autorizzato;
import stato.Stato;
import stato.StatoDAO;
import stato.Tipologia_stato;
import tappa_mezzo.Tappa_mezzo;
import tappa_mezzo.Tappa_mezzoDAO;
import tessera.Tessera;
import tessera.TesseraDAO;
import tratta.Tratta;
import tratta.TrattaDAO;
import utente.Utente;
import utente.UtenteDAO;
import utils.JpaUtil;

public class Main {
//	static  EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	public static void main(String[] args) {
		
		Abbonamento a = new Abbonamento(Tipologia_abbonamento.Mensile,LocalDate.now());
		Biglietto b = new Biglietto(false,LocalDate.now());
		
		Biglietto b2 = new Biglietto(false,LocalDate.now());
		
		List<Abbonamento> listaAbbonamenti = new ArrayList();
		listaAbbonamenti.add(a);

		List<Biglietto> listaBiglietti = new ArrayList();
		listaBiglietti.add(b);
		listaBiglietti.add(b2);
		
		List<Biglietto> listaBiglietti2 = new ArrayList();
		listaBiglietti2.add(b2);
		
		
		
		Tessera t = new Tessera(LocalDate.now(),listaAbbonamenti);
		Rivenditore_autorizzato rivenditore = new Rivenditore_autorizzato(listaAbbonamenti,listaBiglietti);
		
		Utente u = new Utente(listaBiglietti,t);
		
		Stato s = new Stato(LocalDate.now(), null, Tipologia_stato.Servizio);
		Stato s2 = new Stato(LocalDate.now().minusDays(2), null, Tipologia_stato.Manutenzione);
		List<Stato> listaStato = new ArrayList();
		listaStato.add(s);
		List<Stato> listaStato2 = new ArrayList();
		listaStato2.add(s2);
		
		Tratta tr = new Tratta("Roma","Milano",4);
		Tratta tr2 = new Tratta("Roma","Verona",5);
		
		List<Tratta> listatratti = new ArrayList();
		listatratti.add(tr);
		listatratti.add(tr2);
		List<Tratta> listatratti2 = new ArrayList();
		
		
		
		Autobus autobus = new Autobus(listaBiglietti,listaStato);
		Tram tram = new Tram(listaBiglietti2,listaStato2);
		
		List<Mezzo> listaMezzi = new ArrayList();
		listaMezzi.add(tram);
		listaMezzi.add(autobus);
		
		Tappa_mezzo tm = new Tappa_mezzo(listaMezzi,listatratti,LocalDate.now(),LocalDate.now().plusDays(1));
//		
////		
		AbbonamentoDAO.saveAbbonamento(a);
		BigliettoDAO.saveBiglietto(b);
		BigliettoDAO.saveBiglietto(b2);
	
		TesseraDAO.saveTessera(t);
		RivenditoreDAO.saveRivenditore_autorizzato(rivenditore);
		UtenteDAO.saveUtente(u);
		
		StatoDAO.saveStato(s);
		StatoDAO.saveStato(s2);
		TrattaDAO.saveTratta(tr);
		TrattaDAO.saveTratta(tr2);
		
		MezzoDAO.saveMezzo(autobus);
		MezzoDAO.saveMezzo(tram);
//		Tappa_mezzoDAO.saveTappa_mezzo(tm);
//		
//		
//		AbbonamentoDAO.saveAbbonamento(a);
		
		
//		RivenditoreDAO.quantita_emessi_periodo(7,LocalDate.now().minusYears(1),LocalDate.now().plusYears(1));
//		MezzoDAO.sommaBigliettiVidimato(1);
//		AbbonamentoDAO.updateAbbonamento(AbbonamentoDAO.findAbbonamento(1).setData_fine_abbonamento(LocalDate.now().minusMonths(2)));
		
	}

}
