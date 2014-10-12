package br.com.locadora.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.connection.MysqlConnect;
import br.com.locadora.model.vo.Endereco;

public class EnderecoDAO extends MysqlConnect{

	/**
	 * Retorna um objeto Endereco com as informações encontradas 
	 * a partir do CEP fornecido
	 * @author Renan Baggio
	 * @param cep String
	 * @return Endereco
	 * @throws SQLException
	 */
	public Endereco buscarEndereco(String cep) {
		Endereco endereco = new Endereco();
		
		try {
			// Pesquisando o endereço
			PreparedStatement query = conn.prepareStatement(
					"SELECT * FROM endereco WHERE cep = '" + cep + "'");
			
			ResultSet rs = query.executeQuery();
			if(rs.next()) {
				endereco.setLogradouro(rs.getString("endereco").toUpperCase());
				endereco.setIdBairro(rs.getInt("id_bairro"));
				endereco.setIdCidade(rs.getInt("id_cidade"));
				endereco.setCep(cep);
				// Pesquisando a cidade
				query = conn.prepareStatement(
						"SELECT cidade, uf FROM cidade WHERE id_cidade = '" + endereco.getIdCidade() + 
						"' AND codigo_ibge <> 0");
				rs = query.executeQuery();
				
				if(rs.next()) {
					endereco.setCidade(rs.getString("cidade").toUpperCase());
					endereco.setUf(rs.getString("uf").toUpperCase());
				} else {
					return null;
				}
				
				// Pesquisando o bairro
				query = conn.prepareStatement(
						"SELECT bairro FROM bairro WHERE id_bairro = '" + endereco.getIdBairro() + "'");
				rs = query.executeQuery();
				
				if(rs.next()) endereco.setBairro(rs.getString("bairro").toUpperCase());
				
				return endereco;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Encerrando a conexão
			closeConnection();
		}
		
		return null;
	}
	
	/**
	 * Retorna uma lista com todas as cidades do Brasil cadastradas
	 * @author Renan Baggio
	 * @return listaCidades
	 * @throws SQLException
	 */
	public List<String> buscarTodasCidadesString() {
		List<String> listaCidades = new ArrayList<String>();
			
		try {
			// Select que pesquisa todas as cidades
			PreparedStatement query = conn.prepareStatement("SELECT cidade FROM cidade " +
					"ORDER BY cidade ASC");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()) {
				listaCidades.add(rs.getString("cidade").toUpperCase());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Encerrando a conexão
			closeConnection();
		}
		
		// Retorna a lista com todas as cidades consultadas
		return listaCidades;
	}
	
	/**
	 * Retorna uma lista com todas as cidades pertencentes à UF
	 * @author Renan Baggio
	 * @return listaCidades
	 * @throws SQLException
	 */
	public List<String> buscarTodasCidadesDaUf(String uf) {
		List<String> listaCidades = new ArrayList<String>();

		try {
			// Select que pesquisa todas as cidades
			PreparedStatement query = conn.prepareStatement("SELECT * FROM cidade " +
					"WHERE uf = '" + uf + "' ORDER BY cidade ASC");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()) {
				listaCidades.add(rs.getString("cidade").toUpperCase());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Encerrando a conexão
			closeConnection();
		}
		
		// Retorna a lista com todas as cidades consultadas
		return listaCidades;
	}
	
	/**
	 * Retorna uma lista com todas as UFs do Brasil cadastradas
	 * @author Renan Baggio
	 * @return listaUfs
	 * @throws SQLException
	 */
	public List<String> buscarTodasUfs() {
		List<String> listaUfs = new ArrayList<String>();
			
		try {
			// Select que pesquisa todas as cidades
			PreparedStatement query = conn.prepareStatement("SELECT uf FROM uf");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()) {
				listaUfs.add(rs.getString("uf"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Encerrando a conexão
			closeConnection();
		}
		
		// Retorna a lista com todas as cidades consultadas
		return listaUfs;
	}
	
	/**
	 * Consulta o ID da cidade pelo nome da cidade e UF
	 * @author Renan Baggio
	 * @param idCidade
	 * @return ID da cidade
	 * @throws SQLException
	 */
	public int buscarIdCidade(String cidade, String uf) {
		int idCidade = 0;
		
		try {
			// Select que pesquisa a cidade solicitada
			PreparedStatement query = conn.prepareStatement(
					"SELECT id_cidade FROM cidade WHERE UPPER(cidade) = '" + cidade + "' AND UPPER(uf) = '" + uf + "';");
			ResultSet rs = query.executeQuery();
			
			if(rs.next()) {
				idCidade = rs.getInt("id_cidade");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Encerrando a conexão
			closeConnection();
		}
		
		return idCidade;
	}
}
