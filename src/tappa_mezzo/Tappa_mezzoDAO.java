package tappa_mezzo;

import java.time.Duration;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import tessera.Tessera;
import utils.JpaUtil;

public class Tappa_mezzoDAO {
	static EntityManager em = JpaUtil.entityManagerFactory.createEntityManager();

    public static void saveTappa_mezzo(Tappa_mezzo e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit(); 
        System.out.println("Tappa_mezzo salvato");

    }


    public static void multipleSaveTappa_mezzo(List<Tappa_mezzo> el) {
        em.getTransaction().begin();
        el.forEach(e -> em.persist(e));
        em.getTransaction().commit();
        }



    public static Tappa_mezzo findTappa_mezzo(Integer id) {
        em.getTransaction().begin();
        Tappa_mezzo e = em.find(Tappa_mezzo.class, id);
        em.getTransaction().commit();
        return e;
    }
   
    


    public static void removeTappa_mezzo(Tappa_mezzo e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        System.out.println("Tappa_mezzo eliminato!");
    };


    @SuppressWarnings("unchecked")
    public static List<Tappa_mezzo> Tappa_mezzoFindAll(){
        Query q = em.createNamedQuery("Tappa_mezzo.findAll");
        return (List<Tappa_mezzo> ) q.getResultList();
    }
    public static void numeroTappaPercorso(Integer id_mezzo,Integer id_tratta) {
    	Query q = em.createQuery("SELECT m FROM Tappa_mezzo m WHERE m.mezzi.id = :id_mezzo AND (m.tratta.id = :id_tratta) ");
    	q.setParameter("id_mezzo", id_mezzo);
    	q.setParameter("id_tratta", id_tratta);
    	System.out.println("il mezzo ha percorso " +q.getResultList().size() +" volte questa tappa");
    
    }
    public static void tempoPercorrenzaTappa(Integer id_tabella) {
    	Query q = em.createQuery("SELECT m FROM Tappa_mezzo m WHERE m.id = :id_tabella");
    	q.setParameter("id_tabella", id_tabella);
    	Tappa_mezzo tappa = (Tappa_mezzo) q.getResultList().get(0);
    	System.out.println("Mezzo id " + tappa.getMezzi().getId() +" Tappa id " + tappa.getTratta().getId() +" tempo di tragitto: " +Duration.between(tappa.getInizio_tappa(), tappa.getFine_tappa()).toMinutes() + " minuti.");
    	
    	
    }
}
