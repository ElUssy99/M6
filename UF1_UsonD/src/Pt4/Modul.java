package Pt4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class Modul implements Serializable {
	
	private String nom;
	private String profe;
	private ArrayList ufs;

	public Modul() {
		this.profe = this.nom = "";
		this.ufs = new ArrayList();
	}

	public String donaNom() {
		return this.nom;
	}

	public void canviaNom(String nou) {
		this.nom = nou;
	}

	public String donaProfe() {
		return this.profe;
	}

	public void canviaProfe(String nom) {
		this.profe = nom;
	}

	public void afegirUf(String titol) {
		// ArrayList ordenats=new ArrayList();
		this.ufs.add(titol);
	}

	public ArrayList donaUfs() {
		return this.ufs;
	}

	public void llistarUfs() {
		if (!this.ufs.isEmpty()) {
			for (int i = 0; i < this.ufs.size(); i++)
				System.out.println(":: " + this.ufs.get(i));
		} else {
			System.out.println(":: Aquest modul no te cap UF especificada");
		}

	}

	public void canviaUf(int numero, String titol) {
		if (!this.ufs.isEmpty()) {
			this.ufs.set(numero - 1, titol);
		} else {
			System.out.println("Aquest modul no te cap UF especificada");
		}
	}

	public void omplirUFs(Scanner s) {
		System.out.println("Escriu el nom de les UFs (xx per sortir)");
		String nuf = "";
		while (!nuf.equals("xx")) {
			nuf = s.next();
			if (!nuf.equals("xx"))
				this.afegirUf(nuf);

		}
	}

	public void mostrarDadesModul() {
		System.out.println("Nom modul: " + this.nom);
		System.out.println("Professor/a: " + this.profe);
		System.out.println("LLista d'UFs:");
		this.llistarUfs();
	}

	public void omplirModul(Scanner s) {
		System.out.println("Nom del modul:");
		this.canviaNom(s.next());
		System.out.println("Nom profesor/a:");
		this.canviaProfe(s.next());
		System.out.println("Vols indicar ara les UFs (s/n)?");
		String sn = s.next();
		if (sn.equals("s"))
			this.omplirUFs(s);
	}

	public void modificarDadesModul(String id) {
		int k = 0;
		while (k < 6) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Que vols fer amb el modul?");
			System.out.println(" 1. Canviar el nom de " + id);
			System.out.println(" 2. Canviar de professor");
			System.out.println(" 3. Afegir UFs a " + id);
			System.out.println(" 4. Canviar una UF de " + id);
			System.out.println(" 5. Treure una UF");
			System.out.println(" 6. TORNAR");
			k = sc.nextInt();
			String nom = "";
			switch (k) {
			case 1:
				System.out.println("Quin es el nou nom del modul?");
				nom = sc.next();
				this.canviaNom(nom);
				break;
			case 2:
				System.out.println("Quin sera el nom del nou professor?");
				nom = sc.next();
				this.canviaProfe(nom);
				break;
			case 3:
				this.omplirUFs(sc);
				break;
			case 4:
				System.out.println("Quina es la UF que vols rectificar?");
				int r = sc.nextInt();
				System.out.println("Quin es el nou titol de la UF?");
				nom = sc.next(nom);
				this.canviaUf(r - 1, nom);
				break;
			case 5:
				System.out.println("Quina es la UF que vols treure?");
				int e = sc.nextInt();
				this.ufs.remove(e - 1);
				break;
			}
		}
	}
}
