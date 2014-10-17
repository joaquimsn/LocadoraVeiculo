package br.com.locadora.model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.locadora.model.connection.MysqlConnect;
import br.com.locadora.model.entity.Veiculo;
import br.com.locadora.utils.SystemUtils;

public class VeiculoDAO extends MysqlConnect{

	public Veiculo select(int id) {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		try{
			String sql = "SELECT * FROM veiculo WHERE id_veiculo = ?";
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
			veiculo.setAcessorio(resultSet.getInt(7));
			veiculo.setChassi(resultSet.getString(8));
			veiculo.setPlaca(resultSet.getString(9));
			veiculo.setCidade(resultSet.getString(10));
			veiculo.setUf(resultSet.getString(11));
			veiculo.setKmRodado(resultSet.getDouble(12));
			veiculo.setPrecoKmLivre(resultSet.getDouble(13));
			veiculo.setPrecoKmControlado(resultSet.getDouble(14));
			veiculo.setStatus(resultSet.getInt(15));
			veiculo.setIdAgencia(resultSet.getInt(16));
			
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
							"status," +
							"id_agencia," +
							"id_funcionario," +
							"data_cadastro," + 
							"ativo)" +
							"WHERE " +
								"id_veiculo = ?";
			
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1, veiculo.getModelo());
			sqlSt.setString(2, veiculo.getFabricante());
			sqlSt.setString(3, veiculo.getImagem());
			sqlSt.setInt(4, veiculo.getAno());
			sqlSt.setInt(5, veiculo.getGrupo());
			sqlSt.setInt(6, veiculo.getAcessorio());
			sqlSt.setString(7, veiculo.getChassi());
			sqlSt.setString(8, veiculo.getPlaca());
			sqlSt.setString(9, veiculo.getCidade());
			sqlSt.setString(10, veiculo.getUf());
			sqlSt.setDouble(11, veiculo.getKmRodado());
			sqlSt.setDouble(12, veiculo.getPrecoKmLivre());
			sqlSt.setDouble(13, veiculo.getPrecoKmControlado());
			sqlSt.setInt(14, veiculo.getStatus());
			sqlSt.setInt(15, veiculo.getIdAgencia());
			sqlSt.setInt(16, veiculo.getIdFuncionario());
			sqlSt.setDate(17, SystemUtils.dataConverter(veiculo.getDataCadastro()));
			sqlSt.setBoolean(18, veiculo.isAtivo());
			sqlSt.execute();
			
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
							"status," +
							"id_agencia," +
							"id_funcionario," +
							"data_cadastro," + 
							"ativo)" +
						"VALUES" +
							"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1, veiculo.getModelo());
			sqlSt.setString(2, veiculo.getFabricante());
			sqlSt.setString(3, veiculo.getImagem());
			sqlSt.setInt(4, veiculo.getAno());
			sqlSt.setInt(5, veiculo.getGrupo());
			sqlSt.setInt(6, veiculo.getAcessorio());
			sqlSt.setString(7, veiculo.getChassi());
			sqlSt.setString(8, veiculo.getPlaca());
			sqlSt.setString(9, veiculo.getCidade());
			sqlSt.setString(10, veiculo.getUf());
			sqlSt.setDouble(11, veiculo.getKmRodado());
			sqlSt.setDouble(12, veiculo.getPrecoKmLivre());
			sqlSt.setDouble(13, veiculo.getPrecoKmControlado());
			sqlSt.setInt(14, veiculo.getStatus());
			sqlSt.setInt(15, veiculo.getIdAgencia());
			sqlSt.setInt(16, veiculo.getIdFuncionario());
			sqlSt.setDate(17, SystemUtils.dataConverter(veiculo.getDataCadastro()));
			sqlSt.setBoolean(18, veiculo.isAtivo());
			
			sqlSt.execute();
			
			return true;
		}catch(Exception insertError){
			insertError.printStackTrace();
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

	public List<Veiculo> selectByDate(int status, Date dataMinima, Date dataMaxima) {
		return null;
	}

	public List<Veiculo> selectByStatus(int status) {
		return null;
	}

	/**
	 * Busca todas as veiculos cadastradas na base, com base na conditional 
	 * passada por parâmetro, a query usada para pesquisa é <b>SELECt * FROM veiculo</b>
	 * @author Joaquim Neto
	 * @param conditional condição para a consulta sql
	 * @return Lista com os veiculos encontrados
	 */
	public List<Veiculo> pesquisarPorCondicao(String conditional){
		List<Veiculo> lista = new ArrayList<Veiculo>();
		ResultSet resultSet;
		Veiculo veiculo;
		
		try{
			String sql = "SELECT * FROM veiculo " + conditional;
			
			PreparedStatement st = conn.prepareStatement(sql);
			resultSet = st.executeQuery();
			
			while(resultSet.next()){
				veiculo = new Veiculo();
				
				veiculo.setId(resultSet.getInt(1));
				veiculo.setModelo(resultSet.getString(2));
				veiculo.setFabricante(resultSet.getString(3));
				veiculo.setImagem(resultSet.getString(4));
				veiculo.setAno(resultSet.getInt(5));
				veiculo.setGrupo(resultSet.getInt(6));
				veiculo.setAcessorio(resultSet.getInt(7));
				veiculo.setChassi(resultSet.getString(8));
				veiculo.setPlaca(resultSet.getString(9));
				veiculo.setCidade(resultSet.getString(10));
				veiculo.setUf(resultSet.getString(11));
				veiculo.setKmRodado(resultSet.getDouble(12));
				veiculo.setPrecoKmLivre(resultSet.getDouble(13));
				veiculo.setPrecoKmControlado(resultSet.getDouble(14));
				veiculo.setStatus(resultSet.getInt(15));
				veiculo.setIdAgencia(resultSet.getInt(16));
				veiculo.setIdFuncionario(resultSet.getInt(17));
				veiculo.setDataCadastro(resultSet.getDate(18));
				veiculo.setDataManutencao(resultSet.getDate(19));
				veiculo.setAtivo(resultSet.getBoolean(20));
				
				lista.add(veiculo);
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
