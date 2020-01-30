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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();  
         
		    String username=request.getParameter("UserName");  
		    String password=request.getParameter("Password");  
		    String pass=password;
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement smt =(Statement) con.createStatement();
			ResultSet rs = smt.executeQuery("select password from register where username='"+username+"'");  
		   while(rs.next()){
		    	pass=rs.getString("password");
		    	
		    }
		   smt.execute("truncate table useranswers");
		   con.close();
		   smt.close();
		   rs.close();
		   
		    if(!(pass.equals(password))){
		    	out.println("<script type=\"text/javascript\">");  
				out.println("alert('Password and confirm password are Not Same');");  
				 out.println("location='login.html';");
				out.println("</script>");

		    }
		    else{
		    	
		    	response.sendRedirect("taketest.html");
		    	

		    }
		    }
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
