package br.com.locadora.controller;

import java.io.File;
import java.io.Serializable;

import br.com.locadora.utils.TxtUtils;


public class Autenticacao implements Serializable{
	private static final long serialVersionUID = -8361564707515153741L;
	
	private TxtUtils txtUtils;
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
	 * Criptografa e retorna  uma string criptografada
	 * @author Joaquim Neto
	 * @return texto criptografado
	 */
	public String criptografar() {
		// Objeto responsavel por ler e gravar aquivos txt
		txtUtils = new TxtUtils();
		
		String msgClaraString = txtUtils.lerTxt(new File("usuario.txt"));
		String msgCifradaString;
		
		byte[] msgClaraArrayByte = msgClaraString.getBytes();
		byte[] bMsgCifrada = null;
		
		/*
		 * Criptografia AES
		 * --------------------------------------------------------------
		 */
		// Instancia um objeto da classe CryptoAES
		cryptoAES = new CryptoAES();
		// Gera a Chave criptografica AES simetrica e o nome do arquivo onde será armazenada
		try {
			// Gera a chave
			cryptoAES.geraChave(new File("chave.simetrica"));
			
			// Gera a cifra AES da mensagem dada, com a chave simetrica dada
			cryptoAES.geraCifra(msgClaraArrayByte, new File("chave.simetrica"));
			
			// Recebe o texto cifrado
			bMsgCifrada = cryptoAES.getTextoCifrado();
			
			// Converte o texto byte[] no equivalente String
			msgCifradaString = (new String(bMsgCifrada, "ISO-8859-1"));
			
			// Grava a mensagem cifrada no txt
			txtUtils.gravarTxt(new File("controle-usuario.txt"), msgCifradaString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cryptoAES.getTextoCifrado().toString();
	}
	
	public String descriptografar() {
		// Objeto responsavel por ler e gravar aquivos txt
		txtUtils = new TxtUtils();
		
		String msgCifradaString = txtUtils.lerTxt(new File("controle-usuario"));
		String msgDecifradaString = null;
				
		byte[] msgCifradaArrayByte = msgCifradaString.getBytes();
		byte[] msgDecifradaArrayByte = null;
		
		// Instancia um objeto da classe CryptoAES
		cryptoAES = new CryptoAES();
		// Gera a Chave criptografica AES simetrica e o nome do arquivo onde será armazenada
		try { 
			
			File chave = new File("chave.simetrica");
			
			// Gera a decifra AES da mensagem dada, segundo a chave simetrica gerada
			cryptoAES.geraDecifra(msgCifradaArrayByte, chave);
			
			// Converte o texto byte[] no equivalente String
			msgDecifradaString = (new String(msgDecifradaArrayByte, "ISO-8859-1"));
			
			// recebe o texto decifrado
			msgDecifradaArrayByte = cryptoAES.getTextoDecifrado();
			txtUtils.gravarTxt(new File("usuario.txt"), msgDecifradaString);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cryptoAES.getTextoDecifrado().toString();
	}

}
