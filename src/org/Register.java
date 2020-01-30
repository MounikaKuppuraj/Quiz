package org;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
     // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			String username = request.getParameter("username");
			String password = request.getParameter("Password");
			String confirmpassword = request.getParameter("Confirmpassword");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String gender= request.getParameter("gender");
			String dob= request.getParameter("dob");
			String occupation= request.getParameter("occupation");
			String answer = request.getParameter("answer");
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement stmt =   conn.createStatement();
				stmt.executeUpdate("insert into register values('"+username+"','"+password+"','"+confirmpassword+"','"+email+"','"+telephone+"','"+gender+"','"+dob+"','"+occupation+"','"+answer+"')");
				stmt.close();
				conn.close();
				if(!(password.equals(confirmpassword))){
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Password and confirm password are Not Same');");  
				 out.println("location='register.html';");
				out.println("</script>");

				}
				else{
				response.sendRedirect("login.html");
				}

			} catch(Exception e){
				out.println(e);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


