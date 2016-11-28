package br.com.nfe.dao;

import java.util.List;

import br.com.nfe.model.Pais;

public class PaisDAO extends DAO<Pais>{

	@Override
	public List<Pais> findAll() {
            List<Pais> p;
            p = entityManager.createQuery("SELECT e FROM Pais e").getResultList();
            return p;
	}

	@Override
	public Pais getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
