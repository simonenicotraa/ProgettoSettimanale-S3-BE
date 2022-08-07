package it.epicode.biblioteca.services;

import java.util.List;

import it.epicode.biblioteca.Catalog;
import it.epicode.biblioteca.Book;
import it.epicode.biblioteca.DAO.CatalogDAO;

public class CatalogService {
	public CatalogDAO dao = new CatalogDAO();

	public void save(Catalog a) {
		dao.save(a);
	}

	public Catalog getById(String isbn) {
		return dao.getById(isbn);
	}

	public void delete(String isbn) {
		dao.delete(isbn);
	}

	public void refresh(Catalog a) {
		dao.refresh(a);
	}

	public List<Catalog> searchForYear(int i) {
		return dao.getByYear(i);
	}

	public List<Catalog> searchForTitle(String str) {
		return dao.getByTitle(str);
	}

	public List<Catalog> searchForPartOfTitle(String str) {
		return dao.getByPartTitle(str);
	}

	public List<Book> searchForAutor(String aut) {
		return dao.getForAuthor(aut);
	}
}
