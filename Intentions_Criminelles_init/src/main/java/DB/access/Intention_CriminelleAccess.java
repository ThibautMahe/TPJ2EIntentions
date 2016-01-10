package DB.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.Entite.Intention_CriminelleEntite;

public class Intention_CriminelleAccess {

	public Intention_CriminelleAccess() {

	}

	public ArrayList<Intention_CriminelleEntite> selectAll(Connection conn) throws SQLException {

		ArrayList<Intention_CriminelleEntite> list = new ArrayList<Intention_CriminelleEntite>();

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM intentions")) {
				while (rs.next()) {
					Intention_CriminelleEntite temp = new Intention_CriminelleEntite();
					list.add(temp);
				}

			}
		}
		return list;
	}
	
}
