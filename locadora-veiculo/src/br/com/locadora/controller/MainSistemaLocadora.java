package br.com.locadora.controller;


import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

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
		
		// Garante que a lista de login está ordernada
		Autenticacao autenticacao = new Autenticacao();
		autenticacao.ordenarListaLogins();
		
//		System.out.println(autenticacao.getQuantidadeUsuarios());
//		autenticacao.criptografar();
	
		
		//Teste insert
//		AgenciaDAO agenciaDAO = new AgenciaDAO();
//		Agencia agencia = new Agencia();
//		agencia.setBairro("Centro");
//		agencia.setCep("02224-010");
//		agencia.setCidade("São Paulo");
//		agencia.setCnpj("17.481.473/0001-50");
//		agencia.setEmail("teste@teste.com");
//		agencia.setInscricaoEstadual("000.000.000");
//		agencia.setLogradouro("Rua central");
//		agencia.setNomeFantasia("ID & OTA Locação LTDA");
//		agencia.setNumero(20);
//		agencia.setRazaoSocial("Zé da esquina locação e venda LTDA");
//		agencia.setUf("SP");
//		
//		agenciaDAO.insert(agencia);
		
		new LoginGUI();
	}	
}
