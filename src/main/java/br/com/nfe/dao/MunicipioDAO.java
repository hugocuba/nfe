package br.com.nfe.dao;

import java.util.List;

import br.com.nfe.model.Municipio;

public class MunicipioDAO extends DAO<Municipio>{

	@Override
	public List<Municipio> findAll() {
            List<Municipio> m;
            m = entityManager.createQuery("SELECT e FROM Municipio e").getResultList();
            return m;
	}

	@Override
	public Municipio getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
