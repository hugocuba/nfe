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
import br.com.nfe.model.Telefone;

public class Main {

	public static void main(String[] args) {

		Pais pais = new Pais("Brasil");

		Estado estado = new Estado("São Paulo", pais);

		Municipio municipio = new Municipio();
		municipio.setNome("Caraguatatuba");
		municipio.setEstado(estado);
		
		Pessoa p = new Pessoa();
		p.setNome("Hugo");
		p.setEmail("hscuba@gmail.com");
		
		Endereco e = new Endereco();
		e.setMunicipio(municipio);
		e.setCep("11673-460");
		e.setBairro("Jardim das Gaivotas");
		e.setComplemento("NADA");
		e.setEndereco("Cardeal");
		e.setNumero(150);
		e.setPessoa(p);
		e.setTipo('R');
		
		Telefone t = new Telefone();
		t.setDdd("12");
		t.setNumero("981636528");
		t.setPessoa(p);
		t.setTipo('C');
		
		p.addEndereco(e);
		p.addTelefone(t);
		
		
		PessoaDAO pDAO = new PessoaDAO();
		Pessoa p2 = pDAO.getById(1);
		
		System.out.println(p2.getNome());
		
		

		/*EnderecoDAO eDAO = new EnderecoDAO();
		eDAO.persist(e);*/
		
		
	}

}
