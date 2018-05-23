package com.stockManagementSystem.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stockManagementSystem.dao.ManageGeneralOrExtraInformationDao;

/**
 * Servlet implementation class ManageGeneralOrExtraInformationListService
 */
@WebServlet("/ManageGeneralOrExtraInformationListService")
public class ManageGeneralOrExtraInformationListService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageGeneralOrExtraInformationListService() {
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
		
		String id=request.getParameter("hiddenFieldId");
		String entity=request.getParameter("textFieldEntity");
		String contact=request.getParameter("textFieldContact");
		String social=request.getParameter("textFieldSocial");
		String email=request.getParameter("textFieldEmail");
		String location=request.getParameter("textFieldLocation");
		
		if(request.getParameter("buttonRemoveExtra") != null)
		{
			if(ManageGeneralOrExtraInformationDao.removeExtra(listId)){  
				out.println("<script type=\"text/javascript\">");
				out.println("alert('extra information removed');");
				out.println("location='manageGeneralOrExtraInformation.jsp';");
				out.println("</script>");
			}  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('failed to remove extra information');");
		    	out.println("location='manageGeneralOrExtraInformation.jsp';");
			    out.println("</script>");
		    }
		}
		
		if(request.getParameter("buttonEditExtra") != null)
		{
			if(ManageGeneralOrExtraInformationDao.editExtra(id, entity, contact, social, email, location)){  
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
	 	}
		
		if(request.getParameter("buttonEditExtraFetch") != null)
		{
			request.setAttribute("editId", listId);
			rd=request.getRequestDispatcher("manageGeneralOrExtraInformationListEdit.jsp");  
		}
		rd.forward(request,response);
		out.close();
	}

}
