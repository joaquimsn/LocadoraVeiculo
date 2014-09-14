package br.com.locadora.model.entity;
import java.util.Date;
import java.util.List;

public class Locacao {
	private int numeroLocacao;
	private Date dataHoraLocacao;
	private Date dataHoraDevolucao;
	private int agenciaDevolucao;
	private int tipoTarifa;
	private double kmLocacao;
	private Pagamento pagamento;
	private Devolucao devolucao;
	private Cliente cliente;
	public Locacao(int numeroLocacao, Date dataHoraLocacao, Date dataHoraDevolucao, 
					int agenciaDevolucao, int tipoTarifa, double kmLocacao, 
					Pagamento pagamento, Devolucao devolucao, Cliente cliente){
		setNumeroLocacao(numeroLocacao);
		setDataHoraLocacao(dataHoraLocacao);
		setDataHoraDevolucao(dataHoraDevolucao);
		setAgenciaDevolucao(agenciaDevolucao);
		setTipoTarifa(tipoTarifa);
		setKmLocacao(kmLocacao);
		setPagamento(pagamento);
		setDevolucao(devolucao);
		setCliente(cliente);
	}
	public int getNumeroLocacao() {
		return numeroLocacao;
	}
	public void setNumeroLocacao(int numeroLocacao) {
		this.numeroLocacao = numeroLocacao;
	}
	public Date getDataHoraLocacao() {
		return dataHoraLocacao;
	}
	public void setDataHoraLocacao(Date dataHoraLocacao) {
		this.dataHoraLocacao = dataHoraLocacao;
	}
	public Date getDataHoraDevolucao() {
		return dataHoraDevolucao;
	}
	public void setDataHoraDevolucao(Date dataHoraDevolucao) {
		this.dataHoraDevolucao = dataHoraDevolucao;
	}
	public int getAgenciaDevolucao() {
		return agenciaDevolucao;
	}
	public void setAgenciaDevolucao(int agenciaDevolucao) {
		this.agenciaDevolucao = agenciaDevolucao;
	}
	public int getTipoTarifa() {
		return tipoTarifa;
	}
	public void setTipoTarifa(int tipoTarifa) {
		this.tipoTarifa = tipoTarifa;
	}
	public double getKmLocacao() {
		return kmLocacao;
	}
	public void setKmLocacao(double kmLocacao) {
		this.kmLocacao = kmLocacao;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Devolucao getDevolucao() {
		return devolucao;
	}
	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void consultar() {
	}
	public void locar() {
	}
	public List<Locacao> consultarLocacaoDiaria() {
		return null;
	}

}
