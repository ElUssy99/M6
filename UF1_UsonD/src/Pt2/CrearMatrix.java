package Pt2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CrearMatrix {

	public static void main(String[] args) {
		crearBW();
//		crearFW();
	}

	public static void crearBW() {
		// BufferedWriter:
		// El problema de este programa es que solo escribe esta frease.
		// Para escribir mas de una linea, añadimos el bw.newLine(), y despues otra
		// frase que queramos.
		String ruta = "..\\UF1_UsonD\\src\\frasesMatrix.txt";
		File archivo = new File(ruta);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(archivo));
			bw.write("Yo solo puedo mostrarte la puerta, tu eres quien la tiene que atravesar.");
			bw.newLine();
			bw.write("Otra frase.");
			bw.close();
		} catch (Exception e) {
			System.out.println("Mensaje: " + e.getMessage());
		}

	}

	public static void crearFW() {
		// FileWriter:
		// El problema del FileWriter, es que lo escribe todo en una misma linea y solo se puede escribir una vez.
		// Para poder escribir mas de una vez, se pone el "true" despues de la ruta del archivo (si esta en "false" o esta vacio, se sobreescribe el texto).
		// Y para el salto de linea, se añade el "\n" despues de cada frase para hacer un salto de linea.
		String ruta = "..\\UF1_UsonD\\src\\frasesMatrix.txt";
		try {
			FileWriter fw = new FileWriter(ruta, true);
			fw.write("Yo solo puedo mostrarte la puerta, tu eres quien la tiene que atravesar.\n");
			fw.write("Otra frase.\n");
			fw.close();
		} catch (Exception e) {
			System.out.println("Mensaje: " + e.getMessage());
		}
	}

}
