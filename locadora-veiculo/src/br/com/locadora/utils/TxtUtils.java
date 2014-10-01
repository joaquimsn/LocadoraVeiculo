package br.com.locadora.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class TxtUtils {

	public String lerTxt(File file) {
		StringBuilder builder = new StringBuilder();

		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				builder.append(scanner.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return builder.toString();
	}

	public void gravarTxt(File file, String texto) {
		try {
			PrintStream printStream = new PrintStream(file);
			printStream.print(texto);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
