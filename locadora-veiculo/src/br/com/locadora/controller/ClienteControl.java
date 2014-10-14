
package br.com.locadora.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.locadora.model.DAO.ClienteDAO;
import br.com.locadora.model.entity.Cliente;
import br.com.locadora.utils.SystemUtils;

public class ClienteControl implements Serializable{
	private static final long serialVersionUID = 4056318420856682823L;
	
	private ClienteDAO clienteDAO;
	
	public ClienteControl() {
		clienteDAO = new ClienteDAO();
	}
	
	/**
	 * Persiste ou altera uma agência na base de dados
	 * @author Joaquim Neto
	 * @param cliente Objeto Agência
	 * @return <b>true</b> Se for cadastrado/Alterado com sucesso
	 */
	public boolean salvarOuAlterar(Cliente cliente) {
		if (!SystemUtils.isNuloOuVazio(cliente) && cliente.getId() == 0) {
			return salvar(cliente);
		} else {
			return alterar(cliente);
		}
	}
	
	/**
	 * Persiste uma agência na base de dados
	 * @author Joaquim Neto
	 * @param cliente Objeto Agência
	 * @return <b>true</b> Se for cadastrado com sucesso
	 */
	private boolean salvar(Cliente cliente) {
		// Cria uma nova conexão com o banco de dados
		clienteDAO = new ClienteDAO();
		
		// Associa a agência e o funcionario ao cliente cadastrado
		cliente.setIdAgencia(SystemUtils.getFuncionarioLogado().getCodigoAgencia());
		cliente.setIdFuncionario(SystemUtils.getFuncionarioLogado().getId());
		
		cliente.setAtivo(true);
		cliente.setDataCadastro(new Date());
		return clienteDAO.insert(cliente);
	}
	
	/**
	 * Altera uma agência já persistida na base de dados
	 * @author Joaquim Neto
	 * @param cliente Objeto Agência
	 * @return <b>true</b> Se for alterado com sucesso
	 */
	private boolean alterar(Cliente cliente) {
		// Cria uma nova conexão com o banco de dados
		clienteDAO = new ClienteDAO();
		cliente.setDataManutencao(new Date());
		
		return clienteDAO.update(cliente);
	}
	
	/**
	 * Busca todas as agências cadastradas na base de dados
	 * @author Joaquim Neto
	 * @return List com todas as agências cadastradas
	 */
	public List<Cliente> buscarTodos() {
		// Cria uma nova conexão com o banco de dados
		clienteDAO = new ClienteDAO();		
		return clienteDAO.pesquisarPorCondicao("");
	}
	
	/**
	 * Busca uma agência na base pelo id informado por parâmetro
	 * @author Joaquim Neto
	 * @param id INT ind
	 * @return Cliente
	 */
	public Cliente buscarPorId(int id) {
		// Cria uma nova conexão com o banco de dados
		clienteDAO = new ClienteDAO();
		return clienteDAO.select(id);
	}
	
	/**
	 * Consulta todas as agências cadastradas na base
	 * @author Joaquim Neto
	 * @param parametro
	 * @param valor
	 * @return List com as agências encontradas
	 */
	public List<Cliente> buscarPorCondicao(int parametro, String valor) {
		// Cria uma nova conexão com o banco de dados
		clienteDAO = new ClienteDAO();
		
		String condicao = "";
		
		switch (parametro) {
		case 1:
			condicao = " WHERE ativo = 1";
			break;
		case 2:
			condicao = " WHERE " + "id_cliente  = " + valor + " AND ativo = 1";
			break;
		
		case 3:
			condicao = " WHERE " + "cnh  LIKE '" + valor  + "%' AND ativo = 1";
			break;
		
		case 4:
			condicao = " WHERE " + "nome LIKE '" + valor + "%' AND ativo = 1";
			break;
		
		case 5:
			condicao = " WHERE " + "email LIKE '" + valor + "%' AND ativo = 1";
			break;
			
		default:
			condicao = " WHERE ativo = 1";
			break;
		}	
		
		return clienteDAO.pesquisarPorCondicao(condicao);
	}
}
