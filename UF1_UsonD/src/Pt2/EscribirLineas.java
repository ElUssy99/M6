package Pt2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class EscribirLineas {
	
	public static void main(String[] args) {
		String ruta = "..\\UF1_UsonD\\src\\escribeLineas.txt";
		File archivo = new File(ruta);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(archivo));
			for (int i = 1; i < 11; i++) {
				bw.write("Linea " + i);
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.out.println("Mensaje: " + e.getMessage());
		}
	}
	
}
