package it.epicode.user.DAO.services;

import it.epicode.user.User;
import it.epicode.user.DAO.UserDAO;

public class UserServices {
	public UserDAO dao = new UserDAO();

	public void save(User user) {
		dao.save(user);
	}

	public User getById(Integer numCard) {
		return dao.getById(numCard);
	}

	public void delete(Integer numCard) {
		dao.delete(numCard);
	}

	public void refresh(User user) {
		dao.refresh(user);
	}

}
