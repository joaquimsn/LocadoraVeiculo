package br.com.locadora.model.enums;

import java.util.ArrayList;
import java.util.List;

import br.com.locadora.utils.locale.LocaleUtils;

public enum NivelUsuarioEnum {
	SELECIONE(LocaleUtils.getLocaleView().getString("txt_selecione"), 0),
	ATENDENTE(LocaleUtils.getLocaleView().getString("txt_atendente"), 1),
	SUPERVISOR(LocaleUtils.getLocaleView().getString("txt_supervisor"), 2);
	
	private String display;
	private int value;
	
	private NivelUsuarioEnum(String display, int value) {
		this.display = display;
		this.value = value;
	}
	
	public static List<Integer> getValueList() {
		List<Integer> lista = new ArrayList<Integer>();
		for(NivelUsuarioEnum objeto : values()) {
			lista.add(objeto.value);
		}
		return lista;
	}
	
	public static List<String> getDisplayList() {
		List<String> lista = new ArrayList<String>();
		for(NivelUsuarioEnum objeto : values()) {
			lista.add(objeto.display);
		}
		return lista;
	}
	
	public static int getValueByDisplay(String display) {
		for(NivelUsuarioEnum objeto : values()) {
			if(objeto.display.equals(display)) {
				return objeto.value;
			}
		}
		return 0;
	}
	
	public static String getDisplayByValue(Integer value) {
		for(NivelUsuarioEnum objeto : values()) {
			if(objeto.value == value.intValue()) {
				return objeto.display;
			}
		}
		return null;
	}
	
	public static NivelUsuarioEnum getEnumByValue(Integer value) {
		for(NivelUsuarioEnum objeto : values()) {
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
