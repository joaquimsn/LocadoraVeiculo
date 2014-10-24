package br.com.locadora.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class RelatorioUtil {

	/**
	 * Retorna um objeto StreamedContent com o relatório gerado em formato PDF
	 * @author Joaquim Neto
	 * @param parametrosRelatorio HashMap com os parâmetros que existirem no report.jasper
	 *            se o report não tiver parâmetro, forneça um HashMap vazio
	 * @param nomeLayoutJasper Nome do arquivo de layout Jasper
	 * @param diretorioRelatorio Nome do diretório onde está o arquivo jasper
	 * @param nomeRelatorioSaida Nome para o relatório que será gerado
	 * @param dataSource Que contém os dados para geração do relatório
	 * @return StreamedContent com PDF
	 * @throws Exception
	 */
	public JasperPrint gerarRelatorio(HashMap<String, Object> parametrosRelatorio, String nomeLayoutJasper,
			String diretorioRelatorio, JRDataSource dataSource) throws Exception {
		
		JasperPrint arquivoRetorno = null;
		try {

			String caminhoRelatorio = diretorioRelatorio;

			// Verifica se o nome do arquivo já tem extenção
			if (!nomeLayoutJasper.endsWith(".jasper")) {
				nomeLayoutJasper += ".jasper";
			}
			
			// Define o idioma padrão para Português Brasil
			parametrosRelatorio.put("REPORT_LOCALE", new Locale("pt", "BR"));
			
			// Adiciona a logo do cliente ao parâmetro LOGO_EMPRESA
			
			String caminhoArquivoJasper = caminhoRelatorio + File.separator + nomeLayoutJasper;

			File jasperFile = new File(caminhoArquivoJasper);

			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametrosRelatorio, dataSource);


			arquivoRetorno = jasperPrint;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Não foi possivel gerar o relatório.", e);
		}
		return arquivoRetorno;
	}
}
