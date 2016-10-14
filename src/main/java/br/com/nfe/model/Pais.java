package br.com.nfe.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Pais {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPais;

	@Column
	private String nome;

	@OneToMany(targetEntity = Estado.class, mappedBy = "pais", cascade = CascadeType.ALL)
	private List<Estado> estados = new ArrayList<Estado>();

	public Pais(String nome) {
		this.nome = nome;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void addEstado(Estado estado) {
		this.estados.add(estado);
	}
}
