package br.com.elo.desafiocielo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.elo.desafiocielo.domains.Cliente;
import br.com.elo.desafiocielo.domains.enums.TipoCliente;
import br.com.elo.desafiocielo.domains.enums.TipoPerfil;
import br.com.elo.desafiocielo.dto.ClienteDTO;
import br.com.elo.desafiocielo.dto.ClienteNewDTO;
import br.com.elo.desafiocielo.repositories.ClienteRepository;
import br.com.elo.desafiocielo.securities.UserSpringSecurity;
import br.com.elo.desafiocielo.services.exceptions.AutorizacaoExcecao;
import br.com.elo.desafiocielo.services.exceptions.ObjetoNaoEncontradoExcecao;
import br.com.elo.desafiocielo.services.exceptions.ViolacaoIntegridadeDadoExcecao;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

@Service
public class ClienteService {

	// Declara a dependencia ao objeto repository
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public Cliente buscarId(Integer id) {
		UserSpringSecurity user = UserService.authenticated();
		if (user == null || !user.hasRole(TipoPerfil.ADMIN) && !id.equals(user.getId())) {
			throw new AutorizacaoExcecao("Acesso negado!");
		}
		
		Optional<Cliente> obj = clienteRepo.findById(id);
		
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoExcecao("Objeto não encontrado! Id: " + id 
				+ ", Tipo: " + Cliente.class.getName()));
		
	}
	
	@Transactional
	public Cliente guardarEntidade(Cliente entity) {
		entity.setId(null);
		entity = clienteRepo.save(entity);
		
		
		return entity;
	}
	
	@Transactional
	public Cliente atualizarEntidade(Cliente entity) {
		Cliente newEntity = buscarId(entity.getId());
		atualizaNovoVelho(newEntity, entity);
		
		return clienteRepo.save(newEntity);
	}
	
	
	public void removerId(Integer id) {
		buscarId(id);
		
		try {
			clienteRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new ViolacaoIntegridadeDadoExcecao("Não é possível excluir Cliente que possui entidades relacionadas!");
		}
	}
	
	public List<Cliente> buscarTodas() {
		return clienteRepo.findAll();
	}
	
	public Cliente buscarEmail(String email) {
		UserSpringSecurity user = UserService.authenticated();
		if (user == null || !user.hasRole(TipoPerfil.ADMIN) && !email.equals(user.getUsername()) ) {
			throw new AutorizacaoExcecao("Acesso negado!");
		}
		
		Cliente cliente = clienteRepo.findByEmail(email);
		if (cliente == null) {
			throw new ObjetoNaoEncontradoExcecao("Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Cliente.class.getName());
		}
		
		return cliente;
	}
	
	public Page<Cliente> buscarPaginado(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return clienteRepo.findAll(pageRequest);
	}
	
	/*
	 * Metodo auxiliar para instanciar uma classe de dominio a partir de um DTO, para realizar atualizações
	 */
	public Cliente fromDTO(ClienteDTO objetoDTO) {
		return new Cliente(objetoDTO.getId(), objetoDTO.getNome(), objetoDTO.getEmail(), null, null, null);
	}
	
	// Sobreescrita de metodo para instanciar uma classe de dominio a partir de um DTO - Novos registros
	public Cliente fromDTO(ClienteNewDTO objetoDTO) {
		Cliente cliente = new Cliente(null, objetoDTO.getNome(), objetoDTO.getEmail(), objetoDTO.getCpfOuCnpj(), 
				TipoCliente.toEnum(objetoDTO.getTipoCliente()), passwordEncoder.encode(objetoDTO.getSenha()));
		
		cliente.getTelefones().add(objetoDTO.getTelefone1());
		if (objetoDTO.getTelefone2() != null) {
			cliente.getTelefones().add(objetoDTO.getTelefone2());
		}
		if (objetoDTO.getTelefone3() != null) {
			cliente.getTelefones().add(objetoDTO.getTelefone3());
		}
		
		return cliente;
	}
	
	/*
	 * Metodo para manter atualizado os dados que não serão modificados pela entrada no sistema.
	 */
	private void atualizaNovoVelho(Cliente newEntity, Cliente entity) {
		newEntity.setNome(entity.getNome());
		newEntity.setEmail(entity.getEmail());
	}
	
	
}
