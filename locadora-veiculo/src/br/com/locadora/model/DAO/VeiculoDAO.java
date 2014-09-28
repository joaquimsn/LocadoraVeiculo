package br.com.locadora.model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Date;

import br.com.locadora.model.connection.MysqlConnect;
import br.com.locadora.model.entity.Agencia;
import br.com.locadora.model.entity.Cliente;
import br.com.locadora.model.entity.Veiculo;

public class VeiculoDAO extends MysqlConnect{

	public Veiculo select(int id) {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		try{
			String sql = "SELECT * FROM veiculo where id_veiculo=?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setInt(1, id);
			resultSet = sqlSt.executeQuery();
			Veiculo veiculo = new Veiculo();
			veiculo.setId(resultSet.getInt(1));
			veiculo.setModelo(resultSet.getString(2));
			veiculo.setFabricante(resultSet.getString(3));
			veiculo.setImagem(resultSet.getString(4));
			veiculo.setAno(Integer.parseInt(resultSet.getDate(5).toString()));
			veiculo.setGrupo(resultSet.getInt(6));
			veiculo.setAcessorio(resultSet.getString(7));
			veiculo.setChassi(resultSet.getString(8));
			veiculo.setPlaca(resultSet.getString(9));
			veiculo.setCidade(resultSet.getString(10));
			veiculo.setUf(resultSet.getString(11));
			veiculo.setKmRodado(resultSet.getDouble(12));
			veiculo.setPrecoKmLivre(resultSet.getDouble(13));
			veiculo.setPrecoKmControlado(resultSet.getDouble(14));
			veiculo.setStatus(resultSet.getString(15));
			Agencia agencia = new Agencia();
			agencia.setId(resultSet.getInt(16));
			veiculo.setAgencia(agencia);
			return veiculo;
		}catch(Exception selectError){
			return null;
		}
	}

	public boolean update(Veiculo veiculo) {
		PreparedStatement sqlSt;
		try{
			String sql = "UPDATE veiculo" +
							"SET" +
								"modelo = ?," +
								"fabricante = ?," +
								"imagem = ?," +
								"ano = ?," +
								"grupo = ?," +
								"acessorio = ?," +
								"chassi = ?," +
								"placa = ?," +
								"cidade = ?," +
								"uf = ?," +
								"kmrodado = ?," +
								"precokmlivre = ?," +
								"precokmcontrolado = ?," +
								"status_veiculo = ?," +
								"id_agencia = ?" +
							"WHERE " +
								"id_veiculo = ?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1, veiculo.getModelo());
			sqlSt.setString(2, veiculo.getFabricante());
			sqlSt.setString(3, veiculo.getImagem());
			sqlSt.setInt(4, veiculo.getAno());
			sqlSt.setInt(5, veiculo.getGrupo());
			sqlSt.setString(6, veiculo.getAcessorio());
			sqlSt.setString(7, veiculo.getChassi());
			sqlSt.setString(8, veiculo.getPlaca());
			sqlSt.setString(9, veiculo.getCidade());
			sqlSt.setString(10, veiculo.getUf());
			sqlSt.setDouble(11, veiculo.getKmRodado());
			sqlSt.setDouble(12, veiculo.getPrecoKmLivre());
			sqlSt.setDouble(13, veiculo.getPrecoKmControlado());
			sqlSt.setString(14, veiculo.getStatus());
			sqlSt.setInt(15, veiculo.getAgencia().getId());
			sqlSt.setInt(16, veiculo.getId());
			sqlSt.executeQuery();
			return true;
		}catch(Exception updateError){
			return false;
		}
	}

	public boolean insert(Veiculo veiculo) {
		PreparedStatement sqlSt;
		try{
			String sql = "INSERT INTO veiculo" +
							"(modelo," +
							"fabricante," +
							"imagem," +
							"ano," +
							"grupo," +
							"acessorio," +
							"chassi," +
							"placa," +
							"cidade," +
							"uf," +
							"kmrodado," +
							"precokmlivre," +
							"precokmcontrolado," +
							"status_veiculo," +
							"id_agencia)" +
						"VALUES" +
							"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1, veiculo.getModelo());
			sqlSt.setString(2, veiculo.getFabricante());
			sqlSt.setString(3, veiculo.getImagem());
			sqlSt.setInt(4, veiculo.getAno());
			sqlSt.setInt(5, veiculo.getGrupo());
			sqlSt.setString(6, veiculo.getAcessorio());
			sqlSt.setString(7, veiculo.getChassi());
			sqlSt.setString(8, veiculo.getPlaca());
			sqlSt.setString(9, veiculo.getCidade());
			sqlSt.setString(10, veiculo.getUf());
			sqlSt.setDouble(11, veiculo.getKmRodado());
			sqlSt.setDouble(12, veiculo.getPrecoKmLivre());
			sqlSt.setDouble(13, veiculo.getPrecoKmControlado());
			sqlSt.setString(14, veiculo.getStatus());
			sqlSt.setInt(15, veiculo.getAgencia().getId());
			sqlSt.executeQuery();
			return true;
		}catch(Exception updateError){
			return false;
		}
	}

	public boolean delete(int id) {
		try{
			String sqlString = "delete from veiculo where id_veiculo=?";
			PreparedStatement sqlSt;
			sqlSt = conn.prepareStatement(sqlString);
			sqlSt.setInt(1, id);
			sqlSt.executeQuery();
			return true;
		}catch(Exception deleteError){
			return false;
		}
	}

	public List<Veiculo> buscarTodos() {
		return null;
	}

	public List<Veiculo> selectByDate(int status, Date dataMinima, Date dataMaxima) {
		return null;
	}

	public List<Veiculo> selectByStatus(int status) {
		return null;
	}

}
