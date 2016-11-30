/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.view.model;

import br.com.nfe.model.Cliente;
import br.com.nfe.model.Emitente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    private final int COL_DOC = 1;

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
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        //qual o nome da coluna
        if (column == COL_NOME) {
            return "Nome";
        } else if (column == COL_DOC) {
            return "CPF / CNPJ";
        }
        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        //retorna a classe que representa a coluna
        if (columnIndex == COL_NOME) {
            return String.class;
        } else if (columnIndex == COL_DOC) {
            return String.class;
        }

        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o produto da linha
        Emitente e = emitentes.get(rowIndex);

        //verifica qual valor deve ser retornado
        if (columnIndex == COL_NOME) {
            return e.getPessoa().getNome();
        } else if (columnIndex == COL_DOC) {
            return e.getPessoa().getEmail();
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void inserir(Emitente c) {
        emitentes.add(c);
        fireTableDataChanged();
    }

    public Emitente getEmitente(int pos) {
        if (pos < 0 || pos >= emitentes.size()) {
            return null;
        }

        return emitentes.get(pos);
    }
    
        public void ordenarPorNome() {
//ordena pelo nome
        Collections.sort(emitentes, new Comparator() {

            @Override
            public int compare(Object t, Object t1) {
                Emitente e1 = (Emitente) t;
                Emitente e2 = (Emitente) t1;
                return e1.getPessoa().getNome().compareTo(e2.getPessoa().getNome());
            }
        });

        //avisa que a tabela foi alterada
        fireTableDataChanged();
    }
}
