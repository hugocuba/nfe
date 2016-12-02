package br.com.nfe.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

    @OneToMany(targetEntity = ProdutosNota.class, mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Produto> produtos = new ArrayList<>();
    
    private String serie;
    
    private String numero;
    
    private Boolean tipoDocumento;
    
    

    private boolean consumidorFinal;

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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean isConsumidorFinal() {
        return consumidorFinal;
    }

    public void setConsumidorFinal(boolean consumidorFinal) {
        this.consumidorFinal = consumidorFinal;
    }

}
