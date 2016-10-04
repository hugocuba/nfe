package br.com.nfe.model;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Pais {

        @Id
	//@Column
	@GeneratedValue
	private Integer idPais;
        
        @Column
	private String nome;
        
        @OneToMany(
                targetEntity = Estado.class,
                mappedBy = "pais",
                cascade = CascadeType.ALL)
	private ArrayList<Estado> estados = new ArrayList<Estado>();

        public Pais(String nome) {
            this.nome = nome;
        }

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Estado> getEstados() {
		return estados;
	}
	
	public void addEstado(Estado estado){
		this.estados.add(estado);
	}
}
