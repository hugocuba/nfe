package br.com.nfe.dao;

import java.util.List;

import br.com.nfe.model.Cliente;
import java.sql.ResultSet;
import java.util.Collection;
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

    public List<Cliente> findByDoc(String doc) {
        System.out.println("Procurando por doc");
        List<Cliente> c;
        Query f = entityManager.createQuery("SELECT e FROM Cliente e INNER JOIN e.pessoa p INNER JOIN Fisica f ON p.idPessoa = f.idPessoa WHERE f.cpf LIKE :cpf");
        Query j = entityManager.createQuery("SELECT e FROM Cliente e INNER JOIN e.pessoa p INNER JOIN Juridica j ON p.idPessoa = j.idPessoa WHERE j.cnpj LIKE :cnpj");
        f.setParameter("cpf", "%" + doc + "%");
        j.setParameter("cnpj", "%" + doc + "%");
        c = f.getResultList();
        c.addAll(j.getResultList());
        return c;
    }
    @Override
    public boolean removeById(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

}
