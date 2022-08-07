package it.epicode.biblioteca;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "SELECT_FOR_AUTHOR", query = "SELECT b FROM Book b WHERE b.author like :author")
public class Book extends Catalog {
	private String author;
	private String genreString;

	public String getAuthor() {
		return author;
	}

	public String getGenreString() {
		return genreString;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setGenreString(String genreString) {
		this.genreString = genreString;
	}

	@Override
	public String toString() {
		return String.format("Book [author=%s, genreString=%s, toString()=%s]", author, genreString, super.toString());
	}

	public Book(String codISBN, String title, int yearPublication, int pages, String author, String genreString) {
		super(codISBN, title, yearPublication, pages);
		this.author = author;
		this.genreString = genreString;
	}

	public Book() {
		
	}

}
