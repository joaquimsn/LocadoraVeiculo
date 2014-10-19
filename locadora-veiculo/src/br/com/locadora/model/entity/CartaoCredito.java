package br.com.locadora.model.entity;

import java.util.Date;

import br.com.locadora.utils.annotation.Required;

public class CartaoCredito extends Pagamento {
	@Required(label = "Número cartão",  minimo = 10)
	private String numeroCartao;
	private char tipoCartao;
	private Date validade;
	private int codigoSeguranca;

	public CartaoCredito() {
		super(0.0, "", "");
		setTipoCartao(' ');
		setTipoPagamento("Cartão credito");
		setValidade(null);
		setCodigoSeguranca(0);
	}

	public CartaoCredito(double valor, String cpf, String titular) {
		super(valor, cpf, titular);
	}

	public CartaoCredito(String numeroCartao, char tipoCartao, Date validade, int codigoSeguranca) {
		setNumeroCartao(numeroCartao);
		setTipoCartao(tipoCartao);
		setValidade(validade);
		setCodigoSeguranca(codigoSeguranca);
	}

	public CartaoCredito(double valor, String cpf, String titular, String numeroCartao, char tipoCartao, Date validade,
			int codigoSeguranca) {
		super(valor, cpf, titular);
		setNumeroCartao(numeroCartao);
		setTipoCartao(tipoCartao);
		setValidade(validade);
		setCodigoSeguranca(codigoSeguranca);
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public char getTipoCartao() {
		return tipoCartao;
	}

	public Date getValidade() {
		return validade;
	}

	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public void setTipoCartao(char tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public void setCodigoSeguranca(int codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}

	public void validar() {

	}

	public boolean enviar() {
		return false;
	}

}
