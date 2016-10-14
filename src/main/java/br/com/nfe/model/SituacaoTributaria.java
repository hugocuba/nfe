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
public class SituacaoTributaria {
	private Integer idSituacaoTributaria;
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

}
