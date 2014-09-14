package br.com.locadora.model.entity;
public class CartaoDebito extends Pagamento {
	private int banco;
	private int agencia;
	private int tipoConta;
	private String telefone;
	public CartaoDebito(double valor, String cpf, String titular, int banco, int agencia, int tipoConta, String telefone){
		super(valor, cpf, titular);
		setBanco(banco);
		setAgencia(agencia);
		setTipoConta(tipoConta);
		setTelefone(telefone);
	}
	
	public int getBanco() {return banco;}
	public int getAgencia() {return agencia;}
	public int getTipoConta() {return tipoConta;}
	public String getTelefone() {return telefone;}
	public void setBanco(int banco) {this.banco = banco;}
	public void setAgencia(int agencia) {this.agencia = agencia;}
	public void setTipoConta(int tipoConta) {this.tipoConta = tipoConta;}
	public void setTelefone(String telefone) {this.telefone = telefone;}
	public void validar() {
	}
	public boolean enviar() {
		return false;
	}

}
