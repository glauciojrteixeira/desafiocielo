package br.com.elo.desafiocielo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.elo.desafiocielo.domains.Cliente;
import br.com.elo.desafiocielo.services.validations.ClienteUpdateAC;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

@ClienteUpdateAC
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 5, max = 120, message = "O tamanho deste campo deve estar entre 5 e 80 caracteres!")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 5, max = 80, message = "O tamanho deste campo deve estar entre 5 e 80 caracteres!")
	@Email(message = "Email Inválido!")
	private String email;
	
	/**
	 * Construtores
	 * @param id
	 * @param nome
	 * @param email
	 */
	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
	}
	public ClienteDTO() {
		
	}
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
