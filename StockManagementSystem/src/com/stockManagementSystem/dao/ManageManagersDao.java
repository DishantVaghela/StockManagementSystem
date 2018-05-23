package com.stockManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ManageManagersDao {
	public static boolean add(String managerId, String password, String recoveryQuestion, String recoveryAnswer, String emailId) {
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			     
			PreparedStatement ps=con.prepareStatement("insert into sms_managers values (SMS_FOOTER_SEQ.nextval,?,?,?,?,?,?)");   
			ps.setString(1,managerId);
			ps.setString(2,password);  
			ps.setString(3,recoveryQuestion);
			ps.setString(4,recoveryAnswer);
			ps.setString(5,emailId);
			ps.setString(6,managerId+".png");
			      
			ps.executeUpdate();
            ps.clearParameters(); 
			status=true;
			
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
	
	public static boolean edit(String id, String managerId, String password, String recoveryQuestion, String recoveryAnswer, String emailId) {
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("update sms_managers set manager_id=?, password=?, recovery_question=?, recovery_answer=?, email_id=?, picture=? where id=?");   
			ps.setString(1,managerId);
			ps.setString(2,password);  
			ps.setString(3,recoveryQuestion);
			ps.setString(4,recoveryAnswer);
			ps.setString(5,emailId);
			ps.setString(6,managerId+".png");
			ps.setString(7,id);
			     
			ps.executeUpdate();
            ps.clearParameters(); 
			status=true;
			
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
	
	public static boolean remove(String listId) {
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("delete from sms_managers where id=?");   
			ps.setString(1,listId);
			      
			ps.executeUpdate();
            ps.clearParameters(); 
			status=true;
			
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