package it.epicode.biblioteca;

import java.time.LocalDate;

import it.epicode.biblioteca.services.ArchiveServices;

import it.epicode.user.Lending;
import it.epicode.user.User;

import it.epicode.user.DAO.services.LendingServices;
import it.epicode.user.DAO.services.UserServices;

public class Program {
	public static void main(String[] args) {
		UserServices us = new UserServices();
		ArchiveServices arc = new ArchiveServices();
		LendingServices le = new LendingServices();

		Magazine ma = new Magazine("01001", "Automobili100", 2000, 10, Periodicity.SETTIMANALE);
		Magazine ma1 = new Magazine("01002", "PCxTutto", 1900, 20, Periodicity.MENSILE);
		Magazine ma2 = new Magazine("01004", "Il gioco degli esperti", 2022, 70, Periodicity.SEMESTRALE);
		Magazine ma3 = new Magazine("01006", "Aranzulla", 2002, 18, Periodicity.SETTIMANALE);

		Book b1 = new Book("01008", "Aiutate il soldato Ryan", 1505, 300, "Gino Merendina", "Comico");
		Book b2 = new Book("01010", "Io sono io", 2022, 490, "Gino Merendina", "Thriller");
		Book b3 = new Book("01005", "Palo all'ultimo", 1490, 150, "Mario Credente", "Biografia");
		Book b4 = new Book("01040", "Sollevato dal re", 300, 200, "Ottaviano Mitico", "Storico");

		User user = new User(2201, "Salvatore", "Ereditato", "25-04-1991");
		User user1 = new User(2271, "Flavio", "Barca", "5-08-2000");
		User user2 = new User(1000, "Concetto", "Bullo", "17-6-1980");
		User user3 = new User(1200, "Marco", "Verde", "30-3-2006");
		User user4 = new User(1122, "Antonio", "Salta", "22-12-1990");

		Lending len1 = new Lending(user2, ma3, LocalDate.of(2022, 8, 2), null);
		Lending len2 = new Lending(user1, ma1, LocalDate.of(2022, 7, 2), null);
		Lending len3 = new Lending(user4, b3, LocalDate.of(2022, 7, 20), LocalDate.of(2022, 8, 1));
		Lending len4 = new Lending(user3, b4, LocalDate.of(2022, 5, 14), LocalDate.of(2022, 6, 1));
		Lending len5 = new Lending(user3, b1, LocalDate.of(2022, 8, 1), null);
		arc.save(ma);
		arc.save(ma1);
		arc.save(ma2);
		arc.save(ma3);

		arc.save(b1);
		arc.save(b2);
		arc.save(b3);
		arc.save(b4);

		us.save(user);
		us.save(user1);
		us.save(user2);
		us.save(user3);
		us.save(user4);

		le.save(len1);
		le.save(len2);
		le.save(len3);
		le.save(len4);
		le.save(len5);

		System.out.println("##################################################");
		arc.getById("01004");
		System.out.println("##################################################");
		arc.searchForYear(2022);
		System.out.println("##################################################");
		arc.searchForTitle("Aiutate il soldato Ryan");
		System.out.println("##################################################");
		arc.searchForPartOfTitle("io");
		System.out.println("##################################################");
		arc.searchForAutor("Gino Merendina");
		System.out.println("##################################################");
		le.getListByNumCard(1200);
		System.out.println(le.getListElementExpired());

	}
}
