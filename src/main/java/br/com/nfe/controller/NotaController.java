/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfe.controller;

import br.com.nfe.dao.NotaDAO;
import br.com.nfe.model.Cliente;
import br.com.nfe.model.Municipio;
import br.com.nfe.model.Nota;
import br.com.nfe.model.Produto;
import br.com.nfe.model.ProdutosNota;
import br.com.nfe.model.Sessao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivo
 */
public class NotaController {
    public Boolean salvar(Map<String, JComponent> dados, Sessao sessao, Cliente cliente, List<Produto> produtos){
        Boolean salvo = false;
        
        Nota nota = new Nota();
        
        nota.setEmitente(sessao.getEmitente());
        nota.setConsumidorFinal(((JCheckBox)dados.get("consumidor")).isSelected());
        nota.setDataCadastro(System.currentTimeMillis());
        nota.setMunicipio((Municipio)((JComboBox)dados.get("cidade")).getSelectedItem());
        nota.setNumero(((JTextField)dados.get("numero")).getText());
        nota.setSerie(((JTextField) dados.get("serie")).getText());
        
        List<ProdutosNota> produtosNota = new ArrayList<>();
        
        DefaultTableModel dtm = (DefaultTableModel) ((JTable)dados.get("detalhes")).getModel();
        
        for(Produto produto : produtos){
            ProdutosNota p = new ProdutosNota();
            p.setNota(nota);
            p.setProduto(produto);
            p.setQuantidade((Integer) dtm.getValueAt(produtos.indexOf(produto), 1));
            p.setValor((Double) dtm.getValueAt(produtos.indexOf(produto), 0));
            produtosNota.add(p);
        }
        
        nota.setProdutosNota(produtosNota);
        
        NotaDAO notaDAO = new NotaDAO();
        
        if(notaDAO.persist(nota));
            salvo = true;
            
        return salvo;
    }
}
