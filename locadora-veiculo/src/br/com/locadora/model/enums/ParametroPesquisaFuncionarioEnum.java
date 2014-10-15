package br.com.locadora.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum ParametroPesquisaFuncionarioEnum {
	SELECIONA_TODOS("Buscar todos", 1),
	CODIGO("Código", 2),
	CPF("CPF", 3),
	NOME("Nome", 4),
	USUARIO("Usuário", 5);
	
	private String display;
	private int value;
	
	private ParametroPesquisaFuncionarioEnum(String display, int value) {
		this.display = display;
		this.value = value;
	}
	
	public static List<Integer> getValueList() {
		List<Integer> lista = new ArrayList<Integer>();
		for(ParametroPesquisaFuncionarioEnum objeto : values()) {
			lista.add(objeto.value);
		}
		return lista;
	}
	
	public static List<String> getDisplayList() {
		List<String> lista = new ArrayList<String>();
		for(ParametroPesquisaFuncionarioEnum objeto : values()) {
			lista.add(objeto.display);
		}
		return lista;
	}
	
	public static int getValueByDisplay(String display) {
		for(ParametroPesquisaFuncionarioEnum objeto : values()) {
			if(objeto.display.equals(display)) {
				return objeto.value;
			}
		}
		return 0;
	}
	
	public static String getDisplayByValue(Integer value) {
		for(ParametroPesquisaFuncionarioEnum objeto : values()) {
			if(objeto.value == value.intValue()) {
				return objeto.display;
			}
		}
		return null;
	}
	
	public static ParametroPesquisaFuncionarioEnum getEnumByValue(Integer value) {
		for(ParametroPesquisaFuncionarioEnum objeto : values()) {
			if(objeto.value == value.intValue()) {
				return objeto;
			}
		}
		return null;
	}

	/**
	 * @return the display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
}
