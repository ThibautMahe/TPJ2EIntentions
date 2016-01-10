package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.access.Constants;
import DB.access.Action_CriminelleAccess;
import DB.Entite.Action_CriminelleEntite;

public class Action_CriminelleServices {

	private Action_CriminelleAccess action_CriminelleAccess;

	public Action_CriminelleServices() {
		this.action_CriminelleAccess = new Action_CriminelleAccess();
	}

	public ArrayList<Action_CriminelleEntite> getAllActions_Criminelles() {
		ArrayList<Action_CriminelleEntite> allIntentions = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			allIntentions = action_CriminelleAccess.selectAll(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allIntentions;
	}

}
