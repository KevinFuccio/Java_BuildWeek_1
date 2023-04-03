package abbonamento;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import utente.Utente;
import utils.JpaUtil;

public class AbbonamentoDAO {
	static EntityManager em = JpaUtil.entityManagerFactory.createEntityManager();

    public static void saveAbbonamento(Abbonamento e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit(); 
        System.out.println("Abbonamento salvato");

    }


    public static void multipleSaveAbbonamento(List<Abbonamento> el) {
        em.getTransaction().begin();
        el.forEach(e -> em.persist(e));
        em.getTransaction().commit();
        }



    public static Utente findAbbonamento(Integer id) {
        em.getTransaction().begin();
        Abbonamento e = em.find(Abbonamento.class, id);
        em.getTransaction().commit();
        return e;
    }
   
    


    public static void removeAbbonamento(Abbonamento e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        System.out.println("Abbonamento eliminato!");
    };


    @SuppressWarnings("unchecked")
    public static List<Abbonamento> AbbonamentoFindAll(){
        Query q = em.createNamedQuery("Abbonamento.findAll");
        return (List<Abbonamento> ) q.getResultList();
    }
}
