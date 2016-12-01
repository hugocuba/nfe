/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author hugo
 */
@Entity
public class SituacaoTributaria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSituacaoTributaria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRegimeTributario", nullable = false)
    private RegimeTributario regimeTributario;

    private String situacaoTributaria;

    public RegimeTributario getRegimeTributario() {
        return regimeTributario;
    }

    public void setRegimeTributario(RegimeTributario regimeTributario) {
        this.regimeTributario = regimeTributario;
    }

    public String getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public void setSituacaoTributaria(String situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public Integer getIdSituacaoTributaria() {
        return idSituacaoTributaria;
    }

    public void setIdSituacaoTributaria(Integer idSituacaoTributaria) {
        this.idSituacaoTributaria = idSituacaoTributaria;
    }

    @Override
    public String toString() {
        return situacaoTributaria;
    }

}
