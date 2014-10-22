package br.com.locadora.model.connection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import br.com.locadora.model.vo.ParametrosConexao;
import br.com.locadora.utils.Constants;

public class ConfiguracaoDinamnicaBD {

	private ParametrosConexao parametros;

	/**
	 * Carrega as configurações do Banco de Dados e retorna um objeto ParametroConexao
	 * conténdo os dados necessários para conectar à base
	 * @author Joaquim Neto
	 * @return parametros Objeto ParametrosConexao
	 */
	public ParametrosConexao carregar() {
		parametros = new ParametrosConexao();
		Properties prop = new Properties();

		try {
			FileInputStream inputStream = new FileInputStream(Constants.ABSOLUTEPATH + "config.properties");
			prop.load(inputStream);

			parametros.setUsuario(prop.getProperty("usuario"));
			parametros.setSenha(prop.getProperty("senha"));
			parametros.setPorta(prop.getProperty("porta"));
			parametros.setNomeDb(prop.getProperty("nomeBD"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return parametros;
	}
	
	/**
	 * Salva os novos atributos para conexão com o banco de dados
	 * no arquivo <b>config.properties</b>
	 * @author Joaquim Neto
	 * @param parametros
	 */
	public void salvarParametrosConexao(ParametrosConexao parametros) {
		Properties property = new Properties();
		OutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(Constants.ABSOLUTEPATH + "config.properties");
			property.setProperty("usuario", parametros.getUsuario());
			property.setProperty("senha", parametros.getSenha());
			property.setProperty("porta", parametros.getPorta());
			property.setProperty("nomeBD", parametros.getNomeBd());
			
			property.store(outputStream, null);
		} catch (Exception e) {
			System.err.println("Falha ao gravar os parâmetros de conexão dobanco");
			e.printStackTrace();
		}
	}
}