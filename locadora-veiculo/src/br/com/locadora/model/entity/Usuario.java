package br.com.locadora.model.entity;

import br.com.locadora.utils.annotation.Required;

public class Usuario{
	@Required(label = "Usuário", minimo = 4)
	private String usuario;
	@Required(label = "Senha", minimo = 4)
	private String senha;
	private Funcionario funcionario;
	public Usuario(){
		setUsuario("");
		setSenha("");
		setFuncionario(null);
	}
	
	public Usuario(String usuario, String senha, Funcionario funcionario){
		setUsuario(usuario);
		setSenha(senha);
		setFuncionario(funcionario);
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void Logar() {

	}

}
