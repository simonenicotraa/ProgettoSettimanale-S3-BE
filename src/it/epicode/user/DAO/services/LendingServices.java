package it.epicode.user.DAO.services;


import java.util.List;


import it.epicode.user.Lending;
import it.epicode.user.DAO.LendingDAO;


public class LendingServices {
	public LendingDAO dao = new LendingDAO();

	public void save(Lending lending) {
		dao.save(lending);
	}

	public Lending getById(int id) {
		return dao.getById(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public void refresh(Lending lending) {
		dao.refresh(lending);
	}
	public List<Lending> getListLandByCard(Integer i ) {
        return getListLandByCard(i);
    }
	public List<Lending> getListElementExpired(){
		return dao.getListElementExpired();
	}
	public List<Lending> getListByNumCard(Integer numCard ){
		return dao.getListByNumCard(numCard);
	}
}
