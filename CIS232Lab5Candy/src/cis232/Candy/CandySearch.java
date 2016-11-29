package cis232.Candy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CandySearch {
	
	public static void main(String[] args) throws SQLException {
	
		Scanner keyboard = new Scanner(System.in);
		final String DB_URL = "jdbc:hsqldb:file:CandyDB/candy";
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DB_URL);
			
		boolean productFound=false;
		while (!productFound){
		System.out.println("Enter a year candy was received: ");
		int userYear = keyboard.nextInt();
		
		productFound=findAndDisplay(conn, userYear);
		}
		
		}finally{
			if (conn != null){
				conn.close();
			}
		}
	}
	
	public static boolean findAndDisplay(Connection conn, int userYear) throws SQLException{
		String sqlString="Select Name, Flavor, Year, Calories"
				+ " FROM Candy"
				+ " Where Year = ?";
		
//		String sqlCalorie="Select MAX(Calorie)"
//						+" FROM Candy"
//						+" Where Year = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sqlString);
//		PreparedStatement stmt2= conn.prepareStatement(sqlCalorie);

		stmt.setString(1, Integer.toString(userYear));
		//stmt2.setString(1, Integer.toString(userCal));
		
		boolean productFound = false;

		ResultSet result = stmt.executeQuery();
		

		if (result.next()){
		System.out.printf("Found based on Year: \n Name: %s \n "
							+ "Flavor: %s \n TOTY: %d \n Calories:%d", result.getString("Name"), result.getString("Flavor"),
				result.getInt("Year"), result.getInt("Calories"));
		//System.out.printf("The Maximum Calorie for Candies in List is: %d ", result.getInt("Calories"));
			productFound=true;
		}
		
		return productFound;
				
	}

}
