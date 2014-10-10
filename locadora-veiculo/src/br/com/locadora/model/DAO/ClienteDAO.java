package br.com.locadora.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.connection.MysqlConnect;
import br.com.locadora.model.entity.Cliente;

public class ClienteDAO extends MysqlConnect{

	public Cliente select(int id) {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		
		try{
			String sql = "SELECT * FROM cliente where id_cliente=?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setInt(1, id);
			resultSet = sqlSt.executeQuery();
			Cliente resultado = new Cliente();
			
			if (resultSet.next()){
				resultado.setId(resultSet.getInt(1));
				resultado.setNome(resultSet.getString(2));
				resultado.setDataNascimento(resultSet.getDate(3));
				resultado.setCpf(resultSet.getString(4));
				resultado.setRg(resultSet.getString(5));
				resultado.setCnh(resultSet.getString(6));
				resultado.setValidadeCnh(resultSet.getDate(7));
				resultado.setEstadoEmissor(resultSet.getString(8));
				resultado.setGenero(resultSet.getInt(9));
				resultado.setLogradouro(resultSet.getString(10));
				resultado.setBairro(resultSet.getString(11));
				resultado.setNumero(resultSet.getInt(12));
				resultado.setCep(resultSet.getString(13));
				resultado.setCidade(resultSet.getString(14));
				resultado.setUf(resultSet.getString(15));
				resultado.setTelefone(resultSet.getString(16));
				resultado.setEmail(resultSet.getString(17));
				resultado.setIdAgencia(resultSet.getInt(18));
			}
			return resultado;
		} catch(Exception selectError) {
			selectError.printStackTrace();
			return null;
		} finally {
			closeConnection();
		}
	}

	public boolean update(Cliente cliente) {
		PreparedStatement sqlSt;
		try{
			String sql = "update cliente"
					+ " set"
					+ "nome=?,"
					+ "data_nascimento=?,"
					+ "cpf=?,"
					+ "rg=?,"
					+ "cnh=?,"
					+ "validadecnh=?,"
					+ "estado_emissor=?,"
					+ "genero=?,"
					+ "logradouro=?,"
					+ "bairro=?,"
					+ "numero=?,"
					+ "cep=?,"
					+ "cidade=?,"
					+ "uf=?,"
					+ "telefone=?,"
					+ "email=?,"
					+ "id_agencia=?"
					+ " where id_cliente=?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1,  cliente.getNome());
			sqlSt.setDate(2, new java.sql.Date(cliente.getDataNascimento().getTime()));
			sqlSt.setString(3,  cliente.getCpf());
			sqlSt.setString(4, cliente.getRg());
			sqlSt.setString(5, cliente.getCnh());
			sqlSt.setDate(5, new java.sql.Date(cliente.getValidadeCnh().getTime()));
			sqlSt.setString(6, cliente.getEstadoEmissor());
			sqlSt.setInt(7, cliente.getGenero());
			sqlSt.setString(8, cliente.getLogradouro());
			sqlSt.setString(9, cliente.getBairro());
			sqlSt.setInt(10, cliente.getNumero());
			sqlSt.setString(11, cliente.getCep());
			sqlSt.setString(12, cliente.getCidade());
			sqlSt.setString(13, cliente.getUf());
			sqlSt.setString(14, cliente.getTelefone());
			sqlSt.setString(15, cliente.getEmail());
			sqlSt.setInt(16, cliente.getIdAgencia());
			sqlSt.setInt(17, cliente.getId());
			sqlSt.execute();
			return true;
		}catch(Exception selectError){
			selectError.printStackTrace();
			return false;
		} finally {
			closeConnection();
		}
	}

	public boolean insert(Cliente cliente) {
		PreparedStatement sqlSt;
		try{
			String sql = "insert into cliente (nome, data_nascimento, cpf, rg, cnh, validadecnh, estado_emissor,"
					+ " genero, logradouro, bairro, numero, cep, cidade, uf, telefone, email, id_agencia)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1,  cliente.getNome());
			sqlSt.setDate(2, new java.sql.Date(cliente.getDataNascimento().getTime()));
			sqlSt.setString(3,  cliente.getCpf());
			sqlSt.setString(4, cliente.getRg());
			sqlSt.setString(5, cliente.getCnh());
			sqlSt.setDate(6, new java.sql.Date(cliente.getValidadeCnh().getTime()));
			sqlSt.setString(7, cliente.getEstadoEmissor());
			sqlSt.setInt(8, cliente.getGenero());
			sqlSt.setString(9, cliente.getLogradouro());
			sqlSt.setString(10, cliente.getBairro());
			sqlSt.setInt(11, cliente.getNumero());
			sqlSt.setString(12, cliente.getCep());
			sqlSt.setString(13, cliente.getCidade());
			sqlSt.setString(14, cliente.getUf());
			sqlSt.setString(15, cliente.getTelefone());
			sqlSt.setString(16, cliente.getEmail());
			sqlSt.setInt(17, cliente.getIdAgencia());
			sqlSt.setDate(18, cliente.getDataCadastro());
			sqlSt.setDate(19, cliente.getDataManutencao());
			sqlSt.setBoolean(20, cliente.isAtivo());
			sqlSt.toString();
			sqlSt.execute();
			return true;
		}catch(Exception selectError){
			selectError.printStackTrace();
			return false;
		} finally {
			closeConnection();
		}
	}

	public boolean delete(int id) {
		try{
			String sqlString = "delete from cliente where id_cliente=?";
			PreparedStatement sqlSt;
			sqlSt = conn.prepareStatement(sqlString);
			sqlSt.setInt(1, id);
			sqlSt.execute();
			return true;
		}catch(Exception deleteError){
			return false;
		}
	}
	
	/**
	 * Busca todas as clientes cadastradas na base, com base na conditional 
	 * passada por parâmetro, a query usada para pesquisa é <b>SELECt * FROM cliente</b>
	 * @author Joaquim Neto
	 * @param conditional condição para a consulta sql
	 * @return Lista com os clientes encontrados
	 */
	public List<Cliente> pesquisaPorCondicao(String conditional){
		List<Cliente> lista = new ArrayList<Cliente>();
		ResultSet resultSet;
		Cliente cliente;
		
		try{
			String sql = "SELECT * FROM cliente " + conditional;
			
			PreparedStatement st = conn.prepareStatement(sql);
			resultSet = st.executeQuery();
			
			while(resultSet.next()){
				cliente = new Cliente();
				cliente.setId(resultSet.getInt(1));
				cliente.setNome(resultSet.getString(2));
				cliente.setDataNascimento(resultSet.getDate(3));
				cliente.setCpf(resultSet.getString(4));
				cliente.setRg(resultSet.getString(5));
				cliente.setCnh(resultSet.getString(6));
				cliente.setValidadeCnh(resultSet.getDate(7));
				cliente.setEstadoEmissor(resultSet.getString(8));
				cliente.setGenero(resultSet.getInt(9));
				cliente.setLogradouro(resultSet.getString(10));
				cliente.setBairro(resultSet.getString(11));
				cliente.setNumero(resultSet.getInt(12));
				cliente.setCep(resultSet.getString(13));
				cliente.setCidade(resultSet.getString(14));
				cliente.setUf(resultSet.getString(15));
				cliente.setTelefone(resultSet.getString(16));
				cliente.setEmail(resultSet.getString(17));
				cliente.setIdAgencia(resultSet.getInt(18));
				lista.add(cliente);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
		
		return lista;
	}

}
