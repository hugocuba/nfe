/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author hugo
 */

@Entity
public class Icms {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIcms;
        
        @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProduto", nullable = false)
	private Produto produto;
        
        @OneToOne(cascade = CascadeType.ALL, targetEntity = Pessoa.class)
	@JoinColumn(name = "idSituacaoTributaria", nullable = false)
	private SituacaoTributaria situacaoTributaria;
        
        @OneToOne(cascade = CascadeType.ALL, targetEntity = Pessoa.class)
	@JoinColumn(name = "idOrigem", nullable = false)
	private Origem origem;

	public Integer getIdIcms() {
		return idIcms;
	}

	public void setIdIcms(Integer idIcms) {
		this.idIcms = idIcms;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public SituacaoTributaria getSituacaoTributaria() {
		return situacaoTributaria;
	}

	public void setSituacaoTributaria(SituacaoTributaria situacaoTributaria) {
		this.situacaoTributaria = situacaoTributaria;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}
        
        

}
