package br.com.locadora.view;

import br.com.locadora.utils.locale.LocaleUtils;

public class Teste {
	
	public static void main(String[] args) {
		LocaleUtils.setLocaleId("CA_BR", true);
		
		
		System.out.println(LocaleUtils.getLocaleView().getString("titulo_sys"));
		System.out.println(LocaleUtils.getLocaleView().getLocale());
	}
}
