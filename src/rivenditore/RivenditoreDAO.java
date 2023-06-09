package rivenditore;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import abbonamento.Abbonamento;
import utente.Utente;
import utils.JpaUtil;

public class RivenditoreDAO {
	static EntityManager em = JpaUtil.entityManagerFactory.createEntityManager();

    public static void saveRivenditore_autorizzato(Rivenditore_autorizzato e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit(); 
        System.out.println("Rivenditore_autorizzato salvato");

    }


    public static void multipleSaveRivenditore_autorizzato(List<Rivenditore_autorizzato> el) {
        em.getTransaction().begin();
        el.forEach(e -> em.persist(e));
        em.getTransaction().commit();
        }



    public static Rivenditore_autorizzato findRivenditore_autorizzato(Integer id) {
        em.getTransaction().begin();
        Rivenditore_autorizzato e = em.find(Rivenditore_autorizzato.class, id);
        em.getTransaction().commit();
        return e;
    }
   
    


    public static void removeUtente(Rivenditore_autorizzato e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        System.out.println("Rivenditore_autorizzato eliminato!");
    };


    @SuppressWarnings("unchecked")
    public static List<Rivenditore_autorizzato> Rivenditore_autorizzatoFindAll(){
        Query q = em.createNamedQuery("Rivenditore_autorizzato.findAll");
        return (List<Rivenditore_autorizzato> ) q.getResultList();
    }
    
    public static void quantita_emessi_periodo(Integer id, LocalDate inizio,LocalDate fine) {
    	Query q = em.createQuery("SELECT b FROM Biglietto b  WHERE b.rivenditore.id = :id AND (b.data_emissione_biglietto BETWEEN :inizio AND :fine)");
    	Query q2 = em.createQuery("SELECT b FROM Abbonamento b  WHERE b.rivenditore.id = :id AND (b.data_inizio_abbonamento BETWEEN :inizio AND :fine)");
    	q.setParameter("id", id );
    	q.setParameter("inizio", inizio);
    	q.setParameter("fine", fine);
    	q2.setParameter("id", id );
    	q2.setParameter("inizio", inizio);
    	q2.setParameter("fine", fine);
    	
    	System.out.println("numero biglietti emessi: "+q.getResultList().size() +" numero abbonamenti emessi: "+ q2.getResultList().size());    	
    }
    
    

    
}
