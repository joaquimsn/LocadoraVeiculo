package br.com.locadora.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.locadora.model.vo.RelatorioLocacao;
import br.com.locadora.utils.Constants;
import br.com.locadora.utils.RelatorioUtil;

public class RelatorioControl {
	
	public JasperPrint gerarLocacoes(RelatorioLocacao relatorioLocacao) throws Exception {
		RelatorioUtil relatorioUtil = new RelatorioUtil();
				
		List<RelatorioLocacao> lista = new ArrayList<RelatorioLocacao>();
		lista.add(relatorioLocacao);
		
		// Adiciona o JRBeanCollenctioDataSource ao Jasper datasource
		JRDataSource dataSource = new JRBeanCollectionDataSource(lista);
		
		// Armazena o DACTE no formato PDF após a geração
		JasperPrint jasperPrint = null;
		
		// HashMap que irá receber os parametros necessário para geração do relatório
		HashMap<String, Object> parametrosRelatorio = new HashMap<String, Object>();		

		// Parâmetros Essenciais para geração do relátorio
		parametrosRelatorio.put("DIRETORIO_SUB", Constants.DIRETORIO_LAYOUT_JASPER);
		
		jasperPrint = relatorioUtil.gerarRelatorio(parametrosRelatorio, "locacaoPorPeriodo", Constants.DIRETORIO_LAYOUT_JASPER, dataSource);
		
		return jasperPrint;
	}
}
