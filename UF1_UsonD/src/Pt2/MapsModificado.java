package Pt2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MapsModificado {
	
	public static Scanner entradaGen = new Scanner(System.in);
	
	// Sistema de almacenamiento con Map:
	static Map<String, Float> almacen = new TreeMap<String, Float>();
	
	public static void main(String[] args) {
		// Menu:
		Scanner entrada = new Scanner(System.in);
		
		String ruta = "..\\UF1_UsonD\\src\\Maps.txt";
		FileWriter fw = null;
		try {
			fw = new FileWriter(ruta, true);
		} catch (IOException e) {
			System.err.println("Mensaje: " + e.getMessage());
		}
		
		boolean continuar = true;
		while (continuar) {
			System.out.println("// ALMACENAMIENTO DE INFORMACION //");
			System.out.println("1 - Insertar");
			System.out.println("2 - Modificar");
			System.out.println("3 - Eliminar");
			System.out.println("4 - Mostrar");
			System.out.println("5 - Insertar datos de Maps a Archivo");
			System.out.println("6 - Insertar datos de Archivo a Maps");
			System.out.println("7 - Mostrar datos del Archivo");
			System.out.println("8 - Salir");
			
			System.out.println("Escoge una opcion entre 1 y 7 (8 para salir):");
			int opcion = entrada.nextInt();
			switch (opcion) {
				case 1:
					opcion1();
					break;
				case 2:
					opcion2();
					break;
				case 3:
					opcion3();
					break;
				case 4:
					opcion4();
					break;
				case 5:
					opcion5(fw);
					break;
				case 6:
					opcion6();
					break;
				case 7:
					opcion7(ruta);
					break;
				case 8:
					continuar = opcion8();
					break;
				default:
					System.out.println("No has escogido ninguna de las opciones.");
			}
		}
	}
	
	public static void opcion1() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Inserta el nombre del juego que quieres almacenar:");
		String juego = entrada.nextLine();
		System.out.println("Inserta el precio del juego");
		Float precio = entrada.nextFloat();
		almacen.put(juego, precio);
	}
	
	public static void opcion2() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Inserta el nombre del juego que quieres modificar:");
		String juego = entrada.nextLine();
		
		if (almacen.containsKey(juego)) {
			System.out.println("Inserta el nuevo precio del juego:");
			Float precio = entrada.nextFloat();
			almacen.put(juego, precio);
		}else {
			System.out.println("El juego no existe. No es posible modificarlo.");
		}
	}
	
	public static void opcion3() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Inserta el nomnbre del juego que quieres eliminar:");
		String juego = entrada.nextLine();
		almacen.remove(juego);
	}
	
	public static void opcion4() {
		String clave;
		Iterator<String> productos = almacen.keySet().iterator();
		System.out.println("Hay los siguientes productos (" + almacen.size() + "):");
		while (productos.hasNext()) {
			clave = productos.next();
			System.out.println(clave + " - " + almacen.get(clave));
		}
	}
	
	public static void opcion5(FileWriter fw) {
		String clave;
		Iterator<String> productos = almacen.keySet().iterator();
		System.out.println("Hay los siguientes productos (" + almacen.size() + "):");
		while (productos.hasNext()) {
			clave = productos.next();
			try {
				fw.write(clave + " - " + almacen.get(clave) + "\n");
			} catch (IOException e) {
				System.err.println("Mensaje: " + e.getMessage());
			}
		}
		
		try {
			fw.close();
		} catch (Exception e) {
			System.err.println("Mensaje: " + e.getMessage());
		}
	}
	
	public static void opcion6() {
		
	}
	
	public static void opcion7(String ruta) {
		File archivo = new File(ruta);
		Scanner entrada = null;
		
		try {
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
	
	public static boolean opcion8() {
		return false;
	}
	
}
