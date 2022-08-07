package it.epicode.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.OneToMany;


@Entity

public class User {
	@Id
	private Integer numCard;
	private String name;
	private String surname;
	private String dateOfBirth;
	
	@OneToMany(fetch = FetchType.EAGER ,mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Lending> listLend = new ArrayList<>();

	public Integer getNumCard() {
		return numCard;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public List<Lending> getListLend() {
		return listLend;
	}

	public void setListLend(List<Lending> listLend) {
		this.listLend = listLend;
	}

	public void setNumCard(Integer numCard) {
		this.numCard = numCard;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	

	public User(Integer numCard, String name, String surname, String dateOfBirth) {
		super();
		this.numCard = numCard;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return String.format("User [numCard=%s, name=%s, surname=%s, dateOfBirth=%s]", numCard, name,
				surname, dateOfBirth);
	}

	

	

}
