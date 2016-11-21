package br.com.nfe.dao;

import java.util.List;

import br.com.nfe.model.Cliente;

public class ClienteDAO extends DAO<Cliente>{

	@Override
	public List<Cliente> findAll() {
		List<Cliente> c;
		c = entityManager.createQuery("SELECT e FROM Cliente e").getResultList();
		return c;
	}

	@Override
	public Cliente getById(Integer id) {
		Cliente c;
		c = entityManager.find(Cliente.class, id);
		return c;
	}

	@Override
	public boolean removeById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
