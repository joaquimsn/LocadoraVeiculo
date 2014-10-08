package br.com.locadora.model.entity;

import java.util.Date;

public class Funcionario {
	private int idFuncionario;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private String rg;
	private char genero;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	private String telefone;
	private String email;
	private int nivel;
	private String nomeUsuario;
	private int funcionarioSupervisor;
	private int codigoAgencia;
	private Date dataCadastro;
	private Date dataManutencao;
	private boolean ativo;

	public Funcionario() {
		setId(0);
		setNome("");
		setDataNascimento(null);
		setCpf("");
		setRg("");
		setGenero(' ');
		setLogradouro("");
		setNumero(0);
		setBairro("");
		setCep("");
		setCidade("");
		setUf("");
		setTelefone("");
		setEmail("");
		setNivel(0);
		setFuncionarioSupervisor(0);
		setCodigoAgencia(0);
		setDataCadastro(null);
		setDataManutencao(null);
	}

	public int getId() {
		return idFuncionario;
	}

	public void setId(int id) {
		this.idFuncionario = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getFuncionarioSupervisor() {
		return funcionarioSupervisor;
	}

	public void setFuncionarioSupervisor(int funcionarioSupervisor) {
		this.funcionarioSupervisor = funcionarioSupervisor;
	}

	public int getCodigoAgencia() {
		return codigoAgencia;
	}

	public void setCodigoAgencia(int codigoAgencia) {
		this.codigoAgencia = codigoAgencia;
	}

	public String getUsuario() {
		return nomeUsuario;
	}

	public void setUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataManutencao() {
		return dataManutencao;
	}

	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}

	/**
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}