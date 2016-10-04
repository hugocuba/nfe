package br.com.nfe.model;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Estado {

        @Id
        @GeneratedValue
	private Integer idEstado;
        
        @Column
	private String nome;
        
        @OneToMany(
                targetEntity = Municipio.class,
                mappedBy = "estado",
                cascade = CascadeType.ALL)
	private ArrayList<Municipio> municipios = new ArrayList<Municipio>();
        
        @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idPais", nullable = false)
	private Pais pais;

        public Estado(String nome, Pais pais) {
            this.nome = nome;
            this.pais = pais;
        }

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Municipio> getMunicipios() {
		return municipios;
	}
	
	public void setPais(Pais pais){
		this.pais = pais;
		this.pais.addEstado(this);
	}
	
	public void addMunicipio(Municipio municipio){
		this.municipios.add(municipio);
	}

}
