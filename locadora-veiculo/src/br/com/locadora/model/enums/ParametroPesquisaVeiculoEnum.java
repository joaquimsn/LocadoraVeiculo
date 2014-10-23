package br.com.locadora.model.enums;

import java.util.ArrayList;
import java.util.List;

import br.com.locadora.utils.locale.LocaleUtils;

public enum ParametroPesquisaVeiculoEnum {
	SELECIONA_TODOS(LocaleUtils.getLocaleView().getString("txt_buscartodos"), 1),
	PLACA(LocaleUtils.getLocaleView().getString("lbl_placa"), 2),
	MODELO(LocaleUtils.getLocaleView().getString("lbl_modelo"), 3);
	
	private String display;
	private int value;
	
	private ParametroPesquisaVeiculoEnum(String display, int value) {
		this.display = display;
		this.value = value;
	}
	
	public static List<Integer> getValueList() {
		List<Integer> lista = new ArrayList<Integer>();
		for(ParametroPesquisaVeiculoEnum objeto : values()) {
			lista.add(objeto.value);
		}
		return lista;
	}
	
	public static List<String> getDisplayList() {
		List<String> lista = new ArrayList<String>();
		for(ParametroPesquisaVeiculoEnum objeto : values()) {
			lista.add(objeto.display);
		}
		return lista;
	}
	
	public static int getValueByDisplay(String display) {
		for(ParametroPesquisaVeiculoEnum objeto : values()) {
			if(objeto.display.equals(display)) {
				return objeto.value;
			}
		}
		return 0;
	}
	
	public static String getDisplayByValue(Integer value) {
		for(ParametroPesquisaVeiculoEnum objeto : values()) {
			if(objeto.value == value.intValue()) {
				return objeto.display;
			}
		}
		return null;
	}
	
	public static ParametroPesquisaVeiculoEnum getEnumByValue(Integer value) {
		for(ParametroPesquisaVeiculoEnum objeto : values()) {
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
