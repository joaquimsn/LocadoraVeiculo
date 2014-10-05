package br.com.locadora.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.locadora.model.connection.MysqlConnect;
import br.com.locadora.model.entity.Agencia;

public class AgenciaDAO extends MysqlConnect {
	public Agencia select(int id) {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		try {
			String sql = "SELECT * FROM agencia where agencia_id=?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setInt(1, id);
			resultSet = sqlSt.executeQuery();
			Agencia resultado = new Agencia();
			
			if (resultSet.next()) {
				resultado.setId(resultSet.getInt(1));
				resultado.setRazaoSocial(resultSet.getString(2));
				resultado.setNomeFantasia(resultSet.getString(3));
				resultado.setCnpj(resultSet.getString(4));
				resultado.setInscricaoEstadual(resultSet.getString(5));
				resultado.setLogradouro(resultSet.getString(7));
				resultado.setBairro(resultSet.getString(8));
				resultado.setNumero(resultSet.getInt(9));
				resultado.setCep(resultSet.getString(10));
				resultado.setCidade(resultSet.getString(11));
				resultado.setUf(resultSet.getString(12));
				resultado.setTelefone(resultSet.getString(13));
				resultado.setEmail(resultSet.getString(14));
				resultado.setSite(resultSet.getString(15));
			}
			return resultado;
		} catch (Exception selectError) {
			return null;
		}
	}

	public boolean update(Agencia agencia) {
		PreparedStatement sqlSt;
		try {
			String sql = "UPDATE agencia" +
							"SET" +
								"razao_social = ?," +
								"fantasia = ?," +
								"cnpj = ?," +
								"insc_estadual = ?," +
								"logradouro = ?," +
								"bairro = ?," +
								"numero = ?," +
								"cep = ?," +
								"cidade = ?," +
								"uf = ?," +
								"telefone = ?," +
								"email = ?," +
								"site = ?" +
							"WHERE id_agencia = ?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1, agencia.getRazaoSocial());
			sqlSt.setString(2, agencia.getNomeFantasia());
			sqlSt.setString(3, agencia.getCnpj());
			sqlSt.setString(4, agencia.getInscricaoEstadual());
			sqlSt.setString(6, agencia.getLogradouro());
			sqlSt.setString(7, agencia.getBairro());
			sqlSt.setInt(8, agencia.getNumero());
			sqlSt.setString(9, agencia.getCep());
			sqlSt.setString(10, agencia.getCidade());
			sqlSt.setString(11, agencia.getUf());
			sqlSt.setString(12,  agencia.getTelefone());
			sqlSt.setString(13,  agencia.getEmail());
			sqlSt.setString(14, agencia.getSite());
			sqlSt.setInt(15, agencia.getId());
			sqlSt.executeUpdate();
			return true;
		} catch (Exception selectError) {
			return false;
		}
	}

	public boolean insert(Agencia agencia) {
		PreparedStatement sqlSt;
		try {
			String sql = "INSERT INTO agencia" +
							"(razao_social," +
							"fantasia," +
							"cnpj," +
							"insc_estadual," +
							"logradouro," +
							"bairro," +
							"numero," +
							"cep," +
							"cidade," +
							"uf," +
							"telefone," +
							"email," +
							"site)" +
						"VALUES" +
						"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1, agencia.getRazaoSocial());
			sqlSt.setString(2, agencia.getNomeFantasia());
			sqlSt.setString(3, agencia.getCnpj());
			sqlSt.setString(4, agencia.getInscricaoEstadual());
			sqlSt.setString(5, agencia.getLogradouro());
			sqlSt.setString(6, agencia.getBairro());
			sqlSt.setInt(7, agencia.getNumero());
			sqlSt.setString(8, agencia.getCep());
			sqlSt.setString(9, agencia.getCidade());
			sqlSt.setString(10, agencia.getUf());
			sqlSt.setString(11,  agencia.getTelefone());
			sqlSt.setString(12,  agencia.getEmail());
			sqlSt.setString(13, agencia.getSite());
			sqlSt.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
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
