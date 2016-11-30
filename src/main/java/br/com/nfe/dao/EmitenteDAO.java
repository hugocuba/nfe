/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.dao;

import br.com.nfe.model.Emitente;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author hugo
 */
public class EmitenteDAO extends DAO<Emitente>{

    @Override
    public List<Emitente> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Emitente getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Emitente> findByNome(String nome) {
        List<Emitente> e;
        Query q = entityManager.createQuery("SELECT e FROM Cliente e INNER JOIN e.pessoa p WHERE p.nome LIKE :name");
        q.setParameter("name", "%" + nome + "%");
        e = q.getResultList();
        return e;

    }

    public List<Emitente> findByDoc(String doc) {
        List<Emitente> e;
        Query q = entityManager.createQuery("SELECT e FROM Cliente e, Fisica f, Juridica j INNER JOIN e.pessoa p WHERE (p.idPessoa LIKE f.idPessoa AND f.cpf LIKE :doc) OR (p.idPessoa LIKE j.idPessoa AND j.cnpj LIKE :doc)");
        q.setParameter("doc", "%" + doc + "%");
        e = q.getResultList();
        return e;

    }
    
}
