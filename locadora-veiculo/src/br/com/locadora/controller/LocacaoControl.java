
package br.com.locadora.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.locadora.model.DAO.LocacaoDAO;
import br.com.locadora.model.entity.Locacao;
import br.com.locadora.model.entity.Pagamento;
import br.com.locadora.model.entity.Veiculo;
import br.com.locadora.model.enums.StatusLocacaoEnum;
import br.com.locadora.model.enums.StatusVeiculoEnum;
import br.com.locadora.model.enums.TipoTarifaEnum;
import br.com.locadora.utils.Constants;
import br.com.locadora.utils.RelatorioUtil;
import br.com.locadora.utils.SystemUtils;

public class LocacaoControl implements Serializable{
	private static final long serialVersionUID = 4056318420856682823L;
	
	private LocacaoDAO locacaoDAO;
	
	public LocacaoControl() {
		locacaoDAO = new LocacaoDAO();
	}
	
	/**
	 * Faz uma locação validando os dados informados
	 * @author Joaquim Neto
	 * @param locacao
	 * @return Objeto locação com os dados validados
	 */
	public Locacao fazerLocacao(Locacao locacao) {
		double valorLocacao;
		
		if (locacao.getTipoTarifa() == TipoTarifaEnum.KM_CONTROLADO.getValue()) {
			valorLocacao = locacao.getVeiculo().getPrecoKmControlado() * locacao.getKmLocacao();
		} else {
			valorLocacao = locacao.getVeiculo().getPrecoKmLivre() * locacao.getKmLocacao();
		}
		
		// Atribui o valor da locação ao objeto locação
		locacao.setValor(valorLocacao);
		
		// Persiste a locao
		salvar(locacao);
		
		// Busca o id da locação
		int indLocacao = buscarIdLocacao(locacao);
		locacao.setId(indLocacao);
		
		// Atribui os valores da locação ao pagamento
		PagamentoControl pagamentoControl = new PagamentoControl();
		Pagamento pagamento = locacao.getPagamento();
		pagamento.setIdLocacao(indLocacao);
		pagamento.setValor(valorLocacao);
		pagamento.setValor(locacao.getValor());
		
		// Presiste o pagamento
		pagamentoControl.salvarPagamento(locacao.getPagamento());
		
		// Altera o status do veículo para locado
		VeiculoControl veiculoControl = new VeiculoControl();
		Veiculo veiculo = locacao.getVeiculo();
		veiculo.setStatus(StatusVeiculoEnum.LOCADO.getValue());
		veiculoControl.salvarOuAlterar(veiculo);
				
		return locacao;
	}
	
	/**
	 * Persiste uma locação na base de dados
	 * @author Joaquim Neto
	 * @param locacao Objeto Locação
	 * @return <b>true</b> Se for cadastrado com sucesso
	 */
	private boolean salvar(Locacao locacao) {
		// Cria uma nova conexão com o banco de dados
		locacaoDAO = new LocacaoDAO();
		
		locacao.setStatus(StatusLocacaoEnum.ABERTA.getValue());
		locacao.setIdAgencia(SystemUtils.getAgenciaSelecionado().getIdAgencia());
		locacao.setIdFuncionario(SystemUtils.getFuncionarioLogado().getId());
		return locacaoDAO.insert(locacao);
	}
	
	/**
	 * Altera uma locação já persistida na base de dados
	 * @author Joaquim Neto
	 * @param locacao Objeto Locação
	 * @return <b>true</b> Se for alterado com sucesso
	 */
	private boolean alterar(Locacao locacao) {
		// Cria uma nova conexão com o banco de dados
		locacaoDAO = new LocacaoDAO();
		
		return locacaoDAO.update(locacao);
	}
	
	/**
	 * Busca todas as locaçãos cadastradas na base de dados
	 * @author Joaquim Neto
	 * @return List com todas as locaçãos cadastradas
	 */
	public List<Locacao> buscarTodos() {
		// Cria uma nova conexão com o banco de dados
		locacaoDAO = new LocacaoDAO();		
		return locacaoDAO.pesquisarPorCondicao("");
	}
	
