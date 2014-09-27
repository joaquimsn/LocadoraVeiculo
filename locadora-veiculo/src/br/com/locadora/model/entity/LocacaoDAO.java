package br.com.locadora.model.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Date;

import br.com.locadora.model.connection.MysqlConnect;

public class LocacaoDAO extends MysqlConnect{

	public Locacao select(int id) {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		try{
			String sql = "SELECT * FROM locacao where id_locacao=?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setInt(1, id);
			resultSet = sqlSt.executeQuery();
			Locacao resultado = new Locacao();
			if (resultSet.next()){
				resultado.setId(resultSet.getInt(1));
				resultado.setDataHoraLocacao(resultSet.getDate(2));
				resultado.setDataHoraDevolucao(resultSet.getDate(3));
				resultado.setAgenciaDevolucao(resultSet.getInt(4));
				resultado.setTipoTarifa(resultSet.getInt(5));
				resultado.setKmLocacao(resultSet.getDouble(6));
				resultado.setKmDevolucao(resultSet.getDouble(7));
				resultado.setValor(resultSet.getDouble(8));
				resultado.setValorAcrescimo(resultSet.getDouble(10));
				
			}
			return resultado;
		}catch(Exception selectError){
			return null;
		}
	}

	public boolean update(Locacao locacao) {
		return false;
	}

	public boolean insert(Locacao locacao) {
		return false;
	}

	public List<Locacao> selectByCliente(Cliente cliente) {
		return null;
	}

	public List<Locacao> selectByDate(Date date) {
		return null;
	}

}
