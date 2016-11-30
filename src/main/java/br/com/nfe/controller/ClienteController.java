package br.com.nfe.controller;

import br.com.nfe.dao.ClienteDAO;
import br.com.nfe.model.Fisica;
import br.com.nfe.model.Juridica;
import br.com.nfe.model.Pessoa;
import br.com.nfe.model.Cliente;
import br.com.nfe.model.Endereco;
import br.com.nfe.model.Estado;
import br.com.nfe.model.Municipio;
import br.com.nfe.model.Pais;
import br.com.nfe.model.Telefone;
import br.com.nfe.utils.Telephone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author a1502824
 */
public class ClienteController {

    public boolean salvar(Map<String, JComponent> dados) {
        boolean salvo = false;

        Municipio municipio;
        Estado estado;
        Pais pais;
        Pessoa p;

        if (((JRadioButton) dados.get("tipo")).isSelected()) {
            p = new Fisica();

            ((Fisica) p).setCpf(((JTextField) dados.get("documento")).getText());
        } else {
            p = new Juridica();

            ((Juridica) p).setCnpj(((JTextField) dados.get("documento")).getText());
        }

        p.setNome(((JTextField) dados.get("nome")).getText());
        p.setEmail(((JTextField) dados.get("email")).getText());
        p.setInscricaoEstadual(((JTextField) dados.get("ie")).getText());
        p.setIsencaoIcms(((JCheckBox) dados.get("icms")).isSelected());
        p.setSuframa(((JTextField) dados.get("suframa")).getText());
        

        municipio = (Municipio) (((JComboBox) dados.get("municipio")).getSelectedItem());
        Endereco endereco = new Endereco();
        endereco.setMunicipio(municipio);
        endereco.setEndereco(((JTextField) dados.get("logradouro")).getText());
        endereco.setNumero(Integer.parseInt(((JTextField) dados.get("num")).getText()));
        endereco.setBairro(((JTextField) dados.get("bairro")).getText());
        endereco.setComplemento(((JTextField) dados.get("complemento")).getText());
        endereco.setCep(((JTextField) dados.get("cep")).getText());
        endereco.setPessoa(p);

        List<String> tel = new ArrayList<>();
        tel = Telephone.separarDDD(((JTextField) dados.get("telefone")).getText());
        Telefone telefone = new Telefone();
        telefone.setDdd(tel.get(0));
        telefone.setNumero(tel.get(1));
        telefone.setPessoa(p);

        Cliente cliente = new Cliente();
        cliente.setPessoa(p);

        ClienteDAO clienteDAO = new ClienteDAO();

        if (clienteDAO.persist(cliente)) {
            salvo = true;
        }

        return salvo;
    }
    
    public boolean atualizar(Cliente cliente){
        boolean atualizado = false;
        ClienteDAO cDAO = new ClienteDAO();
        if(cDAO.merge(cliente))
            atualizado = true;
        
        return atualizado;
    }
    
    public List<Cliente> pesquisar(String nome, Boolean doc){
        List<Cliente> c;
        ClienteDAO cDAO = new ClienteDAO();
        
        if(doc){
            c = cDAO.findByDoc(nome);
        }
        else{
            c = cDAO.findByNome(nome);
        }
        
        return c;
    }
}
