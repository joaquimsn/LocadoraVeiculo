package br.com.locadora.model.entity;

import java.util.Date;

import br.com.locadora.model.vo.Endereco;
import br.com.locadora.utils.annotation.Required;

public class Agencia {
	private int idAgencia;
	@Required(label = "Razão social", minimo = 10)
	private String razaoSocial;

	@Required(label = "Nome fantasia", minimo = 5)
	private String nomeFantasia;

	@Required(label = "CNPJ", minimo = 14)
	private String cnpj;

	@Required(label = "Inscrição estadual", minimo = 9)
	private String inscricaoEstadual;

	@Required(label = "Responsavel", minimo = 9)
	private String responsavel;

	private String logradouro;
	private String bairro;
	private int numero;
	private String cep;
	private String cidade;
	private String uf;
	private String telefone;
	private String email;
	private String site;
	private Date dataCadastro;
	private Date dataManutencao;
	private boolean ativo;

	public Agencia() {
		setRazaoSocial("");
		setNomeFantasia("");
		setCnpj("");
		setInscricaoEstadual("");
		setLogradouro("");
		setBairro("");
		setNumero(0);
		setCep("");
		setUf("");
		setCidade("");
		setTelefone("");
		setEmail("");
		setSite("");
	}

	public Agencia(String razaoSocial, String nomeFantasia) {
		setRazaoSocial(razaoSocial);
		setNomeFantasia(nomeFantasia);
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	/**
	 * @return the responsavel
	 */
	public String getResponsavel() {
		return responsavel;
	}

	/**
	 * @param responsavel the responsavel to set
	 */
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the dataManutenção
	 */
	public Date getDataManutencao() {
		return dataManutencao;
	}

	/**
	 * @param dataManutencao the dataManutenção to set
	 */
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
		endereco.setSite(getSite());
		
		return endereco;
	}

}
