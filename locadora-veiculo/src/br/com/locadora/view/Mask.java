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
	 * Máscara para Telefone
	 * @author Joaquim Neto
	 * @return MaskFormatter (00) 0000-0000
	 */
	public static final MaskFormatter maskTelefone() {
		MaskFormatter maskFormatter = null;
		
		try {
			maskFormatter = new MaskFormatter("(##) ####-####");
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
	
	/**
	 * Máscara para placa de veículo
	 * @author Joaquim Neto
	 * @return MaskFormatter
	 */
	public static final MaskFormatter maskPlaca() {
		MaskFormatter maskFormatter = null;
		
		try {
			maskFormatter = new MaskFormatter("UUU-####");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return maskFormatter;
	}
}
