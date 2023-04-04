package utente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import utils.JpaUtil;

public class UtenteDAO {
	static EntityManager em = JpaUtil.entityManagerFactory.createEntityManager();

    public static void saveUtente(Utente e) {
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit(); 
        System.out.println("utente salvato");

    }


    public static void multipleSaveUtente(List<Utente> el) {
        em.getTransaction().begin();
        el.forEach(e -> em.persist(e));
        em.getTransaction().commit();
        }



    public static Utente findUtente(Integer id) {
        em.getTransaction().begin();
        Utente e = em.find(Utente.class, id);
        em.getTransaction().commit();
        return e;
    }
   
    


    public static void removeUtente(Utente e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        System.out.println("utente eliminato!");
    };


    @SuppressWarnings("unchecked")
    public static List<Utente> UtenteFindAll(){
        Query q = em.createNamedQuery("Utente.findAll");
        return (List<Utente> ) q.getResultList();
    }
}
