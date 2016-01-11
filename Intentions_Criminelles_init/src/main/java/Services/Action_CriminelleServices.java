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
	
	public void createAction_Criminelle(Action_CriminelleEntite action_Criminelle) {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			action_CriminelleAccess.createAction_Criminelle(action_Criminelle, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setAction_Criminelle(Action_CriminelleEntite action_Criminelle) {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			action_CriminelleAccess.setActionCriminel(action_Criminelle, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Action_CriminelleEntite getAction_Criminelle(int Action_CriminelleID) {
		Action_CriminelleEntite action_Criminelle = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			action_Criminelle = action_CriminelleAccess.getAction_Criminelle(Action_CriminelleID, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return action_Criminelle;
	}

	public int getnbAction_Criminelle() {
		int nbAction_Criminelle = 0;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			nbAction_Criminelle = action_CriminelleAccess.getnbAction_Criminelle(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nbAction_Criminelle;
	}

	public void DeleteAction_Criminelle(Action_CriminelleEntite action_Criminelle) {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			action_CriminelleAccess.DeleteAction_Criminelle(action_Criminelle, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Action_CriminelleEntite> getAllActions_Criminelles() {
		ArrayList<Action_CriminelleEntite> allIntentions = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			allIntentions = action_CriminelleAccess.getAllActions_Criminelles(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allIntentions;
	}

}
