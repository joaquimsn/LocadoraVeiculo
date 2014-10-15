
package br.com.locadora.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.locadora.model.DAO.FuncionarioDAO;
import br.com.locadora.model.entity.Funcionario;
import br.com.locadora.utils.SystemUtils;

public class FuncionarioControl implements Serializable{
	private static final long serialVersionUID = 4056318420856682823L;
	
	private FuncionarioDAO funcionarioDAO;
	
	public FuncionarioControl() {
		funcionarioDAO = new FuncionarioDAO();
	}
	
	/**
	 * Persiste ou altera uma agência na base de dados
	 * @author Joaquim Neto
	 * @param funcionario Objeto Agência
	 * @return <b>true</b> Se for cadastrado/Alterado com sucesso
	 */
	public boolean salvarOuAlterar(Funcionario funcionario) {
		if (!SystemUtils.isNuloOuVazio(funcionario) && funcionario.getId() == 0) {
			return salvar(funcionario);
		} else {
			return alterar(funcionario);
		}
	}
	
	/**
	 * Persiste uma agência na base de dados
	 * @author Joaquim Neto
	 * @param funcionario Objeto Agência
	 * @return <b>true</b> Se for cadastrado com sucesso
	 */
	private boolean salvar(Funcionario funcionario) {
		// Cria uma nova conexão com o banco de dados
		funcionarioDAO = new FuncionarioDAO();
		
		funcionario.setAtivo(true);
		funcionario.setDataCadastro(new Date());
		return funcionarioDAO.insert(funcionario);
	}
	
	/**
	 * Altera uma agência já persistida na base de dados
	 * @author Joaquim Neto
	 * @param funcionario Objeto Agência
	 * @return <b>true</b> Se for alterado com sucesso
	 */
	private boolean alterar(Funcionario funcionario) {
		// Cria uma nova conexão com o banco de dados
		funcionarioDAO = new FuncionarioDAO();
		funcionario.setDataManutencao(new Date());
		
		return funcionarioDAO.update(funcionario);
	}
	
	/**
	 * Busca todas as agências cadastradas na base de dados
	 * @author Joaquim Neto
	 * @return List com todas as agências cadastradas
	 */
	public List<Funcionario> buscarTodos() {
		// Cria uma nova conexão com o banco de dados
		funcionarioDAO = new FuncionarioDAO();		
		return funcionarioDAO.pesquisarPorCondicao("");
	}
	
	/**
	 * Busca uma agência na base pelo id informado por parâmetro
	 * @author Joaquim Neto
	 * @param id INT ind
	 * @return Funcionario
	 */
	public Funcionario buscarPorId(int id) {
		// Cria uma nova conexão com o banco de dados
		funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.select(id);
	}
	
	public Funcionario buscarPorUsuario(String usuario) {
		funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.selectByUser(usuario);
	}
	
	public List<Funcionario> buscarTodosSupervisor() {
		funcionarioDAO = new FuncionarioDAO();
		return funcionarioDAO.selectAllSupervisor();
	}
	
	/**
	 * Consulta todas as agências cadastradas na base
	 * @author Joaquim Neto
	 * @param parametro
	 * @param valor
	 * @return List com as agências encontradas
	 */
	public List<Funcionario> buscarPorCondicao(int parametro, String valor) {
		// Cria uma nova conexão com o banco de dados
		funcionarioDAO = new FuncionarioDAO();
		
		String condicao = "";
		
		switch (parametro) {
		case 1:
			condicao = " WHERE ativo = 1";
			break;
		case 2:
			condicao = " WHERE " + "id_funcionario  = " + valor + " AND ativo = 1";
			break;
		
		case 3:
			condicao = " WHERE " + "cpf  LIKE '" + valor  + "%' AND ativo = 1";
			break;
		
		case 4:
			condicao = " WHERE " + "nome LIKE '" + valor + "%' AND ativo = 1";
			break;
		
		case 5:
			condicao = " WHERE " + "usuario LIKE '" + valor + "%' AND ativo = 1";
			break;
			
		default:
			condicao = " WHERE ativo = 1";
			break;
		}	
		
		return funcionarioDAO.pesquisarPorCondicao(condicao);
	}
	
	/**
	 * Adiciona o funcionário a sessão do sistema ao realizar o login
	 * @author Joaquim Neto
	 * @param usuario String nome do usuário
	 * @return <b>true</b> Se existe funcionário cadastrado com o usuário
	 * passado por parâmetro
	 */
	public boolean adicionarFuncionarioNaSessao(String usuario) {
		// Busca o funcionário na base de dados
		Funcionario funcionario = buscarPorUsuario(usuario);
		
		// Verifica se o funcionario está cadastrado
		if (!SystemUtils.isNuloOuVazio(funcionario)) {
			SystemUtils.setFuncionarioLogado(funcionario);
			return true;
		}
		
		return false;
	}
}
