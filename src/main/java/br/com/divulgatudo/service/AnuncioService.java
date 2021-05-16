package br.com.divulgatudo.service;

import java.util.List;

import br.com.divulgatudo.model.Anuncio;

public interface AnuncioService {

	/*
	 * Cadastra um novo Anuncio.
	 * 
	 * @param Anuncio, O Anuncio que será criado.
	 * 
	 * @return O Anuncio que foi cadastrado.
	 * 
	 */
	public Anuncio create(Anuncio a);
	
	/*
	 * Atualiza novo Anuncio.
	 * 
	 * @param Anuncio, O Anuncio que será atualizado.
	 * 
	 * @param ID, O Identificador do Anuncio que será atualizado.
	 * 
	 * @return O Anuncio que foi atualizado.
	 * 
	 */
	public Anuncio update(Anuncio a, Long id);

	/*
	 * Pesquisa um Anuncio pelo Identificador.
	 * 
	 * @param id, O Identificador do anuncio que será pesquisado.
	 * 
	 * @return O Anuncio que foi pesquisado.
	 * 
	 */
	public Anuncio findById(Long id);
	
	/*
	 * Pesquisa todos os Anuncio.
	 * 
	 * @return A lista com todos os anuncios.
	 * 
	 */
	public List<Anuncio> findAll();
	
	/*
	 * Excluir um Anuncio pelo identificador
	 * 
	 * @param ID, Identificador do Anuncio que será excluido.	 
	 */
	public void delete(Long id);
}
