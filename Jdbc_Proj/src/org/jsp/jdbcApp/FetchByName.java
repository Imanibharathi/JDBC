package org.jsp.jdbcApp;

import java.sql.*;
import java.util.Scanner;

public class FetchByName {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry ="select * from btm.student where name=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name : ");
		String name = sc.next();
		sc.close();
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				int id= rs.getInt(1);
				double perc = rs.getDouble(3);
				System.out.println("ID = "+id+"\nPerc = "+perc);
			}
			else {
				System.err.println("No data found for name "+name);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}


		}

	}

}
