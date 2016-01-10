package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.access.Constants;
import DB.access.Intention_CriminelleAccess;
import DB.Entite.Intention_CriminelleEntite;

public class Intention_CriminelleServices {
	private Intention_CriminelleAccess intention_CriminelleAccess;

	public Intention_CriminelleServices() {
		this.intention_CriminelleAccess = new Intention_CriminelleAccess();
	}

	public ArrayList<Intention_CriminelleEntite> getAllIntentions() {
		ArrayList<Intention_CriminelleEntite> allIntentions = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			allIntentions = intention_CriminelleAccess.selectAll(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allIntentions;
	}
}
