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
				resultado.setInscricaoMunicipal(resultSet.getString(6));
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
		return false;
	}

	public boolean insert(Agencia agencia) {
		return false;
	}

	public int delete(int id) {
		return 0;
	}

}
