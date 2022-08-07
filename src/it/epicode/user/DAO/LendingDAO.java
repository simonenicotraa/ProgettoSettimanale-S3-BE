package it.epicode.user.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.epicode.user.Lending;
import it.epicode.utils.JpaUtil;

public class LendingDAO {
	public void save(Lending lending) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(lending);
		em.getTransaction().commit();
		em.close();
	}

	public Lending getById(int id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Lending lending = em.find(Lending.class, id);
		em.close();
		return lending;
	}

	public void delete(int id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.remove(getById(id));
		em.getTransaction().commit();
		em.close();
	}

	public void refresh(Lending lending) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(lending);
		em.getTransaction().commit();
		em.close();
	}

	//Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
	public List<Lending> getListByNumCard(Integer numCard ) {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("SELECT_ELEMENT_LENDING");
        query.setParameter("numCard", numCard);
        List<Lending> list = query.getResultList();
//        System.out.println(list);
        for (Lending lending : list) {
        	System.out.println(lending);
		}	//se non metto begin e commit non funziona
        em.getTransaction().commit();
        em.close();
        return list;
    }
	//Ricerca di tutti i prestiti scaduti e non ancora restituiti
	public List<Lending> getListElementExpired(){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("SELECT_LEND_EXPIRED");
		List<Lending> list = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}
}
