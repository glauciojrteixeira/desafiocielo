package br.com.elo.desafiocielo.configurations;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.elo.desafiocielo.services.DatabaseService;

@Configuration
@Profile("dev")
public class ProfileDevConfig {
	/**
	 * Este arquivo é especifico para configurações de um profile (application.properties).
	 * Os Beans desta classe somente serão ativados quando o profile estiver ativo no application.properties
	 */
	
	@Autowired
	private DatabaseService databaseService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	/**
	 * Metodo :: Responsavel por instanciar a base de dados no profile ativo
	 * @return
	 * @throws ParseException
	 */
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		if (!"create".equals(strategy)) {
			return false;
		}
		
		databaseService.instantiateDatabaseTest();
		
		return true;
	}
	
	

}
