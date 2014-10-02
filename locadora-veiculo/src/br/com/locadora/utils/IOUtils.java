package br.com.locadora.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class IOUtils {

	/**
	 * Obtém os bytes do arquivo passado por parâmetro e retorna um array de byte
	 * @author Joaquim Neto
	 * @param file Arquivo que será lido
	 * @return byte[]
	 */
	public byte[] obterBytesPorFile(File file) {
		// InputStream para armazenar o file em memória até ser lido
		FileInputStream inputStream = null;

		// Usado para ler os bytes do file
		ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();

		try {
			// Ler o file
			inputStream = new FileInputStream(file);
			// Cria um array de byte com o tamanho do file
			byte[] buffer = new byte[(int) file.length()];
			int read = 0;

			// Adiciona os bytes do file ao ByteArrayOutputStream
			while ((read = inputStream.read(buffer)) != -1) {
				byteArrayOS.write(buffer, 0, read);
			}

			// Fecha o arquivo
			byteArrayOS.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return byteArrayOS.toByteArray();
	}

	/**
	 * Grava um array de byte no file passado por parâmetro
	 * @author Joaquim Neto
	 * @param file
	 * @param dado Array com os dados que serão savlos em arquivo
	 */
	public void gravarArquivo(File file, byte[] dado) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			OutputStream outputStream = new BufferedOutputStream(fileOutputStream);
			outputStream.write(dado, 0, dado.length);
			outputStream.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Grava uma String no file passado para parâmetro usando a ISO-8859-1
	 * @author Joaquim Neto
	 * @param file
	 * @param dado String com o conteúdo a ser gravado
	 */
	public void gravarArquivo(File file, String dado) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			Writer writer = new OutputStreamWriter(fileOutputStream, "ISO-8859-1");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

			// Escreve o dado no arquivo
			bufferedWriter.write(dado);

			// Fecha o arquivo
			bufferedWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Ler o conteúdo do file armazenado no passado por parâmetro
	 * @author Joaquim Neto
	 * @param file Arquivo que será lido
	 * @return String com o conteúdo do file
	 */
	@SuppressWarnings("resource")
	public String lerFile(File file) {
		StringBuilder builder = new StringBuilder();

		Scanner scanner;
		try {
			scanner = new Scanner(file, "ISO-8859-1");
			while (scanner.hasNext()) {
				builder.append(scanner.next());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Retorna o conteúdo do file
		return builder.toString();
	}
}
