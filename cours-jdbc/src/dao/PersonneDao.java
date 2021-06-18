package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import config.MyConnection;
import model.Personne;
public class PersonneDao {
	public ArrayList<Personne> findAll() {
		ArrayList<Personne> personnes = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				personnes = new ArrayList<>();
				PreparedStatement ps = c.prepareStatement("select * from personne");
				ResultSet r = ps.executeQuery();
				while (r.next()) {
					Personne personne = new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
					personnes.add(personne);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personnes;
	}
	public Personne findById(int id) {
		Personne personne = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from personne where num = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				if (r.next())
					personne = new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personne;
	}
	public Personne save(Personne personne) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into personne (nom,prenom) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, personne.getNom());
				ps.setString(2, personne.getPrenom());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					personne.setNum(resultat.getInt(1));
					return personne;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Personne update(Personne personne) {
		return null;
	}
	public void remove(Personne personne) {
	}
	
	
	
	
}





//package dao;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import config.MyConnection;
//import model.Personne;
//public class PersonneDao {
//	
//	public ArrayList<Personne> findAll() {
//		ArrayList<Personne> personnes = null;
//		Connection c = MyConnection.getConnection();
//		if (c != null) {
//			try {
//				personnes = new ArrayList<>();
//				PreparedStatement ps = c.prepareStatement("select * from personne");
//				ResultSet r = ps.executeQuery();
//				while (r.next()) {
//					Personne personne = new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
//					personnes.add(personne);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return personnes;
//	}
//	
//	public Personne findById(int id) {
//		Personne personne = null;
//		Connection c = MyConnection.getConnection();
//		if (c != null) {
//			try {
//				PreparedStatement ps = c.prepareStatement("select * from personne where num = ?; ");
//				ps.setInt(1, id);
//				ResultSet r = ps.executeQuery();
//				if (r.next())
//					personne = new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return personne;
//	}
//}
//

//package dao;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import config.MyConnection;
//import model.Personne;
//public class PersonneDao {
//	public ArrayList<Personne> findAll() {
//		ArrayList<Personne> personnes = null;
//		Connection c = MyConnection.getConnection();
//		if (c != null) {
//			try {
//				personnes = new ArrayList<>();
//				PreparedStatement ps = c.prepareStatement("select * from personne");
//				ResultSet r = ps.executeQuery();
//				while (r.next()) {
//					Personne personne = new Personne(r.getInt("num"), r.getString("nom"), r.getString("prenom"));
//					personnes.add(personne);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return personnes;
//	}
//}
