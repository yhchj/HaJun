package com.hajun.rho.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	// 단일 커넥션
	public static Connection con = null; 
	
	public static void getConnection() {
		try {
			Class.forName("org.sqlite.JDBC");

			String projectPath = System.getProperty("user.dir");
			con = DriverManager.getConnection("jdbc:sqlite:" + projectPath + "/DB/data.db");
		} catch (ClassNotFoundException e) {
			System.out.println("Database getConnection ClassNotFoundException --> " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Database getConnection SQLException --> " + e.getMessage());
		}

	}

}
