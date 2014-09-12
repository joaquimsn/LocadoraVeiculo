package br.com.locadora.controller;


import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.locadora.view.TelaPrincipalGUI;

public class MainSistemaLocadora {
	
	public static void main(String[] args) {
		// Define o look in feel Nimbus para à aplicação
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
		
		TelaPrincipalGUI telaPrincipalGUI = new TelaPrincipalGUI();
	}
}
