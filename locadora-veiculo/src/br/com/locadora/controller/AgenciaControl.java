
package br.com.locadora.controller;

import java.io.Serializable;
import java.util.List;

import br.com.locadora.model.DAO.AgenciaDAO;
import br.com.locadora.model.entity.Agencia;
import br.com.locadora.utils.SystemUtils;

public class AgenciaControl implements Serializable{
	private static final long serialVersionUID = 4056318420856682823L;
	
	private AgenciaDAO agenciaDAO;
	
	public AgenciaControl() {
		agenciaDAO = new AgenciaDAO();
	}
	
	/**
	 * Persiste ou altera uma agência na base de dados
	 * @author Joaquim Neto
	 * @param agencia Objeto Agência
	 * @return <b>true</b> Se for cadastrado/Alterado com sucesso
	 */
	public boolean salvarOuAlterar(Agencia agencia) {
		if (!SystemUtils.isNuloOuVazio(agencia) && agencia.getIdAgencia() == 0) {
			return salvar(agencia);
		} else {
			return alterar(agencia);
		}
	}
	
	/**
	 * Persiste uma agência na base de dados
	 * @author Joaquim Neto
	 * @param agencia Objeto Agência
	 * @return <b>true</b> Se for cadastrado com sucesso
	 */
	private boolean salvar(Agencia agencia) {
		return agenciaDAO.insert(agencia);
	}
	
	/**
	 * Altera uma agência já persistida na base de dados
	 * @author Joaquim Neto
	 * @param agencia Objeto Agência
	 * @return <b>true</b> Se for alterado com sucesso
	 */
	private boolean alterar(Agencia agencia) {
		agenciaDAO.update(agencia);
		
		return true;
	}
	
	/**
	 * Busca todas as agências cadastradas na base de dados
	 * @author Joaquim Neto
	 * @return List com todas as agências cadastradas
	 */
	public List<Agencia> buscarTodos() {
		return null;
	}
	
	/**
	 * Busca uma agência na base pelo id informado por parâmetro
	 * @author Joaquim Neto
	 * @param id INT ind
	 * @return Agencia
	 */
	public Agencia buscarPorId(int id) {
		return null;
	}
	
	public List<Agencia> buscarPorCondicao(int parametro, String valor) {
		String condicao = "";
		if (parametro == 1) {
			condicao = "WHERE " + "id_agencia  = " + valor;
			agenciaDAO.pesquisaPorCondicao(condicao);
		}
		
		
		return null;
	}
}
