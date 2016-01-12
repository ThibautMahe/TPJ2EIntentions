package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.access.Constants;
import DB.access.Intention_CriminelleAccess;
import DB.Entite.Action_CriminelleEntite;
import DB.Entite.Intention_CriminelleEntite;
import DB.Entite.LieuEntite;

public class Intention_CriminelleServices {
	private Intention_CriminelleAccess intention_CriminelleAccess;

	public Intention_CriminelleServices() {
		this.intention_CriminelleAccess = new Intention_CriminelleAccess();
	}

	public boolean createIntention_Criminelle(Intention_CriminelleEntite intention_Criminelle) {
		boolean IsCreated = false;
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			if (UneActionDansUnLieu(intention_Criminelle.getAction_Criminelle(), intention_Criminelle.getLieu())) {
				intention_CriminelleAccess.createIntention_Criminelle(intention_Criminelle, conn);
				IsCreated = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return IsCreated;
	}

	public boolean setIntention_Criminelle(Intention_CriminelleEntite intention_Criminelle) {
		boolean IsSettled = false;
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			if (UneActionDansUnLieu(intention_Criminelle.getAction_Criminelle(), intention_Criminelle.getLieu())) {
				intention_CriminelleAccess.setIntention_Criminelle(intention_Criminelle, conn);
				IsSettled = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return IsSettled;
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

	private boolean UneActionDansUnLieu(Action_CriminelleEntite action_Criminelle, LieuEntite lieu) {
		boolean ZoneEtLieuEgale = false;
		if (action_Criminelle.getLieuID() == 0 || action_Criminelle.getLieuID() == lieu.getID())
			ZoneEtLieuEgale = true;
		return ZoneEtLieuEgale;
	}
}
