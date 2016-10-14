package br.com.nfe.model;

import java.awt.Image;
import java.util.ArrayList;

public class Pessoa {
	
	private Integer idPessoa;
	private String nome;
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	private Municipio municipio;
	private String email;
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}
	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
        
}