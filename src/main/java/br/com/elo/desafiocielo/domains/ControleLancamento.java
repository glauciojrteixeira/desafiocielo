package br.com.elo.desafiocielo.domains;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
public class ControleLancamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter private Integer id;
	@Getter @Setter private Date dataEfetivaLancamento;
	@Getter @Setter private Date dataLancamentoContaCorrenteCliente;
	@Getter @Setter private Long numeroEvento;
	@Getter @Setter private String descricaoGrupoPagamento;
	@Getter @Setter private Integer codigoIdentificadorUnico;
	@Getter @Setter private String nomeBanco;
	@Getter @Setter private Integer quantidadeLancamentoRemessa;
	@Getter @Setter private String numeroRaizCNPJ;
	@Getter @Setter private String numeroSufixoCNPJ;
	@Getter @Setter private Float valorLancamentoRemessa;
	@Getter @Setter private Long dateLancamentoContaCorrenteCliente;
	@Getter @Setter private Long dateEfetivaLancamento;
	
	
	/**
	 * Mapeamentos - Cardinalidades
	 */
	// Passa a ser o owner da relação
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lancamentoContaCorrente_id")
	@Getter @Setter private LancamentoContaCorrente lancamentoContaCorrente;
	
}
