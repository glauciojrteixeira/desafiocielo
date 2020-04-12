package br.com.elo.desafiocielo.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
 * Hashcode and equals, construtor padrao e toString 
 * anotados na classe
 * 
 */

@Entity
@NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode(of={"id"})
public class ContaCorrente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;
	
	@Getter @Setter private String numeroContaCorrente;
	
	/**
	 * Mapeamentos - Cardinalidades
	 */
	@ManyToOne
	@JoinColumn(name = "domicilioBancario_id")
	@Getter @Setter private DomicilioBancario domicilioBancario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "contaCorrente")
	@Getter @Setter private List<LancamentoContaCorrente> lancamentoContaCorrentes = new ArrayList<>();
	
}
