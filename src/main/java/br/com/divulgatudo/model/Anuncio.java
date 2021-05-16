package br.com.divulgatudo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Anuncio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ANUNCIO")
	private Long id;

	@NotEmpty(message = "O Campo é Obrigatório")
	@Column(name = "NOME_ANUNCIO", length = 100, nullable = false)
	@Size(min = 3, max = 100, message = "O tamanho minimo do campo é {min} e o máximo é {max}")
	private String nomeAnuncio;

	@NotEmpty(message = "O Campo é Obrigatório")
	@Column(name = "NOME_CLIENTE", length = 100, nullable = false)
	@Size(min = 3, max = 100, message = "O tamanho minimo do campo é {min} e o máximo é {max}")
	private String nomeCliente;

	@NotNull(message = "O Campo é Obrigatório")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInicio;

	@NotNull(message = "O Campo é Obrigatório")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataTermino;

	@NotNull(message = "O Campo é Obrigatório")
	private Double investimentoDiario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeAnuncio() {
		return nomeAnuncio;
	}

	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Double getInvestimentoDiario() {
		return investimentoDiario;
	}

	public void setInvestimentoDiario(Double investimentoDiario) {
		this.investimentoDiario = investimentoDiario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((dataTermino == null) ? 0 : dataTermino.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((investimentoDiario == null) ? 0 : investimentoDiario.hashCode());
		result = prime * result + ((nomeAnuncio == null) ? 0 : nomeAnuncio.hashCode());
		result = prime * result + ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anuncio other = (Anuncio) obj;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataTermino == null) {
			if (other.dataTermino != null)
				return false;
		} else if (!dataTermino.equals(other.dataTermino))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (investimentoDiario == null) {
			if (other.investimentoDiario != null)
				return false;
		} else if (!investimentoDiario.equals(other.investimentoDiario))
			return false;
		if (nomeAnuncio == null) {
			if (other.nomeAnuncio != null)
				return false;
		} else if (!nomeAnuncio.equals(other.nomeAnuncio))
			return false;
		if (nomeCliente == null) {
			if (other.nomeCliente != null)
				return false;
		} else if (!nomeCliente.equals(other.nomeCliente))
			return false;
		return true;
	}

}
