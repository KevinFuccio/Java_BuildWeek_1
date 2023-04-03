package abbonamento;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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



    public static Abbonamento findAbbonamento(Integer id) {
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
    
    public static boolean validitaAbbonamento(Integer id_tessera,Integer id_abbonamento) {
    	
    	Query q = em.createQuery("SELECT a FROM Abbonamento a WHERE a.tessera.id = :id_tessera");
    	q.setParameter(":id_tessera", id_tessera);
    	List<Abbonamento> resList = q.getResultList();
    	List<Abbonamento> a = resList.stream().filter(e -> e.getId() == id_abbonamento).collect(Collectors.toList());
    	Abbonamento res = a.get(0);
    	
    	LocalDate adesso =  LocalDate.now();
    	if(adesso.isBefore(res.getData_fine_abbonamento())) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
