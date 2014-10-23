package br.com.locadora.model.entity;

import java.util.Date;

import br.com.locadora.utils.annotation.Required;

public class Pagamento {
	private int id;
	private double valor;
	private String tipoPagamento;
	@Required(label = "CPF", minimo = 11)
	private String cpf;
	@Required(label = "Titular", minimo = 4)
	private String titular;
	private Date dataPagamento;
	private int idLocacao;

	public Pagamento() {
		setId(0);
		setValor(0);
		setCpf("");
		setTitular("");
	}

	public Pagamento(int id, double valor, String cpf, String titular) {
		setId(id);
		setValor(valor);
		setCpf(cpf);
		setTitular(titular);
	}

	public Pagamento(double valor, String cpf, String titular) {
		setId(0);
		setValor(valor);
		setCpf(cpf);
		setTitular(titular);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the tipoPagamento
	 */
	public String getTipoPagamento() {
		return tipoPagamento;
	}

	/**
	 * @param tipoPagamento the tipoPagamento to set
	 */
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	/**
	 * @return the dataPagamento
	 */
	public Date getDataPagamento() {
		return dataPagamento;
	}

	/**
	 * @param dataPagamento the dataPagamento to set
	 */
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	/**
	 * @return the idLocacao
	 */
	public int getIdLocacao() {
		return idLocacao;
	}

	/**
	 * @param idLocacao the idLocacao to set
	 */
	public void setIdLocacao(int idLocacao) {
		this.idLocacao = idLocacao;
	}

}
