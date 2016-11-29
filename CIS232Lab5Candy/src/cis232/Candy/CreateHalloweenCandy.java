package cis232.Candy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateHalloweenCandy {

	public static void main(String[] args) {
		// Create a named constant for the URL.
		// NOTE: This value is specific for Java DB.
		final String DB_URL = "jdbc:hsqldb:file:CandyDB/candy";
		
		try {
			// Create a connection to the database.
			Connection conn = DriverManager.getConnection(DB_URL);

			// If the DB already exists, drop the tables.
			dropTables(conn);

			// Build the Candy table.
			buildCandyTable(conn);


			// Close the connection.
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}

	}
	
	private static void dropTables(Connection conn) {
		try {
			// Get a Statement object.
			Statement stmt = conn.createStatement();
			;

			try {
				// Drop the Coffee table.
				stmt.execute("DROP TABLE Candy");
				System.out.println("Candy table dropped.");
			} catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
		
	}
	

	private static void buildCandyTable(Connection conn) {
		try {
			// Get a Statement object.
			Statement stmt = conn.createStatement();

			// Create the table.
			stmt.execute("CREATE TABLE Candy (" + "Name CHAR(25) NOT NULL PRIMARY KEY, " + "Flavor CHAR(20), "
					+ "Year INT, " +"Calories INT " + ")");

			// Insert row #1.
			stmt.execute("INSERT INTO Candy VALUES ( " + "'Starburst', " + "'Fruity', " + "2013, " + "160 )");

			// Insert row #2.
			stmt.execute("INSERT INTO Candy VALUES ( " + "'Nerds', " + "'Strawberry/Grape', " + "2016, " + "50  )");

			// Insert row #3.
			stmt.execute("INSERT INTO Candy VALUES ( " + "'Reeses Cup', " + "'Peanut/Chocolate', " + "2001, " + "87  )");

			// Insert row #4.
			stmt.execute("INSERT INTO Candy VALUES ( " + "'M&Ms', " + "'Chocolate', " + "2009, " + "175  )");

			// Insert row #5.
			stmt.execute("INSERT INTO Candy VALUES ( " + "'Kit Kat', " + "'Chocolate/Wafer', " + "2012, " + "218  )");
			
			// Insert row #6.
			stmt.execute("INSERT INTO Candy VALUES ( " + "'Reeses Pieces', " + "'Peanut/Chocolate', " + "2012, " + "350  )");

			System.out.println("Candy table created.");
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	

}
