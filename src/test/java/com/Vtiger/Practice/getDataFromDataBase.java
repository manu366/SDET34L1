package com.Vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class getDataFromDataBase {
	static Connection connection=null;
	public static void main(String[] args) throws SQLException {
		
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from emp_details;");
			while (result.next()) {
				System.out.print(result.getString(1)+" ");
				System.out.print(result.getString(2)+" ");
				System.out.print(result.getString(3)+" ");
				System.out.println();
			}
		}finally {
			connection.close();
		}
	}

}
