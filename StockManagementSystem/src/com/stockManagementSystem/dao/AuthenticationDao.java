package com.stockManagementSystem.dao;

import java.sql.*;

public class AuthenticationDao {
	public static boolean validate(String signInId,String signInPassword){  
		boolean status=false;  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("select * from sms_managers where manager_id=? and password=?");  
			ps.setString(1,signInId);  
			ps.setString(2,signInPassword);  
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
			
			if (con != null && !con.isClosed())
			{
				con.close();
				Thread.sleep(1000);
			}
		          
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	}  
	public static boolean idExists(String signInId){  
		boolean status=false;  
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("select * from sms_managers where manager_id=?");  
			ps.setString(1,signInId);  
			      
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
		          
			if (con != null && !con.isClosed())
			{
				con.close();
				Thread.sleep(1000);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}  
		return status;  
	} 
}
