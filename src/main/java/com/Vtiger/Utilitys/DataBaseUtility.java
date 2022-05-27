package com.Vtiger.Utilitys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;
/**
 * this method is used for data base
 */
public class DataBaseUtility {
	static Statement statement;
	static Connection connection;
	/**
	 * this method is used to get connection to data base
	 * @param dataBaseUrl
	 * @param dbusername
	 * @param dbpassword
	 * @throws SQLException 
	 */
	public static void openDataBaseConnection( String dataBaseUrl,String dbusername,String dbpassword) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(dataBaseUrl,dbusername,dbpassword);
		statement = connection.createStatement();
	}
	/**
	 * this method is used fetch the data from data base
	 * @param query
	 * @param columenName
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> getDataFromDataBase(String query,String columenName) throws SQLException {	
		ArrayList<String> list=new ArrayList<>();
		ResultSet result = statement.executeQuery(query);
		while (result.next()) {
			list.add(result.getString(columenName));
		}
		return list;
	}
	/**
	 * this method is used to validate data in data whether it is presentin database or not
	 * @param query
	 * @param columenName
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<String> validateDataInDatabase(String query,String columenName,String expectedData) throws SQLException {	
		ArrayList<String> list=getDataFromDataBase(query, columenName);
		boolean flag=false;
		for (String actualData : list) {
			if (actualData.equalsIgnoreCase(expectedData)) {
				flag=true;
				break;
			}
		}
		return list;
	}
	/**
	 * this method is use to store data in database
	 * @param qurey
	 * @throws SQLException
	 */
	public static void setDataInDataBase(String qurey) throws SQLException {
		int reult = statement.executeUpdate(qurey);
		if (reult==1) {
			System.out.println("data entered sucessfully");
		}
		
	}
	/**
	 * this method is used to close the database connection
	 */
	public static void closeDataBaseConnection() {	
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}