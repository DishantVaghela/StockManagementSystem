package com.stockManagementSystem.services;

import java.io.*;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.stockManagementSystem.dao.ManageManagersDao;

/**
 * Servlet implementation class ManageManagersService
 */
@WebServlet("/ManageManagersService")
public class ManageManagersService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "managers";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageManagersService() {
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
		
		
		// checks if the request actually contains upload file
        /*if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
        
            out.println("Error: Form must has enctype=multipart/form-data.");
     
            return;
        }*/
 
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = "C:\\Users\\jigis\\Desktop\\6th semester project\\sts workspace\\StockManagementSystem\\WebContent\\images"
                + File.separator + UPLOAD_DIRECTORY;
         
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try{
	        // parses the request's content to extract file data
	        //@SuppressWarnings("unchecked")
	        List<FileItem> formItems = upload.parseRequest(request);
	        // Process the uploaded items
	        Iterator<FileItem> iter = formItems.iterator();
	        String buttonClicked = ((FileItem) iter.next()).getString();
	        String managerId = ((FileItem) iter.next()).getString();
	        String password = ((FileItem) iter.next()).getString();
	        String recoveryQuestion = ((FileItem) iter.next()).getString();
	        String recoveryAnswer = ((FileItem) iter.next()).getString();
	        String emailId = ((FileItem) iter.next()).getString();
	        
	        FileItem item = iter.next();
	        try{
	        	if (!item.isFormField() && buttonClicked.equals("buttonAdd") && item.getSize()>0) {
			        String fileName = managerId + ".png";
		            String filePath = uploadPath + File.separator + fileName;
		            File storeFile = new File(filePath);
		            // saves the file on disk
		            item.write(storeFile);
	        	}
	        }
	        catch(Exception e){
				
			}  	
	               
	        if(buttonClicked.equals("buttonSearch"))
			{
				if(managerId.equals("") && password.equals("") && recoveryQuestion.equals("") && recoveryAnswer.equals("") && emailId.equals("")){  
					RequestDispatcher rd = request.getRequestDispatcher("manageManagersList.jsp");  
					  rd.forward(request,response);
				}  
			    else{  
			    	
			    }
			}
			if(buttonClicked.equals("buttonAdd"))
			{			
				if(ManageManagersDao.add(managerId, password, recoveryQuestion, recoveryAnswer, emailId)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('manager added');");
					out.println("location='manageManagers.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to add manager');");
			    	out.println("location='manageManagers.jsp';");
				    out.println("</script>");
			    }
		 	}
        }
        catch(Exception e){
			System.out.println(e);
		}  

		
		/*String id=request.getParameter("hiddenFieldId");
		//String managerId=request.getParameter("textFieldManagerId");
		//String password=request.getParameter("textFieldPassword");
		//String recoveryQuestion=request.getParameter("textFieldRecoveryQuestion");
		//String recoveryAnswer=request.getParameter("textFieldRecoveryAnswer");
		//String emailId=request.getParameter("textFieldEmailId");
		
		if(request.getParameter("buttonSearch") != null)
		{
			if(managerId=="" && password=="" && recoveryQuestion=="" && recoveryAnswer=="" && emailId==""){  
				rd=request.getRequestDispatcher("manageManagersList.jsp");  
			}  
		    else{  
		    	
		    }
		}
		if(request.getParameter("buttonAdd") != null)
		{			
			out.println();
			/*String fileName = new File(item.getName()).getName();
            String filePath = uploadPath + File.separator + fileName;
            File storeFile = new File(filePath);

            // saves the file on disk
            item.write(storeFile);
			if(ManageManagersDao.add(managerId, password, recoveryQuestion, recoveryAnswer, emailId)){  
				out.println("<script type=\"text/javascript\">");
				out.println("alert('manager added');");
				out.println("location='manageManagers.jsp';");
				out.println("</script>");
			}  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('failed to add manager');");
		    	out.println("location='manageManagers.jsp';");
			    out.println("</script>");
		    }
	 	}
		if(request.getParameter("buttonEdit") != null)
		{
			if(ManageManagersDao.edit(id, managerId, password, recoveryQuestion, recoveryAnswer, emailId)){  
				out.println("<script type=\"text/javascript\">");
				out.println("alert('manager edited');");
				out.println("location='manageManagers.jsp';");
				out.println("</script>");
			}  
		    else{  
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('failed to edit manager');");
		    	out.println("location='manageManagers.jsp';");
			    out.println("</script>");
		    }
	 	}*/
		
      
		
		out.close();
	}
}
