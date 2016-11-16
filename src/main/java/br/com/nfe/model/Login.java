/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author a1502794
 */
@Entity
@Table
public class Login {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLogin;

    @Column
    private String usuario;

    @Column
    private String senha;

    //@Temporal(TemporalType.DATE)
    //private Date ultimoAcesso;

    public Login(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Login(){
    	
    }

    public Integer getId() {
        return idLogin;
    }

    public void setId(Integer id) {
        this.idLogin = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   
    
}
