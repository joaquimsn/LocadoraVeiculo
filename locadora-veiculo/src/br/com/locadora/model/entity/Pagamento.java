package br.com.locadora.model.entity;
public class Pagamento {
	private double valor;
	private String cpf;
	private String titular;
	public Pagamento(double valor, String cpf, String titular){
		setValor(valor);
		setCpf(cpf);
		setTitular(titular);
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
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
