package br.com.elo.desafiocielo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.elo.desafiocielo.domains.DomicilioBancario;
import br.com.elo.desafiocielo.dto.DomicilioBancarioDTO;
import br.com.elo.desafiocielo.resources.utils.APIVersion;
import br.com.elo.desafiocielo.services.DomicilioBancarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/domicilio-bancarios")
public class DomicilioBancarioResource {
	/*
	 * Todos os metodos possuem o parametro versionHeader e versionParam.
	 * O cliente pode ou não informar a versão da API que deseja acessar.
	 * Caso o cliente informe a versao da API, isso deverá acontecer pelo
	 * cabeçalho e/ou pela URI.
	 */
	
	@Autowired
	private DomicilioBancarioService service;

	/*
	 * GET
	 */
	
	@ApiOperation(value="Busca registro por id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DomicilioBancarioDTO> buscarId(
			@RequestHeader(name = "api-version", defaultValue = "0", required = false) String versionHeader, 
			@RequestParam(value = "version", defaultValue = "0", required = false) String versionParam,
			@PathVariable Integer id) {
				
		DomicilioBancario body = service.buscarId(
				APIVersion.version(versionHeader, versionParam), id);
		
		// Antes do response, converte o objeto de dominio em um DTO
		return ResponseEntity.ok().body(new DomicilioBancarioDTO(body));
	}

	
	@ApiOperation(value="Busca todos os registros")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DomicilioBancarioDTO>> buscarTodas(
			@RequestHeader(name = "api-version", defaultValue = "0", required = false) String versionHeader, 
			@RequestParam(value = "version", defaultValue = "0", required = false) String versionParam) {
		
		List<DomicilioBancario> body = service.buscarTodas(
				APIVersion.version(versionHeader, versionParam));
		
		// Converte a lista do objeto de dominio em uma lista DTO
		List<DomicilioBancarioDTO> bodyDTO = body
				.stream()
				.map(domicilioBancario -> new DomicilioBancarioDTO(domicilioBancario))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(bodyDTO);
	}
	
	@ApiOperation(value="Busca todos os registros com paginação")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<DomicilioBancarioDTO>> buscarTodasPaginado(
			@RequestHeader(name = "api-version", defaultValue = "0", required = false) String versionHeader, 
			@RequestParam(value = "version", defaultValue = "0", required = false) String versionParam,
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "codigoBanco") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		Page<DomicilioBancario> body = service.buscarTodasPaginado(
				APIVersion.version(versionHeader, versionParam), 
				page, linesPerPage, orderBy, direction);
		
		// Converte a lista do objeto de dominio em uma lista DTO
		Page<DomicilioBancarioDTO> bodyDTO = body
				.map(domicilioBancario -> new DomicilioBancarioDTO(domicilioBancario));
		
		return ResponseEntity.ok().body(bodyDTO);
	}
	
	
	/*
	 * POST
	 */
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@ApiOperation(value="Grava registros pelo contexto do DTO")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> guardarEntidade(
			@RequestHeader(name = "api-version", defaultValue = "0", required = false) String versionHeader, 
			@RequestParam(value = "version", defaultValue = "0", required = false) String versionParam,
			@Valid @RequestBody DomicilioBancarioDTO entityDTO) {
		
		// Convertendo de DTO para objeto
		DomicilioBancario entity = service.fromDTO(
				APIVersion.version(versionHeader, versionParam), 
				entityDTO); 
		
		entity = service.guardarEntidade(
				APIVersion.version(versionHeader, versionParam), entity);
		
		/* Preparando para devolver a URI se o status for 201 */
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(entity.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	/*
	 * PUT
	 */
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@ApiOperation(value="Atualiza registro por id")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarEntidade(
			@RequestHeader(name = "api-version", defaultValue = "0", required = false) String versionHeader, 
			@RequestParam(value = "version", defaultValue = "0", required = false) String versionParam,
			@Valid @RequestBody DomicilioBancarioDTO entityDTO, @PathVariable Integer id) {
		
		// Convertendo de DTO para objeto
		DomicilioBancario entity = service.fromDTO(
				APIVersion.version(versionHeader, versionParam), entityDTO); 
		
		entity.setId(id);
		entity = service.atualizarEntidade(
				APIVersion.version(versionHeader, versionParam), entity);
		
		return ResponseEntity.noContent().build();
	}
	
	
	/*
	 * DELETE
	 */
	
	@ApiOperation(value="Remove registro por id")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possivel excluir um domicilioBancario que possui lancamentos!"),
			@ApiResponse(code = 404, message = "Código inexistente!")
	})
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> removerId(
			@RequestHeader(name = "api-version", defaultValue = "0", required = false) String versionHeader, 
			@RequestParam(value = "version", defaultValue = "0", required = false) String versionParam,
			@PathVariable Integer id) {
		
		service.removerId(
				APIVersion.version(versionHeader, versionParam), id);
		
		return ResponseEntity.noContent().build();
	}
}
