package br.com.nfe;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.swing.UIManager;

import br.com.nfe.dao.LoginDAO;
import br.com.nfe.dao.MunicipioDAO;
import br.com.nfe.dao.OrigemDAO;
import br.com.nfe.dao.RegimeTributarioDAO;
import br.com.nfe.dao.SituacaoTributariaDAO;
import br.com.nfe.model.Estado;
import br.com.nfe.model.Icms;
import br.com.nfe.model.Login;
import br.com.nfe.model.Municipio;
import br.com.nfe.model.Origem;
import br.com.nfe.model.Pais;
import br.com.nfe.model.RegimeTributario;
import br.com.nfe.model.SituacaoTributaria;
import br.com.nfe.utils.PasswordHash;
import br.com.nfe.view.LoginView;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

		/*Login usuario = new Login("hugo", PasswordHash.createHash("123"));
		usuario.setNome("Hugo Salles Cuba");
		LoginDAO lDAO = new LoginDAO();
		lDAO.persist(usuario);
                
                Pais p = new Pais("Brasil");
                Estado e = new Estado("São Paulo", p);
                Municipio m = new Municipio("Caraguatautuba", e);
                Pais p1 = new Pais("Argentina");
                Estado e1 = new Estado("Buenos Aires", p1);
                Municipio m1 = new Municipio("La Plata", e1);
                MunicipioDAO mDAO = new MunicipioDAO();
                mDAO.persist(m);
                mDAO.persist(m1);
		
                RegimeTributario r = new RegimeTributario();
                r.setNome("Simples Nacional");
                RegimeTributario r1 = new RegimeTributario();
                r1.setNome("Simples Nacional - excesso de sublimite de receita bruta");
                RegimeTributario r2 = new RegimeTributario();
                r2.setNome("Regime Normal");
                RegimeTributarioDAO rDAO = new RegimeTributarioDAO();
                rDAO.persist(r);
                rDAO.persist(r1);
                rDAO.persist(r2);
                
                Origem o0 = new Origem();
                Origem o1 = new Origem();
                Origem o2 = new Origem();
                Origem o3 = new Origem();
                Origem o4 = new Origem();
                Origem o5 = new Origem();
                Origem o6 = new Origem();
                Origem o7 = new Origem();
                o0.setOrigem("0	- Nacional, exceto as indicadas nos códigos 3 a 5");
                o1.setOrigem("1	- Estrangeira - Importação direta, exceto a indicada no código 6");
                o2.setOrigem("2	- Estrangeira - Adquirida no mercado interno, exceto a indicada no código 7");
                o3.setOrigem("3	- Nacional, mercadoria ou bem com Conteúdo de Importação superior a 40% (quarenta por cento)");
                o4.setOrigem("4	- Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos de que tratam o Decreto-Lei nº 288/67, e as Leis nºs 8.248/91, 8.387/91, 10.176/01 e 11 . 4 8 4 / 0 7");
                o5.setOrigem("5	- Nacional, mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40% (quarenta por cento)");
                o6.setOrigem("6	- Estrangeira - Importação direta, sem similar nacional, constante em lista de Resolução CAMEX");
                o7.setOrigem("7	- Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista de Resolução CAMEX");
                OrigemDAO oDAO = new OrigemDAO();
                oDAO.persist(o7);
                oDAO.persist(o6);
                oDAO.persist(o5);
                oDAO.persist(o4);
                oDAO.persist(o3);
                oDAO.persist(o2);
                oDAO.persist(o1);
                oDAO.persist(o0);
                
                SituacaoTributaria s = new SituacaoTributaria();
                SituacaoTributaria s1 = new SituacaoTributaria();
                s.setRegimeTributario(r);
                s.setSituacaoTributaria("400 - Não tributada");
                s1.setRegimeTributario(r2);
                s1.setSituacaoTributaria("41 - Não tributada");
                SituacaoTributariaDAO sDAO = new SituacaoTributariaDAO();
                sDAO.persist(s);
                sDAO.persist(s1);*/
		
		LoginView loginView = new LoginView();
		loginView.setVisible(true);
	}

}
