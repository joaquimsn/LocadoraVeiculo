package br.com.locadora.controller;

import java.io.Serializable;
import java.util.List;

import br.com.locadora.model.DAO.EnderecoDAO;
import br.com.locadora.model.vo.Endereco;

public class EnderecoControl implements Serializable {
	private static final long serialVersionUID = -7945469051757178860L;
	
	private EnderecoDAO enderecoDAO;
	
	/**
	 * Busca todas as UFs
	 * @author Joaquim Neto
	 * @param uf String
	 * @return Lista com todas as unidades da federação
	 */
	public List<String> buscarCidadePorUf(String uf) {
		enderecoDAO = new EnderecoDAO();
		return  enderecoDAO.buscarTodasCidadesDaUf(uf);
	}
	
	/**
	 * Busca um endereço pelo cep informado por parâmetro
	 * @author Joaquim Neto
	 * @param cep String cep
	 * @return Objeto Endereço
	 */
	public Endereco buscarEnderecoPorCep(String cep) {
		enderecoDAO = new EnderecoDAO();
		String[] cepAux = cep.split("[^0-9]");
		return enderecoDAO.buscarEndereco(cepAux[0] + cepAux[1]);
	}
}
