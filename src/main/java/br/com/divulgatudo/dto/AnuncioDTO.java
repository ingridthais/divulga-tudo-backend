package br.com.divulgatudo.dto;

public class AnuncioDTO {

	private String nomeCliente;
	private String nomeAnuncio;
	private Double valorTotalInvestido;
	private Integer qtdMaxVisualizacao;
	private Integer qtdMaxClique;
	private Integer qtdMaxCompartilhamento;

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Double getValorTotalInvestido() {
		return valorTotalInvestido;
	}

	public void setValorTotalInvestido(Double valorTotalInvestido) {
		this.valorTotalInvestido = valorTotalInvestido;
	}

	public Integer getQtdMaxVisualizacao() {
		return qtdMaxVisualizacao;
	}

	public void setQtdMaxVisualizacao(Integer qtdMaxVisualizacao) {
		this.qtdMaxVisualizacao = qtdMaxVisualizacao;
	}

	public Integer getQtdMaxClique() {
		return qtdMaxClique;
	}

	public void setQtdMaxClique(Integer qtdMaxClique) {
		this.qtdMaxClique = qtdMaxClique;
	}

	public Integer getQtdMaxCompartilhamento() {
		return qtdMaxCompartilhamento;
	}

	public void setQtdMaxCompartilhamento(Integer qtdMaxCompartilhamento) {
		this.qtdMaxCompartilhamento = qtdMaxCompartilhamento;
	}

	public String getNomeAnuncio() {
		return nomeAnuncio;
	}

	public void setNomeAnuncio(String nomeAnuncio) {
		this.nomeAnuncio = nomeAnuncio;
	}
}
