package Pt1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ForHonor {
	
	static String url = "jdbc:sqlite:../UF2_UsonD/src/ForHonor.db";
	
	public static void main(String[] args) {
		createDataBase();
		connect();
		createFaction();
		createCharacter();
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
				+ "		lore text(200)";
	}
	
	public static void createCharacter() {
		
	}
	
}
