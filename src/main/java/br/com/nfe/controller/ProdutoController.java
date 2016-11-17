/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.controller;

import java.util.ArrayList;
import br.com.nfe.model.Produto;
import br.com.nfe.dao.ProdutoDAO;

/**
 *
 * @author a1502816
 */
public class ProdutoController {

    public void Incluir(Produto p) {
        
        ProdutoDAO pd = new ProdutoDAO();
        pd.persist(p);
    }

    public Produto exportar(int codigo){
        ProdutoDAO pd = new ProdutoDAO();
        return pd.getById(codigo);
    }
    
    public void excluir(int codigo){
        ProdutoDAO pd = new ProdutoDAO();
        pd.removeById(codigo);
    }
}
