package br.com.nfe.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Juridica extends Pessoa {
	
	private String cnpj;

	private String inscricaoEstadual;

	private boolean isencaoIcms;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public boolean isIsencaoIcms() {
		return isencaoIcms;
	}
	public void setIsencaoIcms(boolean isencaoIcms) {
		this.isencaoIcms = isencaoIcms;
	}
	
}
