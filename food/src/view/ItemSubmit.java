package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import controller.ItemController;
import model.Item;

/**
 * Servlet implementation class ItemSubmit
 */
@WebServlet("/ItemSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class ItemSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Item I=new Item();PrintWriter out=response.getWriter();
		I.setItemname(request.getParameter("name"));
         I.setPrice(request.getParameter("price"));	
         I.setDescription(request.getParameter("scdescription"));
         I.setCategory(request.getParameter("pcategory"));
         I.setSubcategory(request.getParameter("psubcategory"));
		
		 Part P1=request.getPart("ph");
		    FileUpload F=new FileUpload(P1,"C:/Users/rahul/workspace/food/WebContent/itemimages");
		    I.setPhoto(F.filename);
		  boolean st=  ItemController.addNewItem(I);
		  out.println("<html>");
			if(st)
			{
				
				out.println("Item inserted <a href='ItemView'>Add more Item</a>");
				
			}
			  else
		       {out.println("Fail to Submit Item..<br><a href='ItemView'>Add More Item</a>");}
		       out.println("</html>");  
		       out.flush();       
	}

}
