package br.com.locadora.utils;

import java.util.ArrayList;

public class Constants {
	
	static {
			// Inicializa as listas constantes no startup do servidor
			UF = new ArrayList<String>();
			inicializaUf();
		}
	
	/**
	 * Caminho que contém os properties de internacionalização das views do sistema
	 */
	public static final String PATH_VIEWS_INTERNACIONALIZADA = "br/com/locadora/utils/locale/views/views";
	
	/**
	 * Caminho que contém os properties de internacionalização das mensagem do sistema
	 */
	public static final String PATH_MESSAGES_INTERNACIONALIZADA = "br/com/locadora/utils/locale/messages/messages";
	
	/**
	 * Lista de Unidades de Federação
	 */
	public static final ArrayList<String> UF;
	
	/**
	 * Lista de Unidades de Federação
	 */
	private static ArrayList<String> inicializaUf() {
		
		UF.add("SP");
		UF.add("RJ");
		UF.add("AC");
		UF.add("AL");
		UF.add("AM");
		UF.add("AP");
		UF.add("BA");
		UF.add("CE");
		UF.add("DF");
		UF.add("ES");
		UF.add("GO");
		UF.add("MA");
		UF.add("MT");
		UF.add("MS");
		UF.add("MG");
		UF.add("PA");
		UF.add("PB");
		UF.add("PE");
		UF.add("PI");
		UF.add("PR");
		UF.add("RN");
		UF.add("RO");
		UF.add("RR");
		UF.add("RS");
		UF.add("SC");
		UF.add("SE");
		UF.add("TO");
		
		return UF;
	}
}
