package br.com.divulgatudo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.divulgatudo.dto.FiltroAnuncioDTO;
import br.com.divulgatudo.error.ResourceNotFoundException;
import br.com.divulgatudo.model.Anuncio;
import br.com.divulgatudo.repository.AnuncioRepository;
import br.com.divulgatudo.service.AnuncioService;

@Service
public class AnuncioServiceImpl implements AnuncioService {
	
	@Autowired
	AnuncioRepository repository;

	@Override
	public Anuncio create(Anuncio a) {
		return repository.save(a);
	}

	@Override
	public Anuncio update(Anuncio a, Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("O Anuncio não existe!");
		}
		a.setId(id);
		return repository.save(a);
	}

	@Override
	public Anuncio findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("O Anuncio não existe!"));
	}

	@Override
	public List<Anuncio> findAll() {
		return repository.findAll();
	}

	@Override
	public Void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("O Anuncio não existe ou já foi excluido!");
		}
		repository.deleteById(id);
		return null;
	}

	@Override
	public List<Anuncio> findByFilter(FiltroAnuncioDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
