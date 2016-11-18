package br.com.nfe.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Calendar;
import java.util.Map;

import br.com.nfe.dao.LoginDAO;
import br.com.nfe.model.Login;
import br.com.nfe.model.Sessao;
import br.com.nfe.utils.PasswordHash;

public class LoginController {
	
	public Boolean verificaUsuarioSenha(Map<String, String> dados) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		Boolean valido = false;

		LoginDAO lDAO = new LoginDAO();

		Login user = lDAO.verifica(dados.get("login"));

		if (user != null) {
			if(PasswordHash.validatePassword(dados.get("senha"), user.getSenha())){
				valido = true;
				user.setUltimoAcesso(Calendar.getInstance());
				lDAO.merge(user);
				Sessao sessao = Sessao.getInstance();
				sessao.setUsuario(user);
			}
		}

		return valido;
	}
	
}
