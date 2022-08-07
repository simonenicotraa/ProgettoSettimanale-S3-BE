package it.epicode.biblioteca.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.epicode.biblioteca.Catalog;
import it.epicode.biblioteca.Book;
import it.epicode.utils.JpaUtil;

public class CatalogDAO {

	public void save(Catalog a) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
		em.close();
	}

	public Catalog getById(String isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Catalog archive = em.find(Catalog.class, isbn);
		return archive;
	}

	public void delete(String isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.remove(getById(isbn));
		em.getTransaction().commit();
		em.close();
	}

	public void refresh(Catalog a) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();
		em.close();
	}

	public List<Catalog> getByYear(int i) {

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		// inizializzo namedQuery
		Query querySelect = em.createNamedQuery("SELECT_FOR_YEAR");
		// imposta parametro
		querySelect.setParameter("yearPublication", i);
		List<Catalog> listForYear = new ArrayList<>();
		listForYear = querySelect.getResultList();
		em.close();
		return listForYear;
	}

	public List<Catalog> getByTitle(String str) {

		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		// inizializzo namedQuery
		Query querySelect = em.createNamedQuery("SELECT_FOR_TITLE");
		// imposta parametro
		querySelect.setParameter("title", str);
		List<Catalog> listForTitle = new ArrayList<>();
		listForTitle = querySelect.getResultList();
		em.close();
		return listForTitle;
	}
	public List<Catalog> getByPartTitle(String str) {
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		// inizializzo namedQuery
		Query querySelect = em.createNamedQuery("SELECT_FOR_TITLE");
		String string = "%" + str + "%";
		// imposta parametro
		querySelect.setParameter("title", string);
		List<Catalog> listForTitle = new ArrayList<>();
		listForTitle = querySelect.getResultList();
		em.close();
		return listForTitle;
	}
	public List<Book> getForAuthor(String aut){
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		// inizializzo namedQuery
		Query querySelect = em.createNamedQuery("SELECT_FOR_AUTHOR");
		// imposta parametro
		querySelect.setParameter("author", aut);
		List<Book> listForaut = new ArrayList<>();
		listForaut = querySelect.getResultList();
		em.close();
		return listForaut;
	}
	}

