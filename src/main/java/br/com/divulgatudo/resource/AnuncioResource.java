package br.com.divulgatudo.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/anuncios")
@Api(value = "Anuncio")
public class AnuncioResource {

	@Autowired
	AnuncioServiceImpl service;

	@ApiOperation(value = "Lista todos os Anuncios")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Anuncio>> findAll() {
		return new ResponseEntity<List<Anuncio>>(this.service.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Lista os Anuncios pelo filtro")
	@GetMapping(value = "/findByFilter", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AnuncioDTO>> findByFilter(@ModelAttribute FiltroAnuncioDTO filtro) {
		return new ResponseEntity<List<AnuncioDTO>>(this.service.findByFilter(filtro), HttpStatus.OK);
	}

	@ApiOperation(value = "Cria um Anuncio")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Anuncio> create(@RequestBody(required = true) @Valid Anuncio anuncio) {
		return new ResponseEntity<Anuncio>(this.service.create(anuncio), HttpStatus.OK);
	}

	@ApiOperation(value = "Atualiza um Anuncio pelo seu ID")
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Anuncio> update(@RequestBody(required = true) @Valid Anuncio anuncio,
			@PathVariable(required = true, name = "id") Long id) {
		return new ResponseEntity<Anuncio>(this.service.update(anuncio, id), HttpStatus.OK);
	}

	@ApiOperation(value = "Consulta o Anuncio pelo seu ID")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Anuncio> findById(@PathVariable(required = true, name = "id") Long id) {
		return new ResponseEntity<Anuncio>(this.service.findById(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Deleta um Anuncio pelo seu ID")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable(required = true, name = "id") Long id) {
		return new ResponseEntity<Void>(this.service.delete(id), HttpStatus.OK);
	}
}
