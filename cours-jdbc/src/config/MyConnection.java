package config;
import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {
	private static String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=UTC";
	private static String utilisateur = "root";
	private static String motDePasse = "root";
	private static Connection connexion = null;
	private MyConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		if (connexion == null) {
			new MyConnection();
		}
		return connexion;
	}
}





//package config;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class MyConnection {
//	
//	private static String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=UTC";
//	private static String utilisateur = "root";
//	private static String motDePasse = "root";
//	private static Connection connexion = null;
//	
//	private MyConnection() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static Connection getConnection() {
//		if (connexion == null) {
//			new MyConnection();
//		}
//		return connexion;
//	}
//
//}
