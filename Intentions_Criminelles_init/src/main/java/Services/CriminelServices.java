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

	public void createCriminel(CriminelEntite criminel) {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			criminelleAccess.createCriminel(criminel, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setCriminel(CriminelEntite criminel) {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			criminelleAccess.setCriminel(criminel, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public CriminelEntite getCriminel(int criminelID) {
		CriminelEntite criminel = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			criminel = criminelleAccess.getCriminel(criminelID, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return criminel;
	}

	public int getnbCriminel() {
		int nbcriminel = 0;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			nbcriminel = criminelleAccess.getnbCriminel(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nbcriminel;
	}

	public void DeleteCriminel(CriminelEntite criminel) {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			criminelleAccess.DeleteCriminel(criminel, conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CriminelEntite> getAllCriminels() {
		ArrayList<CriminelEntite> allCriminels = null;

		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			allCriminels = criminelleAccess.getAllCriminels(conn);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allCriminels;
	}
}