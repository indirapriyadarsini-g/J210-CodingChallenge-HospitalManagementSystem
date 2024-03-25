package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnection {
	
	static Connection conn;
	
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/j210hospitalmanagementsystem";
		System.out.println("Entering into DB --- ");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter username: ");
		String username = s.next();
		System.out.println("Enter password: ");
		String password = s.next();
//		s.close();
		
//		String username = "root";
//		String password = "indira";
		
		conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
}
