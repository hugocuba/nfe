/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Ivo
 */
@Entity
public class NotaLancada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotaLancada;
    
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Nota.class)
    @JoinColumn(name = "idNota", nullable = false)
    private Nota nota;
    
    private Long dataLancamento;
    
    public NotaLancada(){
        
    }
}
