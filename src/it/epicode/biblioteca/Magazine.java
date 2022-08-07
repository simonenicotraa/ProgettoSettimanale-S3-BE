package it.epicode.biblioteca;

import javax.persistence.Entity;

@Entity
public class Magazine extends Catalog {
	private Periodicity periodicity;

	public Magazine(String codISBN, String title, int yearPublication, int pages, Periodicity periodicity) {
		super(codISBN, title, yearPublication, pages);
		this.periodicity = periodicity;
	}

	public Magazine() {
		
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return String.format("Magazine [periodicity=%s, toString()=%s]", periodicity, super.toString());
	}

}
