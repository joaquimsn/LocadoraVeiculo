package br.com.locadora.view;

import javax.swing.text.MaskFormatter;


public class Mask {
	
	/**
	 * Máscara so números
	 * @author Joaquim Neto
	 * @param tamanho INT Quantidade de caracteres que será aceito
	 * @return MaskFormatter
	 */
	public static final MaskFormatter soNumeros(int tamanho) {
		MaskFormatter maskFormatter = null;
		
		try {
			String mascara = "";
			while ((tamanho != 0) && (tamanho > 0)){
				mascara += "#";
				tamanho--;
			}
			maskFormatter = new MaskFormatter(mascara);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return maskFormatter;
	}
	
	/**
	 * Máscara s[o texto
	 * @author Joaquim Neto
	 * @param tamanho INT Quantidade de caracteres que será aceito
	 * @return MaskFormatter
	 */
	public static final MaskFormatter soTexto(int tamanho) {
		MaskFormatter maskFormatter = null;
		
		try {
			String mascara = "";
			while ((tamanho != 0) && (tamanho > 0)){
				mascara += "L";
				tamanho--;
			}
			maskFormatter = new MaskFormatter(mascara);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return maskFormatter;
	}
	
	/**
	 * Máscara para CPF
	 * @author Joaquim Neto
	 * @return MaskFormatter
	 */
	public static final MaskFormatter maskCpf() {
		MaskFormatter maskFormatter = null;
		
		try {
			maskFormatter = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return maskFormatter;
	}
}
