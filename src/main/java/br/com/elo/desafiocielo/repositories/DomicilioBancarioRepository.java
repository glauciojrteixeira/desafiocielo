package br.com.elo.desafiocielo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.elo.desafiocielo.domains.DomicilioBancario;

@Repository
public interface DomicilioBancarioRepository extends JpaRepository<DomicilioBancario, Integer> {
	/* Classe da camada de acesso aos dados. Basta a anotação @Repository e a assinatura da interface
	 * Ao extender JpaRepository é passado como tipo a classe de dominio já mapeada (JPA) e o tipo do 
	 * atributo identificador do objeto, que no cado é o Integer (id). 
	 */
}
