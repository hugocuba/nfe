package br.com.nfe;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import br.com.nfe.dao.LoginDAO;
import br.com.nfe.model.Login;
import br.com.nfe.utils.PasswordHash;
import br.com.nfe.view.LoginView;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
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

		Login usuario = new Login("hugo", PasswordHash.createHash("123"));
		
		LoginDAO lDAO = new LoginDAO();

		lDAO.persist(usuario);
		
		//Login login = lDAO.verifica("hugo");
		
		//System.out.println(PasswordHash.validatePassword("123", login.getSenha()));
		
		//login.setUltimoAcesso(Calendar.getInstance());
		
		//lDAO.merge(login);
		
		//if(login != null)

		//System.out.println(login.getUsuario());
		
		LoginView loginView = new LoginView();
		loginView.setVisible(true);

	}

}
