package br.com.nfe;

import java.util.List;

import br.com.nfe.dao.ClienteDAO;
import br.com.nfe.dao.LoginDAO;
import br.com.nfe.dao.PessoaDAO;
import br.com.nfe.model.Endereco;
import br.com.nfe.model.Estado;
import br.com.nfe.model.Fisica;
import br.com.nfe.model.Municipio;
import br.com.nfe.model.Pais;
import br.com.nfe.model.Pessoa;
import br.com.nfe.model.Telefone;
import br.com.nfe.model.Cliente;
import br.com.nfe.model.Login;

public class Main {

	public static void main(String[] args) {
		/*
		 * Pais pais = new Pais("Brasil");
		 * 
		 * Estado estado = new Estado("São Paulo", pais);
		 * 
		 * Municipio municipio = new Municipio();
		 * municipio.setNome("Caraguatatuba"); municipio.setEstado(estado);
		 * 
		 * Fisica p = new Fisica(); p.setNome("Hugo");
		 * p.setEmail("hscuba@gmail.com");
		 * 
		 * Endereco e = new Endereco(); e.setMunicipio(municipio);
		 * e.setCep("11673-460"); e.setBairro("Jardim das Gaivotas");
		 * e.setComplemento("NADA"); e.setEndereco("Cardeal"); e.setNumero(150);
		 * e.setPessoa(p); e.setTipo('R');
		 * 
		 * Telefone t = new Telefone(); t.setDdd("12");
		 * t.setNumero("981636528"); t.setPessoa(p); t.setTipo('C');
		 * 
		 * p.addEndereco(e); p.addTelefone(t);
		 * 
		 * Cliente c = new Cliente(); c.setInscricaoSuframa("123456");
		 * c.setPessoa(p);
		 * 
		 * //PessoaDAO pDAO = new PessoaDAO(); //pDAO.persist(p);
		 * 
		 * ClienteDAO cDAO = new ClienteDAO(); cDAO.persist(c);
		 */

		/*
		 * PessoaDAO pDAO = new PessoaDAO(); List<Pessoa> p; p = pDAO.findAll();
		 * 
		 * 
		 * 
		 * for(Pessoa pp : p){ System.out.println(pp.getNome()); }
		 */

		//Login usuario = new Login("hugo", "123");
		
		LoginDAO lDAO = new LoginDAO();

		//lDAO.persist(usuario);

		Login login = lDAO.verifica("hugo", "123");

		System.out.println(login.getUsuario());

	}

}
