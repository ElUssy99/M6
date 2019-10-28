package Pt1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ForHonor {
	
	static String url = "jdbc:sqlite:../UF2_UsonD/src/ForHonor.db";
	
	public static void main(String[] args) {
		createDataBase();
		connect();
		createFaction();
		createCharacter();
		
		// Insertar Facciones:
		insertFaction(1, "Caballeros", "Un caballero es, según la acepción más general de la palabra, un jinete o persona que monta a caballo o, más estrictamente, una persona de origen noble o, en época actual, simplemente distinguida o poseedora de un código de conducta gentil, atento y solidario.");
		insertFaction(2, "Vikingo", "Vikingo (del nórdico antiguo víkingr) es el principal nombre dado a los miembros de los pueblos nórdicos originarios de Escandinavia, famosos por sus incursiones y pillajes en Europa.");
		insertFaction(3, "Samurai", "La palabra samurái (samurai) (también samuray) generalmente se utiliza para designar una gran variedad de guerreros del antiguo Japón, aunque su verdadero significado es el de una élite militar que gobernó el país durante cientos de años.");
		
		// Insertar Caballeros:
		insertCharacter(1, "David", 6, 4, 1);
		insertCharacter(2, "Dario", 8, 6, 1);
		insertCharacter(3, "Marc", 7, 7, 1);
		// Insertar Vikingos:
		insertCharacter(1, "Adri", 4, 9, 2);
		insertCharacter(2, "Jonatan", 5, 8, 2);
		// Insertar Smurais:
		insertCharacter(1, "Xon", 11, 3, 3);
		insertCharacter(2, "Pachon", 9, 4, 3);
	}
	
	public static void connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Connection to SQLite has been established.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	
	public static void createDataBase() {
		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName() + ".");
				System.out.println("A new database has been created.");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void createFaction() {
		String sql = "CREATE TABLE IF NOT EXISTS Faccion (\n"
				+ "		faccion_id integer PRIMARY KEY,\n"
				+ "		nombre_faccion text(15),\n"
				+ "		lore text(200));";
		
		try (Connection conn = DriverManager.getConnection(url)) {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			if (stmt.execute(sql)) {
				System.out.println("Se ha ejecutado el codigo SQL de Faccion.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void createCharacter() {
		String sql = "CREATE TABLE IF NOT EXISTS Personaje (\n"
				+ "		personaje_id integer PRIMARY KEY,\n"
				+ "		nombre_personaje text(15),\n"
				+ "		ataque integer,\n"
				+ "		defensa integer,\n"
				+ "		faccion_id integer,\n"
				+ "		FOREIGN KEY (faccion_id) REFERENCES Faccion(faccion_id));";
		
		try (Connection conn = DriverManager.getConnection(url)) {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
			if (stmt.execute(sql)) {
				System.out.println("Se ha ejecutado el codigo SQL de Personaje.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertFaction(int faccion_id, String nombre_faccion, String lore) {
		String sql = "INSERT INTO Faccion (faccion_id, nombre_faccion, lore) VALUES (?,\"?\",\"?\")";
		try {
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, faccion_id);
			pstmt.setString(2, nombre_faccion);
			pstmt.setString(3, lore);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertCharacter(int personaje_id, String nombre_personaje, int ataque, int defensa, int faccion_id) {
		String sql = "INSERT INTO Faccion (faccion_id, nombre_faccion, lore) VALUES (?,\"?\",?,?,?)";
		try {
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, personaje_id);
			pstmt.setString(2, nombre_personaje);
			pstmt.setInt(3, ataque);
			pstmt.setInt(4, defensa);
			pstmt.setInt(5, faccion_id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
