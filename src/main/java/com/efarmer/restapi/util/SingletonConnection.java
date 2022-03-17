package com.efarmer.restapi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//singleton connection

public class SingletonConnection
{
	
	static Connection connection = null;
	public static Connection getConnection() 
	{
		
		try 
		{
			if(connection == null) 
			{
				System.out.println("in Connection try");
				Class.forName("org.postgresql.Driver"); // loading postgrel driver to esteblish database connection.
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/efarmer",
			        "postgres", "root");//getConnection() method of DriverManager class is used to establish connection with the database.
			}
			return connection;
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeConnection(Connection connection) 
	{
		try 
		{
			if(connection!=null) 
			{
				try 
				{
					connection.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		finally 
		{
			
		}
	}

}
