package Pt3;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ArchivoBinario {
	
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		boolean continuar = true;
		while (continuar) {
			System.out.println("// ALMACENAMIENTO DE INFORMACION //");
			System.out.println("1 - Recoger datos");
			System.out.println("2 - Mostrar");
			System.out.println("3 - Copia de seguridad");
			System.out.println("4 - Salir");
			
			System.out.println("Escoge una opcion entre 1 y 7 (8 para salir):");
			int opcion = entrada.nextInt();
			switch (opcion) {
				case 1:
					opcion1();
					count+=1;
					break;
				case 2:
					opcion2();
					break;
				case 3:
					opcion3();
					break;
				case 4:
					continuar = opcion4();
					break;
				default:
					System.out.println("No has escogido ninguna de las opciones.");
			}
		}
	}
	
	public static void opcion1() {
		Scanner entrada = new Scanner(System.in);
		FileOutputStream fos = null;
		DataOutputStream salida = null;
		try {
			fos = new FileOutputStream("..\\UF1_UsonD\\src\\becadades.dat");
			salida = new DataOutputStream(fos);
			System.out.print("Nombre y 1rApellido:");
			String nombre_apellido = entrada.nextLine();
			System.out.print("Sexo (H|M):");
			String StrSexo = entrada.nextLine();
			char sexo = StrSexo.charAt(0);
			System.out.print("Edad:");
			int edad = entrada.nextInt();
			System.out.print("Numero de suspensos:");
			int suspensos = entrada.nextInt();
			System.out.print("Ingresos anuales:");
			float ingresos = entrada.nextFloat();
			
			salida.writeBytes("Alumno " + count);
//			salida.writeBytes();
			
//			while (num != -1) {
//				salida.writeInt(num); // se escribe el número entero en el fichero
//				System.out.print("Introduce número entero. -1 para	acabar: ");
//				num = entrada.nextInt();
//			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (salida != null)
					salida.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void opcion2() {
		
	}
	
	public static void opcion3() {
		
	}
	
	public static boolean opcion4() {
		return false;
	}

}
