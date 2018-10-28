package ru.koror.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	 
	public static Connection getConnection()
	{
		Properties prop = new Properties();
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			InputStream is = Database.class.getResourceAsStream("config.properties");
			if(is==null)
				System.out.println("InputStream is null");
			prop.load(is);
			con = DriverManager.getConnection(prop.getProperty("host"),prop.getProperty("user"),prop.getProperty("password"));
			return con;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Database.getConnection() Error -->" + e.getMessage());
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("Properties Error");
			e.printStackTrace();
			return null;
		} catch (IOException e1) {
			System.out.println("Properties Error");
			e1.printStackTrace();
			return null;
		}
		
	}
	
	public static void close(Connection con)
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
