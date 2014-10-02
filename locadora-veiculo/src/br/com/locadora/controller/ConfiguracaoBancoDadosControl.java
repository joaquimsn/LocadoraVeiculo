package br.com.locadora.controller;

import java.io.Serializable;

import br.com.locadora.model.connection.ConfiguracaoDinamnicaBD;
import br.com.locadora.model.vo.ParametrosConexao;

public class ConfiguracaoBancoDadosControl implements Serializable{
	private static final long serialVersionUID = 2145021853309195897L;
	
	private ConfiguracaoDinamnicaBD configuracao;
	
	public ConfiguracaoBancoDadosControl() {
		configuracao = new ConfiguracaoDinamnicaBD();
	}
	
	/**
	 * Altera as configurações de comunicação com o banco de dados
	 * @author Joaquim Neto
	 * @param parametrosConexao Objeto ParametrosConexao
	 */
	public void salvar(ParametrosConexao parametrosConexao) {
		configuracao.salvarParametrosConexao(parametrosConexao);
	}
}
