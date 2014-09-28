package br.com.locadora.model.entity;
public class Veiculo {
	private int id;
	private String modelo;
	private String fabricante;
	private String imagem;
	private int ano;
	private int grupo;
	private String acessorio;
	private String chassi;
	private String placa;
	private String cidade;
	private String uf;
	private double kmRodado;
	private double precoKmLivre;
	private double precoKmControlado;
	private String status;
	private Devolucao devolucao;
	private Locacao locacao;
	private Agencia agencia;
	
	public Veiculo(){
		
	}

	public int getId(){
		return id;
	}
	
	public void setId(int id){
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
	public String getAcessorio() {
		return acessorio;
	}
	public void setAcessorio(String acessorio) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Devolucao getDevolucao() {
		return devolucao;
	}
	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}
	public Locacao getLocacao() {
		return locacao;
	}
	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public void Cadastrar() {
	}
	public void Consultar() {
	}
	public void Alterar() {
	}
	public void Inativar() {
	}
}
