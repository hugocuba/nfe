package br.com.nfe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPessoa;

	@Column
	private String nome;

	@OneToMany(targetEntity = Telefone.class, mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<Telefone>();

	@OneToMany(targetEntity = Endereco.class, mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	@Column
	private String email;
        
        private boolean isencaoIcms;
        
        private String suframa;
        
        private String inscricaoEstadual;

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }
        
        

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public void addEndereco(Endereco endereco){
		enderecos.add(endereco);
	}
	
	public void addTelefone(Telefone telefone){
		telefones.add(telefone);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        
        
	public boolean isIsencaoIcms() {
		return isencaoIcms;
	}
	public void setIsencaoIcms(boolean isencaoIcms) {
		this.isencaoIcms = isencaoIcms;
	}
        
        public String getSuframa() {
		return suframa;
	}

	public void setSuframa(String suframa) {
		this.suframa = suframa;
	}
        
        public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
}