package com.bilgeadam.lesson042;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCConnectionTest {

	public static void main(String[] args) {
//		String url = "jdbc:postgresql://localhost:5432/northwind";     1
//		String url = "jdbc:postgresql://localhost:5432/northwind?user=postgres&password=root";   // 2

		// 3. yol
		String url = "jdbc:postgresql://localhost:5432/northwind";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "root");
		try {
//			Connection conn = DriverManager.getConnection(url, "postgres", "root");    1
//			Connection conn = DriverManager.getConnection(url);   					// 2
			Connection conn = DriverManager.getConnection(url, props);   			// 3
			System.out.println("connection established");
			
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM products;";
			ResultSet rs = stmt.executeQuery(sql);
			
			int colCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				for (int i=1; i<=colCount;i++) {
					System.out.println(rs.getMetaData().getColumnLabel(i) + ": " + rs.getString(i));
				}
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString("quantity_per_unit"));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}


