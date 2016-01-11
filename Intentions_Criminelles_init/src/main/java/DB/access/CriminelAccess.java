package DB.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.Entite.CriminelEntite;

public class CriminelAccess {

	public CriminelAccess() {

	}

	public void createCriminel(CriminelEntite criminel, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("INSERT INTO Criminels(Name,Age) VALUES ('" + criminel.getName() + "',"
						+ criminel.getAge() + ")");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void setCriminel(CriminelEntite criminel, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("UPDATE Criminels SET Name='" + criminel.getName() + "',Age=" + criminel.getAge()
						+ " WHERE CriminelID=" + criminel.getID());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public CriminelEntite getCriminel(int criminelID, Connection conn) {
		CriminelEntite criminel = null;

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM Criminels WHERE CriminelID=" + criminelID)) {
				rs.next();
				criminel = new CriminelEntite(Integer.parseInt(rs.getString("CriminelID")), rs.getString("Name"),
						Integer.parseInt(rs.getString("Age")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return criminel;
	}

	public int getnbCriminel(Connection conn) {
		int nbcriminel = 0;

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT MAX(CriminelID) as nbCriminel FROM Criminels")) {
				rs.next();
				if (rs.getString("NBCRIMINEL") != null)
					nbcriminel = Integer.parseInt(rs.getString("NBCRIMINEL"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return nbcriminel;
	}

	public void DeleteCriminel(CriminelEntite criminel, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("DELETE FROM Criminels where CriminelID=" + criminel.getID());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<CriminelEntite> getAllCriminels(Connection conn) throws SQLException {

		ArrayList<CriminelEntite> list = new ArrayList<CriminelEntite>();

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM Criminels")) {
				while (rs.next()) {
					CriminelEntite temp = new CriminelEntite(Integer.parseInt(rs.getString("CriminelID")),
							rs.getString("Name"), Integer.parseInt(rs.getString("Age")));
					list.add(temp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

}
