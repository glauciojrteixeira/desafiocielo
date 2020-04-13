package br.com.elo.desafiocielo.configurations;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class JacksonConfig {
	// https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-of-interfaceclass-without-hinting-the-pare
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				/**
				 * Registra as subclasses
				 */
//				objectMapper.registerSubtypes(PagamentoComCartao.class);
//				objectMapper.registerSubtypes(PagamentoComBoleto.class);
				
				super.configure(objectMapper);
			};
		};
		return builder;
	}
}
