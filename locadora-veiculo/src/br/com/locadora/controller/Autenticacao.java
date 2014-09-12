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
	public static Boolean autenticar(String usuario, String senha) {

		try {
			// Ler o arquivo txt com o usuário e senha para validação
			File file = new File("./src/br/usuario.txt");

			Scanner scanner = new Scanner(file);
			do {
				if (scanner.next().contains(usuario)) {
					if (scanner.next().equals(senha)) {
						return true;
					}
				}
			} while (scanner.hasNext());
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
