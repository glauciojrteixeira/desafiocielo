package br.com.elo.desafiocielo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elo.desafiocielo.domains.Municipio;
import br.com.elo.desafiocielo.repositories.MunicipioRepository;


@Service
public class MunicipioService {
	
	@Autowired
	private MunicipioRepository municipioRepo;
	
	public List<Municipio> buscarEstado(Integer estadoId) {
		return municipioRepo.procurarMunicipios(estadoId);
	}

}
