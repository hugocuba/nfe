/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.view.model;

import br.com.nfe.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ivo
 */
public class ProdutoTableModel extends AbstractTableModel{
    private final int COL_DESCRICAO = 0;
    private final int COL_CODIGO = 1;

    private List<Produto> produtos;

    public ProdutoTableModel(List<Produto> c) {
        this.produtos = c;
    }

    public ProdutoTableModel() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        //qual o nome da coluna
        switch (column) {
            case COL_DESCRICAO:
                return "Descrição";
            case COL_CODIGO:
                return "Código";
            default:
                break;
        }
        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        //retorna a classe que representa a coluna
        switch (columnIndex) {
            case COL_DESCRICAO:
                return String.class;
            case COL_CODIGO:
                return String.class;
            default:
                break;
        }

        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o produto da linha
        Produto c = produtos.get(rowIndex);

        //verifica qual valor deve ser retornado
        switch (columnIndex) {
            case COL_DESCRICAO:
                return c.getDescricao();
            case COL_CODIGO:
                return c.getCodigo();
            default:
                break;
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void inserir(Produto c) {
        produtos.add(c);
        fireTableDataChanged();
    }

    public Produto getProduto(int pos) {
        if (pos < 0 || pos >= produtos.size()) {
            return null;
        }

        return produtos.get(pos);
    }
}
