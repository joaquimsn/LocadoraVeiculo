package br.com.locadora.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
				resultado.setAgencia(resultSet.getInt(18));
			}
			return resultado;
		}catch(Exception selectError){
			return null;
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
			sqlSt.setInt(16, cliente.getAgencia());
			sqlSt.setInt(17, cliente.getId());
			sqlSt.executeQuery();
			return true;
		}catch(Exception selectError){
			return false;
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
			sqlSt.setInt(16, cliente.getAgencia());
			sqlSt.executeQuery();
			return true;
		}catch(Exception selectError){
			return false;
		}
	}

	public boolean delete(int id) {
		try{
			String sqlString = "delete from cliente where id_cliente=?";
			PreparedStatement sqlSt;
			sqlSt = conn.prepareStatement(sqlString);
			sqlSt.setInt(1, id);
			sqlSt.executeQuery();
			return true;
		}catch(Exception deleteError){
			return false;
		}
	}

}
