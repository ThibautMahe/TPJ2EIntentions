package DB.access;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Populator {

	public static void createSchema() {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			try (Statement stm = conn.createStatement()) {
				stm.execute("DROP TABLE IF EXISTS Intentions");
				stm.execute(
						"CREATE TABLE Intentions(id IntentionID PRIMARY KEY AUTO_INCREMENT, int CriminelID, int LieuID, int Action_CriminelleID)");
				stm.execute("DROP TABLE IF EXIST Actions_criminelles");
				stm.execute(
						"CREATE TABLE Actions_criminelles(int Action_CriminelleID PRIMARY KEY AUTO_INCREMENT, Action_criminelle VARCHAR(255)) ");
				stm.execute("DROP TABLE IF EXIST Criminelles");
				stm.execute(
						"CREATE TABLE Criminelles(int CriminelleID PRIMARY KEY AUTO_INCREMENT, Nom VARCHAR(255), int Age) ");
				stm.execute("DROP TABLE IF EXIST Lieu");
				stm.execute("CREATE TABLE Criminelles(int LieuID PRIMARY KEY AUTO_INCREMENT, Nom VARCHAR(255)) ");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void populateSchema() {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			try (Statement stm = conn.createStatement()) {
				stm.executeUpdate("INSERT INTO Intentions(description) VALUES('Essai description')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}