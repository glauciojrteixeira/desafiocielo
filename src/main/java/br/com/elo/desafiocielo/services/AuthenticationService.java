package br.com.elo.desafiocielo.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.elo.desafiocielo.domains.Cliente;
import br.com.elo.desafiocielo.repositories.ClienteRepository;
import br.com.elo.desafiocielo.services.exceptions.ObjetoNaoEncontradoExcecao;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

@Service
public class AuthenticationService {

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private Random random = new Random();
	
	public void sendNewPassword(String email) {
		Cliente cliente = clienteRepo.findByEmail(email);
		
		if (cliente == null) {
			throw new ObjetoNaoEncontradoExcecao("Email não encontrado!");
		}
		
		String novaSenha = newPassword();
		cliente.setSenha(passwordEncoder.encode(novaSenha));
		
		clienteRepo.save(cliente);
		
	}

	private String newPassword() {
		char[] vetorNovaSenha = new char[10];
		
		for (int i = 0; i < 10; i++) {
			vetorNovaSenha[i] = randomChar();
		}
		
		return new String(vetorNovaSenha);
	}

	private char randomChar() {
		int opt = random.nextInt(3);
		
		if (opt == 0) {
			// gera um digito
			return (char) (random.nextInt(10) + 48);
			
		} else if (opt == 1) {
			// gera letra maiuscula
			return (char) (random.nextInt(26) + 65);
			
		} else {
			// gera letra minuscula
			return (char) (random.nextInt(10) + 97);
		}
	}
}
