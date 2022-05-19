package com.phbook.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnectionUtil {
	
	
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String Url="jdbc:mysql://localhost:3306/fsd19jan";
	private static final String User="root";
	private static final String Password="mayur";
	
	//create Database Connection
	public static final Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName(Driver);
			con = DriverManager.getConnection(Url,User,Password);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	
	//close DB connection 
	public static final void closeConnection(Connection con) {
		try {
			if(con!=null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
