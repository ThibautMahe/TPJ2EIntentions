package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.access.Constants;
import DB.access.CriminelAccess;
import DB.Entite.CriminelEntite;

public class CriminelServices {
	private CriminelAccess criminelleAccess;

	public CriminelServices() {
		this.criminelleAccess = new CriminelAccess();
	}

	public ArrayList<CriminelEntite> getAllIntentions() {
		ArrayList<CriminelEntite> allIntentions = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			allIntentions = criminelleAccess.selectAll(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allIntentions;
	}
}