package br.com.locadora.model.entity;

import java.util.Date;

public class Locacao {
	public int id;
	private Date dataHoraLocacao;
	private Date dataHoraPrevistaDevolucao;
	private Date dataHoraDevolucao;
	private int agenciaDevolucao;
	private int tipoTarifa;
	private double kmLocacao;
	private double kmDevolucao;
	private double valor;
	private double valorAcrescimo;
	private int status;
	private Veiculo veiculo;
	private Pagamento pagamento;
	private Cliente cliente;
	private int idAgencia;
	private int idFuncionario;
	private Agencia objetoAgenciaPrevistaDevolucao;

	public Locacao() {
		setDataHoraLocacao(null);
		setDataHoraDevolucao(null);
		setAgenciaDevolucao(0);
		setTipoTarifa(0);
		setKmLocacao(0.0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDataHoraPrevistaDevolucao() {
		return dataHoraPrevistaDevolucao;
	}

	public void setDataHoraPrevistaDevolucao(Date dataHoraPrevistaDevolucao) {
		this.dataHoraPrevistaDevolucao = dataHoraPrevistaDevolucao;
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

	public double getKmDevolucao() {
		return kmDevolucao;
	}

	public void setKmDevolucao(double kmDevolucao) {
		this.kmDevolucao = kmDevolucao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorAcrescimo() {
		return valorAcrescimo;
	}

	public void setValorAcrescimo(double valorAcrescimo) {
		this.valorAcrescimo = valorAcrescimo;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the idPagamento
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	/**
	 * @param pagamento the pagamento to set
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	/**
	 * @return the idCliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param Cliente the Cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the Veiculo
	 */
	public Veiculo getVeiculo() {
		return veiculo;
	}

	/**
	 * @param veiculo the Veiculo to set
	 */
	public void setIdVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	/**
	 * @return the idAgencia
	 */
	public int getIdAgencia() {
		return idAgencia;
	}

	/**
	 * @param idAgencia the idAgencia to set
	 */
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}

	/**
	 * @return the idFuncionario
	 */
	public int getIdFuncionario() {
		return idFuncionario;
	}

	/**
	 * @param idFuncionario the idFuncionario to set
	 */
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	/**
	 * @return the agenciaPrevisaDevolucao
	 */
	public Agencia getObjetoAgenciaDevolucao() {
		return objetoAgenciaPrevistaDevolucao;
	}

	/**
	 * @param agenciaPrevistaDevolucao the agenciaPrevisaDevolucao to set
	 */
	public void setObjetoAgenciaDevolucao(Agencia agenciaPrevistaDevolucao) {
		objetoAgenciaPrevistaDevolucao = agenciaPrevistaDevolucao;
	}
	
}
