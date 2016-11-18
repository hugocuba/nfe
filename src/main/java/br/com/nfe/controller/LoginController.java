package br.com.nfe.controller;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import br.com.nfe.dao.LoginDAO;
import br.com.nfe.model.Login;
import br.com.nfe.utils.PasswordHash;

public class LoginController {
	
	public Boolean verificaUsuarioSenha(String usuario, String senha) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		Boolean valido = false;

		LoginDAO lDAO = new LoginDAO();

		Login user = lDAO.verifica(usuario);

		if (user != null) {
			if(PasswordHash.validatePassword(senha, user.getSenha())){
				valido = true;
			}
		}

		return valido;
	}
	
}
