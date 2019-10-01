package Pt2;

import java.io.File;
import java.util.Scanner;

public class CatArchivos {
	
	public static void main(String[] args) {
		Scanner entradaArc = new Scanner(System.in);
		System.out.println("Introduce la ruta del archivo:");
		String ruta = entradaArc.nextLine();
		File archivo = new File(ruta);
		Scanner entrada = null;
		
		try {
			System.out.println("Leeyendo el contenido del archivo:");
			entrada = new Scanner(archivo);
			while (entrada.hasNextLine()) {
				String linea = entrada.next();
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
