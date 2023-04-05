package tappa_mezzo;

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
}
