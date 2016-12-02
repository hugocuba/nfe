package br.com.nfe.dao;

import static br.com.nfe.dao.DAO.entityManager;
import java.util.List;

import br.com.nfe.model.Produto;
import javax.persistence.Query;

public class ProdutoDAO extends DAO<Produto> {

    @Override
    public List<Produto> findAll() {
        List<Produto> p;
        p = entityManager.createQuery("SELECT e FROM Produto e").getResultList();
        return p;
    }

    @Override
    public Produto getById(Integer id) {
        Produto p;
        p = entityManager.find(Produto.class, id);
        return p;
    }

    public Produto getByCod(Integer codigo) {
        Produto p;
        p = entityManager.find(Produto.class, codigo);
        return p;
    }

    @Override
    public boolean removeById(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean removeByCod(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    public List<Produto> findByDescricao(String texto) {
        List<Produto> p;
        Query j = entityManager.createQuery("SELECT e FROM Produto e WHERE e.descricao LIKE :descricao");
        j.setParameter("descricao", "%" + texto + "%");
        p = j.getResultList();
        return p;
    }

    public List<Produto> findByCod(String texto) {
        List<Produto> p;
        Query j = entityManager.createQuery("SELECT e FROM Produto e WHERE e.codigo LIKE :codigo");
        j.setParameter("codigo", "%" + texto + "%");
        p = j.getResultList();
        return p;
    }

}
