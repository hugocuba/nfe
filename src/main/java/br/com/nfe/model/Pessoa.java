package br.com.nfe.model;

import java.util.ArrayList;

public class Pessoa {
	
	private Integer idPessoa;
	private String nome;
	private ArrayList<Telefone> telefones = new ArrayList<Telefone>();
	private ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	private Municipio municipio;
	private String email;
}