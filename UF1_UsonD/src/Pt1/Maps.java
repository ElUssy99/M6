package Pt1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Maps {
	
	public static Scanner entradaGen = new Scanner(System.in);
	
	// Sistema de almacenamiento con Map:
	static Map<String, Float> almacen = new TreeMap<String, Float>();
	
	public static void main(String[] args) {
		// Menu:
		Scanner entrada = new Scanner(System.in);
		boolean continuar = true;
		while (continuar) {
			System.out.println("// ALMACENAMIENTO DE INFORMACION //");
			System.out.println("1 - Insertar");
			System.out.println("2 - Modificar");
			System.out.println("3 - Eliminar");
			System.out.println("4 - Mostrar");
			System.out.println("5 - Salir");
			
			System.out.println("Escoge una opcion entre 1 y 4 (5 para salir):");
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
					continuar = opcion5();
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
	
	public static boolean opcion5() {
		return false;
	}
	
}
