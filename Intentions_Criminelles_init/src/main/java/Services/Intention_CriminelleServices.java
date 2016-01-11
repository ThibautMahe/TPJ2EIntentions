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

	public void createIntention_Criminelle(Intention_CriminelleEntite intention_Criminelle) {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			intention_CriminelleAccess.createIntention_Criminelle(intention_Criminelle, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setIntention_Criminelle(Intention_CriminelleEntite intention_Criminelle) {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			intention_CriminelleAccess.setIntention_Criminelle(intention_Criminelle, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Intention_CriminelleEntite getIntention_Criminelle(int intention_CriminelleID) {
		Intention_CriminelleEntite intention_Criminelle = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			intention_Criminelle = intention_CriminelleAccess.getIntention_Criminelle(intention_CriminelleID, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return intention_Criminelle;
	}

	public int getnbIntention_Criminelle() {
		int nbAction_Criminelle = 0;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			nbAction_Criminelle = intention_CriminelleAccess.getnbIntention_Criminelle(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nbAction_Criminelle;
	}

	public void DeleteIntention_Criminelle(Intention_CriminelleEntite intention_Criminelle) {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			intention_CriminelleAccess.DeleteIntention_Criminelle(intention_Criminelle, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Intention_CriminelleEntite> getAllIntentions_Criminelles() {
		ArrayList<Intention_CriminelleEntite> allIntentions = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			allIntentions = intention_CriminelleAccess.getAllIntentions_Criminelles(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allIntentions;
	}
}
