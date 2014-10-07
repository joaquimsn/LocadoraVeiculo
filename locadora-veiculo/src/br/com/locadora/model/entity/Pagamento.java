package br.com.locadora.model.entity;

public class Pagamento {
	private int id;
	private double valor;
	private String tipoPagamento;
	private String cpf;
	private String titular;

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

	public void pagar() {

	}

}
