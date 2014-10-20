package br.com.locadora.model.DAO;
import br.com.locadora.model.entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.List;

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
				resultado.setDataHoraPrevistaDevolucao(resultSet.getDate(3));
				resultado.setDataHoraDevolucao(resultSet.getDate(4));
				resultado.setAgenciaDevolucao(resultSet.getInt(5));
				resultado.setTipoTarifa(resultSet.getInt(6));
				resultado.setKmLocacao(resultSet.getDouble(7));
				resultado.setKmDevolucao(resultSet.getDouble(8));
				resultado.setValor(resultSet.getDouble(9));
				resultado.setTipoPagamento(resultSet.getString(10));
				resultado.setValorAcrescimo(resultSet.getDouble(11));
				resultado.setStatus(resultSet.getInt(12));
				Veiculo veiculo = new Veiculo();
				veiculo.setId(resultSet.getInt(13));
				resultado.setIdVeiculo(veiculo);
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt(14));
				resultado.setCliente(cliente);
				Pagamento pagamento = new Pagamento();
				pagamento.setId(resultSet.getInt(15));
				resultado.setPagamento(pagamento);
				resultado.setIdFuncionario(resultSet.getInt(16));
				Agencia agencia = new Agencia();
				agencia.setIdAgencia(resultSet.getInt(17));
				resultado.setIdAgencia(agencia.getIdAgencia());				
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
							"data_hora_devolucao = ?," +
							"agencia_devolucao = ?," +
							"tipo_tarifa = ?," +
							"km_locacao = ?," +
							"km_devolucao = ?," +
							"valor = ?," +
							"tipo_pagamento = ?," +
							"valor_acrescimo = ?," +
							"status = ?," +
							"id_veiculo = ?," +
							"id_cliente = ?," +
							"id_pagamento = ?," +
							"id_funcionario = ?," +
							"id_agencia = ?" +
						"WHERE id_locacao = ?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setDate(1, new  java.sql.Date(locacao.getDataHoraLocacao().getTime()));
			sqlSt.setDate(2, new java.sql.Date(locacao.getDataHoraPrevistaDevolucao().getTime()));
			sqlSt.setDate(3, new java.sql.Date(locacao.getDataHoraDevolucao().getTime()));
			sqlSt.setInt(4, locacao.getAgenciaDevolucao());
			sqlSt.setInt(5, locacao.getTipoTarifa());
			sqlSt.setDouble(6, locacao.getKmLocacao());
			sqlSt.setDouble(7, locacao.getKmDevolucao());
			sqlSt.setDouble(8, locacao.getValor());
			sqlSt.setString(9, locacao.getTipoPagamento());
			sqlSt.setDouble(10, locacao.getValorAcrescimo());
			sqlSt.setInt(11, locacao.getStatus());
			sqlSt.setInt(12, locacao.getVeiculo().getId());
			sqlSt.setInt(13, locacao.getCliente().getId());
			sqlSt.setInt(14, locacao.getPagamento().getId());
			sqlSt.setInt(15, locacao.getIdFuncionario());
			sqlSt.setInt(16, locacao.getIdAgencia());
			sqlSt.setInt(17, locacao.getId());
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
							"data_hora_devolucao," +
							"agencia_devolucao," +
							"tipo_tarifa," +
							"km_locacao," +
							"km_devolucao," +
							"valor," +
							"tipo_pagamento," +
							"valor_acrescimo," +
							"status," +
							"id_veiculo," +
							"id_cliente," +
							"id_pagamento," +
							"id_funcionario," +
							"id_agencia)" +
						"VALUES" +
							"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setDate(1, new  java.sql.Date(locacao.getDataHoraLocacao().getTime()));
			sqlSt.setDate(2, new java.sql.Date(locacao.getDataHoraPrevistaDevolucao().getTime()));
			sqlSt.setDate(3, new java.sql.Date(locacao.getDataHoraDevolucao().getTime()));
			sqlSt.setInt(4, locacao.getAgenciaDevolucao());
			sqlSt.setInt(5, locacao.getTipoTarifa());
			sqlSt.setDouble(6, locacao.getKmLocacao());
			sqlSt.setDouble(7, locacao.getKmDevolucao());
			sqlSt.setDouble(8, locacao.getValor());
			sqlSt.setString(9, locacao.getTipoPagamento());
			sqlSt.setDouble(10, locacao.getValorAcrescimo());
			sqlSt.setInt(11, locacao.getStatus());
			sqlSt.setInt(12, locacao.getVeiculo().getId());
			sqlSt.setInt(13, locacao.getCliente().getId());
			sqlSt.setInt(14, locacao.getPagamento().getId());
			sqlSt.setInt(15, locacao.getIdFuncionario());
			sqlSt.setInt(16, locacao.getIdAgencia());
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
