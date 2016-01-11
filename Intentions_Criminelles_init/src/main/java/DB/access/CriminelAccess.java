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

	public void setCriminel(CriminelEntite criminel, Connection conn) {
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeUpdate("INSERT INTO Criminels(Name,Age) values('" + criminel.getName() + "',"
						+ criminel.getAge() + ")");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public CriminelEntite getCriminel( Connection conn){
		CriminelEntite criminel = new CriminelEntite();
		
		try (Statement stmt = conn.createStatement()) {
			try {
				stmt.executeQuery("SELECT * FROM Criminels");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return criminel;
	}

	public ArrayList<CriminelEntite> selectAllCriminels(Connection conn) throws SQLException {

		ArrayList<CriminelEntite> list = new ArrayList<CriminelEntite>();

		try (Statement stmt = conn.createStatement()) {
			try (ResultSet rs = stmt.executeQuery("SELECT * FROM Criminels")) {
				while (rs.next()) {
					CriminelEntite temp = new CriminelEntite(rs.getString("Name"),Integer.parseInt(rs.getString("Age")));
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
