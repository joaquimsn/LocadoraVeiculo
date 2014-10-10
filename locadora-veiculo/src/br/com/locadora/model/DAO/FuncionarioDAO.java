package br.com.locadora.model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Date;

import br.com.locadora.model.connection.MysqlConnect;
import br.com.locadora.model.entity.*;

public class FuncionarioDAO extends MysqlConnect{

	public boolean insert(Funcionario funcionario) {
		PreparedStatement sqlSt;
		try{
			String sql = "INSERT INTO funcionario" +
				"(nome," +
				"data_nascimento," +
				"cpf," +
				"rg," +
				"genero," +
				"logradouro," +
				"numero," +
				"bairro," +
				"cep," +
				"cidade," +
				"uf," +
				"telefone," +
				"email," +
				"nivel," +
				"usuario," +
				"data_cadastro," +
				"data_manutencao," +
				"funcionario_supervisor," +
				"id_agencia)" +
			"VALUES" +
				"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, curdate(), curdate(), ?, ?)";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1, funcionario.getNome());
			sqlSt.setDate(2, new java.sql.Date(funcionario.getDataNascimento().getTime()));
			sqlSt.setString(3, funcionario.getCpf());
			sqlSt.setString(4, funcionario.getRg());
			sqlSt.setString(5, String.valueOf(funcionario.getGenero()));
			sqlSt.setString(6, funcionario.getLogradouro());
			sqlSt.setInt(7, funcionario.getNumero());
			sqlSt.setString(8, funcionario.getBairro());
			sqlSt.setString(9, funcionario.getCep());
			sqlSt.setString(10, funcionario.getCidade());
			sqlSt.setString(11, funcionario.getUf());
			sqlSt.setString(12, funcionario.getTelefone());
			sqlSt.setString(13, funcionario.getEmail());
			sqlSt.setInt(14, funcionario.getNivel());
			sqlSt.setString(15, funcionario.getUsuario());
			//as datas de cadastro e manutenção serão dadas pelo servidor, portanto número 16 e 17 pulados
			sqlSt.setInt(18,  funcionario.getFuncionarioSupervisor());
			sqlSt.setInt(19, funcionario.getCodigoAgencia());		
			sqlSt.executeQuery();
			return true;
		}catch(Exception updateError){
			return false;
		}
	}

	public Funcionario select(int id) {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		try{
			String sql = "SELECT * FROM funcionario where id_funcionario=?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setInt(1, id);
			resultSet = sqlSt.executeQuery();
			Funcionario resultado = new Funcionario();
			resultado.setId(id);
			resultado.setNome(resultSet.getString(1));
			resultado.setDataNascimento(resultSet.getDate(2));
			resultado.setCpf(resultSet.getString(3));
			resultado.setRg(resultSet.getString(4));
			resultado.setGenero(resultSet.getString(5).charAt(0));
			resultado.setLogradouro(resultSet.getString(6));
			resultado.setNumero(resultSet.getInt(7));
			resultado.setBairro(resultSet.getString(8));
			resultado.setCep(resultSet.getString(9));
			resultado.setCidade(resultSet.getString(10));
			resultado.setUf(resultSet.getString(11));
			resultado.setTelefone(resultSet.getString(12));
			resultado.setEmail(resultSet.getString(13));
			resultado.setNivel(resultSet.getInt(14));
			Usuario usuario = new Usuario();
			usuario.setUsuario(resultSet.getString(15));
			resultado.setUsuario(usuario.getUsuario());
			resultado.setDataCadastro(resultSet.getDate(16));
			resultado.setDataManutencao(resultSet.getDate(17));
			resultado.setFuncionarioSupervisor(resultSet.getInt(18));
			resultado.setCodigoAgencia(resultSet.getInt(19));
			return resultado;
		}catch(Exception selectError){
			return null;
		}
	}

	public boolean update(Funcionario funcionario) {
		PreparedStatement sqlSt;
		try{
			String sql = "UPDATE funcionario" +
							"SET" +
								"id_funcionario = ?," +
								"nome = ?," +
								"data_nascimento = ?," +
								"cpf = ?," +
								"rg = ?," +
								"genero = ?," +
								"logradouro = ?," +
								"numero = ?," +
								"bairro = ?," +
								"cep = ?," +
								"cidade = ?," +
								"uf = ?" +
								"telefone = ?," +
								"email = ?," +
								"nivel = ?," +
								"usuario = ?," +
								"data_cadastro = ?," +
								"data_manutencao = ?," +
								"funcionario_supervisor = ?," +
								"id_agencia = ?" +
							"WHERE" +
								"id_funcionario = ?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1, funcionario.getNome());
			sqlSt.setDate(2, new java.sql.Date(funcionario.getDataNascimento().getTime()));
			sqlSt.setString(3, funcionario.getCpf());
			sqlSt.setString(4, funcionario.getRg());
			sqlSt.setString(5, String.valueOf(funcionario.getGenero()));
			sqlSt.setString(6, funcionario.getLogradouro());
			sqlSt.setInt(7, funcionario.getNumero());
			sqlSt.setString(8, funcionario.getBairro());
			sqlSt.setString(9, funcionario.getCep());
			sqlSt.setString(10, funcionario.getCidade());
			sqlSt.setString(11, funcionario.getUf());
			sqlSt.setString(12, funcionario.getTelefone());
			sqlSt.setString(13, funcionario.getEmail());
			sqlSt.setInt(14, funcionario.getNivel());
			sqlSt.setString(15, funcionario.getUsuario());
			sqlSt.setDate(16, new java.sql.Date(funcionario.getDataCadastro().getTime()));
			sqlSt.setDate(17, new java.sql.Date(funcionario.getDataManutencao().getTime()));
			sqlSt.setInt(18, funcionario.getFuncionarioSupervisor());
			sqlSt.setInt(19, funcionario.getCodigoAgencia());
			sqlSt.setInt(20, funcionario.getId());
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
