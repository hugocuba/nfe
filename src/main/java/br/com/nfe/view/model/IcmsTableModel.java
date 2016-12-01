/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.view.model;

import br.com.nfe.model.Cliente;
import br.com.nfe.model.Fisica;
import br.com.nfe.model.Icms;
import br.com.nfe.model.Juridica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hugo
 */
public class IcmsTableModel extends AbstractTableModel{
        //constantes que vão representar as colunas
    //(só para facilitar o entendimento do código)
    private final int COL_REGIME = 0;
    private final int COL_SITUACAO = 1;
    private final int COL_ORIGEM = 2;

    private List<Icms> icmss;

    public IcmsTableModel(List<Icms> c) {
        this.icmss = c;
    }

    public IcmsTableModel() {
        this.icmss = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return icmss.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        //qual o nome da coluna
        switch (column) {
            case COL_REGIME:
                return "Regime";
            case COL_SITUACAO:
                return "Situação";
            case COL_ORIGEM:
                return "Origem";
            default:
                break;
        }
        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        //retorna a classe que representa a coluna
        switch (columnIndex) {
            case COL_REGIME:
                return String.class;
            case COL_SITUACAO:
                return String.class;
            case COL_ORIGEM:
                return String.class;
            default:
                break;
        }

        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o produto da linha
        Icms c = icmss.get(rowIndex);

        //verifica qual valor deve ser retornado
        switch (columnIndex) {
            case COL_REGIME:
                return c.getSituacaoTributaria().getRegimeTributario().getNome();
            case COL_SITUACAO:
                return c.getSituacaoTributaria();
            case COL_ORIGEM:
                return c.getOrigem();
            default:
                break;
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void inserir(Icms c) {
        icmss.add(c);
        fireTableDataChanged();
    }

    public Icms getCliente(int pos) {
        if (pos < 0 || pos >= icmss.size()) {
            return null;
        }

        return icmss.get(pos);
    }
    
}
