package br.com.elo.desafiocielo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo.desafiocielo.dto.ExtratoDTO;
import br.com.elo.desafiocielo.resources.utils.APIVersion;
import br.com.elo.desafiocielo.services.ExtratoService;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

@RestController
@RequestMapping("/extratos")
public class ExtratoResource {
	/*
	 * Todos os metodos possuem o parametro versionHeader e versionParam.
	 * O cliente pode ou não informar a versão da API que deseja acessar.
	 * Caso o cliente informe a versao da API, isso deverá acontecer pelo
	 * cabeçalho e/ou pela URI.
	 */
	
	@Autowired
	private ExtratoService service;
	
	/*
	 * GET
	 */
	
	@ApiOperation(value="Busca todos os registros")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ExtratoDTO>> buscarTodas(
			@RequestHeader(name = "api-version", defaultValue = "0", required = false) String versionHeader, 
			@RequestParam(value = "version", defaultValue = "0", required = false) String versionParam) {
		
		List<ExtratoDTO> bodyDTO = service.buscarTodas(
				APIVersion.version(versionHeader, versionParam));
		
		return ResponseEntity.ok().body(bodyDTO);
	}

}
