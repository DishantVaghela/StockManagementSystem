package com.stockManagementSystem.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stockManagementSystem.dao.AuthenticationDao;

/**
 * Servlet implementation class LoginService
 */
@WebServlet("/AuthenticationService")
public class AuthenticationService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String signInId=request.getParameter("textFieldId");
		String signInPassword=request.getParameter("passwordFieldPassword");
		
		if (request.getParameter("buttonSignIn") != null) { 
	    	if(signInId=="" || signInPassword==""){
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter id as well as password');");
		    	out.println("location='index.jsp';");
		    	out.println("</script>");
			}
			else{
				if (AuthenticationDao.idExists(signInId)){
					if(AuthenticationDao.validate(signInId, signInPassword)){  
				        HttpSession session=request.getSession();  
				        session.setAttribute("session_id",signInId);  
				        
				        RequestDispatcher rd=request.getRequestDispatcher("manageStock.jsp");  
				        rd.forward(request,response); 
				    } 
					else{
						out.println("<script type=\"text/javascript\">");
				    	out.println("alert('password is incorrect');");
				    	out.println("location='index.jsp';");
				    	out.println("</script>");
					}	
				}
				else{
					out.println("<script type=\"text/javascript\">");
			    	out.println("alert('id does not exist');");
			    	out.println("location='index.jsp';");
			    	out.println("</script>");
				}
			}
		}
		else {
			if(signInId==""){
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('enter id');");
		    	out.println("location='index.jsp';");
		    	out.println("</script>");
			}
			else{
				if (AuthenticationDao.idExists(signInId)){
					RequestDispatcher rd=request.getRequestDispatcher("recoverPassword.jsp"); 
					rd.forward(request,response); 
				}
				else{
					out.println("<script type=\"text/javascript\">");
			    	out.println("alert('id does not exist');");
			    	out.println("location='index.jsp';");
			    	out.println("</script>");
				}
			}
		}
	    out.close();  
	}
}
