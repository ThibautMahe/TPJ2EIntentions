package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.access.Constants;
import DB.access.LieuAccess;
import DB.Entite.LieuEntite;

public class LieuServices {
	private LieuAccess lieuAccess;

	public LieuServices() {
		this.lieuAccess = new LieuAccess();
	}

	public void createLieu(LieuEntite lieu) {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			lieuAccess.createLieu(lieu, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setLieu(LieuEntite lieu) {

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			lieuAccess.setLieu(lieu, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public LieuEntite getLieu(int lieuID) {
		LieuEntite lieu = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			lieu = lieuAccess.getLieu(lieuID, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lieu;
	}

	public int getnbLieu() {
		int nbLieu = 0;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			nbLieu = lieuAccess.getnbLieu(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nbLieu;
	}

	public void DeleteLieu(LieuEntite lieu) {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			lieuAccess.DeleteLieu(lieu, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<LieuEntite> getAllLieux() {
		ArrayList<LieuEntite> allIntentions = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			allIntentions = lieuAccess.getAllLieux(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allIntentions;
	}
}