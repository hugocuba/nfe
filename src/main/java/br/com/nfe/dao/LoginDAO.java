/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.dao;

import br.com.nfe.model.Login;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author a1502794
 */
public class LoginDAO extends DAO<Login> {

    @Override
    public List<Login> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Login verifica(String usuario) {
        Login login;
        try {
             login = (Login) entityManager
                    .createQuery(
                            "SELECT u from Login u where u.usuario = :usuario")
                    .setParameter("usuario", usuario)
                    .getSingleResult();
        } catch (NoResultException e) {
            login = null;
        }
        return login;
    }
}
