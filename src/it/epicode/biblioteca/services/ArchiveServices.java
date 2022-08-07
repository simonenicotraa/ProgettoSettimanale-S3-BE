package it.epicode.biblioteca.services;

import java.util.List;

import it.epicode.biblioteca.Book;
import it.epicode.biblioteca.Catalog;
import it.epicode.biblioteca.DAO.CatalogDAO;
import it.epicode.user.Lending;
import it.epicode.user.DAO.LendingDAO;
import it.epicode.user.DAO.UserDAO;

public class ArchiveServices {
	CatalogDAO daoCatalogDAO = new CatalogDAO();
	LendingDAO daoLendingDAO = new LendingDAO();
	UserDAO daoUserDAO = new UserDAO();
	
	public void save(Catalog a) {
		daoCatalogDAO.save(a);
	}

	public Catalog getById(String isbn) {
		return daoCatalogDAO.getById(isbn);
	}

	public void delete(String isbn) {
		daoCatalogDAO.delete(isbn);
	}
	public List<Catalog> searchForYear(int i) {
		return daoCatalogDAO.getByYear(i);
	}

	public List<Catalog> searchForTitle(String str) {
		return daoCatalogDAO.getByTitle(str);
	}

	public List<Catalog> searchForPartOfTitle(String str) {
		return daoCatalogDAO.getByPartTitle(str);
	}

	public List<Book> searchForAutor(String aut) {
		return daoCatalogDAO.getForAuthor(aut);
	}
	public List<Lending> getListElementExpired(){
		return daoLendingDAO.getListElementExpired();
	}
	public List<Lending> getListByNumCard(Integer numCard ){
		return daoLendingDAO.getListByNumCard(numCard);
	}
}
