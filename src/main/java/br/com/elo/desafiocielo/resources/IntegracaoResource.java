package br.com.elo.desafiocielo.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo.desafiocielo.dto.IntegracaoDTO;
import br.com.elo.desafiocielo.resources.utils.APIVersion;
import br.com.elo.desafiocielo.services.IntegracaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/integracoes")
public class IntegracaoResource {
	
	@Autowired
	private IntegracaoService service;
	
	/*
	 * POST
	 */
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@ApiOperation(value="URI para integrar com sistema legado XYZ.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Todos os objetos no pay load foram processados!")
	})
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> guardarEntidadeIntegracao(
			@RequestHeader(name = "api-version", defaultValue = "0", required = false) String versionHeader, 
			@RequestParam(value = "version", defaultValue = "0", required = false) String versionParam,
			@Valid @RequestBody IntegracaoDTO entityDTO) {
		
		service.processarPayLoad(
				APIVersion.version(versionHeader, versionParam), entityDTO);
				
		return ResponseEntity.ok().build();
	}

}
