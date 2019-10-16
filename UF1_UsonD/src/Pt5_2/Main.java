package Pt5_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		boolean continuar = true;

		File fXML = new File("..\\UF1_UsonD\\src\\cursos.xml");
		escribirXML(fXML);

//		while (continuar) {
//			System.out.println("// MENU CREAR O ALIMINAR ALUMNOS //");
//			System.out.println("1. Añadir alumno");
//			System.out.println("2. Eliminar alumno");
//			System.out.println("3. Salir");
//			System.out.println("Escoge una opcion entre 1 y 2 (3 para salir):");
//
//			int opcion = entrada.nextInt();
//
//			switch (opcion) {
//			case 1:
//
//				break;
//			case 2:
//
//				break;
//			case 3:
//				continuar = salir(continuar);
//				break;
//			default:
//				System.err.println("No has escogido ninguna de las opciones.");
//			}
//		}

	}

	// Dentro de Curso hay tutor, Alumnos y Modulo/s.
	// Dentro de Alumnos hay una lista de todos los alumnos.
	// Dentro de Modulos hay nombre de Modulo, UFs, profesores.
	// En Modulos tiene un Attr id.
	// Personas puede ser tuto, alumno o profesor.

	public static void escribirXML(File fXML) {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;

		System.out.println("// Escribiendo las personas en el archivo (cursos.xml) //");
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// Elemento Raiz:
			Element eRaiz = doc.createElement("cursos");
			doc.appendChild(eRaiz);

			//// Curso AMS:
			Element eCursoAMS = doc.createElement("curso");
			eRaiz.appendChild(eCursoAMS);
			Attr attrCAMS = doc.createAttribute("id");
			attrCAMS.setValue("AMS");
			eCursoAMS.setAttributeNode(attrCAMS);

			////// Tutor AMS:
			Element eTutorAMS = doc.createElement("tutor");
			eTutorAMS.setTextContent("ESPEJA,David");
			eCursoAMS.appendChild(eTutorAMS);

			////// Alumnos AMS:
			Element eAlumnosAMS = doc.createElement("alumnos");
			eCursoAMS.appendChild(eAlumnosAMS);

			//////// Alumno AMS:
			////////// Alumno 1:
			Element eAlumno1AMS = doc.createElement("alumno");
			eAlumno1AMS.setTextContent("SB,Darius");
			eAlumnosAMS.appendChild(eAlumno1AMS);
			////////// Alumno 2:
			Element eAlumno2AMS = doc.createElement("alumno");
			eAlumno2AMS.setTextContent("MARTINEZ,Marc");
			eAlumnosAMS.appendChild(eAlumno2AMS);
			////////// Alumno 3:
			Element eAlumno3AMS = doc.createElement("alumno");
			eAlumno3AMS.setTextContent("SALAS,Adri");
			eAlumnosAMS.appendChild(eAlumno3AMS);
			////////// Alumno 4:
			Element eAlumno4AMS = doc.createElement("alumno");
			eAlumno4AMS.setTextContent("USON,David");
			eAlumnosAMS.appendChild(eAlumno4AMS);

			////// Modulos AMS:
			Element eModulosAMS = doc.createElement("modulos");
			eCursoAMS.appendChild(eModulosAMS);

			//////// Modulo AMS:
			Element eModuloAMS = doc.createElement("modulo");
			eModulosAMS.appendChild(eModuloAMS);
			Attr attrMAMS = doc.createAttribute("id");
			attrMAMS.setValue("M06");
			eModuloAMS.setAttributeNode(attrMAMS);

			////////// Titulo modulo:
			Element eTituloAMS = doc.createElement("titulo");
			eTituloAMS.setTextContent("Acceso a datos");
			eModuloAMS.appendChild(eTituloAMS);

			//////////// Profesores modulo:
			Element eProfesAMS = doc.createElement("profes");
			eModuloAMS.appendChild(eProfesAMS);

			////////////// Profesor modulo:
			//////////////// Profesor 1:
			Element eProfe1AMS = doc.createElement("profe");
			eProfe1AMS.setTextContent("Rafa");
			eProfesAMS.appendChild(eProfe1AMS);
			//////////////// Profesor 2:
			Element eProfe2AMS = doc.createElement("profe");
			eProfe2AMS.setTextContent("Enric");
			eProfesAMS.appendChild(eProfe2AMS);

			//////////// UFs modulo:
			Element eUFsAMS = doc.createElement("ufs");
			eModuloAMS.appendChild(eUFsAMS);

			//////////// UF modulo:
			////////////// UF 1:
			Element eUF1AMS = doc.createElement("uf");
			eUF1AMS.setTextContent("Persistencia en ficheros");
			eUFsAMS.appendChild(eUF1AMS);
			Attr attrU1AMS = doc.createAttribute("n");
			attrU1AMS.setValue("1");
			eUF1AMS.setAttributeNode(attrU1AMS);
			////////////// UF 2:
			Element eUF2AMS = doc.createElement("uf");
			eUF2AMS.setTextContent("Persitencia en BDR-BDOR-BDOO");
			eUFsAMS.appendChild(eUF2AMS);
			Attr attrU2AMS = doc.createAttribute("n");
			attrU2AMS.setValue("2");
			eUF2AMS.setAttributeNode(attrU2AMS);
			////////////// UF 3:
			Element eUF3AMS = doc.createElement("uf");
			eUF3AMS.setTextContent("Persistencia en BD nativos XML");
			eUFsAMS.appendChild(eUF3AMS);
			Attr attrU3AMS = doc.createAttribute("n");
			attrU3AMS.setValue("3");
			eUF3AMS.setAttributeNode(attrU3AMS);
			////////////// UF 4:
			Element eUF4AMS = doc.createElement("uf");
			eUF4AMS.setTextContent("Componentes de acceso a datos");
			eUFsAMS.appendChild(eUF4AMS);
			Attr attrU4AMS = doc.createAttribute("n");
			attrU4AMS.setValue("4");
			eUF4AMS.setAttributeNode(attrU4AMS);

			//// Curso AWS:
			Element eCursoAWS = doc.createElement("curso");
			eRaiz.appendChild(eCursoAWS);
			Attr attrCAWS = doc.createAttribute("id");
			attrCAWS.setValue("AMS");
			eCursoAWS.setAttributeNode(attrCAWS);

			////// Tutor AWS:
			Element eTutorAWS = doc.createElement("tutor");
			eTutorAWS.setTextContent("ESPEJA,David");
			eCursoAWS.appendChild(eTutorAWS);

			////// Alumnos AWS:
			Element eAlumnosAWS = doc.createElement("alumnos");
			eCursoAMS.appendChild(eAlumnosAMS);

			//////// Alumno AWS:
			////////// Alumno 1:
			Element eAlumno1AWS = doc.createElement("alumno");
			eAlumno1AWS.setTextContent("SB,Darius");
			eAlumnosAWS.appendChild(eAlumno1AWS);
			////////// Alumno 2:
			Element eAlumno2AWS = doc.createElement("alumno");
			eAlumno2AWS.setTextContent("MARTINEZ,Marc");
			eAlumnosAWS.appendChild(eAlumno2AWS);
			////////// Alumno 3:
			Element eAlumno3AWS = doc.createElement("alumno");
			eAlumno3AWS.setTextContent("SALAS,Adri");
			eAlumnosAWS.appendChild(eAlumno3AWS);
			////////// Alumno 4:
			Element eAlumno4AWS = doc.createElement("alumno");
			eAlumno4AWS.setTextContent("USON,David");
			eAlumnosAWS.appendChild(eAlumno4AWS);

			////// Modulos AWS:
			Element eModulosAWS = doc.createElement("modulos");
			eCursoAMS.appendChild(eModulosAWS);

			//////// Modulo AWS:
			Element eModuloAWS = doc.createElement("modulo");
			eModulosAMS.appendChild(eModuloAWS);
			Attr attrMAWS = doc.createAttribute("id");
			attrMAWS.setValue("M06");
			eModuloAWS.setAttributeNode(attrMAWS);

			////////// Titulo modulo:
			Element eTituloAWS = doc.createElement("titulo");
			eTituloAWS.setTextContent("Acceso a datos");
			eModuloAMS.appendChild(eTituloAMS);

			//////////// Profesores modulo:
			Element eProfesAMS = doc.createElement("profes");
			eModuloAMS.appendChild(eProfesAMS);

			////////////// Profesor modulo:
			//////////////// Profesor 1:
			Element eProfe1AMS = doc.createElement("profe");
			eProfe1AMS.setTextContent("Rafa");
			eProfesAMS.appendChild(eProfe1AMS);
			//////////////// Profesor 2:
			Element eProfe2AMS = doc.createElement("profe");
			eProfe2AMS.setTextContent("Enric");
			eProfesAMS.appendChild(eProfe2AMS);

			//////////// UFs modulo:
			Element eUFsAMS = doc.createElement("ufs");
			eModuloAMS.appendChild(eUFsAMS);

			//////////// UF modulo:
			////////////// UF 1:
			Element eUF1AMS = doc.createElement("uf");
			eUF1AMS.setTextContent("Persistencia en ficheros");
			eUFsAMS.appendChild(eUF1AMS);
			Attr attrU1AMS = doc.createAttribute("n");
			attrU1AMS.setValue("1");
			eUF1AMS.setAttributeNode(attrU1AMS);
			////////////// UF 2:
			Element eUF2AMS = doc.createElement("uf");
			eUF2AMS.setTextContent("Persitencia en BDR-BDOR-BDOO");
			eUFsAMS.appendChild(eUF2AMS);
			Attr attrU2AMS = doc.createAttribute("n");
			attrU2AMS.setValue("2");
			eUF2AMS.setAttributeNode(attrU2AMS);
			////////////// UF 3:
			Element eUF3AMS = doc.createElement("uf");
			eUF3AMS.setTextContent("Persistencia en BD nativos XML");
			eUFsAMS.appendChild(eUF3AMS);
			Attr attrU3AMS = doc.createAttribute("n");
			attrU3AMS.setValue("3");
			eUF3AMS.setAttributeNode(attrU3AMS);
			////////////// UF 4:
			Element eUF4AMS = doc.createElement("uf");
			eUF4AMS.setTextContent("Componentes de acceso a datos");
			eUFsAMS.appendChild(eUF4AMS);
			Attr attrU4AMS = doc.createAttribute("n");
			attrU4AMS.setValue("4");
			eUF4AMS.setAttributeNode(attrU4AMS);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fXML);

			transformer.transform(source, result);
		} catch (Exception e) {
			System.out.println("Mensaje: " + e.getMessage());
		}
	}

	public static void addUser() {

	}

	public static void delUser() {

	}

	public static boolean salir(boolean continuar) {
		continuar = false;
		return continuar;
	}

}
