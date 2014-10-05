package br.com.locadora.view;

import javax.swing.text.MaskFormatter;


public class Mask {
	
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
	
	/**
	 * Máscara para CEP
	 * @author Joaquim Neto
	 * @return MaskFormatter
	 */
	public static final MaskFormatter maskCep() {
		MaskFormatter maskFormatter = null;
		
		try {
			maskFormatter = new MaskFormatter("#####-###");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return maskFormatter;
	}
	
	/**
	 * Máscara para CNPJ
	 * @author Joaquim Neto
	 * @return MaskFormatter
	 */
	public static final MaskFormatter maskCnpj() {
		MaskFormatter maskFormatter = null;
		
		try {
			maskFormatter = new MaskFormatter("##.###.###/####-##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return maskFormatter;
	}
}
