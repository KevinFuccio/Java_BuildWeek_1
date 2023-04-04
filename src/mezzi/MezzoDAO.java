package mezzi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import stato.Stato;
import utils.JpaUtil;

public class MezzoDAO {
	static EntityManager em = JpaUtil.entityManagerFactory.createEntityManager();

    public static void saveMezzo(Mezzo e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit(); 
        System.out.println("Mezzo  salvato");

    }


    public static void multipleSaveMezzo (List<Mezzo> el) {
        em.getTransaction().begin();
        el.forEach(e -> em.persist(e));
        em.getTransaction().commit();
        }



    public static Mezzo findMezzo (Integer id) {
        em.getTransaction().begin();
        Mezzo e = em.find(Mezzo.class, id);
        em.getTransaction().commit();
        return e;
    }
   
    


    public static void removeMezzo(Mezzo e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        System.out.println("Mezzo eliminato!");
    };


    @SuppressWarnings("unchecked")
    public static List<Mezzo> MezzoFindAll(){
        Query q = em.createNamedQuery("Mezzo.findAll");
        return (List<Mezzo> ) q.getResultList();
    }
    public static void sommaBigliettiVidimato(Integer id){
    	Query q = em.createQuery("SELECT m FROM Biglietto m WHERE m.mezzo_timbrante.id = :id");
    	q.setParameter("id", id);
    	System.out.println(q.getResultList().size());
    }
}
