
package br.com.locadora.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.locadora.model.DAO.VeiculoDAO;
import br.com.locadora.model.entity.Veiculo;
import br.com.locadora.utils.SystemUtils;

public class VeiculoControl implements Serializable{
	private static final long serialVersionUID = 4056318420856682823L;
	
	private VeiculoDAO veiculoDAO;
	
	public VeiculoControl() {
		veiculoDAO = new VeiculoDAO();
	}
	
	/**
	 * Persiste ou altera uma veículo na base de dados
	 * @author Joaquim Neto
	 * @param veiculo Objeto Veículo
	 * @return <b>true</b> Se for cadastrado/Alterado com sucesso
	 */
	public boolean salvarOuAlterar(Veiculo veiculo) {
		if (!SystemUtils.isNuloOuVazio(veiculo) && veiculo.getId() == 0) {
			return salvar(veiculo);
		} else {
			return alterar(veiculo);
		}
	}
	
	/**
	 * Persiste uma veículo na base de dados
	 * @author Joaquim Neto
	 * @param veiculo Objeto Veículo
	 * @return <b>true</b> Se for cadastrado com sucesso
	 */
	private boolean salvar(Veiculo veiculo) {
		// Cria uma nova conexão com o banco de dados
		veiculoDAO = new VeiculoDAO();
		
		// Associa a veículo e o funcionario ao veiculo cadastrado
		veiculo.setIdAgencia(SystemUtils.getFuncionarioLogado().getCodigoAgencia());
		veiculo.setIdFuncionario(SystemUtils.getFuncionarioLogado().getId());
		
		veiculo.setAtivo(true);
		veiculo.setDataCadastro(new Date());
		return veiculoDAO.insert(veiculo);
	}
	
	/**
	 * Altera uma veículo já persistida na base de dados
	 * @author Joaquim Neto
	 * @param veiculo Objeto Veículo
	 * @return <b>true</b> Se for alterado com sucesso
	 */
	private boolean alterar(Veiculo veiculo) {
		// Cria uma nova conexão com o banco de dados
		veiculoDAO = new VeiculoDAO();
		veiculo.setDataManutencao(new Date());
		
		return veiculoDAO.update(veiculo);
	}
	
	/**
	 * Busca todas as veículos cadastradas na base de dados
	 * @author Joaquim Neto
	 * @return List com todas as veículos cadastradas
	 */
	public List<Veiculo> buscarTodos() {
		// Cria uma nova conexão com o banco de dados
		veiculoDAO = new VeiculoDAO();		
		return veiculoDAO.pesquisarPorCondicao("");
	}
	
	/**
	 * Busca uma veículo na base pelo id informado por parâmetro
	 * @author Joaquim Neto
	 * @param id INT ind
	 * @return Veiculo
	 */
	public Veiculo buscarPorId(int id) {
		// Cria uma nova conexão com o banco de dados
		veiculoDAO = new VeiculoDAO();
		return veiculoDAO.select(id);
	}
	
	/**
	 * Consulta todas as veículos cadastradas na base
	 * @author Joaquim Neto
	 * @param parametro
	 * @param valor
	 * @return List com as veículos encontradas
	 */
	public List<Veiculo> buscarPorCondicao(int parametro, String valor) {
		// Cria uma nova conexão com o banco de dados
		veiculoDAO = new VeiculoDAO();
		
		String condicao = "";
		
		switch (parametro) {
		case 1:
			condicao = " WHERE ativo = 1";
			break;
		case 2:
			condicao = " WHERE " + "id_veiculo  = " + valor + " AND ativo = 1";
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
		
		return veiculoDAO.pesquisarPorCondicao(condicao);
	}
}
