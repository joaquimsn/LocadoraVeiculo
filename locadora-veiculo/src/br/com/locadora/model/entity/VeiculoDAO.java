package br.com.locadora.model.entity;
import java.util.ArrayList;
import java.sql.*;
public class VeiculoDAO extends MysqlConnect{
	public Veiculo select(int id) {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		try{
			String sql = "SELECT * FROM veiculo where veiculo_id=?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setInt(1, id);
			resultSet = sqlSt.executeQuery();
			Veiculo resultado = new Veiculo();
			if (resultSet.next()){
				resultado.setId(resultSet.getInt(1));
				resultado.setModelo(resultSet.getString(2));
				resultado.setFabricante(resultSet.getString(3));
				resultado.setImagem(resultSet.getString(4));
				resultado.setAno(resultSet.getInt(5));
				resultado.setGrupo(resultSet.getInt(6));
				resultado.setAcessorio(resultSet.getString(7));
				resultado.setChassi(resultSet.getInt(8));
				resultado.setPlaca(resultSet.getString(9));
				resultado.setCidade(resultSet.getString(10));
				resultado.setUf(resultSet.getString(11));
				resultado.setKmRodado(resultSet.getDouble(12));
				resultado.setPrecoKmLivre(resultSet.getDouble(13));
				resultado.setPrecoKmControlado(resultSet.getDouble(14));
				resultado.setStatus(resultSet.getInt(15));
			}
			return resultado;
		}catch(Exception selectError){
			return null;
		}
	}
	public boolean update(Veiculo veiculo) {
		try{
			PreparedStatement sqlSt;
			String sqlString = "update veiculo set "
								+ "modelo = ?,"
								+ "fabricante = ?,"
								+ "imagem = ?,"
								+ "ano = ?,"
								+ "grupo = ?,"
								+ "acessorio = ?,"
								+ "chassi = ?,"
								+ "placa = ?,"
								+ "cidade = ?,"
								+ "uf = ?,"
								+ "kmrodado = ?,"
								+ "precokmlivre = ?,"
								+ "precokmcontrolado = ?,"
								+ "status = ?"
								+ "where veiculo_id=?";
			sqlSt = conn.prepareStatement(sqlString);
			sqlSt.setString(1,veiculo.getModelo());
			sqlSt.setString(2, veiculo.getFabricante());
			sqlSt.setString(3, veiculo.getImagem());
			sqlSt.setInt(4, veiculo.getAno());
			sqlSt.setInt(5, veiculo.getGrupo());
			sqlSt.setString(6, veiculo.getAcessorio());
			sqlSt.setInt(7, veiculo.getChassi());
			sqlSt.setString(8, veiculo.getPlaca());
			sqlSt.setString(9, veiculo.getCidade());
			sqlSt.setString(10, veiculo.getUf());
			sqlSt.setDouble(11, veiculo.getKmRodado());
			sqlSt.setDouble(12, veiculo.getPrecoKmLivre());
			sqlSt.setDouble(13, veiculo.getPrecoKmControlado());
			sqlSt.setInt(14, veiculo.getStatus());
			sqlSt.setInt(15, veiculo.getId());
			sqlSt.executeUpdate();
			return true;
		}catch(Exception updateError){
         return false;
		}
	}

	public boolean insert(Veiculo veiculo, Agencia agencia) {
		try{
			PreparedStatement sqlSt;
			String sqlString = "INSERT INTO veiculo (modelo, fabricante, imagem, "
													+ "ano, grupo, acessorio, chassi, placa,"
													+ "cidade, uf, kmrodado, precokmlivre, "
													+ "precokmcontrolado, status, id_agencia) "
								+ "VALUES(?, ?, ?, "
										+ "?, ?, ?, ?, ?, "
										+ "?, ?, ?, "
										+ "?, ?, ?)";
			sqlSt = conn.prepareStatement(sqlString);
			sqlSt.setString(1,veiculo.getModelo());
			sqlSt.setString(2, veiculo.getFabricante());
			sqlSt.setString(3, veiculo.getImagem());
			sqlSt.setInt(4, veiculo.getAno());
			sqlSt.setInt(5, veiculo.getGrupo());
			sqlSt.setString(6, veiculo.getAcessorio());
			sqlSt.setInt(7, veiculo.getChassi());
			sqlSt.setString(8, veiculo.getPlaca());
			sqlSt.setString(9, veiculo.getCidade());
			sqlSt.setString(10, veiculo.getUf());
			sqlSt.setDouble(11, veiculo.getKmRodado());
			sqlSt.setDouble(12, veiculo.getPrecoKmLivre());
			sqlSt.setDouble(13, veiculo.getPrecoKmControlado());
			sqlSt.setInt(14, veiculo.getStatus());
			sqlSt.executeUpdate();
			return true;
		}catch(Exception insertError){
         return false;
		}
	}

