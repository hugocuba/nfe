package br.com.nfe;

import br.com.nfe.dao.EstadoDAO;
import br.com.nfe.dao.MunicipioDAO;
import br.com.nfe.dao.PaisDAO;
import br.com.nfe.model.Estado;
import br.com.nfe.model.Municipio;
import br.com.nfe.model.Pais;

public class Main {

	public static void main(String[] args) {

		Pais pais = new Pais("Brasil");

		Estado estado = new Estado("São Paulo", pais);

		Municipio municipio = new Municipio();
		municipio.setNome("Caraguatatuba");
		municipio.setEstado(estado);

		Municipio m2 = new Municipio();
		m2.setEstado(estado);
		m2.setNome("SSS");

		MunicipioDAO mDAO = new MunicipioDAO();
		mDAO.persist(municipio);
	}

}
