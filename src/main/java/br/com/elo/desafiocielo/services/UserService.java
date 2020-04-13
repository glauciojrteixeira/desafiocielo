package br.com.elo.desafiocielo.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.elo.desafiocielo.securities.UserSpringSecurity;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

public class UserService {

	public static UserSpringSecurity authenticated() {
		try {
			// Retorna o usuario logado
			return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
