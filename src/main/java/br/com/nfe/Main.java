package br.com.nfe;

import br.com.nfe.dao.EnderecoDAO;
import br.com.nfe.dao.EstadoDAO;
import br.com.nfe.dao.MunicipioDAO;
import br.com.nfe.dao.PaisDAO;
import br.com.nfe.dao.PessoaDAO;
import br.com.nfe.model.Endereco;
import br.com.nfe.model.Estado;
import br.com.nfe.model.Municipio;
import br.com.nfe.model.Pais;
import br.com.nfe.model.Pessoa;

public class Main {

	public static void main(String[] args) {

		Pais pais = new Pais("Brasil");

		Estado estado = new Estado("São Paulo", pais);

		Municipio municipio = new Municipio();
		municipio.setNome("Caraguatatuba");
		municipio.setEstado(estado);

		/*MunicipioDAO mDAO = new MunicipioDAO();
		mDAO.persist(municipio);*/
		
		Pessoa p = new Pessoa();
		p.setNome("Hugo");
		p.setEmail("hscuba@gmail.com");
		
		/*PessoaDAO pDAO = new PessoaDAO();
		pDAO.persist(p);*/
		
		Endereco e = new Endereco();
		e.setMunicipio(municipio);
		e.setCep("11673-460");
		e.setBairro("Jardim das Gaivotas");
		e.setComplemento("NADA");
		e.setEndereco("Cardeal");
		e.setNumero(150);
		e.setPessoa(p);
		e.setTipo('R');

		EnderecoDAO eDAO = new EnderecoDAO();
		eDAO.persist(e);
	}

}
