package br.com.locadora.model.vo;

public class ParametrosConexao {

	private String usuario, senha, nomeBd, porta;

	public ParametrosConexao(String usuario, String senha, String nomeBd, String porta) {
		setUsuario(usuario);
		setSenha(senha);
		setNomeDb(nomeBd);
		setPorta(porta);
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	public String getNomeBd() {
		return nomeBd;
	}

	public String getPorta() {
		return porta;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNomeDb(String nomeBd) {
		this.nomeBd = nomeBd;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

}