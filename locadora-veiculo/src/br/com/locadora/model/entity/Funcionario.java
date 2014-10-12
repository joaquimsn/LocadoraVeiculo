package br.com.locadora.model.entity;

import java.util.Date;

import br.com.locadora.controller.AgenciaControl;
import br.com.locadora.controller.FuncionarioControl;
import br.com.locadora.model.enums.GeneroEnum;
import br.com.locadora.model.enums.NivelUsuarioEnum;
import br.com.locadora.model.vo.Endereco;
import br.com.locadora.utils.annotation.Required;

public class Funcionario {
	private int idFuncionario;
	@Required(label = "Nome", minimo = 5)
	private String nome;
	private Date dataNascimento;
	@Required(label = "CPF", minimo = 11)
	private String cpf;
	@Required(label = "RG", minimo = 9)
	private String rg;
	private char genero;
	@Required(label = "Endereço", minimo = 10)
	private String logradouro;
	private int numero;
	@Required(label = "Bairro", minimo = 4)
	private String bairro;
	private String cep;
	@Required(label = "Cidade", minimo = 4)
	private String cidade;
	@Required(label = "Estado", minimo = 2)
	private String uf;
	private String telefone;
	private String email;
	private int nivel;
	@Required(label = "Usuário", minimo = 4)
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
	
	/**
	 * Retorna o genério formatado para visualização
	 * @author Joaquim Neto
	 * @return String 
	 */
	public String getGeneroDisplay() {
		return GeneroEnum.getDisplayByValue(getGenero());
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
	
	/**
	 * Nível de permissão do usuário formatado para visualização
	 * @author Joaquim Neto
	 * @return String 
	 */
	public String getNivelDisplay() {
		return NivelUsuarioEnum.getDisplayByValue(getNivel());
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getFuncionarioSupervisor() {
		return funcionarioSupervisor;
	}
	
	public Funcionario getSupervisor() {
		FuncionarioControl funcionarioControl = new FuncionarioControl();
		return funcionarioControl.buscarPorId(getFuncionarioSupervisor());
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
	
	public Agencia getAgencia() {
		AgenciaControl control = new AgenciaControl();
		return control.buscarPorId(getCodigoAgencia());
	}
	
	/**
	 * Retorna um objeto endereço com os dados presente
	 * na instacia atual do objeto
	 * @author Joaquim Neto
	 * @return Objeto Endereço
	 */
	public Endereco getEndereco() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(getLogradouro());
		endereco.setBairro(getBairro());
		endereco.setNumero(getNumero());
		endereco.setCep(getCep());
		endereco.setUf(getUf());
		endereco.setCidade(getCidade());
		endereco.setTelefone(getTelefone());
		endereco.setEmail(getEmail());
		endereco.setSite("");
		
		return endereco;
	}
}