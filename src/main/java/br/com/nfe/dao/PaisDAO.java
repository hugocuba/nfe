package br.com.nfe.dao;

import java.util.List;

import br.com.nfe.model.Pais;
import javax.persistence.Query;

public class PaisDAO extends DAO<Pais> {

    @Override
    public List<Pais> findAll() {
        List<Pais> p;
        p = entityManager.createQuery("SELECT e FROM Pais e").getResultList();
        return p;
    }

    @Override
    public Pais getById(Integer id) {
        Pais p;
        Query q = entityManager.createQuery("SELECT e FROM Pais e WHERE e.idPais = :id");
        q.setParameter("id", id);
        p = (Pais) q.getSingleResult();
        return p;
    }

    @Override
    public boolean removeById(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

}
