package br.com.locadora.controller;


import java.io.File;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.locadora.utils.IOUtils;
import br.com.locadora.view.LoginGUI;

public class MainSistemaLocadora {
	
	public static void main(String[] args) {
		// Define o look in feel Nimbus para aplicação
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Autenticacao autenticacao = new Autenticacao();
		autenticacao.criptografar();
		System.out.println(autenticacao.descriptografar());
		
		new LoginGUI();
	}	
}
