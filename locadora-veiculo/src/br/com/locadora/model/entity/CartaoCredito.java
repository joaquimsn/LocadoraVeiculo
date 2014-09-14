package br.com.locadora.model.entity;
import java.util.Date;
public class CartaoCredito extends Pagamento {
	private int numeroCartao;
	private char tipoCartao;
	private Date validade;
	private int codigoSeguranca;

	public CartaoCredito(){
		super(0.0, "", "");
		setNumeroCartao(0);
		setTipoCartao(' ');
		setValidade(null);
		setCodigoSeguranca(0);
	}
	
	public CartaoCredito(double valor, String cpf, String titular){
		super(valor, cpf, titular);
	}
	
	public CartaoCredito(int numeroCartao, char tipoCartao, Date validade, int codigoSeguranca){
		setNumeroCartao(numeroCartao);
		setTipoCartao(tipoCartao);
		setValidade(validade);
		setCodigoSeguranca(codigoSeguranca);
	}
	
	public CartaoCredito(double valor, String cpf, String titular, 
						int numeroCartao, char tipoCartao, Date validade, 
						int codigoSeguranca){
		super(valor, cpf, titular);
		setNumeroCartao(numeroCartao);
		setTipoCartao(tipoCartao);
		setValidade(validade);
		setCodigoSeguranca(codigoSeguranca);
	}
	
	public int getNumeroCartao() {return numeroCartao;}
	public char getTipoCartao() {return tipoCartao;}
	public Date getValidade() {return validade;}
	public int getCodigoSeguranca() {return codigoSeguranca;}
	public void setNumeroCartao(int numeroCartao) {this.numeroCartao = numeroCartao;}
	public void setTipoCartao(char tipoCartao) {this.tipoCartao = tipoCartao;}
	public void setValidade(Date validade) {this.validade = validade;}
	public void setCodigoSeguranca(int codigoSeguranca) {this.codigoSeguranca = codigoSeguranca;}

	

	

	

	public void validar() {

	}

	public boolean enviar() {
		return false;
	}

}
