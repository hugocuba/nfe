/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author hugo
 */
@Entity
public class Origem {
    
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrigem;
        
	private String origem;

	public Integer getIdOrigem() {
		return idOrigem;
	}

	public void setIdOrigem(Integer idOrigem) {
		this.idOrigem = idOrigem;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

    @Override
    public String toString() {
        return origem;
    }
}
