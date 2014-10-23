package br.com.locadora.model.enums;

import java.util.ArrayList;
import java.util.List;

import br.com.locadora.utils.locale.LocaleUtils;

public enum ParametroPesquisaClienteEnum {
	SELECIONA_TODOS(LocaleUtils.getLocaleView().getString("txt_buscartodos"), 1),
	CODIGO(LocaleUtils.getLocaleView().getString("col_codigo"), 2),
	CNH(LocaleUtils.getLocaleView().getString("lbl_cnh"), 3),
	NOME(LocaleUtils.getLocaleView().getString("lbl_nome"), 4),
	EMAIL(LocaleUtils.getLocaleView().getString("lbl_email"), 5);
	
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
