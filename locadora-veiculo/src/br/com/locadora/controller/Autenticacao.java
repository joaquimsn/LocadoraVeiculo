package br.com.locadora.controller;

import java.io.File;
import java.io.Serializable;
import java.nio.charset.Charset;

import br.com.locadora.utils.TxtUtils;


public class Autenticacao implements Serializable{
	private static final long serialVersionUID = -8361564707515153741L;
	
	private TxtUtils txtUtils;
	private CryptoAES cryptoAES;

	/**
	 * Faz a autenticaÃ§Ã£o do usuÃ¡rio, verificando se o usuario e a senha sÃ£o iguais aos
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
		
		String msgClaraString = new String(txtUtils.lerTxt(new File("usuario.txt")).getBytes(), Charset.forName("ISO-8859-1"));
		String msgCifradaString;
		
		byte[] msgClaraArrayByte = msgClaraString.getBytes();
		byte[] bMsgCifrada =  null;
		
		// Instancia um objeto da classe CryptoAES
		cryptoAES = new CryptoAES();
		// Gera a Chave criptografica AES simetrica e o nome do arquivo onde serÃ¡ armazenada
		try {
			// Gera a chave
			cryptoAES.geraChave(new File("chave"));
			
			// Gera a cifra AES da mensagem dada, com a chave simetrica dada
			cryptoAES.geraCifra(msgClaraArrayByte, new File("chave"));
			
			// Recebe o texto cifrado
			bMsgCifrada = cryptoAES.getTextoCifrado();
			
			// Converte o texto byte[] no equivalente String
			msgCifradaString = (new String(bMsgCifrada, "ISO-8859-1"));
			
			// Grava a mensagem cifrada no txt
			txtUtils.gravarTxt(new File("controle-usuario"), cryptoAES.getTextoCifrado().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cryptoAES.getTextoCifrado().toString();
	}
	
	public String descriptografar() {
		// Objeto responsavel por ler e gravar aquivos txt
		txtUtils = new TxtUtils();
		
		String msgCifradaString = new String(txtUtils.lerTxt(new File("controle-usuario")).getBytes(), Charset.forName("ISO-8859-1"));
		String msgDecifradaString;
				
		byte[] msgCifradaArrayByte = msgCifradaString.getBytes();
		byte[] msgDecifradaArrayByte = null;
		
		// Instancia um objeto da classe CryptoAES
		cryptoAES = new CryptoAES();
		// Gera a Chave criptografica AES simetrica e o nome do arquivo onde serÃ¡ armazenada
		try { 
			
			File chave = new File("chave");
			
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
