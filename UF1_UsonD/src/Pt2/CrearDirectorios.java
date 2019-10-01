package Pt2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class CrearDirectorios {

	// Ejercicio 3:
	// Crear un directorio con archivos.

	public static void main(String[] args) {
		File directorio = new File("..\\UF1_UsonD\\src\\myFiles");
		File fichero1 = new File("..\\UF1_UsonD\\src\\myFiles\\fichero1.txt");
		File fichero2 = new File("..\\UF1_UsonD\\src\\myFiles\\fichero2.txt");
		
		System.out.println("Crear archivos:");
		crearArchivos(directorio, fichero1, fichero2);
		mostrarDirectorio(directorio);
		
		System.out.println("Renombrar archivo 2:");
		renombrarArchivo(fichero2);
		mostrarDirectorio(directorio);
		
		System.out.println("Eliminar archivo 1:");
//		eliminarArchivo(fichero1);
		mostrarDirectorio(directorio);
	}
	
	// Metodo para crear el directorio y archivos (se le pasan los 3 archivos):
	public static void crearArchivos(File directorio, File fichero1, File fichero2) {
		// Crear la carpeta principal:
		// Si el directorio existe, elimina este con todo su contenido y crea otro:
		
		if (directorio.exists()) {
			directorio.delete();
		} else {
			directorio.mkdir();
		}

		// Crear el archivo 1:
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero1));
			bw.write("archivo 1");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Crear el archivo 2:
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero2));
			bw.write("archivo 2");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Metodo para renombrar el archivo especificado (se le pasa el archivo que se renombra):
	public static void renombrarArchivo(File fichero2) {
		File rn = new File("..\\UF1_UsonD\\src\\myFiles\\ficheroRenombrado.txt");
		// Renombrar el archivo 2:
		fichero2.renameTo(rn);
	}
	
	// Metodo para eliminar el archivo especificado (se le pasa el archivo):
	public static void eliminarArchivo(File fichero1) {
		fichero1.delete();
	}
	
	// Metodo para mostrar todos los archivos del directorio (se le pasa el directorio):
	public static void mostrarDirectorio(File directorio) {
		// Listamos los archivos que tiene el directorio
		String[] ficheros = directorio.list();
		
		// Si no tiene archivos se muestra un mesaje, y si tiene, los muestra todos
		if (ficheros == null) {
			System.out.println("No hay archivos en este directorio.");
		} else {
			for (int i = 0; i < ficheros.length; i++) {
				System.out.println(ficheros[i]);
			}
		}
	}

}
