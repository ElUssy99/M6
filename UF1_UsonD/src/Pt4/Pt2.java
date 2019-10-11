package Pt4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class Pt2 implements Serializable {
	
	private HashMap cursos;
	
	/*
	 * Un HashMap es una col.lecio on cada node es del tipus (Objecte clau, Objecte
	 * Dades) funcionant l'objecte clau com un identificador. En aquest cas la clau
	 * es un String amb el codi del curs, mentre de que l'objecte dades es un del
	 * tipus Curs.
	 */
	
	public Pt2() {
		this.cursos = new HashMap();
	}
	
	public static void main(String[] args) throws IOException {
		Pt2 x = new Pt2();
		String ruta = "Pt2.dat";
		Modul m = new Modul();
		String id = "";
		int o = 0;
		File cd = new File(ruta);
		x.carregarDades(cd); // Carreguem les dades que han estat guardades anteriorment
		do {
			o = x.menuPrincipal();
			Scanner dades = new Scanner(System.in);
			switch (o) {
			case 1:
				Curs c = new Curs();

				id = c.omplirCurs(dades).toUpperCase();
				System.out.println("El curs" + id + " ha estat creat");
				System.out.println("Volsguardar-lo (s/n)?");
				if (dades.next().equals("s")) {
					x.cursos.put(id, c);
					System.out.println("HIHAN " + x.cursos.size() + " CURSOS");
				}
				break;
			case 2:
				System.out.println("Introdueix el codi del curs");
				id = dades.next().toUpperCase();
				if (x.cursos.containsKey(id)) {

					c = (Curs) x.cursos.get(id);
					c.modificarDadesCurs(id);
				} else {
					System.out.println("EL CURS " + id + " NO EXISTEIX");
				}
				break;
			case 3:
				System.out.println("Introdueix el codi del curs");
				id = dades.next().toUpperCase();
				if (x.cursos.containsKey(id)) {
					System.out.println(":::: DADES DEL CURS " + id + " ::");
					c = (Curs) x.cursos.get(id);
					c.mostrarDadesCurs();
					System.out.println(":::::::::::::::::::::::::::::::");
					System.out.println(" Continua?");
					System.in.read();
				} else {
					System.out.println("EL CURS " + id + " NO EXISTEIX");
				}
				break;
			case 4:
				System.out.println("Introdueix el codi del curs");
				id = dades.next().toUpperCase();
				if (x.cursos.containsKey(id)) {
					x.cursos.remove(id);
					System.out.println("S'HA ELIMINAT EL CURS " + id);
					System.out.println("HI HAN " + x.cursos.size() + " CURSOS");
				} else {
					System.out.println("EL CURS " + id + " NO EXISTEIX");
				}
				break;
			}
		} while (o < 5);
		File gd = new File(ruta);
		x.guardarDades(gd); // Tornem a guardar el HashMap de cursos al fitxer
		System.out.println("S'HA ACABAT");
	}

	public void carregarDades(File f) {
		cursos.clear();
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			cursos = (HashMap) ois.readObject(); // ERROR SI S'UTILITZA THIS
			System.out.println("==> LES DADES DEL FITXER HA ESTAT CARREGADES\n");
			ois.close();
		} catch (Exception e) {
			System.err.println("No hay datos en el archivo.");
		}
	}

	public void guardarDades(File f) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(cursos); // ERROR SI S'UTILITZA THIS
			System.out.println("==> LES DADES HAN ESTAT GUARDADES AL FITXER\n");
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int menuPrincipal() {
		Scanner teclat = new Scanner(System.in);
		int opcio = 0;
		for (int i = 0; i < 50; i++)
			System.out.println("");
		System.out.println("PROPOSTA DE RESOLUCIO PT2 (STREAMSD'OBJECTES)");

		System.out.println("==============================================");
		System.out.println("1. AFEGIR UN NOU CURS");
		System.out.println("2. MODIFICAR UN CURS");
		System.out.println("3. MOSTRAR DADES CURS");
		System.out.println("4. ELIMINAR UN CURS");
		System.out.println("5. SORTIR");
		System.out.print("Escull una opcio:");
		opcio = teclat.nextInt();

		return opcio;
	}
	
}