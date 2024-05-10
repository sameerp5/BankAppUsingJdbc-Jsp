package com.bank.databaseconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
	public static Connection connectDB() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root123");
	}
}
