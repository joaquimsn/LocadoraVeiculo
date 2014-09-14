package br.com.locadora.model.entity;
import java.util.Date;
public class Devolucao {
	private Date dataDevolucao;
	private int agenciaDevolucao;
	private double acrescimo;
	private double kmDevolucao;
	private Pagamento pagamento;
	private Veiculo veiculo;
	
	public Devolucao(){
		setDataDevolucao(null);
		setAgenciaDevolucao(0);
		setAcrescimo(0.0);
		setKmDevolucao(0.0);
		setPagamento(null);
		setVeiculo(null);
	}
	
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public int getAgenciaDevolucao() {
		return agenciaDevolucao;
	}
	public void setAgenciaDevolucao(int agenciaDevolucao) {
		this.agenciaDevolucao = agenciaDevolucao;
	}
	public double getAcrescimo() {
		return acrescimo;
	}
	public void setAcrescimo(double acrescimo) {
		this.acrescimo = acrescimo;
	}
	public double getKmDevolucao() {
		return kmDevolucao;
	}
	public void setKmDevolucao(double kmDevolucao) {
		this.kmDevolucao = kmDevolucao;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public void devolver() {

	}

}
