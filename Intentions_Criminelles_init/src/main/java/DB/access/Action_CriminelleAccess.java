package DB.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.Entite.Action_CriminelleEntite;

public class Action_CriminelleAccess {

	public Action_CriminelleAccess() {

	}

	public void createAction_Criminelle(Action_CriminelleEntite action_Criminelle, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("INSERT INTO Actions_criminelles(Action_Criminelle) values('"
						+ action_Criminelle.getAction() + "')");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void setAction_Criminelle(Action_CriminelleEntite action_Criminelle, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate(
						"UPDATE Actions_criminelles SET Action_criminelle='" + action_Criminelle.getAction() + "' WHERE Action_criminelleID=" + action_Criminelle.getID());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public Action_CriminelleEntite getAction_Criminelle(int Action_criminelleID, Connection conn) {
		Action_CriminelleEntite action_criminelle = null;

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(
					"SELECT * FROM Actions_criminelles WHERE Action_criminelleID=" + Action_criminelleID)) {
				rs.next();
				action_criminelle = new Action_CriminelleEntite(Integer.parseInt(rs.getString("Action_criminelleID")),
						rs.getString("Action_criminelle"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return action_criminelle;
	}

	public int getnbAction_Criminelle(Connection conn) {
		int nbAction_Criminelle = 0;

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt
					.executeQuery("SELECT MAX(Action_criminelleID) as nbAction_Criminelle FROM Actions_criminelles")) {
				rs.next();
				if (rs.getString("nbAction_Criminelle") != null)
					nbAction_Criminelle = Integer.parseInt(rs.getString("nbAction_Criminelle"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return nbAction_Criminelle;
	}

	public void DeleteAction_Criminelle(Action_CriminelleEntite action_Criminelle, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate(
						"DELETE FROM Actions_criminelles where Action_criminelleID=" + action_Criminelle.getID());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<Action_CriminelleEntite> getAllActions_Criminelles(Connection conn) throws SQLException {
		ArrayList<Action_CriminelleEntite> list = new ArrayList<Action_CriminelleEntite>();

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM Actions_criminelles")) {
				while (rs.next()) {
					Action_CriminelleEntite temp = new Action_CriminelleEntite(Integer.parseInt(rs.getString("Action_criminelleID")),rs.getString("Action_criminelle"));
					list.add(temp);
				}

			}
		}
		return list;
	}
}
