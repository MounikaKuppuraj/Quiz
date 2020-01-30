package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();  
		
        
	    String username=request.getParameter("UserName");  
	    String password=request.getParameter("Password");  
	   
	   
	    if(!(password.equals("admin")&&username.equals("admin"))){
	    	out.println("<script type=\"text/javascript\">");  
			out.println("alert('Password and confirm password are Not Same');");  
			 out.println("location='register.html';");
			out.println("</script>");

	    }
	    else{
	    	 try {
			    	Class.forName("com.mysql.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
					Statement smt =(Statement) con.createStatement();
					smt.execute("truncate table test");
			    	smt.execute("truncate table question");
				
			 }
			 catch(Exception e){
				 System.out.println(e);
			 }
	    	
	    
	    	response.sendRedirect("Manage.html");
	    	
	    	

	    }
	    
	    out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
