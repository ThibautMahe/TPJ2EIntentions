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
						"CREATE TABLE Intentions(IntentionID BIGINT PRIMARY KEY AUTO_INCREMENT, CriminelID BIGINT, LieuID BIGINT, Action_CriminelleID BIGINT)");
				stm.execute("DROP TABLE IF EXISTS Actions_criminelles");
				stm.execute(
						"CREATE TABLE Actions_criminelles(Action_CriminelleID BIGINT PRIMARY KEY AUTO_INCREMENT, Action_criminelle VARCHAR(255)) ");
				stm.execute("DROP TABLE IF EXISTS Criminels");
				stm.execute(
						"CREATE TABLE Criminels(CriminelID BIGINT PRIMARY KEY AUTO_INCREMENT, Nom VARCHAR(255), Age BIGINT) ");
				stm.execute("DROP TABLE IF EXISTS Lieux");
				stm.execute("CREATE TABLE Lieux(LieuID BIGINT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(255)) ");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void populateSchema() {
		try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD)) {
			try (Statement stm = conn.createStatement()) {
				stm.executeUpdate("INSERT INTO Lieux(Name) VALUES('Jean')");
				stm.executeUpdate("INSERT INTO Lieux(Name) VALUES('Jacque')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}