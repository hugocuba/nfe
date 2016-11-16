package br.com.nfe.dao;

import java.util.List;

import br.com.nfe.model.Pessoa;

public class PessoaDAO extends DAO<Pessoa>{

	@Override
	public List<Pessoa> findAll() {
		List<Pessoa> p;
		p = entityManager.createQuery("SELECT e FROM Pessoa e").getResultList();
		return p;		
	}

	@Override
	public Pessoa getById(Integer id) {
		Pessoa p;
		p = entityManager.find(Pessoa.class, id);
		return p;
	}

	@Override
	public boolean removeById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
