package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestView
 */
@WebServlet("/testview")
public class TestView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try(PrintWriter out = response.getWriter()) {
			response.setContentType("text/html");
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>\n"+
					"<meta charset=\"ISO-8859-1\">\n"+
					"<title>Users</title>\n"+
					"<link rel=\"stylesheet\" href=\"css/bootstrap.css\"/>\n"+
			"</head>");
			out.println("<body>");
			out.println("<nav class=\"navbar navbar-inverse\">\n"+
  "<div class=\"container-fluid\">\n"+
  "<div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n"+
    "<ul class=\"nav navbar-nav\">\n"+
     "<li> <a href=\"managetest.html\"><span class=\"glyphicon glyphicon-time\"></span> Test</a></li>\n"+
     "<li> <a href=\"managequestion.html\"><span class=\"glyphicon glyphicon-list-alt\"></span> Questions</a></li>\n"+
    "<li>  <a href=\"manageuser.html\"><span class=\"glyphicon glyphicon-user\"></span> Users</a></li>\n"+
    "</ul>\n"+
    
    "<ul class=\"nav navbar-nav navbar-right\">"+
      "<li class=\"active\"><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Admin</a></li>\n"+
      "<li><a href=\"admin.html\"><span class=\"glyphicon glyphicon-log-out\"></span>Logout</a></li>\n"+
    "</ul>\n"+
  "</div>\n"+
  "</div>\n"+
"</nav>");
			out.println("<div align=\"right\">\n"+
			"<a href=\"TestView\" class=\"btn btn-primary btn-success\"><span class=\"glyphicon glyphicon-th-list\"></span> View</a>\n"+
			"<a href=\"UpdateTest.html\" class=\"btn btn-primary btn-success\"><span class=\"glyphicon glyphicon-pencil\"></span> Edit </a>\n"+
			"<a href=\"DeleteTest.html\" class=\"btn btn-primary btn-success\"><span class=\"glyphicon glyphicon-trash\"></span> Delete</a>\n"+
			"</div>\n");
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Test");
				out.println("<div style='width: 1024px; margin:0 auto;'>");
				out.println("<table class='table table-striped'>");
				out.println("<br><br>");
				out.println("<tr><th>TestName</th><th>NoOfQuestions</th><th>TestDuration</th><th>StartingDate</th><th>EndingDate</th><th>TestCode</th></tr>");
				while(rs.next())
					out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td>");
				out.println("</table>");
				out.println("</div>");
				rs.close();
				stmt.close();
				conn.close();
			} catch(Exception e){
				out.println(e);
			}
			out.println("</body>");
			out.println("</html>");
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
