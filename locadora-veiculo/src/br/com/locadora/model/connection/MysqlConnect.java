package br.com.locadora.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.locadora.utils.locale.LocaleUtils;

public class MysqlConnect {

	public Connection conn = null;

	public MysqlConnect() {

		ConfiguracaoDinamnicaBD config = new ConfiguracaoDinamnicaBD();

		String url = "jdbc:mysql://localhost:" + config.carregar().getPorta() + "/";
		String dbName = config.carregar().getNomeBd();
		String driver = "com.mysql.jdbc.Driver";
		String userName = config.carregar().getUsuario();
		String password = config.carregar().getSenha();

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			System.out.println(LocaleUtils.getLocaleMessages().getString("falha_erro")+"\n");
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}