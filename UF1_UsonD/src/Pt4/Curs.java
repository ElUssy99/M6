package Pt4;

import java.util.ArrayList;
import java.util.HashMap;

public class Curs extends Pt4{
	
	private String tutor;
	private ArrayList alumnes;
	private HashMap moduls;
	
	// Constructor:
	public Curs(String tutor, ArrayList alumnes, HashMap moduls) {
		this.tutor = tutor;
		this.alumnes = alumnes;
		this.moduls = (HashMap) moduls;
	}
	
	// Getters y Setters:
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public ArrayList getAlumnes() {
		return alumnes;
	}
	public void setAlumnes(ArrayList alumnes) {
		this.alumnes = alumnes;
	}
	public HashMap getModuls() {
		return moduls;
	}
	public void setModuls(HashMap moduls) {
		this.moduls = moduls;
	}
	
	// Metodos:
	public Modul getModul(String nombre){
			
		return null;
	}
	public void printCurs() {
		
	}
	public void setCurs(String id) {
		
	}
	
	// toString:
	@Override
	public String toString() {
		return "Curs [tutor=" + tutor + ", alumnes=" + alumnes + ", moduls=" + moduls + "]";
	}
	
}
