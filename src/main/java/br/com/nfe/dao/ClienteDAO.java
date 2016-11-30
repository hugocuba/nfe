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
        List<Cliente> c;
        Query q = entityManager.createQuery("SELECT e FROM Cliente e, Fisica f, Juridica j INNER JOIN e.pessoa p WHERE (p.idPessoa LIKE f.idPessoa AND f.cpf LIKE :doc) OR (p.idPessoa LIKE j.idPessoa AND j.cnpj LIKE :doc)");
        q.setParameter("doc", "%" + doc + "%");
        c = q.getResultList();
        return c;

    }
    @Override
    public boolean removeById(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

}
