package br.com.locadora.model.vo;

import java.io.Serializable;

import br.com.locadora.utils.annotation.Required;

public class ParametrosConexao implements Serializable{
	private static final long serialVersionUID = -566813367954918130L;
	
	@Required(label = "Usuário", minimo = 4)
	private String usuario;
	@Required(label = "Senha", minimo = 3)
	private String senha;
	@Required(label = "Nome data base", minimo = 5)
	private String nomeBd;
	@Required(label = "Porta", minimo = 2)
	private String porta;

	public ParametrosConexao(String usuario, String senha, String nomeBd, String porta) {
		setUsuario(usuario);
		setSenha(senha);
		setNomeDb(nomeBd);
		setPorta(porta);
	}

	public ParametrosConexao() {
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