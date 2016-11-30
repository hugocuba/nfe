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
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author a1502778
 */

@Entity
@Table
public class Emitente {

        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmitente;
        
        @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPessoa", nullable = false)
	private Pessoa pessoa;
        
	private String inscricaoEstadualSubstTributario;
	private String cnaeFiscal;
	private String inscricaoMunicipal;
	//private RegimeTributario regimeTributario;
        
        @Lob
	private byte[] logotipo;

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

	/*public RegimeTributario getRegimeTributario() {
		return regimeTributario;
	}

	public void setRegimeTributario(RegimeTributario regimeTributario) {
		this.regimeTributario = regimeTributario;
	}*/

	public byte[] getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(byte[] logotipo) {
		this.logotipo = logotipo;
	}

}
