package br.com.locadora.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class TxtUtils {

	public String lerTxt(File file) {
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
		
		return builder.toString();
	}

	public void gravarTxt(File file, String texto) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
//			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "ISO-8859-1");
//			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			Writer writer =new OutputStreamWriter(fileOutputStream, "ISO-8859-1");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			bufferedWriter.write(texto);
			bufferedWriter.close();
			
//			PrintWriter printWriter = new PrintWriter(file, "	");
//			printWriter.write(texto);
//			
//			printWriter.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			PrintStream printStream = new PrintStream(file);
//			printStream.print(texto);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
