/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 *
 * @author hugo
 */
public class Produto {
	private String idProduto;
	private String descricao;
	private String codigo;
	private String ean;
	private String eanTributavel;
	private Character genero;
	private String cest;
	private Currency valor;
	private String cnpjProdutor;
	private List<Icms> icms = new ArrayList<Icms>();

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Icms> getIcms() {
		return icms;
	}

	public void setIcms(ArrayList<Icms> icms) {
		this.icms = icms;
	}

}
