package com.tnsif.JDBC;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.jdi.connect.spi.Connection;

//Demo for JDBC
public class DemoJdbc {
	
	private static String DRIVERNAME="org.postgresql.Driver";
	
	private static String Username="postgres";
	
	private static String Password="santhu";
	
	private static String URL="jdbc:postgresql://localhost:5432/SRIINDU";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.loading the driver
		Class.forName(DRIVERNAME);
		System.out.println("driver loaded");
		
		//2.Establish connection
		java.sql.Connection con=DriverManager.getConnection(URL,Username,Password);
		System.out.println("connection established");
		//3.create statement
		Statement stmt=((java.sql.Connection) con).createStatement();
		
		//4.execute the query
		String query="select * from STUDENTS";
		
		ResultSet rs=stmt.executeQuery(query);
		
	    //5.retrieving the data
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		}
		
		//close the connection
		stmt.close();
		con.close();
	}
}
