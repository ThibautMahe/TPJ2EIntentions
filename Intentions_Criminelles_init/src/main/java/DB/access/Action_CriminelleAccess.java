package DB.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.Entite.Action_CriminelleEntite;
import DB.Entite.CriminelEntite;

public class Action_CriminelleAccess {

	public Action_CriminelleAccess() {

	}
	
	public void setActionCriminel(Action_CriminelleEntite action_Criminelle, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("INSERT INTO Criminels(Action_Criminel) values('" + action_Criminelle.getAction() + "')");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public Action_CriminelleEntite getAction_Criminelle( Connection conn){
		Action_CriminelleEntite action_Criminelle = new Action_CriminelleEntite();
		
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeQuery("SELECT * FROM Criminels");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return action_Criminelle;
	}

	public ArrayList<Action_CriminelleEntite> selectAll(Connection conn) throws SQLException {

		ArrayList<Action_CriminelleEntite> list = new ArrayList<Action_CriminelleEntite>();

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM Actions_criminelles")) {
				while (rs.next()) {
					Action_CriminelleEntite temp = new Action_CriminelleEntite(rs.getString("Action_criminelle"));
					list.add(temp);
				}

			}
		}
		return list;
	}
}
