package br.com.locadora.controller;

import java.io.File;
import java.io.Serializable;

import br.com.locadora.utils.IOUtils;


public class Autenticacao implements Serializable{
	private static final long serialVersionUID = -8361564707515153741L;
	
	private static IOUtils iOUtils;
	private static CryptoAES cryptoAES;
	private static String[] listaLoginsOrdernada;

	/**
	 * Faz a autenticação do usuário, verificando se o <b>usuario, senha e código da agência</b>
	 * corresponde à algum dos login cadastrados
	 * @param usuario String usuário
	 * @param senha String Senha
	 * @param agencia int Código da agência
	 * @return <b>true</b> se o usuario e senha for igual ao cadastrado
	 */
	public static Boolean autenticar(String usuario, String senha, String agencia) {
		String login = usuario + "-" + agencia + "-" + senha;
		
		// Descriptografa o arquivo de autentiação para validar o login
		descriptografar();
		
		int meio = 0;
		int inicio = 0;
		int fim = listaLoginsOrdernada.length - 1;
		
		// Verifica se login procurado está dentro da lista
		if (login.compareTo(listaLoginsOrdernada[fim]) > 0 || login.compareTo(listaLoginsOrdernada[0]) < 0) {
			return false;
		}

		while (inicio <= fim) {
			// Obtém o meio do array
			meio = ((inicio + fim) / 2);
			
			// Se o meio for igual o login retorna true
			if (listaLoginsOrdernada[meio].equals(login)) {
				return true;
			}
			
			// Verifica em qual lado será feita a próxima comparação
			if (listaLoginsOrdernada[meio].compareTo(login) > 0) {
				fim = meio - 1;
			} else {
				inicio = meio + 1;
			}
		}
		
		return false;
	}
	
	/**
	 * Criptografa e retorna a string criptografada
	 * @author Joaquim Neto
	 * @return texto criptografado
	 */
	public static String criptografar() {
		// Objeto responsavel por ler e gravar aquivos
		iOUtils = new IOUtils();
		
		// Armazena as informações que serão criptografados
		String msgClaraString = iOUtils.lerFile(new File("usuario.txt"));
		String msgCifradaString;
		
		byte[] msgClaraArrayByte = msgClaraString.getBytes();
		
		// Instancia um objeto da classe CryptoAES
		cryptoAES = new CryptoAES();
		
		try {
			// Gera a Chave criptografica AES simetrica e o nome do arquivo onde será armazenada
			cryptoAES.geraChave(new File("chave"));
			
			// Gera a cifra AES da mensagem dada, com a chave simetrica dada
			cryptoAES.geraCifra(msgClaraArrayByte, new File("chave"));
			
			// Converte o texto byte[] no equivalente String
			msgCifradaString = (new String(cryptoAES.getTextoCifrado(), "ISO-8859-1"));
			
			// Grava a mensagem cifrada no arquivo definido
			iOUtils.gravarArquivo(new File("controle-usuario.txt"), msgCifradaString);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cryptoAES.getTextoCifrado().toString();
	}
	
	/**
	 * Descriptografa o aqruivo que contém os dados de login do sistema
	 * @author Joaquim Neto
	 * @return String o conteúdo descriptografado
	 */
	public static String descriptografar() {
		// Objeto responsavel por ler e gravar aquivos txt
		iOUtils = new IOUtils();
		
		String msgDecifradaString = null;
		
		// Armazena os dados criptografados do arquivo
		byte[] msgCifradaArrayByte = iOUtils.obterBytesPorFile(new File("controle-usuario.txt"));
		
		// Instancia um objeto da classe CryptoAES
		cryptoAES = new CryptoAES();
		
		try { 
			
			// Chave simetrica para descriptografar o arquivo
			File chave = new File("chave");
			
			// Gera a decifra AES da mensagem dada, segundo a chave simetrica gerada
			cryptoAES.geraDecifra(msgCifradaArrayByte, chave);
			
			// Converte o texto byte[] no equivalente String
			msgDecifradaString = (new String(cryptoAES.getTextoDecifrado(), "ISO-8859-1"));
			
//			iOUtils.gravarArquivo(new File("usuario-decifrado.txt"), msgDecifradaString);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msgDecifradaString;
	}
	
	/**
	 * Ordena a lista de logins em ordem ASC
	 * @author Joaquim Neto
	 */
	public static void ordenarListaLogins() {
		listaLoginsOrdernada = getListaLogins();
		
		// Variável auxiliar para ordernação da lista
		String login = null;
		String antecessor = null;
		String sucessor = null;
		
		// Faz a ordenação da lista de usuário por bubbleSort
		for (int i = 0; i < listaLoginsOrdernada.length; i++) {
			for (int j = 1; j < listaLoginsOrdernada.length -i; j++) {
				// Antecessor recebe o nome do usuário e código da agência
				antecessor = listaLoginsOrdernada[j -1].substring(0, listaLoginsOrdernada[j -1].lastIndexOf("-"));
				
				// Sucessor recebe o nome do usuário e código da agência
				sucessor = listaLoginsOrdernada[j].substring(0, listaLoginsOrdernada[j].lastIndexOf("-"));
				if (antecessor.compareTo(sucessor) > 0) {
					login = listaLoginsOrdernada[j -1];
					listaLoginsOrdernada[j -1] = listaLoginsOrdernada[j];
					listaLoginsOrdernada[j] = login;
				}
			}
		}
	}
	
	/**
	 * Retorna a quantidade de login cadastrados
	 * @author Joaquim Neto
	 * @return int quantidade de login registrados
	 */
	public static int getQuantidadeUsuarios() {
		String aux[] = descriptografar().split("[^a-z-A-Z0-9\\-]");
		
		return aux.length + 1;
	}
	
	/**
	 * Retorna a lista com os logins autorizados para acessar o sistema
	 * os logins são compostos por usuário, senha e código da agência
	 * @author Joaquim Neto
	 * @return String[] com os logins
	 */
	private static String[] getListaLogins() {
		// Os logins são separados por ';' então é usada  a expressão abaixo para 
		// para criar um array, onde cada index corresponde a um login
		// obs: o ponto e virgula não está presente no novo array
		String aux[] = descriptografar().split("[^a-z-A-Z0-9\\-]");
		
		return aux;
	}

}
