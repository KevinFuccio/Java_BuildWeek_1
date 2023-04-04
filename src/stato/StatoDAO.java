package stato;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import utils.JpaUtil;

public class StatoDAO {
	static EntityManager em = JpaUtil.entityManagerFactory.createEntityManager();

    public static void saveStato(Stato e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit(); 
        System.out.println("Stato  salvato");

    }


    public static void multipleSaveStato (List<Stato> el) {
        em.getTransaction().begin();
        el.forEach(e -> em.persist(e));
        em.getTransaction().commit();
        }



    public static Stato  findStato (Integer id) {
        em.getTransaction().begin();
        Stato  e = em.find(Stato .class, id);
        em.getTransaction().commit();
        return e;
    }
   
    


    public static void removeStato(Stato  e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        System.out.println("Stato eliminato!");
    };


    @SuppressWarnings("unchecked")
    public static List<Stato> StatoFindAll(){
        Query q = em.createNamedQuery("Stato.findAll");
        return (List<Stato> ) q.getResultList();
    }
    
}
