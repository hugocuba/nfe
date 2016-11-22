/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hugo
 */

@Entity
@Table
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;
    
    private ArrayList<String> icms = new ArrayList<String>();
    private String descricao, EAN, EAN_unid, EXTIPE, genero, NMC, CEST, unid_com, valor_unid_com, unid_trib, qtd_trib, valor_unit_trib, classe_en, CEL, CNPJ_produtor;
    private int codigo;
    
    public ArrayList<String> getIcms() {
        return icms;
    }

    public void setIcms(ArrayList<String> icms) {
        this.icms = icms;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEAN() {
        return EAN;
    }

    public void setEAN(String EAN) {
        this.EAN = EAN;
    }

    public String getEAN_unid() {
        return EAN_unid;
    }

    public void setEAN_unid(String EAN_unid) {
        this.EAN_unid = EAN_unid;
    }

    public String getEXTIPE() {
        return EXTIPE;
    }

    public void setEXTIPE(String EXTIPE) {
        this.EXTIPE = EXTIPE;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNMC() {
        return NMC;
    }

    public void setNMC(String NMC) {
        this.NMC = NMC;
    }

    public String getCEST() {
        return CEST;
    }

    public void setCEST(String CEST) {
        this.CEST = CEST;
    }

    public String getUnid_com() {
        return unid_com;
    }

    public void setUnid_com(String unid_com) {
        this.unid_com = unid_com;
    }

    public String getValor_unid_com() {
        return valor_unid_com;
    }

    public void setValor_unid_com(String valor_unid_com) {
        this.valor_unid_com = valor_unid_com;
    }

    public String getUnid_trib() {
        return unid_trib;
    }

    public void setUnid_trib(String unid_trib) {
        this.unid_trib = unid_trib;
    }

    public String getQtd_trib() {
        return qtd_trib;
    }

    public void setQtd_trib(String qtd_trib) {
        this.qtd_trib = qtd_trib;
    }

    public String getValor_unit_trib() {
        return valor_unit_trib;
    }

    public void setValor_unit_trib(String valor_unit_trib) {
        this.valor_unit_trib = valor_unit_trib;
    }

    public String getClasse_en() {
        return classe_en;
    }

    public void setClasse_en(String classe_en) {
        this.classe_en = classe_en;
    }

    public String getCEL() {
        return CEL;
    }

    public void setCEL(String CEL) {
        this.CEL = CEL;
    }

    public String getCNPJ_produtor() {
        return CNPJ_produtor;
    }

    public void setCNPJ_produtor(String CNPJ_produtor) {
        this.CNPJ_produtor = CNPJ_produtor;
    }

}