package br.com.elo.desafiocielo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.elo.desafiocielo.domains.DomicilioBancario;
import br.com.elo.desafiocielo.dto.DomicilioBancarioDTO;
import br.com.elo.desafiocielo.repositories.DomicilioBancarioRepository;
import br.com.elo.desafiocielo.services.exceptions.ObjetoNaoEncontradoExcecao;
import br.com.elo.desafiocielo.services.exceptions.APIVersionExcecao;
import br.com.elo.desafiocielo.services.exceptions.ViolacaoIntegridadeDadoExcecao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DomicilioBancarioService {
	
	// Declara a injeção de dependencia ao objeto repository
	@Autowired
	private DomicilioBancarioRepository domicilioBancarioRepo;
	
	/*
	 * Atributo
	 */
	@Value("${api.version.default}")
	private String apiVersionDefault;
	
	public DomicilioBancario buscarId(String version, Integer id) {
		log.info("");
		
		version = version.equals("0") ? apiVersionDefault : version;
		
		if (version.equals("1.0")) {
			Optional<DomicilioBancario> obj = domicilioBancarioRepo.findById(id);
			
			return obj.orElseThrow(() -> new ObjetoNaoEncontradoExcecao("Objeto não encontrado! " 
					+ "[ " + DomicilioBancario.class.getSimpleName() + " | id: " + id + " ]"));
		} else {
			throw new APIVersionExcecao("Versão da API informada não encontrada!");
		}
		
	}
	
	public List<DomicilioBancario> buscarTodas(String version) {
		log.info("");
		
		version = version.equals("0") ? apiVersionDefault : version;
		
		if (version.equals("1.0")) {
			return domicilioBancarioRepo.findAll();
		} else {
			throw new APIVersionExcecao("Versão da API informada não encontrada!");
		}
		
		
	}
	
	public Page<DomicilioBancario> buscarTodasPaginado(String version, 
			Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		log.info("");
		
		version = version.equals("0") ? apiVersionDefault : version;
		
		if (version.equals("1.0")) {
			return domicilioBancarioRepo.findAll(pageRequest);
		} else {
			throw new APIVersionExcecao("Versão da API informada não encontrada!");
		}
		
		
	}
	
	@Transactional
	public DomicilioBancario guardarEntidade(String version, DomicilioBancario entity) {
		log.info("");
		
		version = version.equals("0") ? apiVersionDefault : version;
		
		if (version.equals("1.0")) {
			entity.setId(null);
			
			return domicilioBancarioRepo.save(entity);
		} else {
			throw new APIVersionExcecao("Versão da API informada não encontrada!");
		}
		
		
	}
	
	@Transactional
	public DomicilioBancario atualizarEntidade(String version, DomicilioBancario entity) {
		log.info("");
		
		version = version.equals("0") ? apiVersionDefault : version;
		
		if (version.equals("1.0")) {
			DomicilioBancario newEntity = buscarId(version, entity.getId());
			atualizaNovoVelho(version, newEntity, entity);
			
			return domicilioBancarioRepo.save(entity);
		} else {
			throw new APIVersionExcecao("Versão da API informada não encontrada!");
		}
	}
	
	@Transactional
	public void removerId(String version, Integer id) {
		log.info("");
		
		version = version.equals("0") ? apiVersionDefault : version;
		
		if (version.equals("1.0")) {
			buscarId(version, id);
			
			try {
				domicilioBancarioRepo.deleteById(id);
			} catch (DataIntegrityViolationException e) {
				throw new ViolacaoIntegridadeDadoExcecao("Não é possível excluir domicilioBancario que possui entidades relacionadas!");
			} 
		} else {
			throw new APIVersionExcecao("Versão da API informada não encontrada!");
		}
		
		
		
	}
	
	
	// Metodo auxiliar para instanciar uma classe de dominio a partir de um DTO
	public DomicilioBancario fromDTO(String version, DomicilioBancarioDTO objetoDTO) {
		log.info("");
		
		version = version.equals("0") ? apiVersionDefault : version;
		
		if (version.equals("1.0")) {
			return new DomicilioBancario(
					null,
					objetoDTO.getCodigoBanco(), 
					objetoDTO.getNumeroAgencia(), 
					objetoDTO.getNumeroContaCorrente(),
					null);
		} else {
			throw new APIVersionExcecao("Versão da API informada não encontrada!");
		}
	}
	
	// Metodo para manter atualizado os dados que não serão modificados pela entrada no sistema.
	private void atualizaNovoVelho(String version, DomicilioBancario newEntity, DomicilioBancario entity) {
		log.info("");
		
		version = version.equals("0") ? apiVersionDefault : version;
		
		if (version.equals("1.0")) {
			newEntity.setCodigoBanco(entity.getCodigoBanco());
			newEntity.setNumeroAgencia(entity.getNumeroAgencia());
		} else {
			throw new APIVersionExcecao("Versão da API informada não encontrada!");
		}
		
		
	}
}
