package DB.access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.Entite.LieuEntite;

public class LieuAccess {

	public LieuAccess() {

	}

	public ArrayList<LieuEntite> selectAll(Connection conn) throws SQLException {

		ArrayList<LieuEntite> list = new ArrayList<LieuEntite>();

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM intentions")) {
				while (rs.next()) {
					LieuEntite temp = new LieuEntite(rs.getString("description"));
					list.add(temp);
				}

			}
		}
		return list;
	}

}
