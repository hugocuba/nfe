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

		// JRadioButton tipo = (JRadioButton) dados.get("tipo");
		// JCheckBox icms = (JCheckBox) dados.get("icms");
		// JTextField nome = (JTextField) dados.get("nome");
		// JTextField ie = (JTextField) dados.get("ie");
		// JTextField suframa = (JTextField) dados.get("suframa");
		// JTextField email = (JTextField) dados.get("email");
		// JTextField telefone = (JTextField) dados.get("telefone");
		// JTextField logradouro = (JTextField) dados.get("logradouro");
		// JTextField num = (JTextField) dados.get("num");
		// JTextField bairro = (JTextField) dados.get("bairro");
		// JTextField complemento = (JTextField) dados.get("complemento");
		// JTextField cep = (JTextField) dados.get("cep");
		// JComboBox pais = (JComboBox) dados.get("pais");
		// JComboBox estado = (JComboBox) dados.get("estado");
		// JComboBox municipio = (JComboBox) dados.get("municipio");
		// JTextField cpf = (JTextField) dados.get("cpf");
		// JTextField cnpj = (JTextField) dados.get("cnpj");

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

		/*
		 * Endereco endereco = new Endereco();
		 * endereco.setEndereco(((JTextField)
		 * dados.get("logradouro")).getText());
		 * endereco.setNumero(Integer.parseInt(((JTextField)
		 * dados.get("num")).getText())); endereco.setBairro(((JTextField)
		 * dados.get("bairro")).getText());
		 * endereco.setComplemento(((JTextField)
		 * dados.get("complemento")).getText()); endereco.setCep(((JTextField)
		 * dados.get("cep")).getText()); //endereco.setMunicipio(municipio);
		 * endereco.setPessoa(p);
		 */

		List<String> tel = new ArrayList<>();
		tel = Telephone.separarDDD(((JTextField) dados.get("telefone")).getText());
		Telefone telefone = new Telefone();
		telefone.setDdd(tel.get(0));
		telefone.setNumero(tel.get(1));
		telefone.setPessoa(p);

		Cliente cliente = new Cliente();
		cliente.setPessoa(p);

		ClienteDAO clienteDAO = new ClienteDAO();

		if (clienteDAO.persist(cliente))
			salvo = true;

		return salvo;
	}
}
