package com.stockManagementSystem.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stockManagementSystem.dao.ManageStockDao;

/**
 * Servlet implementation class ManageStockListService
 */
@WebServlet("/ManageStockListService")
public class ManageStockListService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageStockListService() {
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
		
		RequestDispatcher rd = null;
		String listId=request.getParameter("hiddenFieldListId");
		
		/*String id=request.getParameter("hiddenFieldId");
		String managerId=request.getParameter("textFieldManagerId");
		String password=request.getParameter("textFieldPassword");
		String recoveryQuestion=request.getParameter("textFieldRecoveryQuestion");
		String recoveryAnswer=request.getParameter("textFieldRecoveryAnswer");
		String emailId=request.getParameter("textFieldEmailId");*/
		
		if(request.getParameter("buttonRemove") != null)
		{
			if(ManageStockDao.remove(listId)){  
				out.println("<script type=\"text/javascript\">");
				out.println("alert('stock removed');");
				out.println("location='manageStock.jsp';");
				out.println("</script>");
			}  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('failed to remove stock');");
		    	out.println("location='manageStock.jsp';");
			    out.println("</script>");
		    }
		}
		
		/*if(request.getParameter("buttonEdit") != null)
		{
			if(ManageManagersDao.edit(id, managerId, password, recoveryQuestion, recoveryAnswer, emailId)){  
				out.println("<script type=\"text/javascript\">");
				out.println("alert('extra information edited');");
				out.println("location='manageGeneralOrExtraInformation.jsp';");
				out.println("</script>");
			}  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('failed to edit extra information');");
		    	out.println("location='manageGeneralOrExtraInformation.jsp';");
			    out.println("</script>");
		    }
	 	}*/
		
		if(request.getParameter("buttonEditFetch") != null)
		{
			request.setAttribute("editId", listId);
			rd=request.getRequestDispatcher("manageStockListEdit.jsp");  
		}
		rd.forward(request,response);
		out.close();
	}

}
