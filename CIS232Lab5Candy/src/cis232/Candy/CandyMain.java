package cis232.Candy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CandyMain {

	private static final String DB_URL = "jdbc:hsqldb:file:CandyDB/candy";

	public static void main(String[] args) throws SQLException {

		Scanner keyboard = new Scanner(System.in);

		final String DB_URL = "jdbc:hsqldb:file:CandyDB/candy";
		Connection conn = null;

		System.out.println("Enter 1 to Insert Candy or 2 to Delete Candy: ");
		int userInput = keyboard.nextInt();

		keyboard.nextLine();
		
		switch (userInput) {
		case 1: {
			// creating connection
			conn = DriverManager.getConnection(DB_URL);

			System.out.println("Enter the name of Candy you would like to Insert: ");
			String name = keyboard.nextLine();

			
			
			System.out.println("Enter the flavor of the Candy to Insert: ");
			String flavor = keyboard.nextLine();

			
			
			System.out.println("Enter the year you recieved the Candy from Halloween: ");
			int year = keyboard.nextInt();
			
			keyboard.nextLine();

			System.out.println("Enter the Calories the candy has: ");
			int cal = keyboard.nextInt();
			
			keyboard.nextLine();

			String sql = "INSERT INTO CANDY" 
						+" (Name,Flavor,Year, Calories)"
						+" VALUES"
						+" (?, ?, ?,?);";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, name);
			stmt.setString(2, flavor);
			stmt.setDouble(3, year);
			stmt.setDouble(4, cal);

			stmt.executeUpdate();

			conn.close();

			System.out.println("Inserted Candy!");
			break;
		}//case 1 ending 

		
		case 2: {
				  String userName;
					
					// get user input on what to delete
					System.out.println("Enter Candy Name to Delete: ");
					findAndDelete(userName = keyboard.nextLine());
					// look up candy based on name

					

				
				
				break;
		}//case 2 ending
		}//switch ending 
		
	}//main ending

	public static void findAndDelete(String userName) throws SQLException {
		
		Connection conn = DriverManager.getConnection(DB_URL);
		
		

	
		
		String sqlString = "DELETE" + " FROM Candy" + " WHERE Name = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sqlString);
		
		stmt.setString(1, userName);
	
		int count = stmt.executeUpdate();

		System.out.printf("Deleted: %d rows", count );
		
		conn.close();

	}

}
