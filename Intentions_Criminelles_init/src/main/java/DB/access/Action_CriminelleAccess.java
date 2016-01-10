package DB.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.Entite.Action_CriminelleEntite;

public class Action_CriminelleAccess {

	public Action_CriminelleAccess() {

	}

	public ArrayList<Action_CriminelleEntite> selectAll(Connection conn) throws SQLException {

		ArrayList<Action_CriminelleEntite> list = new ArrayList<Action_CriminelleEntite>();

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM intentions")) {
				while (rs.next()) {
					Action_CriminelleEntite temp = new Action_CriminelleEntite(rs.getString("description"));
					list.add(temp);
				}

			}
		}
		return list;
	}

}