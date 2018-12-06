package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CartController;
import controller.ItemController;
import model.Cart;
import model.User;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
HttpSession ses=request.getSession();
    	
    	try{
		@SuppressWarnings("deprecation")
		String s=(String)ses.getValue("LTIME").toString();
    	}catch(Exception e)
    	{
    		response.sendRedirect("UserLogin");
    	}
    	
    	User U=(User)ses.getValue("SUSER");
    	try{PrintWriter out=response.getWriter();
		    ResultSet rs=ItemController.displayById(Integer.parseInt(request.getParameter("iid")));
		    ResultSet rsd=CartController.displayAll();
			if(rsd.next()){
				
			out.println("<html> <table border=1>");
			out.println("<tr> <th><b>Item id:</b> </th><th><b>Quantity:</b></th> <th><b>price</b></th></tr>");

			do{
			out.println("<tr> <td><b>"+rsd.getString(2)+"</b></td> <td><b>"+rsd.getString(3)+"</b></td><td><b>"+rsd.getString(4)+"</b></td></tr>");
			}while(rsd.next());

			out.println("Total Price=");
			out.println("</table>");
			}

    	
		
		
		//out.println("<html>");//out.println(rs.next());out.println(rs.getString(1));
		 if(rs.next())
    	 {
		out.println("iid="+rs.getString(1));
		Cart C=new Cart();
		C.setUserid(U.getUserid());
		C.setItemid(rs.getString(1));
		C.setPrice(rs.getString(3));
		boolean st=CartController.addNewItem(C);
		out.println("<html>");
		if(st)
		{
			
			out.println("<br>Item  successfully inserted into cart <a href='MenuList'>Add more Items</a>");
			
		}
		  else
	       {out.println("Fail to Insert Items..<br><a href='MenuList'>Add More Items</a>");}
	       out.println("</html>");  
	       out.flush();       

		
		
		

		
				
    	 }
		 else
			 {out.println("Empty Cart...");}	 
		 out.println("</html>");
    	}catch(Exception e)
		  {
	 System.out.println("add cart "+e);
	
		  }

	}

}
