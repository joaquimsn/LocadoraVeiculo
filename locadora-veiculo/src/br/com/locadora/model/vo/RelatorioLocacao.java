package br.com.locadora.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.locadora.model.entity.Agencia;
import br.com.locadora.model.entity.Funcionario;
import br.com.locadora.model.entity.Locacao;

public class RelatorioLocacao {
	
	private Agencia agencia;
	private Funcionario funcionario;
	private Date periodoInicial;
	private Date periodoFinal;
	
	private List<Locacao> listaLocacao;
	
	public RelatorioLocacao() {
		listaLocacao = new ArrayList<Locacao>();
	}

	/**
	 * @return the agencia
	 */
	public Agencia getAgencia() {
		return agencia;
	}

	/**
	 * @param agencia the agencia to set
	 */
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the periodoInicial
	 */
	public Date getPeriodoInicial() {
		return periodoInicial;
	}

	/**
	 * @param periodoInicial the periodoInicial to set
	 */
	public void setPeriodoInicial(Date periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	/**
	 * @return the periodoFinal
	 */
	public Date getPeriodoFinal() {
		return periodoFinal;
	}

	/**
	 * @param periodoFinal the periodoFinal to set
	 */
	public void setPeriodoFinal(Date periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	/**
	 * @return the listaLocacao
	 */
	public List<Locacao> getListaLocacao() {
		return listaLocacao;
	}

	/**
	 * @param listaLocacao the listaLocacao to set
	 */
	public void setListaLocacao(List<Locacao> listaLocacao) {
		this.listaLocacao = listaLocacao;
	}

}
