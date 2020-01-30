package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Forget
 */
@WebServlet("/Forget")
public class Forget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forget() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();  
		 String username=request.getParameter("Username");  
		    String answer=request.getParameter("answer");  
		    String ans=null;
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement smt =(Statement) con.createStatement();
			ResultSet rs = smt.executeQuery("select securityques from register where username='"+username+"'");  
		   while(rs.next()){
		    	ans=rs.getString("securityques");
		    }
		   
		   con.close();
		   smt.close();
		   rs.close();
		   
		    if(!(ans.equals(answer))){
		    	out.println("<script type=\"text/javascript\">");  
				out.println("alert('security answer doesnt match');");  
				 out.println("location='forget.html';");
				out.println("</script>");

		    }
		    else{
		    	response.sendRedirect("taketest.html");
		    	

		    }		    }
		    catch(Exception e){
		    out.println(e);
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
