package br.com.locadora.model.entity;

import java.util.Date;

import br.com.locadora.utils.annotation.Required;

public class Veiculo {
	private int id;
	@Required(label = "Modelo", minimo = 4)
	private String modelo;
	@Required(label = "Fabricante", minimo = 3)
	private String fabricante;
	private String imagem;
	@Required(label = "Ano", minimo = 4)
	private int ano;
	private int grupo;
	private int acessorio;
	@Required(label = "Chassi", minimo = 17)
	private String chassi;
	@Required(label = "Placa", minimo = 7)
	private String placa;
	@Required(label = "Cidade", minimo = 4)
	private String cidade;
	@Required(label = "UF", minimo = 2)
	private String uf;
	private double kmRodado;
	private double precoKmLivre;
	private double precoKmControlado;
	private int status;
	private int idAgencia;
	private int idFuncionario;
	private Date dataCadastro;
	private Date dataManutencao;
	private boolean ativo;

	public Veiculo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public int getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(int acessorio) {
		this.acessorio = acessorio;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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

	public double getKmRodado() {
		return kmRodado;
	}

	public void setKmRodado(double kmRodado) {
		this.kmRodado = kmRodado;
	}

	public double getPrecoKmLivre() {
		return precoKmLivre;
	}

	public void setPrecoKmLivre(double precoKmLivre) {
		this.precoKmLivre = precoKmLivre;
	}

	public double getPrecoKmControlado() {
		return precoKmControlado;
	}

	public void setPrecoKmControlado(double precoKmControlado) {
		this.precoKmControlado = precoKmControlado;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}

	/**
	 * @return the idFuncionario
	 */
	public int getIdFuncionario() {
		return idFuncionario;
	}

	/**
	 * @param idFuncionario the idFuncionario to set
	 */
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
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
	 * @param dataManutencao the dataManutencao to set
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
}
