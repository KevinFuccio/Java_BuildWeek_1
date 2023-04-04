package tessera;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import utente.Utente;
import utils.JpaUtil;

public class TesseraDAO {
	static EntityManager em = JpaUtil.entityManagerFactory.createEntityManager();

    public static void saveTessera(Tessera e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit(); 
        System.out.println("tessera salvato");

    }


    public static void multipleSaveTessera(List<Tessera> el) {
        em.getTransaction().begin();
        el.forEach(e -> em.persist(e));
        em.getTransaction().commit();
        }



    public static Tessera findTessera(Integer id) {
        em.getTransaction().begin();
        Tessera e = em.find(Tessera.class, id);
        em.getTransaction().commit();
        return e;
    }
   
    


    public static void removeTessera(Tessera e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        System.out.println("Tessera eliminato!");
    };


    @SuppressWarnings("unchecked")
    public static List<Tessera> TesseraFindAll(){
        Query q = em.createNamedQuery("Tessera.findAll");
        return (List<Tessera> ) q.getResultList();
    }
	
    
}
