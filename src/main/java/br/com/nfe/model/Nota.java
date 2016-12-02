package br.com.nfe.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNota;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Emitente.class)
    @JoinColumn(name = "idEmitente", nullable = false)
    private Emitente emitente;

    @OneToMany(targetEntity = ProdutosNota.class, mappedBy = "nota", cascade = CascadeType.ALL)
    private List<ProdutosNota> produtosNota = new ArrayList<>();
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPais", nullable = false)
    
    private Municipio municipio;
    
    private String serie;
    
    private String numero;

    private boolean consumidorFinal;
    
    private Long dataCadastro;

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public Emitente getEmitente() {
        return emitente;
    }

    public void setEmitente(Emitente emitente) {
        this.emitente = emitente;
    }

    public List<ProdutosNota> getProdutosNota() {
        return produtosNota;
    }

    public void setProdutosNota(List<ProdutosNota> produtosNota) {
        this.produtosNota = produtosNota;
    }

    public boolean isConsumidorFinal() {
        return consumidorFinal;
    }

    public void setConsumidorFinal(boolean consumidorFinal) {
        this.consumidorFinal = consumidorFinal;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Long dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    
}
