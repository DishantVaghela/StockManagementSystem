package com.stockManagementSystem.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.stockManagementSystem.dao.RecoverPasswordDao;

/**
 * Servlet implementation class PasswordService
 */
@WebServlet("/RecoverPasswordService")
public class RecoverPasswordService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecoverPasswordService() {
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
		
		String loginId=request.getParameter("hiddenFieldManagerId");
		String emailId=request.getParameter("hiddenFieldEmailId");
		String loginRecoveryanswer=request.getParameter("textFieldRecoveryAnswer");
		
		if (request.getParameter("buttonGoAhead") != null) {
			if(RecoverPasswordDao.recover(loginId, loginRecoveryanswer)){  
		        
				out.println("<script type=\"text/javascript\">");
		    	out.println("alert('your password has been sent at " + emailId + "');");
		    	out.println("location='index.jsp';");
		    	out.println("</script>");
				
		    }  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('recovery answer is incorrect');");
		    	out.println("location='index.jsp';");
		    	out.println("</script>");
		    } 
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			rd.forward(request,response); 
		}
	}
}