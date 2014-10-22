package br.com.locadora.model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.locadora.model.connection.MysqlConnect;
import br.com.locadora.model.entity.Cliente;
import br.com.locadora.model.entity.Pagamento;
import br.com.locadora.utils.SystemUtils;

public class PagamentoDAO extends MysqlConnect{

	public Pagamento select(int id) {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		try{
			String sql = "SELECT * FROM pagamento where id_pagamento=?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setInt(1, id);
			resultSet = sqlSt.executeQuery();
			Pagamento resultado = new Pagamento();
			if (resultSet.next()){				
				resultado.setId(resultSet.getInt(1));
				resultado.setValor(resultSet.getDouble(9));
				resultado.setTipoPagamento(resultSet.getString(10));
			}
			return resultado;
		}catch(Exception selectError){
			return null;
		}
	}

	public boolean update(Pagamento pagamento) {
		PreparedStatement sqlSt;
		try{
			String sql = "UPDATE pagamento" +
						"SET" +
							"data_hora_pagamento = ?," +
							"data_hora_prevista_devolucao = ?," +
							"data_hora_devolucao = ?," +
							"agencia_devolucao = ?," +
							"tipo_tarifa = ?," +
							"km_pagamento = ?," +
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
						"WHERE id_pagamento = ?";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setInt(17, pagamento.getId());
			sqlSt.executeQuery();
			return true;
		}catch(Exception updateError){
			return false;
		}	
	}

	public boolean insert(Pagamento pagamento) {
		PreparedStatement sqlSt;
		try{
			String sql = "INSERT INTO pagamento" +
							"(tipo," +
							"nome_titular," +
							"cpf," +
							"data_pagamento)" +
						"VALUES" +
							"(?, ?, ?, ?)";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1, pagamento.getTipoPagamento());
			sqlSt.setString(2, pagamento.getTitular());
			sqlSt.setString(3, pagamento.getCpf());
			sqlSt.setDate(4, SystemUtils.dataConverter(new java.util.Date()));
			sqlSt.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public List<Pagamento> selectByCliente(Cliente cliente) {
		return null;
	}

	public List<Pagamento> selectByDate(Date date) {
		return null;
	}

	/**
	 * Busca todas as locacçãos cadastradas na base, com base na conditional 
	 * passada por parâmtro, a query usada para pesquisa é <b>SELECt * FROM pagamento</b>
	 * @author Joaquim Neto
	 * @param conditional condição para a consulta sql
	 * @return Lista com as locacçãos encontradas
	 */
	public List<Pagamento> pesquisarPorCondicao(String conditional) {
		List<Pagamento> lista = new ArrayList<Pagamento>();
		ResultSet resultSet;
		Pagamento pagamento;
		
		try{
			String sql = "SELECT * FROM pagamento " + conditional;
			
			PreparedStatement st = conn.prepareStatement(sql);
			resultSet = st.executeQuery();
			
			while(resultSet.next()){
				pagamento = new Pagamento();
				pagamento.setId(resultSet.getInt(1));
				lista.add(pagamento);
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
