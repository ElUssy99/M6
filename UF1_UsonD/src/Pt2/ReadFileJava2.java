package Pt2;

import java.io.File;
import java.util.Scanner;

public class ReadFileJava2 {
	
	// Ejercicio 2:
	// Lectura de archivo por lineas.
	
	public static void main(String[] args) {
		File archivo = new File("..\\UF1_UsonD\\src\\Pt2\\ReadFileJava1.java");
		Scanner entrada = null;
		
		try {
			System.out.println("Leeyendo el contenido del archivo:");
			entrada = new Scanner(archivo);
			while (entrada.hasNextLine()) {
				String linea = entrada.nextLine();
				System.out.println(linea);
			}
		}catch (Exception e) {
			System.out.println("Mensaje: " + e.getMessage());
		}finally {
			try {
				if (entrada != null) {
					entrada.close();
				}
			}catch (Exception e2) {
				System.out.println("Mensaje: " + e2.getMessage());
			}
		}
	}
	
}
