package br.com.locadora.controller;

import java.io.File;
import java.util.Scanner;

public class Autenticacao {

	/**
	 * Faz a autenticação do usuário, verificando se o usuario e a senha são iguais aos
	 * cadastrados
	 * @param usuario
	 * @param senha
	 * @return <b>true</b> se o usuario e senha for igual ao cadastrado
	 */
	public static Boolean autenticar(String usuario, String senha, String agencia) {

		try {
			// Ler o arquivo txt com o usuário e senha para validação
			File file = new File("usuario.txt");

			Scanner scanner = new Scanner(file);
			String texto = "";
			while (scanner.hasNext()){
				texto += scanner.next();
			}
			scanner.close();
			String[] usuarioSenha2 = texto.split(",");
			String agencias[] = new String[3];
			String usuarios[] = new String[3];
			String senhas[] = new String[3];
			int auxiliar = 0;
			for (int i = 0; i < (usuarioSenha2.length / 3); i++){
				agencias[i] = usuarioSenha2[auxiliar];
				usuarios[i] = usuarioSenha2[(auxiliar + 1)];
				senhas[i] = usuarioSenha2[(auxiliar + 2)];
				auxiliar += 3;
			}
			for (int i = 0; i < 3; i++){
				if ((agencia.equals(agencias[i])) && (usuario.equals(usuarios[i])) && (senha.equals(senhas[i]))){
					return true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Criptografa e retorna  uma string criptografada
	 * @author Joaquim Neto
	 * @return Senha criptografada
	 */
	public String criptografar(String string) {
		
		return null;
	}

}
