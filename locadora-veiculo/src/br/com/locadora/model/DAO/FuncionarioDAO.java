package br.com.locadora.model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.locadora.model.connection.MysqlConnect;
import br.com.locadora.model.entity.Funcionario;
import br.com.locadora.model.enums.NivelUsuarioEnum;
import br.com.locadora.utils.SystemUtils;

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
				"funcionario_supervisor," +
				"id_agencia," +
				"data_cadastro," +
				"ativo) " +
			"VALUES" +
				"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1, funcionario.getNome());
			sqlSt.setDate(2, SystemUtils.dataConverter(funcionario.getDataNascimento()));
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
			sqlSt.setInt(16,  funcionario.getFuncionarioSupervisor());
			sqlSt.setInt(17, funcionario.getCodigoAgencia());	
			sqlSt.setDate(18, SystemUtils.dataConverter(funcionario.getDataCadastro()));
			sqlSt.setBoolean(19, funcionario.isAtivo());
			sqlSt.execute();
			return true;
		} catch (Exception updateError) {
			updateError.printStackTrace();
			return false;
		} finally {
			closeConnection();
		}
	}

	public Funcionario select(int id) {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		Funcionario funcionario = null;
		
		try{
			String sql = "SELECT * FROM funcionario WHERE id_funcionario = ? AND ativo = 1";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setInt(1, id);
			resultSet = sqlSt.executeQuery();
			
			while(resultSet.next()){
				funcionario = new Funcionario();
				
				funcionario.setId(resultSet.getInt(1));
				funcionario.setNome(resultSet.getString(2));
				funcionario.setDataNascimento(resultSet.getDate(3));
				funcionario.setCpf(resultSet.getString(4));
				funcionario.setRg(resultSet.getString(5));
				funcionario.setGenero(resultSet.getString(6).charAt(0));
				funcionario.setLogradouro(resultSet.getString(7));
				funcionario.setNumero(resultSet.getInt(8));
				funcionario.setBairro(resultSet.getString(9));
				funcionario.setCep(resultSet.getString(10));
				funcionario.setCidade(resultSet.getString(11));
				funcionario.setUf(resultSet.getString(12));
				funcionario.setTelefone(resultSet.getString(13));
				funcionario.setEmail(resultSet.getString(14));
				funcionario.setNivel(resultSet.getInt(15));
				funcionario.setUsuario(resultSet.getString(16));
				funcionario.setFuncionarioSupervisor(resultSet.getInt(17));
				funcionario.setCodigoAgencia(resultSet.getInt(18));
				funcionario.setDataCadastro(resultSet.getDate(19));
				funcionario.setDataManutencao(resultSet.getDate(20));
				funcionario.setAtivo(resultSet.getBoolean(21));
				
			}

			return funcionario;
		}catch(Exception selectError){
			selectError.printStackTrace();
			return null;
		}
	}
	
	public Funcionario selectByUser(String nomeUsuario) {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		Funcionario funcionario = null;
		
		try{
			String sql = "SELECT * FROM funcionario WHERE usuario = ? AND ativo = 1";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setString(1, nomeUsuario);
			resultSet = sqlSt.executeQuery();
			
			while(resultSet.next()){
				funcionario = new Funcionario();
				
				funcionario.setId(resultSet.getInt(1));
				funcionario.setNome(resultSet.getString(2));
				funcionario.setDataNascimento(resultSet.getDate(3));
				funcionario.setCpf(resultSet.getString(4));
				funcionario.setRg(resultSet.getString(5));
				funcionario.setGenero(resultSet.getString(6).charAt(0));
				funcionario.setLogradouro(resultSet.getString(7));
				funcionario.setNumero(resultSet.getInt(8));
				funcionario.setBairro(resultSet.getString(9));
				funcionario.setCep(resultSet.getString(10));
				funcionario.setCidade(resultSet.getString(11));
				funcionario.setUf(resultSet.getString(12));
				funcionario.setTelefone(resultSet.getString(13));
				funcionario.setEmail(resultSet.getString(14));
				funcionario.setNivel(resultSet.getInt(15));
				funcionario.setUsuario(resultSet.getString(16));
				funcionario.setFuncionarioSupervisor(resultSet.getInt(17));
				funcionario.setCodigoAgencia(resultSet.getInt(18));
				funcionario.setDataCadastro(resultSet.getDate(19));
				funcionario.setDataManutencao(resultSet.getDate(20));
				funcionario.setAtivo(resultSet.getBoolean(21));
				
			}
			
			return funcionario;
	
		} catch (Exception selectError) {
			selectError.printStackTrace();
			return null;
		} finally {
			closeConnection();
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
		} catch (Exception selectError) {
			selectError.printStackTrace();
			return false;
		} finally {
			closeConnection();
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
	
	/**
	 * Busca todos os funcionários com nível supervisor
	 * @author Joaquim Neto
	 * @param nomeUsuario
	 * @return List 
	 */
	public List<Funcionario> selectAllSupervisor() {
		PreparedStatement sqlSt;
		ResultSet resultSet;
		List<Funcionario> lista = new ArrayList<>();
		
		int nivel = NivelUsuarioEnum.SUPERVISOR.getValue();
		
		try{
			String sql = "SELECT * FROM funcionario WHERE nivel = ? AND ativo = 1";
			sqlSt = conn.prepareStatement(sql);
			sqlSt.setInt(1, nivel);
			resultSet = sqlSt.executeQuery();
			
			while(resultSet.next()){
				Funcionario funcionario = new Funcionario();
				
				funcionario.setId(resultSet.getInt(1));
				funcionario.setNome(resultSet.getString(2));
				funcionario.setDataNascimento(resultSet.getDate(3));
				funcionario.setCpf(resultSet.getString(4));
				funcionario.setRg(resultSet.getString(5));
				funcionario.setGenero(resultSet.getString(6).charAt(0));
				funcionario.setLogradouro(resultSet.getString(7));
				funcionario.setNumero(resultSet.getInt(8));
				funcionario.setBairro(resultSet.getString(9));
				funcionario.setCep(resultSet.getString(10));
				funcionario.setCidade(resultSet.getString(11));
				funcionario.setUf(resultSet.getString(12));
				funcionario.setTelefone(resultSet.getString(13));
				funcionario.setEmail(resultSet.getString(14));
				funcionario.setNivel(resultSet.getInt(15));
				funcionario.setUsuario(resultSet.getString(16));
				funcionario.setFuncionarioSupervisor(resultSet.getInt(17));
				funcionario.setCodigoAgencia(resultSet.getInt(18));
				funcionario.setDataCadastro(resultSet.getDate(19));
				funcionario.setDataManutencao(resultSet.getDate(20));
				funcionario.setAtivo(resultSet.getBoolean(21));
				
				lista.add(funcionario);
			}
			
			return lista;
	
		} catch (Exception selectError) {
			selectError.printStackTrace();
			return null;
		} finally {
			closeConnection();
		}
	}

	
	/**
	 * Busca todas as funcionarios cadastradas na base, com base na conditional 
	 * passada por parâmetro, a query usada para pesquisa é <b>SELECt * FROM funcionario</b>
	 * @author Joaquim Neto
	 * @param conditional condição para a consulta sql
	 * @return Lista com os funcionarios encontrados
	 */
	public List<Funcionario> pesquisarPorCondicao(String conditional){
		List<Funcionario> lista = new ArrayList<Funcionario>();
		ResultSet resultSet;
		Funcionario funcionario;
		
		try{
			String sql = "SELECT * FROM funcionario " + conditional;
			
			PreparedStatement st = conn.prepareStatement(sql);
			resultSet = st.executeQuery();
			
			while(resultSet.next()){
				funcionario = new Funcionario();
				
				funcionario.setId(resultSet.getInt(1));
				funcionario.setNome(resultSet.getString(2));
				funcionario.setDataNascimento(resultSet.getDate(3));
				funcionario.setCpf(resultSet.getString(4));
				funcionario.setRg(resultSet.getString(5));
				funcionario.setGenero(resultSet.getString(6).charAt(0));
				funcionario.setLogradouro(resultSet.getString(7));
				funcionario.setNumero(resultSet.getInt(8));
				funcionario.setBairro(resultSet.getString(9));
				funcionario.setCep(resultSet.getString(10));
				funcionario.setCidade(resultSet.getString(11));
				funcionario.setUf(resultSet.getString(12));
				funcionario.setTelefone(resultSet.getString(13));
				funcionario.setEmail(resultSet.getString(14));
				funcionario.setNivel(resultSet.getInt(15));
				funcionario.setUsuario(resultSet.getString(16));
				funcionario.setFuncionarioSupervisor(resultSet.getInt(17));
				funcionario.setCodigoAgencia(resultSet.getInt(18));
				funcionario.setDataCadastro(resultSet.getDate(19));
				funcionario.setDataManutencao(resultSet.getDate(20));
				funcionario.setAtivo(resultSet.getBoolean(21));
				
				lista.add(funcionario);
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
