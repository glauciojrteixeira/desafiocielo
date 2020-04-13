package br.com.elo.desafiocielo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elo.desafiocielo.domains.LancamentoContaCorrente;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 *
 */

@Repository
public interface LancamentoContaCorrenteRepository extends JpaRepository<LancamentoContaCorrente, Integer> {
	/* Classe da camada de acesso aos dados. Basta a anotação @Repository e a assinatura da interface
	 * Ao extender JpaRepository é passado como tipo a classe de dominio já mapeada (JPA) e o tipo do 
	 * atributo identificador do objeto, que no caso é o Integer (id). 
	 */

}
