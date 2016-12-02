/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.dao;

import br.com.nfe.model.RegimeTributario;
import java.util.List;

/**
 *
 * @author hugo
 */
public class RegimeTributarioDAO extends DAO<RegimeTributario>{

    @Override
    public List<RegimeTributario> findAll() {
            List<RegimeTributario> p;
            p = entityManager.createQuery("SELECT e FROM RegimeTributario e").getResultList();
            return p;
    }
    
    public List<RegimeTributario> findComSituacao(){
        List<RegimeTributario> r;
        r = entityManager.createQuery("SELECT e FROM RegimeTributario e INNER JOIN e.situacaoTributaria").getResultList();
        return r;
    }

    @Override
    public RegimeTributario getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
