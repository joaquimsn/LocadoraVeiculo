package br.com.locadora.model.enums;

import java.util.ArrayList;
import java.util.List;

import br.com.locadora.utils.locale.LocaleUtils;

public enum GrupoVeiculoEnum {
	SELECIONE("Selecione", 0),
	A("A – " + LocaleUtils.getLocaleView().getString("txt_economico"), 1),
	C("C – " + LocaleUtils.getLocaleView().getString("txt_economico") + 
				LocaleUtils.getLocaleView().getString("txt_comar"), 2),
	E("F – " + LocaleUtils.getLocaleView().getString("txt_intermediario"), 3),
	G("G – " + LocaleUtils.getLocaleView().getString("txt_intermediario")
			 + LocaleUtils.getLocaleView().getString("txt_wagonespecial"), 4),
	H("H – " + LocaleUtils.getLocaleView().getString("txt_executivo"), 5),
	I("I – " + LocaleUtils.getLocaleView().getString("txt_utilitario"), 6),
	K("K – " + LocaleUtils.getLocaleView().getString("txt_executivo")
			 + LocaleUtils.getLocaleView().getString("txt_luxo"), 7),
	M("M – " + LocaleUtils.getLocaleView().getString("txt_intermediario")+ " Wagon", 8),
	N("N – Pick-up", 9),
	P("P – " + LocaleUtils.getLocaleView().getString("txt_4x4especial"), 10),
	R("R – " + LocaleUtils.getLocaleView().getString("txt_minivan"), 11),
	U("U – " + LocaleUtils.getLocaleView().getString("txt_furgao"), 12),
	Y("Y – " + LocaleUtils.getLocaleView().getString("txt_blindado"), 13);
	
	private String display;
	private int value;
	
	private GrupoVeiculoEnum(String display, int value) {
		this.display = display;
		this.value = value;
	}
	
	public static List<Integer> getValueList() {
		List<Integer> lista = new ArrayList<Integer>();
		for(GrupoVeiculoEnum objeto : values()) {
			lista.add(objeto.value);
		}
		return lista;
	}
	
	public static List<String> getDisplayList() {
		List<String> lista = new ArrayList<String>();
		for(GrupoVeiculoEnum objeto : values()) {
			lista.add(objeto.display);
		}
		return lista;
	}
	
	public static int getValueByDisplay(String display) {
		for(GrupoVeiculoEnum objeto : values()) {
			if(objeto.display.equals(display)) {
				return objeto.value;
			}
		}
		return 0;
	}
	
	public static String getDisplayByValue(Integer value) {
		for(GrupoVeiculoEnum objeto : values()) {
			if(objeto.value == value.intValue()) {
				return objeto.display;
			}
		}
		return null;
	}
	
	public static GrupoVeiculoEnum getEnumByValue(Integer value) {
		for(GrupoVeiculoEnum objeto : values()) {
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

