package com.stockManagementSystem.services;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.stockManagementSystem.dao.ManageGeneralOrExtraInformationDao;

/**
 * Servlet implementation class UpdateInformationService
 */
@WebServlet("/ManageGeneralOrExtraInformationService")
public class ManageGeneralOrExtraInformationService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "general";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageGeneralOrExtraInformationService() {
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
	        
	        String applicationVersion = ((FileItem) iter.next()).getString();
	        String rightYear = ((FileItem) iter.next()).getString();
	        String rightEntity = ((FileItem) iter.next()).getString();
	        String rightReserved = ((FileItem) iter.next()).getString();
	        String applicationEmailId = ((FileItem) iter.next()).getString();
	        String applicationEmailPassword = ((FileItem) iter.next()).getString();
	        
	        FileItem item = iter.next();
	        try{
	        	if (!item.isFormField() && buttonClicked.equals("buttonEditGeneral") && item.getSize()>0) {
			        String fileName = "background.png";
		            String filePath = uploadPath + File.separator + fileName;
		            File storeFile = new File(filePath);
		            // saves the file on disk
		            item.write(storeFile);
	        	}
	        }
	        catch(Exception e){
				
			}  	
	        
	        item = iter.next();
	        try{
	        	if (!item.isFormField() && buttonClicked.equals("buttonEditGeneral") && item.getSize()>0) {
	        		String fileName = "entityLogo.png";
		            String filePath = uploadPath + File.separator + fileName;
		            File storeFile = new File(filePath);
		            // saves the file on disk
		            item.write(storeFile);
	        	}
	        }
	        catch(Exception e){
				
			}  	
	        
	        item = iter.next();
	        try{
	        	if (!item.isFormField() && buttonClicked.equals("buttonEditGeneral") && item.getSize()>0) {
	        		String fileName = "applicationLogo.png";
		            String filePath = uploadPath + File.separator + fileName;
		            File storeFile = new File(filePath);
		            // saves the file on disk
		            item.write(storeFile);
	        	}
	        }
	        catch(Exception e){
				
			}  	
	        
	        item = iter.next();
	        try{
	        	if (!item.isFormField() && buttonClicked.equals("buttonEditGeneral") && item.getSize()>0) {
	        		String fileName = "contactLogo.png";
		            String filePath = uploadPath + File.separator + fileName;
		            File storeFile = new File(filePath);
		            // saves the file on disk
		            item.write(storeFile);
	        	}
	        }
	        catch(Exception e){
				
			}  	
	        
	        item = iter.next();
	        try{
	        	if (!item.isFormField() && buttonClicked.equals("buttonEditGeneral") && item.getSize()>0) {
			        String fileName = "socialLogo.png";
		            String filePath = uploadPath + File.separator + fileName;
		            File storeFile = new File(filePath);
		            // saves the file on disk
		            item.write(storeFile);
	        	}
	        }
	        catch(Exception e){
				
			}  	
	        
	        item = iter.next();
	        try{
	        	if (!item.isFormField() && buttonClicked.equals("buttonEditGeneral") && item.getSize()>0) {
			        String fileName = "mailLogo.png";
		            String filePath = uploadPath + File.separator + fileName;
		            File storeFile = new File(filePath);
		            // saves the file on disk
		            item.write(storeFile);
	        	}
	        }
	        catch(Exception e){
				
			}  	
	        
	        item = iter.next();
	        try{
	        	if (!item.isFormField() && buttonClicked.equals("buttonEditGeneral") && item.getSize()>0) {
			        String fileName = "locationLogo.png";
		            String filePath = uploadPath + File.separator + fileName;
		            File storeFile = new File(filePath);
		            // saves the file on disk
		            item.write(storeFile);
	        	}
	        }
	        catch(Exception e){
				
			}  	
	        
	        item = iter.next();
	        try{
	        	if (!item.isFormField() && buttonClicked.equals("buttonEditGeneral") && item.getSize()>0) {
			        String fileName = "favicon.ico";
		            String filePath = uploadPath + File.separator + fileName;
		            File storeFile = new File(filePath);
		            // saves the file on disk
		            item.write(storeFile);
	        	}
	        }
	        catch(Exception e){
				
			}  	
	        
	        String entity = ((FileItem) iter.next()).getString();
	        String contact = ((FileItem) iter.next()).getString();
	        String social = ((FileItem) iter.next()).getString();
	        String email = ((FileItem) iter.next()).getString();
	        String location = ((FileItem) iter.next()).getString(); 
			
			if(buttonClicked.equals("buttonSearchExtra"))
			{
				RequestDispatcher rd = null;
				request.setAttribute("entity", entity);
				request.setAttribute("contact", contact);
				request.setAttribute("social", social);
				request.setAttribute("email", email);
				request.setAttribute("location", location);
				
				rd=request.getRequestDispatcher("manageGeneralOrExtraInformationList.jsp");  
				rd.forward(request,response);
			}
			if(buttonClicked.equals("buttonAddExtra"))
			{
				if(ManageGeneralOrExtraInformationDao.addExtra(entity, contact, social, email, location)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('extra information added');");
					out.println("location='manageGeneralOrExtraInformation.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to add extra information');");
			    	out.println("location='manageGeneralOrExtraInformation.jsp';");
				    out.println("</script>");
			    }
		 	}
			if(buttonClicked.equals("buttonEditGeneral"))
			{
				if(ManageGeneralOrExtraInformationDao.editGeneral(applicationVersion, rightYear, rightEntity, rightReserved, applicationEmailId, applicationEmailPassword)){  
					out.println("<script type=\"text/javascript\">");
					out.println("alert('general information edited');");
					out.println("location='manageGeneralOrExtraInformation.jsp';");
					out.println("</script>");
				}  
			    else{  
			    	out.println("<script type=\"text/javascript\">");
			    	out.println("alert('failed to edit general information');");
			    	out.println("location='manageGeneralOrExtraInformation.jsp';");
				    out.println("</script>");
			    }
		 	}	
        }
        catch(Exception e){
			System.out.println(e);
		}  	
	out.close();
	}
}