package it.epicode.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


import it.epicode.biblioteca.Catalog;
@Entity
//Ricerca di tutti i prestiti scaduti e non ancora restituiti
@NamedQuery(name= "SELECT_LEND_EXPIRED", query = "SELECT p FROM Lending p WHERE p.dateReturn is null AND p.dateExpectedReturn = true")
//Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
@NamedQuery(name = "SELECT_ELEMENT_LENDING", query = "SELECT ul FROM Lending ul WHERE ul.user.numCard =:numCard AND ul.dateReturn is null")

public class Lending {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	@OneToOne(fetch = FetchType.EAGER)
	private Catalog elemArchive;
	private LocalDate dateStartLending;				
	private boolean dateExpectedReturn;	
	private LocalDate dateReturn;			
							
	public User getUser() {
		return user;
	}

	public Catalog getElemArchive() {
		return elemArchive;
	}

	public LocalDate getDateStartLending() {
		return dateStartLending;
	}

	public Boolean getDateExpectedReturn() {
		return dateExpectedReturn;
	}

	public LocalDate getDateReturn() {
		return dateReturn;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setElemArchive(Catalog elemArchive) {
		this.elemArchive = elemArchive;
	}

	public void setDateStartLending(LocalDate dateStartLending) {
		this.dateStartLending = dateStartLending;
	}

	public void setDateExpectedReturn(Boolean dateExpectedReturn) {
		this.dateExpectedReturn = dateExpectedReturn;
	}

	public void setDateReturn(LocalDate dateReturn) {
		this.dateReturn = dateReturn;
	}

	public Lending(User user, Catalog elemArchive, LocalDate dateStartLending,
			LocalDate dateReturn) {
		super();
		this.user = user;
		this.elemArchive = elemArchive;
		this.dateStartLending = dateStartLending;
		this.dateExpectedReturn = dateStartLending.plusDays(30).isBefore(LocalDate.now());
		this.dateReturn = dateReturn;
	}

	public Lending() {
		super();
	}

	@Override
	public String toString() {
		return "Lending [id=" + id + ", user=" + user + ", elemArchive=" + elemArchive + ", dateStartLending="
				+ dateStartLending + ", dateExpectedReturn=" + dateExpectedReturn + ", dateReturn=" + dateReturn + "]";
	}

	

}
