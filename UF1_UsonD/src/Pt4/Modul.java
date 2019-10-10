package Pt4;

import java.util.ArrayList;
import java.util.HashMap;

public class Modul extends Curs{
	
	private String nom;
	private String profe;
	private ArrayList ufs;
	
	// Constructor:
	public Modul(String tutor, ArrayList alumnes, HashMap moduls, String nom, String profe, ArrayList ufs) {
		super(tutor, alumnes, moduls);
		this.nom = nom;
		this.profe = profe;
		this.ufs = ufs;
	}
	
	// Getters y Setters:
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getProfe() {
		return profe;
	}
	public void setProfe(String profe) {
		this.profe = profe;
	}
	public ArrayList getUfs() {
		return ufs;
	}
	public void setUfs(ArrayList ufs) {
		this.ufs = ufs;
	}
	
	// Metodos:
	public void printUFs() {
		
	}
	public void printModul() {
		
	}
	
	public void setModul(String id) {
		
	}
	
	// toString:
	@Override
	public String toString() {
		return "Modul [nom=" + nom + ", profe=" + profe + ", ufs=" + ufs + "]";
	}
	
	
	
}
