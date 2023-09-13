package org.jsp.jdbcApp;

import java.sql.*;

public class JdbcDemo {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String qry1 = "insert into btm.student values(4,'Hema',90)";
		String qry2 = "insert into btm.student values(5,'Swaroop',90)";
		String qry3= "insert into btm.student values(6,'Havila',80)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & registered" ); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection established with DBS");
			stmt = con.createStatement();
			System.out.println("Platform created");
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
			System.out.println("Data inserted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(stmt!=null)
			{
			   try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(con!=null)
			{
				try {
					con.close();
				}
				catch(SQLException e)
				{
						e.printStackTrace();
					}
				System.out.println("Closed all costly resources!!!");
				
			}
		}
		
		
	

	 
	}

}
