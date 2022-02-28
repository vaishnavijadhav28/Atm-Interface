package com.atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public Connection connection() {
		Connection conn=null;
		String databaseUrl="jdbc:mysql://localhost:3306/atmapp";
		String username="root";
		String userpassword="MYSQL";
		
		try 
		{
			conn=DriverManager.getConnection(databaseUrl,username,userpassword);
		}
		catch(SQLException e)
		{
			System.out.println("Internal Server Error!!!!");
		}
		
		
		return conn;
		

	}

}
