package Pt4;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Pt4 {
	
	private static File f = new File("..\\UF1_UsonD\\src\\Cursos_Modulos.dat");
	private HashMap<Integer, Curs> cursos = new HashMap<Integer, Curs>();
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		boolean continuar = true;
		
		while (continuar) {
			System.out.println("PROPUESTA DE RESOLUCION PT4 (STREAMS DE OBJETOS)");
			System.out.println("=============================================");
			System.out.println("  1. AÑADIR UN NUEVO CURSO");
			System.out.println("  2. MODIFICAR UN CURSO");
			System.out.println("  3. MOSTRAR DATOS CURSO");
			System.out.println("  4. ELIMINAR UN CURSO");
			System.out.println("  5. SALIR");
		}
	}
	
	public void opcion2() {
		System.out.println("¿Que quier hacer con el curso?");
		System.out.println("    ");
	}
	
	public void opcion5() {
		
	}
	
	public void dadesIn(File f) {
		
	}
	
	public void dadesOut(File f) {
		
	}
	
}
