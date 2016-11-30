/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//http://matheuspiscioneri.com.br/blog/nao-use-defaulttablemodel-e-sim-abstracttablemodel/
package br.com.nfe.view.model;

import br.com.nfe.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivo
 */
public class ClienteTableModel extends AbstractTableModel {

    //constantes que vão representar as colunas
    //(só para facilitar o entendimento do código)
    private final int COL_NOME = 0;

    private List<Cliente> clientes;

    public ClienteTableModel(List<Cliente> c) {
        this.clientes = c;
    }

    public ClienteTableModel() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return clientes.size();
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

    public Cliente getValueAt(int rowIndex, int columnIndex) {
        //pega o produto da linha
        Cliente c = clientes.get(rowIndex);

        //verifica qual valor deve ser retornado
        if (columnIndex == COL_NOME) {
            return c;
        }

        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void inserir(Cliente c) {
        clientes.add(c);
        fireTableDataChanged();
    }

    public Cliente getProduto(int pos) {
        if (pos < 0 || pos >= clientes.size()) {
            return null;
        }

        return clientes.get(pos);
    }
}
