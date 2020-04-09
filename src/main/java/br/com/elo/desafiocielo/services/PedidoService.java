package br.com.elo.desafiocielo.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.elo.desafiocielo.domains.Cliente;
import br.com.elo.desafiocielo.domains.ItemPedido;
import br.com.elo.desafiocielo.domains.PagamentoComBoleto;
import br.com.elo.desafiocielo.domains.Pedido;
import br.com.elo.desafiocielo.domains.enums.EstadoPagamento;
import br.com.elo.desafiocielo.repositories.ItemPedidoRepository;
import br.com.elo.desafiocielo.repositories.PagamentoRepository;
import br.com.elo.desafiocielo.repositories.PedidoRepository;
import br.com.elo.desafiocielo.securities.UserSpringSecurity;
import br.com.elo.desafiocielo.services.exceptions.AutorizacaoExcecao;
import br.com.elo.desafiocielo.services.exceptions.ObjetoNaoEncontradoExcecao;


@Service
public class PedidoService {

	// Declara a dependencia ao objeto repository
	@Autowired
	private PedidoRepository pedidoRepo;
	@Autowired
	private PagamentoRepository pagamentoRepo;
	@Autowired
	private ItemPedidoRepository itemPedidoRepo;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private BoletoService boletoService;
	@Autowired
	private EmailService emailService;
	
	
	public Pedido buscarId(Integer id) {
		Optional<Pedido> obj = pedidoRepo.findById(id);
		
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoExcecao("Objeto não encontrado! Id: " + id 
				+ ", Tipo: " + Pedido.class.getName()));	
	}
	
	@Transactional
	public Pedido guardarEntidade(Pedido entity) {
		entity.setId(null);
		
		entity.setCliente(clienteService.buscarId(entity.getCliente().getId()));
		
		entity.setInstante(new Date());
		entity.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
		entity.getPagamento().setPedido(entity);
		
		if (entity.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagamentoComBoleto = (PagamentoComBoleto) entity.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagamentoComBoleto, entity.getInstante());
		}
		
		entity = pedidoRepo.save(entity);
		pagamentoRepo.save(entity.getPagamento());
		
		for (ItemPedido itemPedido : entity.getItensPedidos()) {
			itemPedido.setDesconto(0.0);
			
			itemPedido.setProduto(produtoService.buscarId(itemPedido.getProduto().getId()));
			
			itemPedido.setPreco(itemPedido.getProduto().getPreco());
			itemPedido.setPedido(entity);
		}
		
		itemPedidoRepo.saveAll(entity.getItensPedidos());
		
		//System.out.println(entity);
		//emailService.emailConfirmacaoPedido(entity); // Envia em texto plano
		emailService.emailConfirmacaoPedidoHtml(entity); // Envia em HTML
		
		return entity;
	}
	
	public Page<Pedido> buscarPaginado(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		UserSpringSecurity userSpringSecurity = UserService.authenticated();
		if (userSpringSecurity == null) {
			throw new AutorizacaoExcecao("Acesso negado!");
		}
		
		Cliente cliente = clienteService.buscarId(userSpringSecurity.getId());
		
		return pedidoRepo.findByCliente(cliente, pageRequest);
	}
	
}
