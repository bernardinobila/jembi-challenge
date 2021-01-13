package org.jembi.challenge.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDAO {
	
	public static Statement statement;

	public ConnectionDAO() {
		super();
		try {
			Connection db = DriverManager.getConnection("jdbc:sqlite::memory:");
			statement = db.createStatement();
			createDatabase();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void createDatabase() throws SQLException {
		statement
				.executeUpdate(
						"create table if not exists patients (id primary key, identityNumber string, "
								+ "firstName string, lastName string, phoneNumber string, address string, gender string, race string)");
	}

}
