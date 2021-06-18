package test;
import java.util.ArrayList;
import dao.PersonneDao;
import model.Personne;
public class Main {
	public static void main(String[] args) {
		PersonneDao dao = new PersonneDao();
		Personne personne = new Personne("Ryan", "HAYOUN");
		dao.save(personne);
		ArrayList<Personne> personnes = dao.findAll();
		for (Personne p : personnes) {
			System.out.println(p);
		}
//		System.out.println(dao.findById(1));
	}
}




//package test;
//import java.util.ArrayList;
//import dao.PersonneDao;
//import model.Personne;
//public class Main {
//	public static void main(String[] args) {
//		PersonneDao dao = new PersonneDao();
////		ArrayList<Personne> personnes = dao.findAll();
////		for (Personne p : personnes) {
////			System.out.println(p);
////		}
//		System.out.println(dao.findById(1));
//	}
//}
//






//package test;
//import java.util.ArrayList;
//import dao.PersonneDao;
//import model.Personne;
//
//public class Main {
//	public static void main(String[] args) {
//		PersonneDao dao = new PersonneDao();
//		ArrayList<Personne> personnes = dao.findAll();
//		for (Personne p : personnes) {
//			System.out.println(p);
//		}
//	}
//}






//package test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Main {
//
//	public static void main(String[] args) {
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false&serverTimezone=UTC";
//		String user = "root";
//		String password = "root";
//		Connection connexion = null;
//		try {
//			connexion = DriverManager.getConnection(url, user, password);
//			
//			//String request = "UPDATE Personne set nom=? , prenom=? where num=?;";
//			String request = "delete f Personne where num=?;";
//			
//			PreparedStatement ps = connexion.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
//			
//			
//			//ps.setString(1, "nawale");
//			//ps.setString(2, "hayoun");
//			ps.setInt(1, 3);
//			
//			ps.executeUpdate();
//			ResultSet resultat = ps.getGeneratedKeys();
//			if (resultat.next())
//				System.out.println("Le numéro généré pour cette personne : " + resultat.getInt(1));
//			Statement statement = connexion.createStatement();
//			request = "SELECT * FROM Personne;";
//			ResultSet result = statement.executeQuery(request);
//			while (result.next()) {
//				int num = result.getInt(1);
//				String nom = result.getString("nom");
//				String prenom = result.getString("prenom");
//				System.out.println(num + " " + nom + " " + prenom);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (connexion != null)
//				try {
//					connexion.close();
//				} catch (SQLException ignore) {
//					ignore.printStackTrace();
//				}
//		}
//
//
//	}
//
//}
