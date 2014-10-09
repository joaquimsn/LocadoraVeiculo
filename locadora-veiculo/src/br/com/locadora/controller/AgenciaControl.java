
package br.com.locadora.controller;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
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
		// Cria uma nova conexão com o banco de dados
		agenciaDAO = new AgenciaDAO();
		
		agencia.setAtivo(true);
		agencia.setDataCadastro(new Date(Calendar.getInstance().getTimeInMillis()));
		return agenciaDAO.insert(agencia);
	}
	
	/**
	 * Altera uma agência já persistida na base de dados
	 * @author Joaquim Neto
	 * @param agencia Objeto Agência
	 * @return <b>true</b> Se for alterado com sucesso
	 */
	private boolean alterar(Agencia agencia) {
		// Cria uma nova conexão com o banco de dados
		agenciaDAO = new AgenciaDAO();
		agencia.setDataManutencao(new Date(Calendar.getInstance().getTimeInMillis()));
		
		return agenciaDAO.update(agencia);
	}
	
	/**
	 * Busca todas as agências cadastradas na base de dados
	 * @author Joaquim Neto
	 * @return List com todas as agências cadastradas
	 */
	public List<Agencia> buscarTodos() {
		// Cria uma nova conexão com o banco de dados
		agenciaDAO = new AgenciaDAO();		
		return agenciaDAO.pesquisaPorCondicao("");
	}
	
	/**
	 * Busca uma agência na base pelo id informado por parâmetro
	 * @author Joaquim Neto
	 * @param id INT ind
	 * @return Agencia
	 */
	public Agencia buscarPorId(int id) {
		// Cria uma nova conexão com o banco de dados
		agenciaDAO = new AgenciaDAO();
		return agenciaDAO.select(id);
	}
	
	/**
	 * Consulta todas as agências cadastradas na base
	 * @author Joaquim Neto
	 * @param parametro
	 * @param valor
	 * @return List com as agências encontradas
	 */
	public List<Agencia> buscarPorCondicao(int parametro, String valor) {
		// Cria uma nova conexão com o banco de dados
		agenciaDAO = new AgenciaDAO();
		
		String condicao = "";
		
		switch (parametro) {
		case 1:
			condicao = " WHERE " + "id_agencia  = " + valor + ";";
			break;
		
		case 2:
			condicao = " WHERE " + "cnpj  = %" + valor  + ";";
			break;
		
		case 3:
			condicao = " WHERE " + "razao_social  = %'" + valor  + "';";
			break;
			
		default:
			break;
		}	
		
		return agenciaDAO.pesquisaPorCondicao(condicao);
	}
}
