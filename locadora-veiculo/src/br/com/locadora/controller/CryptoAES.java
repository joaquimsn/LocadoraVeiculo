package br.com.locadora.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptoAES implements Serializable {
	private static final long serialVersionUID = 253770661159185310L;
	private byte[] textoCifrado;
	private byte[] textoDecifrado;

	public CryptoAES() {
		textoCifrado = null;
		textoDecifrado = null;
	}

	public void geraChave(File file) throws IOException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			CertificateException, KeyStoreException {
		// Gera uma chave simetrica de 128 bits:
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		// Grava a chave simetrica em formato serializado
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(secretKey);
		oos.close();
	}

	public void geraCifra(byte[] texto, File fSim) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
			IOException, ClassNotFoundException, NoSuchProviderException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fSim));
		SecretKey iSim = (SecretKey) ois.readObject();
		byte[] chave = iSim.getEncoded();
		ois.close();
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
		aescf.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"), ivspec);
		textoCifrado = aescf.doFinal(texto);
	}

	public byte[] getTextoCifrado() {
		return textoCifrado;
	}

	public void geraDecifra(byte[] texto, File chave) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException,
			IOException, ClassNotFoundException, NoSuchProviderException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(chave));
		SecretKeySpec iSim = (SecretKeySpec) ois.readObject();
		ois.close();
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
		aescf.init(Cipher.DECRYPT_MODE, iSim, ivspec);
		textoDecifrado = aescf.doFinal(texto);
	}

	public byte[] getTextoDecifrado() {
		return textoDecifrado;
	}

}