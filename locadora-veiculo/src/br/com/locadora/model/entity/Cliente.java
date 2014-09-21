package br.com.locadora.model.entity;
import java.util.Date;
public class Cliente {
	private int id;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private String rg;
	private String cnh;
	private String estadoEmissor;
	private Date validadeCnh;
	private int genero;
	private String logradouro;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;
	private int numero;
	private String telefone;
	private String email;
	private int agencia;
	
	public Cliente(){
		setId(0);
		setNome("");
		setDataNascimento(null);
		setCnh("");
		setEstadoEmissor("");
		setValidadeCnh(null);
		setGenero(0);
		setLogradouro("");
		setBairro("");
		setCep("");
		setCidade("");
		setUf("");
		setNumero(0);
		setTelefone("");
		setEmail("");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getEstadoEmissor() {
		return estadoEmissor;
	}
	public void setEstadoEmissor(String estadoEmissor) {
		this.estadoEmissor = estadoEmissor;
	}
	public Date getValidadeCnh() {
		return validadeCnh;
	}
	public void setValidadeCnh(Date validadeCnh) {
		this.validadeCnh = validadeCnh;
	}
	public int getGenero() {
		return genero;
	}
	public void setGenero(int genero) {
		this.genero = genero;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public void cadastrar() {
	
	}
	public void consultar() {

	}

}
