package br.com.divulgatudo.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.divulgatudo.dto.AnuncioDTO;
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
		validarData(a.getDataTermino(), a.getDataInicio());
		return repository.save(a);
	}

	@Override
	public Anuncio update(Anuncio a, Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("O Anuncio não existe!");
		}
		validarData(a.getDataTermino(), a.getDataInicio());
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
	public List<AnuncioDTO> findByFilter(FiltroAnuncioDTO filtro) {
		validarData(filtro.getDataTermino(), filtro.getDataInicio());
		List<Anuncio> listaAnuncio = repository.findByNomeCliente(filtro.getNomeCliente())
				.orElseThrow(() -> new ResourceNotFoundException("O Cliente não tem nenhum anuncio cadastrado!"));

		return calculaAnuncio(listaAnuncio, filtro);
	}

	private void validarData(LocalDate dataTermino, LocalDate dataInicio) {
		if (dataTermino.isBefore(dataInicio)) {
			throw new ResourceNotFoundException("A data de termino não pode ser maior que a data de inicio");
		}
	}

	private List<AnuncioDTO> calculaAnuncio(List<Anuncio> listaAnuncio, FiltroAnuncioDTO filtro) {
		List<AnuncioDTO> listaAnuncioDTO = new ArrayList<>();
		for (Anuncio a : listaAnuncio) {
			Double qtdTotalInvestido = 0.0;
			long qtdDias = 0;
			int qtdVisualizacaoInicial = 0;
			int qtdClique = 0;
			int qtdCompartilhamento = 0;
			int qtdVisualizacao = 0;
			// Calcula a quantidade de dias
			qtdDias = Math.abs((ChronoUnit.DAYS.between(a.getDataInicio(), a.getDataTermino())));
			// Calcula a quantidade total investida
			qtdTotalInvestido = a.getInvestimentoDiario() * qtdDias;
			// Calcula a quantidade de visualizações
			qtdVisualizacaoInicial = qtdTotalInvestido.intValue() * 30;
			// Calcula a quantidade de cliques
			qtdClique = qtdVisualizacaoInicial / 100;
			qtdClique = qtdClique * 12;
			// Calcula a quantidade de compartilhamento
			qtdCompartilhamento = qtdClique / 20;
			qtdCompartilhamento = qtdCompartilhamento * 3;
			// Calcula a quantidade de visualizações
			qtdVisualizacao = qtdCompartilhamento * 40;
			AnuncioDTO anuncioDTO = new AnuncioDTO();

			anuncioDTO.setNomeCliente(a.getNomeCliente());
			anuncioDTO.setNomeAnuncio(a.getNomeAnuncio());
			anuncioDTO.setQtdMaxClique(qtdClique);
			anuncioDTO.setQtdMaxCompartilhamento(qtdCompartilhamento);
			anuncioDTO.setQtdMaxVisualizacao(qtdVisualizacao);
			anuncioDTO.setQtdMaxVisualizacao(qtdVisualizacaoInicial + qtdVisualizacao);
			anuncioDTO.setValorTotalInvestido(qtdTotalInvestido);
			listaAnuncioDTO.add(anuncioDTO);
		}
		return listaAnuncioDTO;
	}

}
