package biglietto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import rivenditore.Rivenditore_autorizzato;
import utils.JpaUtil;

public class BigliettoDAO {
	static EntityManager em = JpaUtil.entityManagerFactory.createEntityManager();

    public static void saveBiglietto(Biglietto e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit(); 
        System.out.println("Biglietto salvato");

    }


    public static void multipleSaveBiglietto(List<Biglietto> el) {
        em.getTransaction().begin();
        el.forEach(e -> em.persist(e));
        em.getTransaction().commit();
        }



    public static Biglietto findBiglietto(Integer id) {
        em.getTransaction().begin();
        Biglietto e = em.find(Biglietto.class, id);
        em.getTransaction().commit();
        return e;
    }
   
    


    public static void removeUtente(Biglietto e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        System.out.println("Biglietto eliminato!");
    };


    @SuppressWarnings("unchecked")
    public static List<Biglietto> BigliettoFindAll(){
        Query q = em.createNamedQuery("Biglietto.findAll");
        return (List<Biglietto> ) q.getResultList();
    }
}
