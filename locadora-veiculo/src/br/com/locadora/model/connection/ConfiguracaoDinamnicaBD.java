package br.com.locadora.model.connection;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import br.com.locadora.model.vo.ParametrosConexao;

public class ConfiguracaoDinamnicaBD {

	private ParametrosConexao parametros;

	/**
	 * Carrega as configurações do Banco de Dados e retorna um objeto ParametroConexao
	 * conténdo os dados necessários para conectar à base
	 * @author Joaquim Neto
	 * @return parametros Objeto ParametrosConexao
	 */
	public ParametrosConexao carregar() {

		Properties prop = new Properties();

		try {
			FileReader reader = new FileReader("config.properties");
			prop.load(reader);

			parametros.setUsuario(prop.getProperty("Usuario"));
			parametros.setSenha(prop.getProperty("Senha"));
			parametros.setPorta(prop.getProperty("Porta"));
			parametros.setNomeDb(prop.getProperty("DBNome"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return parametros;
	}
	
	public void salvarParametrosConexao(ParametrosConexao parametros) {
		
	}
}