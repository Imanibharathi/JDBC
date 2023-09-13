package org.jsp.jdbcApp;

import java.sql.*;
import java.util.Scanner;

public class FetchById {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry ="select * from btm.student where id=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id : ");
		int id = sc.nextInt();
		sc.close();
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				String name = rs.getString(2);
				double perc = rs.getDouble(3);
				System.out.println("Name = "+name+"\nPerc = "+perc);
			}
			else {
				System.err.println("No data found for id "+id);
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
