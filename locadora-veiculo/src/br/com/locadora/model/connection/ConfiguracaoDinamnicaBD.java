package br.com.locadora.model.connection;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
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
		parametros = new ParametrosConexao();
		Properties prop = new Properties();

		try {
			FileReader reader = new FileReader("./src/br/com/locadora/model/connection/config.properties");
			prop.load(reader);

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
			outputStream = new FileOutputStream("./src/br/com/locadora/model/connection/config.properties");
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