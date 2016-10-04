package br.com.nfe;

import br.com.nfe.dao.EstadoDAO;
import br.com.nfe.model.Estado;
import br.com.nfe.model.Pais;

public class Main {

	public static void main(String[] args) {
            Estado estado = new Estado("São Paulo", new Pais("Brasil"));
            EstadoDAO eDAO = new EstadoDAO();
            eDAO.persist(estado);
	}

}
