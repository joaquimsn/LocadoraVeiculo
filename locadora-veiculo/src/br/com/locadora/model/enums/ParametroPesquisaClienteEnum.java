package br.com.locadora.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum ParametroPesquisaClienteEnum {
	SELECIONA_TODOS("Buscar todos", 1),
	CODIGO("Código", 2),
	CNH("CNH", 3),
	NOME("Nome", 4),
	EMAIL("E-Mail", 5);
	
	private String display;
	private int value;
	
	private ParametroPesquisaClienteEnum(String display, int value) {
		this.display = display;
		this.value = value;
	}
	
	public static List<Integer> getValueList() {
		List<Integer> lista = new ArrayList<Integer>();
		for(ParametroPesquisaClienteEnum objeto : values()) {
			lista.add(objeto.value);
		}
		return lista;
	}
	
	public static List<String> getDisplayList() {
		List<String> lista = new ArrayList<String>();
		for(ParametroPesquisaClienteEnum objeto : values()) {
			lista.add(objeto.display);
		}
		return lista;
	}
	
	public static int getValueByDisplay(String display) {
		for(ParametroPesquisaClienteEnum objeto : values()) {
			if(objeto.display.equals(display)) {
				return objeto.value;
			}
		}
		return 0;
	}
	
	public static String getDisplayByValue(Integer value) {
		for(ParametroPesquisaClienteEnum objeto : values()) {
			if(objeto.value == value.intValue()) {
				return objeto.display;
			}
		}
		return null;
	}
	
	public static ParametroPesquisaClienteEnum getEnumByValue(Integer value) {
		for(ParametroPesquisaClienteEnum objeto : values()) {
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
