package DB.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.Entite.CriminelEntite;

public class CriminelAccess {

	public CriminelAccess() {

	}

	public ArrayList<CriminelEntite> selectAll(Connection conn) throws SQLException {

		ArrayList<CriminelEntite> list = new ArrayList<CriminelEntite>();

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM Criminels")) {
				while (rs.next()) {
					System.out.format("Select criminel %s",rs.getString("Name"));
					CriminelEntite temp = new CriminelEntite(rs.getString("Name"));
					list.add(temp);
				}

			}
		}
		return list;
	}

}
