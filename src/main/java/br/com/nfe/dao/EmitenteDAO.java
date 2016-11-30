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
        List<Emitente> c;
        Query q = entityManager.createQuery("SELECT e FROM Emitente e INNER JOIN e.pessoa p WHERE p.nome LIKE :name");
        q.setParameter("name", "%" + nome + "%");
        c = q.getResultList();
        return c;

    }

    public List<Emitente> findByDoc(String doc) {
        System.out.println("Procurando por doc");
        List<Emitente> c;
        Query f = entityManager.createQuery("SELECT e FROM Emitente e INNER JOIN e.pessoa p INNER JOIN Fisica f ON p.idPessoa = f.idPessoa WHERE f.cpf LIKE :cpf");
        Query j = entityManager.createQuery("SELECT e FROM Emitente e INNER JOIN e.pessoa p INNER JOIN Juridica j ON p.idPessoa = j.idPessoa WHERE j.cnpj LIKE :cnpj");
        f.setParameter("cpf", "%" + doc + "%");
        j.setParameter("cnpj", "%" + doc + "%");
        c = f.getResultList();
        c.addAll(j.getResultList());
        return c;
    }
    
}
