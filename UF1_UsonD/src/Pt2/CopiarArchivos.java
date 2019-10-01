package Pt2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class CopiarArchivos {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce la ruta del archivo origen:");
		String rutaOrigen = entrada.nextLine();
		System.out.println("Introduce la ruta del archivo destino:");
		String rutaDestino = entrada.nextLine();

		File archivoOrigen = new File(rutaOrigen);
		File archivoDestino = new File(rutaDestino);

		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(archivoOrigen);
			outputStream = new FileOutputStream(archivoDestino);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, length);
			}
			inputStream.close();
			outputStream.close();
			System.out.println("Archivo copiado.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
