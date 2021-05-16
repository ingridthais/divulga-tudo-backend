package br.com.divulgatudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divulgatudo.model.Anuncio;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

}
