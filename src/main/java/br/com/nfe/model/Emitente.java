/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

import java.awt.Image;

/**
 *
 * @author a1502778
 */
public class Emitente {

	private Integer idEmitente;
	private Pessoa pessoa;
	private String inscricaoEstadualSubstTributario;
	private String cnaeFiscal;
	private String inscricaoMunicipal;
	private RegimeTributario regimeTributario;
	private Image logotipo;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getInscricaoEstadualSubstTributario() {
		return inscricaoEstadualSubstTributario;
	}

	public void setInscricaoEstadualSubstTributario(String inscricaoEstadualSubstTributario) {
		this.inscricaoEstadualSubstTributario = inscricaoEstadualSubstTributario;
	}

	public String getCnaeFiscal() {
		return cnaeFiscal;
	}

	public void setCnaeFiscal(String cnaeFiscal) {
		this.cnaeFiscal = cnaeFiscal;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public RegimeTributario getRegimeTributario() {
		return regimeTributario;
	}

	public void setRegimeTributario(RegimeTributario regimeTributario) {
		this.regimeTributario = regimeTributario;
	}

	public Image getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(Image logotipo) {
		this.logotipo = logotipo;
	}

}
