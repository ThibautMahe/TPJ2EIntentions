package DB.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.Entite.Intention_CriminelleEntite;
import Services.Action_CriminelleServices;
import Services.CriminelServices;
import Services.LieuServices;

public class Intention_CriminelleAccess {

	public Intention_CriminelleAccess() {

	}

	public void createIntention_Criminelle(Intention_CriminelleEntite intention_Criminelle, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("INSERT INTO Lieux(CriminelID,LieuID,Action_criminelleID) VALUES ("
						+ intention_Criminelle.getCriminelID() + "," + intention_Criminelle.getLieuID() + ","
						+ intention_Criminelle.getAction_CriminelleID() + ")");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void setIntention_Criminelle(Intention_CriminelleEntite intention_Criminelle, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("UPDATE Intentions SET CriminelID='" + intention_Criminelle.getCriminelID()
						+ "',LieuID=" + intention_Criminelle.getLieuID() + ",Action_criminelleID="
						+ intention_Criminelle.getAction_CriminelleID() + " WHERE CriminelID="
						+ intention_Criminelle.getID());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public Intention_CriminelleEntite getIntention_Criminelle(int Intenton_CriminelleID, Connection conn) {
		Intention_CriminelleEntite intention_Criminelle = new Intention_CriminelleEntite();
		CriminelServices criminelService = new CriminelServices();
		LieuServices lieuService = new LieuServices();
		Action_CriminelleServices action_criminelleService = new Action_CriminelleServices();
		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM Intentions WHERE IntionID=" + Intenton_CriminelleID)) {
				rs.next();
				intention_Criminelle = new Intention_CriminelleEntite(Integer.parseInt(rs.getString("IntentionID")),
						action_criminelleService.getAction_Criminelle(
								Integer.parseInt(rs.getString("Action_CriminelleID"))),
								criminelService.getCriminel(Integer.parseInt(rs.getString("CriminelID"))),
								lieuService.getLieu(Integer.parseInt(rs.getString("LieuID"))));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return intention_Criminelle;
	}

	public int getnbIntention_Criminelle(Connection conn) {
		int NBIntention = 0;

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT MAX(IntentionID) as NBIntention FROM Intentions")) {
				rs.next();
				if (rs.getString("NBIntention") != null)
					NBIntention = Integer.parseInt(rs.getString("NBIntention"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return NBIntention;
	}

	public void DeleteIntention_Criminelle(Intention_CriminelleEntite intention_Criminelle, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("DELETE FROM Intentions where IntentionID=" + intention_Criminelle.getID());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<Intention_CriminelleEntite> getAllIntentions_Criminelles(Connection conn) throws SQLException {

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
