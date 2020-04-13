package br.com.elo.desafiocielo.configurations;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.elo.desafiocielo.services.DatabaseService;

@Configuration
@Profile("test")
public class ProfileTestConfig {
	/**
	 * Este arquivo é especifico para configurações de um profile (application.properties).
	 * 
	 * Os Beans desta classe somente serão ativados quando o profile estiver ativo no application.properties
	 */
	
	
	@Autowired
	private DatabaseService databaseService;
	
	/**
	 * Metodo :: Responsavel por instanciar a base de dados no profile ativo
	 * @return
	 * @throws ParseException
	 */
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		databaseService.instantiateDatabaseTest();
		
		return true;
	}
	
	

}
