package br.com.elo.desafiocielo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.elo.desafiocielo.dto.ExtratoDTO;
import br.com.elo.desafiocielo.repositories.ExtratoDTORepository;
import br.com.elo.desafiocielo.services.exceptions.APIVersionExcecao;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

@Slf4j
@Service
public class ExtratoService {
	// Declara a injeção de dependencia ao objeto repository
	@Autowired
	private ExtratoDTORepository extratoDTORepo;
	
	/*
	 * Atributo
	 */
	@Value("${api.version.default}")
	private String apiVersionDefault;
	
	public List<ExtratoDTO> buscarTodas(String version) {
		log.info("");
		
		version = version.equals("0") ? apiVersionDefault : version;
		
		if (version.equals("1.0")) {
			List<ExtratoDTO> extratoDTO = extratoDTORepo.buscarTodas();

			return extratoDTO;
			
		} else {
			throw new APIVersionExcecao("Versão da API informada não encontrada!");
		}
		
		
	}

}