	/**
	 * Busca uma locação na base pelo id informado por parâmetro
	 * @author Joaquim Neto
	 * @param id INT ind
	 * @return Locacao
	 */
	public Locacao buscarPorId(int id) {
		// Cria uma nova conexão com o banco de dados
		locacaoDAO = new LocacaoDAO();
		return locacaoDAO.select(id);
	}
	
	private int buscarIdLocacao(Locacao locacao) {
		locacaoDAO = new LocacaoDAO();
		return locacaoDAO.buscarIdLocacao(locacao);
	}
	
	/**
	 * Consulta todas as locaçãos cadastradas na base
	 * @author Joaquim Neto
	 * @param parametro
	 * @param valor
	 * @return List com as locaçãos encontradas
	 */
	public List<Locacao> buscarPorCondicao(int parametro, String valor) {
		// Cria uma nova conexão com o banco de dados
		locacaoDAO = new LocacaoDAO();
		
		String condicao = "";
		
		switch (parametro) {
		case 1:
			condicao = " WHERE ativo = 1";
			break;
		case 2:
			condicao = " WHERE " + "id_locacao  = " + valor + " AND ativo = 1";
			break;
			
		default:
			condicao = " WHERE ativo = 1";
			break;
		}	
		
		return locacaoDAO.pesquisarPorCondicao(condicao);
	}
	
	/**
	 * Consulta todas as locaçãos cadastradas na base por 
	 * período e status
	 * @author Joaquim Neto
	 * @param parametro
	 * @param valor
	 * @return List com as locaçãos encontradas
	 */
	public List<Locacao> buscarPorPeriodo(Date dataInicial, Date dataFinal,  int parametro) {
		// Cria uma nova conexão com o banco de dados
		locacaoDAO = new LocacaoDAO();
		
		String condicao = "";
		String dataInicio = "2014-01-01";
		String dataFim = "2014-11-11";

		
		switch (parametro) {
		case 1:
			condicao = " WHERE  data_hora_locacao >= " + dataInicio + " AND  data_hora_locacao =< " + dataFim;
			break;
		case 2:
			condicao = " WHERE data_hora_locacao >= " + dataInicio + " AND  data_hora_locacao =< " + dataFim + " AND staus = 1";
			break;
			
		case 3:
			condicao = "WHERE data_hora_locacao >= " + dataInicio + " AND  data_hora_locacao =< " + dataFim + " AND staus = 2";
			break;
		}	
		
		return locacaoDAO.pesquisarPorCondicao(condicao);
	}
	
	public JasperPrint gerarComprovanteLocacao(Locacao locacao) throws Exception {
		RelatorioUtil relatorioUtil = new RelatorioUtil();
				
		List<Locacao> lista = new ArrayList<Locacao>();
		lista.add(locacao);
		
		// Adiciona o JRBeanCollenctioDataSource ao Jasper datasource
		JRDataSource dataSource = new JRBeanCollectionDataSource(lista);
		
		// Armazena o DACTE no formato PDF após a geração
		JasperPrint jasperPrint = null;
		
		// HashMap que irá receber os parametros necessário para geração do relatório
		HashMap<String, Object> parametrosRelatorio = new HashMap<String, Object>();		

		// Parâmetros Essenciais para geração do relátorio
		parametrosRelatorio.put("AGENCIA_ORIGEM", SystemUtils.getAgenciaSelecionado());
		parametrosRelatorio.put("FUNCIONARIO", SystemUtils.getFuncionarioLogado());
		
		jasperPrint = relatorioUtil.gerarRelatorio(parametrosRelatorio, "comprovanteLocacao", Constants.DIRETORIO_LAYOUT_JASPER, dataSource);
		
		return jasperPrint;
	}
}
