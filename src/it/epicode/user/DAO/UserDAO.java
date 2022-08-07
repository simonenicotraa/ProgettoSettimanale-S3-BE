package it.epicode.user.DAO;

import javax.persistence.EntityManager;

import it.epicode.user.User;
import it.epicode.utils.JpaUtil;

public class UserDAO {
	public void save(User user) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public User getById(Integer numCard) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		User user = em.find(User.class, numCard);
		em.close();
		return user;
	}

	public void delete(Integer numCard) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.remove(getById(numCard));
		em.getTransaction().commit();
		em.close();
	}

	public void refresh(User user) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.close();
	}
	
	}

