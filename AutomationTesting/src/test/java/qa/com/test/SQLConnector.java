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

		// While loop to iterate through all data and print results
		int i = 0;
		while (rs.next()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(rs.getString(1));
			list.add(rs.getString(2));
			list.add(rs.getString(3));
			list.add(rs.getString(4));
			list.add(rs.getString(5));
			list.add(rs.getString(6));
			list.add(rs.getString(7));
			list.add(rs.getString(8));
			list.add(rs.getString(9));
			list.add(rs.getString(10));
			list.add(rs.getString(11));
			list.add(rs.getString(12));
			list.add(rs.getString(13));

			writeIntoExcel(System.getProperty("user.dir"), "Database_Excel.xlsx", list, i++);
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