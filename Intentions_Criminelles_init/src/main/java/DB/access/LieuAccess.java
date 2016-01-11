package DB.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.Entite.CriminelEntite;
import DB.Entite.LieuEntite;

public class LieuAccess {

	public LieuAccess() {

	}

	public void setLieu(LieuEntite Lieu, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("INSERT INTO Lieux(Name) values('" + Lieu.getEmplacement() + "')");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<LieuEntite> selectAll(Connection conn) throws SQLException {

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