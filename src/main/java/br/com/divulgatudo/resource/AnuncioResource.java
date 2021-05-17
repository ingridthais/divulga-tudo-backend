package br.com.divulgatudo.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.divulgatudo.dto.AnuncioDTO;
import br.com.divulgatudo.dto.FiltroAnuncioDTO;
import br.com.divulgatudo.model.Anuncio;
import br.com.divulgatudo.service.impl.AnuncioServiceImpl;

@RestController
@RequestMapping("/anuncios")
public class AnuncioResource {

	@Autowired
	AnuncioServiceImpl service;

	@GetMapping
	public ResponseEntity<List<Anuncio>> findAll() {
		return new ResponseEntity<List<Anuncio>>(this.service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/findByFilter")
	public ResponseEntity<List<AnuncioDTO>> findByFilter(@ModelAttribute FiltroAnuncioDTO filtro) {
		return new ResponseEntity<List<AnuncioDTO>>(this.service.findByFilter(filtro), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Anuncio> create(@RequestBody @Valid Anuncio anuncio) {
		return new ResponseEntity<Anuncio>(this.service.create(anuncio), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Anuncio> update(@RequestBody @Valid Anuncio anuncio, @PathVariable(required = true, name = "id") Long id) {
		return new ResponseEntity<Anuncio>(this.service.update(anuncio, id), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Anuncio> findById(@PathVariable(required = true, name = "id") Long id) {
		return new ResponseEntity<Anuncio>(this.service.findById(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(required = true, name = "id") Long id) {
		return new ResponseEntity<Void>(this.service.delete(id), HttpStatus.OK);
	}
}
