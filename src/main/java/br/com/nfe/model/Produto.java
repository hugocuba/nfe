/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

import java.util.ArrayList;

/**
 *
 * @author hugo
 */
public class Produto {
    private String idProduto;
    private String descricao;
    private ArrayList<Icms> icms = new ArrayList<>();
}
