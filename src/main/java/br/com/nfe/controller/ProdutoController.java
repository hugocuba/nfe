/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.controller;

import br.com.nfe.model.Produto;
import br.com.nfe.dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author a1502816
 */
public class ProdutoController {

    Map<String , String> dados = new HashMap<>();
    List<String> icms;
    
    public Boolean Incluir(Map<String, String> dados, ArrayList icms) {
        
        Boolean inserido = false;
        
        Produto p = new Produto();
        ProdutoDAO pd = new ProdutoDAO();

        p.setDescricao(dados.get("Descrição"));
        p.setCodigo(dados.get("Codigo"));
        p.setEAN(dados.get("EAN"));
        p.setEXTIPE(dados.get("EXTIPE"));
        p.setUnid_com(dados.get("Unid_com"));
        p.setUnid_trib(dados.get("Unid_trib"));
        p.setEAN_unid(dados.get("EAN_unid"));
        p.setGenero(dados.get("Genero"));
        p.setValor_unid_com(dados.get("Valor_unid_com"));
        p.setQtd_trib(dados.get("Qtd_trib"));
        p.setValor_unit_trib(dados.get("Valor_unit_trib"));
        p.setNMC(dados.get("NMC"));
        p.setCEST(dados.get("CEST"));
        p.setClasse_en(dados.get("Classe_en"));
        p.setCEL(dados.get("CEL"));
        p.setCNPJ_produtor(dados.get("CNPJ_produtor"));
        p.setIcms(icms);

        if(pd.persist(p));
            inserido = true;
            
        return inserido;
    }

    public void exportar(String codigo) {
        Produto p = new Produto();
        ProdutoDAO pd = new ProdutoDAO();
        p = pd.getByCod(codigo);
       
        
        dados.put("Descrição",p.getDescricao());
        dados.put("Codigo",p.getCodigo());
        dados.put("EAN",p.getEAN());
        dados.put("EXTIPE",p.getEXTIPE());
        dados.put("Unid_com",p.getUnid_com());
        dados.put("Unid_trib",p.getUnid_trib());
        dados.put("EAN_unid",p.getEAN_unid());
        dados.put("Genero",p.getGenero());
        dados.put("Valor_unid_com",p.getValor_unid_com());
        dados.put("Qtd_trib",p.getQtd_trib());
        dados.put("Valor_unit_trib",p.getValor_unit_trib());
        dados.put("NMC",p.getNMC());
        dados.put("CEST",p.getCEST());
        dados.put("Classe_en",p.getClasse_en());
        dados.put("CEL",p.getCEL());
        dados.put("CNPJ_produtor",p.getCNPJ_produtor());
        
        icms = p.getIcms();
    }
    public Map<String,String> getDados(){
        return dados;
    }
    public List<String> getIcms(){
        return icms;
    }

    public void excluir(String codigo) {
        ProdutoDAO pd = new ProdutoDAO();
        pd.removeByCod(codigo);
    }
}
