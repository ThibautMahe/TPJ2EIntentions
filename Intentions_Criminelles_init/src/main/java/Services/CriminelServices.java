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

	public void setCriminel(CriminelEntite Criminel) {

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			criminelleAccess.setCriminel(Criminel, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public CriminelEntite getCriminel() {
		CriminelEntite Criminel = null;
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			Criminel = criminelleAccess.getCriminel(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Criminel;
	}

	public ArrayList<CriminelEntite> getAllCriminels() {
		ArrayList<CriminelEntite> allCriminels = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			allCriminels = criminelleAccess.selectAllCriminels(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allCriminels;
	}
}