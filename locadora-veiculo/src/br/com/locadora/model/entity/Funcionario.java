package br.com.locadora.model.entity;
import java.util.Date;

public class Funcionario {
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
	private int funcionarioSupervisor;
	private int codigoAgencia;
	private Funcionario funcionario;
	private Usuario usuario;
	public Funcionario(String nome, Date dataNascimento, String cpf, String rg, char genero, 
						String logradouro, int numero, String bairro, String cep, String cidade, 
						String uf, String telefone, String email, int nivel, int funcionarioSupervisor,
						int codigoAgencia, Funcionario funcionario, Usuario usuario){
		setNome(nome);
		setDataNascimento(dataNascimento);
		setCpf(cpf);
		setRg(rg);
		setGenero(genero);
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setCep(cep);
		setCidade(cidade);
		setUf(uf);
		setTelefone(telefone);
		setEmail(email);
		setNivel(nivel);
		setFuncionarioSupervisor(funcionarioSupervisor);
		setCodigoAgencia(codigoAgencia);
		setFuncionario(funcionario);
		setUsuario(usuario);
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void cadastrar() {

	}

	public void consultar() {

	}

	public void alterar() {

	}

	public void inativar() {

	}

}