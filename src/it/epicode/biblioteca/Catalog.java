package it.epicode.biblioteca;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "SELECT_FOR_YEAR",query="SELECT a FROM Catalog a WHERE a.yearPublication=:yearPublication")
@NamedQuery(name= "SELECT_FOR_TITLE", query = "SELECT a FROM Catalog a WHERE a.title LIKE :title")
public abstract class Catalog {
	@Id
	private String codISBN;
	private String title;
	private int yearPublication;
	private int pages;

	public String getCodISBN() {
		return codISBN;
	}

	public String getTitle() {
		return title;
	}

	public int getYearPublication() {
		return yearPublication;
	}

	public int getPages() {
		return pages;
	}

	public void setCodISBN(String codISBN) {
		this.codISBN = codISBN;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYearPublication(int yearPublication) {
		this.yearPublication = yearPublication;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Catalog(String codISBN, String title, int yearPublication, int pages) {
		super();
		this.codISBN = codISBN;
		this.title = title;
		this.yearPublication = yearPublication;
		this.pages = pages;
	}

	public Catalog() {
		
	}

	@Override
	public String toString() {
		return String.format("Archive [codISBN=%s, title=%s, yearPublication=%s, pages=%s]", codISBN, title,
				yearPublication, pages);
	}

}
