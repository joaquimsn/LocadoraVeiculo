package br.com.locadora.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum GeneroEnum {
	SELECIONE("Selecione", ' '),
	MASCULINO("Masculino", 'm'),
	FEMININO("Feminino", 'f');
	
	private String display;
	private char value;
	
	private GeneroEnum(String display, char value) {
		this.display = display;
		this.value = value;
	}
	
	public static List<Character> getValueList() {
		List<Character> lista = new ArrayList<Character>();
		for(GeneroEnum objeto : values()) {
			lista.add(objeto.value);
		}
		return lista;
	}
	
	public static List<String> getDisplayList() {
		List<String> lista = new ArrayList<String>();
		for(GeneroEnum objeto : values()) {
			lista.add(objeto.display);
		}
		return lista;
	}
	
	public static char getValueByDisplay(String display) {
		for(GeneroEnum objeto : values()) {
			if(objeto.display.equals(display)) {
				return objeto.value;
			}
		}
		return 0;
	}
	
	public static String getDisplayByValue(Character value) {
		for(GeneroEnum objeto : values()) {
			if(objeto.value == value.charValue()) {
				return objeto.display;
			}
		}
		return null;
	}
	
	public static GeneroEnum getEnumByValue(Character value) {
		for(GeneroEnum objeto : values()) {
			if(objeto.value == value.charValue()) {
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
	public char getValue() {
		return value;
	}
}

