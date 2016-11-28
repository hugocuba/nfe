package br.com.nfe.dao;

import java.util.List;

import br.com.nfe.model.Cliente;
import javax.persistence.Query;

public class ClienteDAO extends DAO<Cliente> {

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

    public List<Cliente> findByNome(String nome) {
        List<Cliente> c;
        Query q = entityManager.createQuery("SELECT e FROM Cliente e INNER JOIN e.pessoa p WHERE p.nome LIKE :name");
        q.setParameter("name", "%" + nome + "%");
        c = q.getResultList();
        return c;

    }

    public List<Cliente> findByCPF(String cpf) {
        List<Cliente> c;
        c = entityManager.createQuery("SELECT e FROM Cliente e").getResultList();
        return c;

    }

    public List<Cliente> findByCNPJ(String cnpj) {
        List<Cliente> c;
        c = entityManager.createQuery("SELECT e FROM Cliente e").getResultList();
        return c;
    }

    @Override
    public boolean removeById(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

}
