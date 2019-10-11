package Pt4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Curs implements Serializable {
	private String tutor;
	private ArrayList alumnes;
	private HashMap moduls;

	public Curs() {
		this.tutor = "";
		this.alumnes = new ArrayList();
		this.moduls = new HashMap();
	}

	public String donaTutor() {
		return this.tutor;
	}

	public void canviaTutor(String nou) {
		this.tutor = nou;
	}

	public void afegirAlumne(String nou) {
		this.alumnes.add(nou);
	}

	public ArrayList donaAlumnes() {
		return this.alumnes;
	}

	public void canviaNomAlumne(int index, String nouNom) {
		this.alumnes.set(index, nouNom);
	}

	public void treureAlumne(int index) {
		this.alumnes.remove(index);
	}

	public void afegirModul(String codi, Modul m) {
		this.moduls.put(codi, m);
	}

	public Modul donaModul(String codi) {
		Modul m = new Modul();
		m = (Modul) this.moduls.get(codi);
		return m;
	}

	public void treureModul(String codi) {
		this.moduls.remove(codi);
	}

	public String omplirCurs(Scanner s) {
		String llista, c, id;
		llista = c = id = "";
		System.out.println("Quin sera el nom del curs?");
		id = s.nextLine();
		System.out.println("Quin sera el nom del tutor?");
		this.tutor = s.nextLine();
		System.out.println("Vols afegir alumnes (s/n)?");
		llista = s.nextLine();
		if (llista.equals("s"))
			this.omplirAlumnes(s);
		do {
			System.out.println("Vols afegir un nou modul(s/n)?");
			llista = s.nextLine();
			if (llista.equals("s")) {
				System.out.println("Quina clau te el modul?");
				c = s.nextLine();
				Modul m = new Modul();
				System.out.println("Vols omplir ara les dades del modul (s/n)?");
				String sn1 = s.nextLine();
				if (sn1.equals("s")) {
					m.omplirModul(s);
				}
				this.afegirModul(c, m);
			}
		} while (llista.equals("s"));
		return id;
	}

	public void omplirAlumnes(Scanner s) {
		String n = "";
		System.out.println("Escriu el nom de l'alumne (xx per Sortir)");
		while (!n.equals("xx")) {
			n = s.next();
			if (!n.equals("xx"))
				this.alumnes.add(n);
		}
		System.out.println("LLISTA D'ALUMNES TANCADA");
	}

	public void mostrarDadesCurs() {
		System.out.println(":: Nom del tutor: " + this.donaTutor());
		System.out.println(":: Te " + this.alumnes.size() + " alumnes que son:");
		for (int i = 0; i < this.alumnes.size(); i++)
			System.out.println(":: " + this.alumnes.get(i));
		System.out.println(":: Te " + this.moduls.size() + " moduls que son:");
		Iterator it = this.moduls.entrySet().iterator(); // (1)
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			Modul m = new Modul();
			m = (Modul) e.getValue();
			System.out.println(":: " + e.getKey() + ":" + m.donaNom());
			m.llistarUfs();
		}
	}

	/*
	 * (1) L'iterador serveix per poder fer fer un recorregut del HashMap moduls. El
	 * metode entrySet retorna un Set, que es un conjunt d'elements no repetits, que
	 * treballarem pero amb Map, una interface que olfereix metodes que ens donen
	 * cadascuna de les parelles d'objectes i no cadascun d'ells de forma
	 * independent.
	 */
	public void modificarDadesCurs(String id) {
		int k = 0;

		while (k < 7) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Que vols fer amb el curs?");
			System.out.println(" 1. Canviar de tutor");
			System.out.println(" 2. Afegir alumnes a " + id);
			System.out.println(" 3. Treure alumnes de " + id);
			System.out.println(" 4. Afegir un nou modul a " + id);
			System.out.println(" 5. Modificar dades d'un modul");
			System.out.println(" 6. Eliminar un modul a " + id);
			System.out.println(" 7. TORNAR");
			k = sc.nextInt();
			String codi = "";
			switch (k) {
			case 1:
				System.out.println("Quin es el nom del nou tutor?");
				codi = sc.next();
				this.canviaTutor(codi);
				break;
			case 2:
				this.omplirAlumnes(sc);
				break;
			case 3:
				System.out.println("Quin numero te l'alumne?");
				int b = sc.nextInt();
				String alumne = (String) this.alumnes.get(b - 1);
				System.out.println("Vols eliminar a " + alumne + " (s/n)?");
				String sn2 = sc.next();
				if (sn2.equals("s"))
					this.treureAlumne(b - 1);
				break;
			case 4:
				System.out.println("Quina clau te el modul?");
				codi = sc.next();
				Modul m = new Modul();
				m.omplirModul(sc);
				System.out.println("Vols guardar (s/n)?");
				String sn = sc.next();
				if (sn.equals("s")) {

					System.out.println("Entro");
					this.moduls.put(codi, m);
					System.out.println("EL MODUL " + codi.toUpperCase() + " HA ESTAT INSERIT");
				}
				break;
			case 5:
				System.out.println("Quina clau te el modul?");
				codi = sc.next();
				Modul mm = new Modul();
				if (this.moduls.containsKey(codi)) {

					mm = (Modul) this.moduls.get(codi);
					mm.modificarDadesModul(codi);
				}
				break;
			case 6:
				System.out.println("Quina clau te el modul?");
				codi = sc.next();
				this.moduls.remove(codi);
				System.out.println("EL MODUL " + codi.toUpperCase() + " HA ESTAT ELIMINAT");
				break;
			}

		}
	}
}
