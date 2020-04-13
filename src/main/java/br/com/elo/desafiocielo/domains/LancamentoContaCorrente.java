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
import javax.persistence.OneToOne;

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
public class LancamentoContaCorrente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;
	@Getter @Setter private Long numeroRemessaBanco;
	@Getter @Setter private String nomeSituacaoRemessa;
	@Getter @Setter private String nomeTipoOperacao;
	
	/**
	 * Mapeamentos - Cardinalidades
	 */
	@ManyToOne
	@JoinColumn(name = "domicilioBancario_id")
	@Getter @Setter private DomicilioBancario domicilioBancario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "lancamentoContaCorrente")
	@Getter @Setter private List<LancamentoFinanceiro> lancamentoFinanceiros = new ArrayList<>();
	
	@OneToOne(mappedBy = "lancamentoContaCorrente")
	@Getter @Setter private ControleLancamento controleLancamento;
	
	
}
