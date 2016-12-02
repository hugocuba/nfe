package br.com.nfe.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMunicipio;

	@Column
	private String nome;
        
        @OneToMany(targetEntity = Nota.class, mappedBy = "municipio", cascade = CascadeType.ALL)
        private List<Nota> nota = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEstado", nullable = false)
	private Estado estado;

    public Municipio(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public Municipio() {
    }
        
        

	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
		this.estado.addMunicipio(this);
	}

    @Override
    public String toString() {
        return this.nome;
    }

        
}
