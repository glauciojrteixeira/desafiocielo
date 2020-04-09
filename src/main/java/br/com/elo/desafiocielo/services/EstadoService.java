package br.com.elo.desafiocielo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elo.desafiocielo.domains.Estado;
import br.com.elo.desafiocielo.repositories.EstadoRepository;



@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepo;
	
	public List<Estado> buscarTodas() {
		return estadoRepo.findAllByOrderByNome();
	}

}
