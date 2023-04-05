package tratta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mezzi.Mezzo;
import utils.JpaUtil;

public class TrattaDAO {
	static EntityManager em = JpaUtil.entityManagerFactory.createEntityManager();

    public static void saveTratta(Tratta e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit(); 
        System.out.println("Tratta  salvato");

    }


    public static void multipleSaveTratta (List<Tratta> el) {
        em.getTransaction().begin();
        el.forEach(e -> em.persist(e));
        em.getTransaction().commit();
        }



    public static Tratta findTratta (Integer id) {
        em.getTransaction().begin();
        Tratta e = em.find(Tratta.class, id);
        em.getTransaction().commit();
        return e;
    }
   
    


    public static void removeTratta(Tratta e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        System.out.println("Tratta eliminato!");
    };


    @SuppressWarnings("unchecked")
    public static List<Tratta> MezzoFindAll(){
        Query q = em.createNamedQuery("Tratta.findAll");
        return (List<Tratta> ) q.getResultList();
    }
}
