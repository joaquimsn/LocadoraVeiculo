package br.com.locadora.controller;

import java.io.File;
import java.io.Serializable;

import br.com.locadora.utils.IOUtils;


public class Autenticacao implements Serializable{
	private static final long serialVersionUID = -8361564707515153741L;
	
	private IOUtils iOUtils;
	private CryptoAES cryptoAES;

	/**
	 * Faz a autenticação do usuário, verificando se o usuario e a senha são iguais aos
	 * cadastrados
	 * @param usuario
	 * @param senha
	 * @return <b>true</b> se o usuario e senha for igual ao cadastrado
	 */
	public static Boolean autenticar(String usuario, String senha, String agencia) {
		
		return true;
	}
	
	/**
	 * Criptografa e retorna a string criptografada
	 * @author Joaquim Neto
	 * @return texto criptografado
	 */
	public String criptografar() {
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
	public String descriptografar() {
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
			
			iOUtils.gravarArquivo(new File("usuario-decifrado.txt"), msgDecifradaString);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msgDecifradaString;
	}

}
