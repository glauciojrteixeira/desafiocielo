package br.com.elo.desafiocielo.domains;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.elo.desafiocielo.domains.enums.TipoCliente;
import br.com.elo.desafiocielo.domains.enums.TipoPerfil;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

@Entity
@EqualsAndHashCode(of={"id"})
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Atributos
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String cpfOuCnpj;
	
	private Integer tipoCliente;
	
	@JsonIgnore
	private String senha;
	
	
	/*
	 * Telefone representado por um conjunto de string não repetivel
	 * Entidade fraca dispensa existencia de classe.
	 */
	@ElementCollection
	@CollectionTable(name = "TELEFONE")
	private Set<String> telefones = new HashSet<>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "CLIENTEPERFIL")
	private Set<Integer> perfis = new HashSet<>();
	
	

	/**
	 * Construtores
	 * @param id
	 * @param nome
	 * @param email
	 * @param cpfOuCnpj
	 * @param tipoCliente
	 */
	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoCliente tipoCliente, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipoCliente = (tipoCliente == null) ? null : tipoCliente.getCod();
		this.senha = senha;
		
		addTipoPerfil(TipoPerfil.CLIENTE);
	}
	public Cliente() {
		addTipoPerfil(TipoPerfil.CLIENTE);
	}
	

	/**
	 * Getters and Setters
	 * @return
	 */
	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipoCliente);
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente.getCod();
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<TipoPerfil> getPerfis() {
		return perfis.stream().map(x -> TipoPerfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addTipoPerfil(TipoPerfil tipoPerfil) {
		perfis.add(tipoPerfil.getCod());
	}
	
	
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
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	

	public Set<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
}
