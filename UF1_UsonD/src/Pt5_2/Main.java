package Pt5_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws SAXException, IOException, TransformerException {
		Scanner entrada = new Scanner(System.in);
		boolean continuar = true;

		File fXML = new File("..\\UF1_UsonD\\src\\cursos.xml");
		escribirXML(fXML);

		while (continuar) {
			System.out.println("// MENU CREAR O ALIMINAR ALUMNOS //");
			System.out.println("1. Añadir alumno");
			System.out.println("2. Eliminar alumno");
			System.out.println("3. Salir");
			System.out.println("Escoge una opcion entre 1 y 2 (3 para salir):");

			int opcion = entrada.nextInt();

			switch (opcion) {
			case 1:
				addUser(fXML);
				break;
			case 2:
				
				break;
			case 3:
				continuar = salir(continuar);
				break;
			default:
				System.err.println("No has escogido ninguna de las opciones.");
			}
		}

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
			eAlumno1AMS.setTextContent("SB, Darius");
			eAlumnosAMS.appendChild(eAlumno1AMS);
			////////// Alumno 2:
			Element eAlumno2AMS = doc.createElement("alumno");
			eAlumno2AMS.setTextContent("MARTINEZ, Marc");
			eAlumnosAMS.appendChild(eAlumno2AMS);
			////////// Alumno 3:
			Element eAlumno3AMS = doc.createElement("alumno");
			eAlumno3AMS.setTextContent("SALAS, Adri");
			eAlumnosAMS.appendChild(eAlumno3AMS);
			////////// Alumno 4:
			Element eAlumno4AMS = doc.createElement("alumno");
			eAlumno4AMS.setTextContent("USON, David");
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
			attrCAWS.setValue("AWS");
			eCursoAWS.setAttributeNode(attrCAWS);

			////// Tutor AWS:
			Element eTutorAWS = doc.createElement("tutor");
			eTutorAWS.setTextContent("Julian Fuentes");
			eCursoAWS.appendChild(eTutorAWS);

			////// Alumnos AWS:
			Element eAlumnosAWS = doc.createElement("alumnos");
			eCursoAWS.appendChild(eAlumnosAWS);

			//////// Alumno AWS:
			////////// Alumno 1:
			Element eAlumno1AWS = doc.createElement("alumno");
			eAlumno1AWS.setTextContent("CARBALLO, Roger");
			eAlumnosAWS.appendChild(eAlumno1AWS);
			////////// Alumno 2:
			Element eAlumno2AWS = doc.createElement("alumno");
			eAlumno2AWS.setTextContent("MENGUAL, Alexis");
			eAlumnosAWS.appendChild(eAlumno2AWS);
			////////// Alumno 3:
			Element eAlumno3AWS = doc.createElement("alumno");
			eAlumno3AWS.setTextContent("BOAKIE, Marc");
			eAlumnosAWS.appendChild(eAlumno3AWS);

			////// Modulos AWS:
			Element eModulosAWS = doc.createElement("modulos");
			eCursoAWS.appendChild(eModulosAWS);

			//////// Modulo AWS:
			Element eModuloAWS = doc.createElement("modulo");
			eModulosAWS.appendChild(eModuloAWS);
			Attr attrMAWS = doc.createAttribute("id");
			attrMAWS.setValue("M01");
			eModuloAWS.setAttributeNode(attrMAWS);

			////////// Titulo modulo:
			Element eTituloAWS = doc.createElement("titulo");
			eTituloAWS.setTextContent("Sistemas informaticos");
			eModuloAWS.appendChild(eTituloAWS);

			//////////// Profesores modulo:
			Element eProfesAWS = doc.createElement("profes");
			eModuloAWS.appendChild(eProfesAWS);

			////////////// Profesor modulo:
			//////////////// Profesor 1:
			Element eProfe1AWS = doc.createElement("profe");
			eProfe1AWS.setTextContent("FUENTES, Julian");
			eProfesAWS.appendChild(eProfe1AWS);
			//////////////// Profesor 2:
			Element eProfe2AWS = doc.createElement("profe");
			eProfe2AWS.setTextContent("MESTRE, Manu");
			eProfesAWS.appendChild(eProfe2AWS);

			//////////// UFs modulo:
			Element eUFsAWS = doc.createElement("ufs");
			eModuloAWS.appendChild(eUFsAWS);

			//////////// UF modulo:
			////////////// UF 1:
			Element eUF1AWS = doc.createElement("uf");
			eUF1AWS.setTextContent("Instalacion, configuracion y explotacion de un SI");
			eUFsAWS.appendChild(eUF1AWS);
			Attr attrU1AWS = doc.createAttribute("n");
			attrU1AWS.setValue("1");
			eUF1AWS.setAttributeNode(attrU1AWS);
			////////////// UF 2:
			Element eUF2AWS = doc.createElement("uf");
			eUF2AWS.setTextContent("Gestion de la informacion y de recursos en una red");
			eUFsAWS.appendChild(eUF2AWS);
			Attr attrU2AWS = doc.createAttribute("n");
			attrU2AWS.setValue("2");
			eUF2AWS.setAttributeNode(attrU2AWS);
			////////////// UF 3:
			Element eUF3AWS = doc.createElement("uf");
			eUF3AWS.setTextContent("Implantacion de programario especifico");
			eUFsAWS.appendChild(eUF3AWS);
			Attr attrU3AWS = doc.createAttribute("n");
			attrU3AWS.setValue("3");
			eUF3AWS.setAttributeNode(attrU3AWS);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fXML);

			transformer.transform(source, result);
		} catch (Exception e) {
			System.out.println("Mensaje: " + e.getMessage());
		}
	}

	public static void addUser(File fXML) throws SAXException, IOException, TransformerException {
		Scanner entrada = new Scanner(System.in);
		System.out.println("De que curso quieres añadir el alumno (AMS | AWS)");
		String curso = entrada.nextLine();
		if (curso.equalsIgnoreCase("AMS")) {
			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		        DocumentBuilder db = dbf.newDocumentBuilder();
		        Document document = db.parse(fXML);
		        document.getDocumentElement().normalize();
		        
		        // https://stackoverflow.com/questions/8925054/how-to-navigate-dom-tree-from-xml-in-java
		        // En esta web tengo como navegar en un archivo XML
		        
				TransformerFactory factory = TransformerFactory.newInstance();
		        Transformer transformer = factory.newTransformer();
		        DOMSource domSource = new DOMSource(document);
		        StreamResult streamResult = new StreamResult(new File("cdCatalog.xml"));
		        transformer.transform(domSource, streamResult);

		        DOMSource source = new DOMSource(document);
			} catch (ParserConfigurationException e) {
				System.out.println("Mensaje: " + e.getMessage());
			}
	        
		} else if (curso.equalsIgnoreCase("AWS")) {
			
		} else {
			
		}
	}

	public static void delUser() {

	}

	public static boolean salir(boolean continuar) {
		continuar = false;
		return continuar;
	}

}
