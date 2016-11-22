package br.com.nfe.controller;

import br.com.nfe.dao.ClienteDAO;
import br.com.nfe.model.Fisica;
import br.com.nfe.model.Juridica;
import br.com.nfe.model.Cliente;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author a1502824
 */
public class ClienteController {
    public boolean salvar(Map<String, Object> dados){
        boolean salvo = false;
        
        JRadioButton tipo = (JRadioButton) dados.get("tipo");
        JCheckBox icms = (JCheckBox) dados.get("icms");
        JTextField nome = (JTextField) dados.get("nome");
        JTextField ie = (JTextField) dados.get("ie");
        JTextField suframa = (JTextField) dados.get("suframa");
        JTextField email = (JTextField) dados.get("email");
        JTextField telefone = (JTextField) dados.get("telefone");
        JTextField logradouro = (JTextField) dados.get("logradouro");
        JTextField num = (JTextField) dados.get("num");
        JTextField bairro = (JTextField) dados.get("bairro");
        JTextField complemento = (JTextField) dados.get("complemento");
        JTextField cep = (JTextField) dados.get("cep");
        JComboBox pais = (JComboBox) dados.get("pais");
        JComboBox estado = (JComboBox) dados.get("estado");
        JComboBox municipio = (JComboBox) dados.get("municipio");
        //JTextField cpf = (JTextField) dados.get("cpf");
        //JTextField cnpj = (JTextField) dados.get("cnpj");
        
        if(tipo.isSelected()){
            Fisica p = new Fisica();
            p.setIsencaoIcms(icms.isSelected());
            p.setNome(nome.getText());
            p.set
            p.setCpf(cpf.getText());
            p.setEmail(email.getText());
            p.setSuframa(suframa.getText());
            p.set
            
            Cliente cliente = new Cliente();
            cliente.setPessoa(p);
            
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.persist(cliente);
        }else{
            Juridica p = new Juridica();
            p.setNome(nome.getText());
            p.setIsencaoIcms(icms.isSelected());
        }
        
        
        
        return salvo;
    }
}
