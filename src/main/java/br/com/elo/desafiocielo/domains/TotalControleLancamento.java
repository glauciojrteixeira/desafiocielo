package br.com.elo.desafiocielo.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author Gláucio Teixeira
 * @since 09/04/2020
 * @serial 1.0
 * 
 */

@Entity
@NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode(of={"id"})
public class TotalControleLancamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;
	
	@Getter @Setter private Integer quantidadeLancamentos;
	@Getter @Setter private Integer quantidadeRemessas;
	@Getter @Setter private Float valorLancamentos;

}
