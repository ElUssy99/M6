package Pt5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		// Escribir en el archivo myPeople.dat:
		File f = new File("..\\UF1_UsonD\\src\\myPeople.dat");
		File fXML = new File("..\\UF1_UsonD\\src\\myPeople.xml");
		
		// Escribir en el archivo myPeople.dat:
		escribirArchivo(f);
		
		// Leer archivo myPeople.dat:
		leerArchivo(f);
		
		// Escribir en el archivo XML:
		escribirXML(f, fXML);
	}

	public static void escribirArchivo(File f) {
		// Crear las Personas:
		Persona p1 = new Persona("Maria Lopez", 36);
		Persona p2 = new Persona("Gustavo Gomez", 1);
		Persona p3 = new Persona("Irene Salas", 36);
		Persona p4 = new Persona("Roberto Morgade", 63);
		Persona p5 = new Persona("Graciela Iglesias", 60);

		// Escribir en el archivo:
		FileOutputStream fos = null;
		ObjectOutputStream salida = null;

		try {
			fos = new FileOutputStream(f);
			salida = new ObjectOutputStream(fos);
			
			System.out.print("Escribiendo las personas en el archivo (myPeople.dat).\n");

			// Escribir nombre y edad:
			salida.writeObject(p1);
			salida.writeObject(p2);
			salida.writeObject(p3);
			salida.writeObject(p4);
			salida.writeObject(p5);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (salida != null) {
					salida.close();
					System.out.println("Las personas se han escrito correctamente en el archivo (myPeople.dat).\n");
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public static void leerArchivo(File f) {
		Persona p;
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		try {
			fis = new FileInputStream(f);
			entrada = new ObjectInputStream(fis);
			while (true) {
				try {
					System.out.println(p = (Persona) entrada.readObject());
				} catch (ClassNotFoundException e) {
					System.out.println("Mensaje: " + e.getMessage());
				}
			}
		} catch (IOException e) {
//			System.err.println("Mensaje: " + e.getMessage());
		} finally {
			try {
				entrada.close();
			} catch (Exception e2) {
				System.err.println("Mensaje: " + e2.getMessage());
			}
		}
	}

	public static void escribirXML(File f, File fXML) throws ParserConfigurationException, SAXException {
		Persona p;
		FileInputStream fis = null;
		ObjectInputStream entrada = null;

		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element eRaiz = doc.createElement("personas");
			doc.appendChild(eRaiz);
			try {
				fis = new FileInputStream(f);
				entrada = new ObjectInputStream(fis);
				while (true) {
					// Elementos y atributos: 
					Element ePersona = doc.createElement("persona");
					eRaiz.appendChild(ePersona);
					Element eNombre = doc.createElement("nombre");
					ePersona.appendChild(eNombre);
					Element eEdad = doc.createElement("edad");
					ePersona.appendChild(eEdad);
					
					// Recoger los datos:
					p = (Persona) entrada.readObject();
					String nombre = p.getNombre();
					String edad = String.valueOf(p.getEdad());
					
					// Añadir los datos al XML:
					eNombre.setNodeValue(nombre);
					eEdad.setNodeValue(edad);
				}

			} catch (IOException e) {
//				System.out.println("Mensaje: " + e.getMessage());
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("myPeople.xml"));
			
			entrada.close();
		} catch (Exception e) {
			System.err.println("Mensaje: " + e.getMessage());
		}
	}
}
