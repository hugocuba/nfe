/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.dao;

import br.com.nfe.model.Estado;
import java.util.List;

/**
 *
 * @author a1502794
 */
public class EstadoDAO extends DAO<Estado>{

    @Override
    public List<Estado> findAll() {
        List<Estado> e;
        e = entityManager.createQuery("SELECT e FROM Estado e").getResultList();
        return e;
    }

    @Override
    public Estado getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
