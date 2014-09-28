package br.com.locadora.model.DAO;
import br.com.locadora.model.entity.*;
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
		PreparedStatement sqlSt;
		try{
			String sql = "UPDATE locacao" + 
							"SET" + 
								"data_hora_locacao = ?," + 
								"data_hora_prevista_devolucao = ?," + 
								"agencia_devolucao = ?," + 
								"tipo_tarifa = ?," + 
								"km_locacao = ?," + 
								"km_devolucao = ?," + 
								"valor = ?," + 
								"tipo_pagamento = ?," + 
								"valor_acrescimo = ?," + 
								"id_veiculo = ?," + 
								"id_pagamento = ?" + 
							"WHERE id_locacao = ?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setDate(1, new java.sql.Date(locacao.getDataHoraLocacao().getTime()));
			sqlSt.setDate(2,  new java.sql.Date(locacao.getDataHoraDevolucao().getTime()));
			sqlSt.setInt(3, locacao.getAgenciaDevolucao());
			sqlSt.setInt(4, locacao.getTipoTarifa());
			sqlSt.setDouble(5, locacao.getKmLocacao());
			sqlSt.setDouble(6, locacao.getKmDevolucao());
			sqlSt.setDouble(7, locacao.getValor());
			sqlSt.setDouble(8, locacao.getTipoTarifa());
			sqlSt.setString(9, locacao.getTipoPagamento());
			sqlSt.setDouble(10, locacao.getValorAcrescimo());
			sqlSt.setInt(11, locacao.getVeiculo().getId());
			sqlSt.setInt(12, locacao.getPagamento().getId());
			sqlSt.setInt(13, locacao.getId());
			sqlSt.executeQuery();
			return true;
		}catch(Exception updateError){
			return false;
		}	
	}

	public boolean insert(Locacao locacao) {
		PreparedStatement sqlSt;
		try{
			String sql = "INSERT INTO locacao" +
							"(data_hora_locacao," +
							"data_hora_prevista_devolucao," +
							"agencia_devolucao," +
							"tipo_tarifa," +
							"km_locacao," +
							"km_devolucao," +
							"valor," +
							"tipo_pagamento," +
							"valor_acrescimo," +
							"id_veiculo," +
							"id_pagamento)" +
						"VALUES" +
							"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setDate(1, new java.sql.Date(locacao.getDataHoraLocacao().getTime()));
			sqlSt.setDate(2,  new java.sql.Date(locacao.getDataHoraDevolucao().getTime()));
			sqlSt.setInt(3, locacao.getAgenciaDevolucao());
			sqlSt.setInt(4, locacao.getTipoTarifa());
			sqlSt.setDouble(5, locacao.getKmLocacao());
			sqlSt.setDouble(6, locacao.getKmDevolucao());
			sqlSt.setDouble(7, locacao.getValor());
			sqlSt.setDouble(8, locacao.getTipoTarifa());
			sqlSt.setString(9, locacao.getTipoPagamento());
			sqlSt.setDouble(10, locacao.getValorAcrescimo());
			sqlSt.setInt(11, locacao.getVeiculo().getId());
			sqlSt.setInt(12, locacao.getPagamento().getId());
			sqlSt.executeQuery();
			return true;
		}catch(Exception updateError){
			return false;
		}
	}

	public List<Locacao> selectByCliente(Cliente cliente) {
		return null;
	}

	public List<Locacao> selectByDate(Date date) {
		return null;
	}

}
