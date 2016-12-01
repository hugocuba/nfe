/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author a1502778
 */
@Entity
public class RegimeTributario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegime;

    private String nome;

    @OneToMany(targetEntity = SituacaoTributaria.class, mappedBy = "regimeTributario", cascade = CascadeType.ALL)
    private List<SituacaoTributaria> situacaoTributaria;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public Integer getIdRegime() {
        return idRegime;
    }

    public void setIdRegime(Integer idRegime) {
        this.idRegime = idRegime;
    }

    public List<SituacaoTributaria> getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public void setSituacaoTributaria(List<SituacaoTributaria> situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }
    
    

}
