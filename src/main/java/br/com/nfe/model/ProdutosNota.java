/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Ivo
 */
@Entity
public class ProdutosNota implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProdutosNota;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idNota", nullable = false)
    private Nota nota;
    
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Produto.class)
    @JoinColumn(name = "idProduto", nullable = false)
    private Produto produto;
    
    private Integer quantidade;
    
    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getIdProdutosNota() {
        return idProdutosNota;
    }

    public void setIdProdutosNota(Integer idProdutosNota) {
        this.idProdutosNota = idProdutosNota;
    }
}
