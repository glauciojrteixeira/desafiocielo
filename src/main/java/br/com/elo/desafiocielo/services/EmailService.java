package br.com.elo.desafiocielo.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import br.com.elo.desafiocielo.domains.Cliente;
import br.com.elo.desafiocielo.domains.Pedido;


/**
 * Padrão de projeto Template Method
 * @author glaucio
 *
 */

public interface EmailService {

	/**
	 * Emails
	 */
	void emailConfirmacaoPedido(Pedido pedido);
	void emailConfirmacaoPedidoHtml(Pedido pedido);
	
	void emailNovaSenha(Cliente cliente, String novaSenha);
	
	
	
	/**
	 * Texto Plano
	 * @param message
	 */
	void enviaEmail(SimpleMailMessage message);
	
	/**
	 * Texto HTML
	 * @param message
	 */
	void enviaEmailHtml(MimeMessage message);
}
