/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.dao;

import static br.com.nfe.dao.DAO.entityManager;
import br.com.nfe.model.Origem;
import br.com.nfe.model.RegimeTributario;
import java.util.List;

/**
 *
 * @author hugo
 */
public class OrigemDAO extends DAO<Origem>{

    @Override
    public List<Origem> findAll() {
            List<Origem> p;
            p = entityManager.createQuery("SELECT e FROM Origem e").getResultList();
            return p;
    }

    @Override
    public Origem getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
