package qa.com.test;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SQLConnector {

	static XSSFWorkbook workbook = new XSSFWorkbook();
	static XSSFSheet sheet = workbook.createSheet("database");

	public static void main(String[] args) throws Exception {
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

		XSSFWorkbook workbook = new XSSFWorkbook();

		// While loop to iterate through all data and print results
		String customerNumber = "", customerName = "", contactLastName = "", contactFirstName = "", phone = "",
				addressLine1 = "", addressLine2 = "", city = "", state = "", postalCode = "", country = "",
				salesRepEmployeeNumber = "", creditLimit = "";
		int i = 0;
		while (rs.next()) {
			customerNumber = rs.getString(1);
			customerName = rs.getString(2);
			contactLastName = rs.getString(3);
			contactFirstName = rs.getString(4);
			phone = rs.getString(5);
			addressLine1 = rs.getString(6);
			addressLine2 = rs.getString(7);
			city = rs.getString(8);
			state = rs.getString(9);
			postalCode = rs.getString(10);
			country = rs.getString(11);
			salesRepEmployeeNumber = rs.getString(12);
			creditLimit = rs.getString(13);
			ArrayList<String> list = new ArrayList<>();
			list.add(customerNumber);
			list.add(customerName);
			list.add(contactLastName);
			list.add(contactFirstName);
			list.add(phone);
			list.add(addressLine1);
			list.add(addressLine2);
			list.add(city);
			list.add(state);
			list.add(postalCode);
			list.add(country);
			list.add(salesRepEmployeeNumber);
			list.add(creditLimit);
//
//			System.out.println(customerNumber + "\t" + customerName + "\t" + contactLastName + "\t" + contactFirstName
//					+ "\t" + phone + "\t" + addressLine1 + "\t" + addressLine2 + "\t" + city + "\t" + state + "\t"
//					+ postalCode + "\t" + country + "\t" + salesRepEmployeeNumber + "\t" + creditLimit);
			writeIntoExcel(System.getProperty("user.dir"), "Database_Excel.xlsx", list, i);
			i++;
		}
		// Close connection to Database
		con.close();
		System.out.println("Writing into Excel completed!");
	}

	public static void writeIntoExcel(String filePath, String fileName, ArrayList<String> dataToWrite, int rowIndex)
			throws Exception {

		Row row = sheet.createRow(rowIndex);

		for (int i = 0; i < dataToWrite.size(); i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(dataToWrite.get(i));
		}

		FileOutputStream fos = new FileOutputStream(filePath + "\\" + fileName);
		workbook.write(fos);
		fos.close();
	}
}