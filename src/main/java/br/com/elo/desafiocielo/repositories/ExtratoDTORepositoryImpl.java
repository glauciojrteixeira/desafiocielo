package br.com.elo.desafiocielo.repositories;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.elo.desafiocielo.dto.ExtratoDTO;
import br.com.elo.desafiocielo.repositories.utils.QueryUtil;


@Repository
public class ExtratoDTORepositoryImpl implements ExtratoDTORepository {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<ExtratoDTO> buscarTodas() {
		
		Query qry = entityManager.createNativeQuery(QueryUtil.QRYBUSCARTODAS);
				
		List<ExtratoDTO> listaExtratoDTO = new ArrayList<ExtratoDTO>();
		
		@SuppressWarnings("unchecked")
		List<Object[]> lista = qry.getResultList();
		
		for (Object[] objects : lista) {
			ExtratoDTO extratoDTO = new ExtratoDTO();
			
			extratoDTO.setDataLancamentoContaCorrenteCliente((Date) objects[0]);
			extratoDTO.setNomeTipoOperacao((String) objects[1]);
			extratoDTO.setNumeroRemessaBanco(((BigInteger) objects[2]));
			extratoDTO.setNomeSituacaoRemessa((String) objects[3]);
			extratoDTO.setDataEfetivaLancamento((Date) objects[4]);
			extratoDTO.setNomeBanco((String) objects[5]);
			extratoDTO.setNumeroAgencia((String) objects[6]);
			extratoDTO.setNumeroContaCorrente((String) objects[7]);
			extratoDTO.setValorLancamentoRemessa((Double) objects[8]);
			
			listaExtratoDTO.add(extratoDTO);
		}
		
		return listaExtratoDTO;
	}
}
