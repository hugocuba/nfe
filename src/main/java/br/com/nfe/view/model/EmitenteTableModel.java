/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.view.model;

import br.com.nfe.model.Emitente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Minska
 */
public class EmitenteTableModel extends AbstractTableModel {

    //constantes que vão representar as colunas
    //(só para facilitar o entendimento do código)
    private final int COL_NOME = 0;

    private List<Emitente> emitentes;

    public EmitenteTableModel(List<Emitente> e) {
        this.emitentes = e;
    }

    public EmitenteTableModel() {
        this.emitentes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return emitentes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        //qual o nome da coluna
        if (column == COL_NOME) {
            return "Nome";
        }

        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        //retorna a classe que representa a coluna
        if (columnIndex == COL_NOME) {
            return String.class;
        }

        return String.class;
    }

    public Emitente getValueAt(int rowIndex, int columnIndex) {
        //pega o produto da linha
        Emitente e = emitentes.get(rowIndex);

        //verifica qual valor deve ser retornado
        if (columnIndex == COL_NOME) {
            return e;
        }

        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void inserir(Emitente c) {
        emitentes.add(c);
        fireTableDataChanged();
    }

    public Emitente getProduto(int pos) {
        if (pos < 0 || pos >= emitentes.size()) {
            return null;
        }

        return emitentes.get(pos);
    }
}
