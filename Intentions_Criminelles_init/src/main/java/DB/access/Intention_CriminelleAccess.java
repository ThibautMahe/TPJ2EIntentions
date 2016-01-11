package DB.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.Entite.Intention_CriminelleEntite;
import DB.Entite.LieuEntite;

public class Intention_CriminelleAccess {

	public Intention_CriminelleAccess() {

	}
	
	public void setIntention_Criminelle(Intention_CriminelleEntite intention_Criminelle, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("INSERT INTO Intentions(Name) values('" + intention_Criminelle + "')");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public Intention_CriminelleEntite getCriminel( Connection conn){
		Intention_CriminelleEntite intention_Criminelle = new Intention_CriminelleEntite();
		
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeQuery("SELECT * FROM Intentions");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return intention_Criminelle;
	}

	public ArrayList<Intention_CriminelleEntite> selectAll(Connection conn) throws SQLException {

		ArrayList<Intention_CriminelleEntite> list = new ArrayList<Intention_CriminelleEntite>();

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM Intentions")) {
				while (rs.next()) {
					Intention_CriminelleEntite temp = new Intention_CriminelleEntite();
					list.add(temp);
				}

			}
		}
		return list;
	}
	
}
