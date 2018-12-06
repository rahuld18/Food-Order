package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.User;

/**
 * Servlet implementation class UserHome
 */
@WebServlet("/UserHome")
public class UserHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();	 
	    out.println("<html>");
	    try{
	    	HttpSession ses=request.getSession();
	    	
			@SuppressWarnings("deprecation")
			User A=(User)ses.getValue("SUSER");
	    	
			@SuppressWarnings("deprecation")
			
			String nav="<h4>"+A.getName()+"["+A.getUserid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+A.getEmail()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='UserLogout'>Logout</a></h4><hr color='red'>";
			
			out.println(nav);
	    	
	    }catch(Exception e){
		    response.sendRedirect("UserLogin");
		   
	    	
		    }
	    
	    
		
	    out.println("<table>");
	   
	    out.println("<tr><td valign='top'>");
        out.println("<a href='UserHome' target='mw'>Home</a><br>");
        out.println("<a href='MenuList' target='mw'>List Menu</a><br>");
        out.print("</td>");
	    out.println("<td valign='top'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<iframe name='mw' frameborder=0 width='1100' height='800'></iframe></td>");
	    out.println("</html>");
		

	}

}
