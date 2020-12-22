package qa.com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnector {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String URL = "jdbc:mysql://localhost:3306/classicmodels";

		// Database Username
		String username = "root";

		// Database password
		String password = "Rajat@1234";

		// Query to execute
		String query = "Select * from customers;";

		// Load mysql jdbc driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Create connection to Database
		Connection con = DriverManager.getConnection(URL, username, password);

		// Create Statement object
		Statement stmt = con.createStatement();

		// Execute the SQL query and store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);

		// While loop to iterate through all data and print results
		while (rs.next()) {
			String customerNumber = rs.getString(1);
			String customerName = rs.getString(2);
			System.out.println(customerNumber + " " + customerName);
		}
		// Close connection to Database
		con.close();
	}
}