	public boolean delete(int id) {
		try{
			String sqlString = "delete from veiculo where veiculo_id=?";
			PreparedStatement sqlSt;
			sqlSt = conn.prepareStatement(sqlString);
			sqlSt.setInt(1, id);
			return true;
		}catch(Exception deleteError){
			return false;
		}
	}

	public ArrayList<Veiculo> buscarTodos() {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		ArrayList<Veiculo> resultado = new ArrayList<Veiculo>();
		try{
			String sql = "SELECT * FROM veiculo";
			sqlSt = conn.prepareStatement(sql);
			resultSet = sqlSt.executeQuery();
			Veiculo auxVeiculo = new Veiculo();
			while (resultSet.next()){
				auxVeiculo.setId(resultSet.getInt(1));
				auxVeiculo.setModelo(resultSet.getString(2));
				auxVeiculo.setFabricante(resultSet.getString(3));
				auxVeiculo.setImagem(resultSet.getString(4));
				auxVeiculo.setAno(resultSet.getInt(5));
				auxVeiculo.setGrupo(resultSet.getInt(6));
				auxVeiculo.setAcessorio(resultSet.getString(7));
				auxVeiculo.setChassi(resultSet.getInt(8));
				auxVeiculo.setPlaca(resultSet.getString(9));
				auxVeiculo.setCidade(resultSet.getString(10));
				auxVeiculo.setUf(resultSet.getString(11));
				auxVeiculo.setKmRodado(resultSet.getDouble(12));
				auxVeiculo.setPrecoKmLivre(resultSet.getDouble(13));
				auxVeiculo.setPrecoKmControlado(resultSet.getDouble(14));
				auxVeiculo.setStatus(resultSet.getInt(15));				
				resultado.add(auxVeiculo);
			}
			return resultado;
		}catch(Exception selectError){
			return null;
		}
	}

	public ArrayList<Veiculo> buscarTodosPorStatus(int status) {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		ArrayList<Veiculo> resultado = new ArrayList<Veiculo>();
		try{
			String sql = "SELECT * FROM veiculo where status=?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setInt(1, status);
			resultSet = sqlSt.executeQuery();
			Veiculo auxVeiculo = new Veiculo();
			while (resultSet.next()){
				auxVeiculo.setId(resultSet.getInt(1));
				auxVeiculo.setModelo(resultSet.getString(2));
				auxVeiculo.setFabricante(resultSet.getString(3));
				auxVeiculo.setImagem(resultSet.getString(4));
				auxVeiculo.setAno(resultSet.getInt(5));
				auxVeiculo.setGrupo(resultSet.getInt(6));
				auxVeiculo.setAcessorio(resultSet.getString(7));
				auxVeiculo.setChassi(resultSet.getInt(8));
				auxVeiculo.setPlaca(resultSet.getString(9));
				auxVeiculo.setCidade(resultSet.getString(10));
				auxVeiculo.setUf(resultSet.getString(11));
				auxVeiculo.setKmRodado(resultSet.getDouble(12));
				auxVeiculo.setPrecoKmLivre(resultSet.getDouble(13));
				auxVeiculo.setPrecoKmControlado(resultSet.getDouble(14));
				auxVeiculo.setStatus(resultSet.getInt(15));				
				resultado.add(auxVeiculo);
			}
			return resultado;
		}catch(Exception selectError){
			return null;
		}
	}

}
