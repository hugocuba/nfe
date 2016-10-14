/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

/**
 *
 * @author hugo
 */
public class Icms {

	private Integer idIcms;
	private Produto produto;
	private SituacaoTributaria situacaoTributaria;
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
