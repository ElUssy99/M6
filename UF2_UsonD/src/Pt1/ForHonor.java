package Pt1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ForHonor {
	
	public static void main(String[] args) {
		conectar();
	}
	
	public static void conectar() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:../UF2_UsonD/src/ForHonor.db";
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
	
}
