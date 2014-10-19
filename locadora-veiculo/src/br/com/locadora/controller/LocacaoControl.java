
package br.com.locadora.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.locadora.model.DAO.LocacaoDAO;
import br.com.locadora.model.entity.Locacao;
import br.com.locadora.utils.SystemUtils;

public class LocacaoControl implements Serializable{
	private static final long serialVersionUID = 4056318420856682823L;
	
	private LocacaoDAO locacaoDAO;
	
//	public LocacaoControl() {
//		locacaoDAO = new LocacaoDAO();
//	}
//	
//	/**
//	 * Persiste ou altera uma agência na base de dados
//	 * @author Joaquim Neto
//	 * @param locacao Objeto Agência
//	 * @return <b>true</b> Se for cadastrado/Alterado com sucesso
//	 */
//	public boolean salvarOuAlterar(Locacao locacao) {
//		if (!SystemUtils.isNuloOuVazio(locacao) && locacao.getIdLocacao() == 0) {
//			return salvar(locacao);
//		} else {
//			return alterar(locacao);
//		}
//	}
//	
//	/**
//	 * Persiste uma agência na base de dados
//	 * @author Joaquim Neto
//	 * @param locacao Objeto Agência
//	 * @return <b>true</b> Se for cadastrado com sucesso
//	 */
//	private boolean salvar(Locacao locacao) {
//		// Cria uma nova conexão com o banco de dados
//		locacaoDAO = new LocacaoDAO();
//		
//		locacao.setAtivo(true);
//		locacao.setDataCadastro(new Date());
//		return locacaoDAO.insert(locacao);
//	}
//	
//	/**
//	 * Altera uma agência já persistida na base de dados
//	 * @author Joaquim Neto
//	 * @param locacao Objeto Agência
//	 * @return <b>true</b> Se for alterado com sucesso
//	 */
//	private boolean alterar(Locacao locacao) {
//		// Cria uma nova conexão com o banco de dados
//		locacaoDAO = new LocacaoDAO();
//		locacao.setDataManutencao(new Date());
//		
//		return locacaoDAO.update(locacao);
//	}
//	
//	/**
//	 * Busca todas as agências cadastradas na base de dados
//	 * @author Joaquim Neto
//	 * @return List com todas as agências cadastradas
//	 */
//	public List<Locacao> buscarTodos() {
//		// Cria uma nova conexão com o banco de dados
//		locacaoDAO = new LocacaoDAO();		
//		return locacaoDAO.pesquisarPorCondicao("");
//	}
//	
//	/**
//	 * Busca uma agência na base pelo id informado por parâmetro
//	 * @author Joaquim Neto
//	 * @param id INT ind
//	 * @return Locacao
//	 */
//	public Locacao buscarPorId(int id) {
//		// Cria uma nova conexão com o banco de dados
//		locacaoDAO = new LocacaoDAO();
//		return locacaoDAO.select(id);
//	}
//	
//	/**
//	 * Consulta todas as agências cadastradas na base
//	 * @author Joaquim Neto
//	 * @param parametro
//	 * @param valor
//	 * @return List com as agências encontradas
//	 */
//	public List<Locacao> buscarPorCondicao(int parametro, String valor) {
//		// Cria uma nova conexão com o banco de dados
//		locacaoDAO = new LocacaoDAO();
//		
//		String condicao = "";
//		
//		switch (parametro) {
//		case 1:
//			condicao = " WHERE ativo = 1";
//			break;
//		case 2:
//			condicao = " WHERE " + "id_locacao  = " + valor + " AND ativo = 1";
//			break;
//		
//		case 3:
//			condicao = " WHERE " + "cnpj  LIKE '" + valor  + "%' AND ativo = 1";
//			break;
//		
//		case 4:
//			condicao = " WHERE " + "razao_social LIKE '" + valor + "%' AND ativo = 1";
//			break;
//			
//		default:
//			condicao = " WHERE ativo = 1";
//			break;
//		}	
//		
//		return locacaoDAO.pesquisarPorCondicao(condicao);
//	}
}
