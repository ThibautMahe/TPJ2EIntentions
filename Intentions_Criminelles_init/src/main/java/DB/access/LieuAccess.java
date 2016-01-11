package DB.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.Entite.LieuEntite;

public class LieuAccess {

	public LieuAccess() {

	}

	public void createLieu(LieuEntite lieu, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("INSERT INTO Lieux(Name,Age) VALUES ('" + lieu.getEmplacement() + "')");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void setLieu(LieuEntite lieu, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("UPDATE Lieux SET Name='" + lieu.getEmplacement() + "'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public LieuEntite getLieu(int LieuID, Connection conn) {
		LieuEntite lieu = null;

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM Lieux WHERE LieuID=" + LieuID)) {
				rs.next();
				lieu = new LieuEntite(Integer.parseInt(rs.getString("LieuID")), rs.getString("Name"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return lieu;
	}
	
	public int getnbLieu(Connection conn) {
		int nbLieu = 0;

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT MAX(LieuID) as NBLieu FROM Lieux")) {
				rs.next();
				nbLieu = Integer.parseInt(rs.getString("NBLieu"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return nbLieu;
	}

	public void DeleteLieu(LieuEntite lieu, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("DELETE FROM Lieux where LieuID=" + lieu.getID());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<LieuEntite> getAllLieux(Connection conn) throws SQLException {

		ArrayList<LieuEntite> list = new ArrayList<LieuEntite>();

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM Lieux")) {
				while (rs.next()) {
					LieuEntite temp = new LieuEntite(rs.getString("Name"));
					list.add(temp);
				}

			}
		}
		return list;
	}

}