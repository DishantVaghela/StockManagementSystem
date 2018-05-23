package com.stockManagementSystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ManageStockDao {

	public static boolean add(String description, String deliveryDay, String permittedBy, String grantName, String quantity, String cost, String isDeadStock) {
		boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			     
			PreparedStatement ps=con.prepareStatement("insert into sms_stock values (SMS_FOOTER_SEQ.nextval,?,?,?,?,?,?,?,?)");   
			ps.setString(1,deliveryDay);
			ps.setString(2,description);  
			ps.setString(3,permittedBy);
			ps.setString(4,grantName);
			ps.setString(5,quantity);
			ps.setString(6,cost);
			ps.setString(7,isDeadStock);
			ps.setString(8,description+deliveryDay+grantName+quantity+".png");
			      
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
			      
			PreparedStatement ps=con.prepareStatement("delete from sms_stock where id=?");   
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

	public static boolean edit(String id, String description, String deliveryDay, String permittedBy, String grantName,	String quantity, String cost, String isDeadStock) {
boolean status=false;  
		
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			      
			PreparedStatement ps=con.prepareStatement("update sms_stock set description=?, delivery_day=?, permitted_by=?, grant_name=?, quantity=?, cost=?, is_deadstock=?, picture=? where id=?");   
			ps.setString(1,description);
			ps.setString(2,deliveryDay);  
			ps.setString(3,permittedBy);
			ps.setString(4,grantName);
			ps.setString(5,quantity);
			ps.setString(6,cost);
			ps.setString(7,isDeadStock);
			ps.setString(8,description+deliveryDay+grantName+quantity+".png");
			ps.setString(9,id);
			     
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
