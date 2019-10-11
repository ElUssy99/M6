package Pt5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
		escribirArchivo(f);

		// Leer archivo myPeople.dat
		leerArchivo(f);

		escribirXML(f, fXML);
	}

	public static void escribirArchivo(File f) {
		// Crear las Personas:
		Persona p1 = new Persona("Maria", "Lopez", 36);
		Persona p2 = new Persona("Gustavo", "Gomez", 1);
		Persona p3 = new Persona("Irene", "Salas", 36);
		Persona p4 = new Persona("Roberto", "Morgade", 63);
		Persona p5 = new Persona("Graciela", "Iglesias", 60);

		// Escribir en el archivo:
		FileOutputStream fos = null;
		DataOutputStream salida = null;

		try {
			fos = new FileOutputStream(f);
			salida = new DataOutputStream(fos);
			System.out.print("Escribiendo las personas en el archivo (myPeople.dat).\n");

			// Escribir nombre: // Escribir apellido: // Escribir edad:
			salida.writeUTF(p1.getNombre());
			salida.writeUTF(p1.getApellido());
			salida.writeInt(p1.getEdad());
			salida.writeUTF(p2.getNombre());
			salida.writeUTF(p2.getApellido());
			salida.writeInt(p2.getEdad());
			salida.writeUTF(p3.getNombre());
			salida.writeUTF(p3.getApellido());
			salida.writeInt(p3.getEdad());
			salida.writeUTF(p4.getNombre());
			salida.writeUTF(p4.getApellido());
			salida.writeInt(p4.getEdad());
			salida.writeUTF(p5.getNombre());
			salida.writeUTF(p5.getApellido());
			salida.writeInt(p5.getEdad());
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
		FileInputStream fis = null;
		DataInputStream entrada = null;
		try {
			fis = new FileInputStream(f);
			entrada = new DataInputStream(fis);
			while (true) {
				String nombre = entrada.readUTF();
				String apellido = entrada.readUTF();
				int edad = entrada.readInt();

				System.out.println(nombre + " " + apellido + " - " + edad);
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
		FileInputStream fis = null;
		DataInputStream entrada = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXML);

			Element eRaiz = doc.createElement("personas");
			doc.appendChild(eRaiz);

			// Falta el nodo persona
			Attr aNombre = doc.createAttribute("nombre");
			eRaiz.setAttributeNode(aNombre);
			Attr aApellido = doc.createAttribute("apellido");
			eRaiz.setAttributeNode(aApellido);
			Attr aEdad = doc.createAttribute("edad");
			eRaiz.setAttributeNode(aEdad);

			fis = new FileInputStream(f);
			entrada = new DataInputStream(fis);
			while (true) {
				String nombre = entrada.readUTF();
				String apellido = entrada.readUTF();
				int edad = entrada.readInt();
				String edadStr = String.valueOf(edad);

				aNombre.setValue(nombre);
				aApellido.setValue(apellido);
				aEdad.setValue(edadStr);

			}

//			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("ejercicio3.xml"));
		} catch (IOException e) {
//			System.err.println("Mensaje: " + e.getMessage());
		} finally {
			try {
				entrada.close();
			} catch (Exception e2) {
				System.err.println("Mensaje: " + e2.getMessage());
			}
		}

//		try {
//			  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//			  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//			  Document doc = dBuilder.parse(fXML);

//			  Element eRaiz = doc.createElement("persona");
//			  doc.appendChild(eRaiz);
//			  
//			  Attr aNombre = doc.createAttribute("nombre");
//			  eRaiz.setAttributeNode(aNombre);
//			  Attr aApellido = doc.createAttribute("apellido");
//			  eRaiz.setAttributeNode(aApellido);
//			  Attr aEdad = doc.createAttribute("edad");
//			  eRaiz.setAttributeNode(aEdad);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
