package br.com.elo.desafiocielo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elo.desafiocielo.domains.DomicilioBancario;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

@Repository
public interface DomicilioBancarioRepository extends JpaRepository<DomicilioBancario, Integer> {
	/* Classe da camada de acesso aos dados. Basta a anotação @Repository e a assinatura da interface
	 * Ao extender JpaRepository é passado como tipo a classe de dominio já mapeada (JPA) e o tipo do 
	 * atributo identificador do objeto, que no caso é o Integer (id). 
	 */
	
	// Assinatura do metodo que será implementado automaticamente pelo framework
	@Transactional()
	DomicilioBancario findByCodigoBancoAndNumeroAgenciaAndNumeroContaCorrente(
			String codigoBanco, String numeroAgencia, String numeroContaCorrente);
	
//	@Transactional
//	//@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
//	@Query("SELECT DISTINCT obj, lcc FROM ControleLancamento obj INNER JOIN obj.lancamentoContaCorrente lcc INNER JOIN lcc.domicilioBancario")
//	List<List<Object[]>> procurarExtrato();
	
	

	
	/* Mesmo resultado da consulta acima usando o padrão de nomes do framework 
	 * 
	 * Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
	 */
	
}
