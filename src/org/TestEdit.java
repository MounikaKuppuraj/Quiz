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
 * Servlet implementation class TestEdit
 */
@WebServlet("/EditTest1")
public class TestEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
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
			"<a href=\"testview\" class=\"btn btn-primary btn-success\"><span class=\"glyphicon glyphicon-th-list\"></span> View</a>\n"+
			"<a href=\"UpdateTest.html\" class=\"btn btn-primary btn-success\"><span class=\"glyphicon glyphicon-pencil\"></span> Edit </a>\n"+
			"<a href=\"DeleteTest.html\" class=\"btn btn-primary btn-success\"><span class=\"glyphicon glyphicon-trash\"></span> Delete</a>\n"+
			"</div>\n"+
			"</form>\n"+
			"</div>\n"+
			"</body>\n"+
			"</html>\n");
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement stmt = conn.createStatement();
				String name=request.getParameter("TestName");
				ResultSet rs = stmt.executeQuery("select * from test where Testname = '"+name+"'");
			if(rs.next()){
				out.println("<!DOCTYPE html>\n");
				out.println("<html>\n");
				out.println("<head>\n");
				out.println("<meta charset='ISO-8859-1'>"+

				"<title>Student - Update</title>"+
				"<link rel=\"stylesheet\" href=\"css/bootstrap.css\"/>"+
				"</head>"+
				"<body>"+
				
				"<div style='width: 512px; margin:0 auto;'>"+
				"<form action=\"EditTest2\" method=\"post\">"+
				  "<div class=\"form-group row\">\n"+
				  "<label for=\"TestName\" class=\"col-2 col-form-label\">TestName</label>\n"+
				  "<div class=\"col-10\">\n"+
				  
				    "<input class=\"form-control\" type=\"text\" name=\"TestName\" value='"+name+"' id=\"TestName\">\n"+
				  "</div>\n"+
				"</div>\n"+
				"<div class=\"form-group row\">\n"+
				  "<label for=\"NoOfQuestions\" class=\"col-2 col-form-label\">NoOfQuestions</label>\n"+
				  "<div class=\"col-10\">\n"+
				    "<input class=\"form-control\" type=\"search\" name=\"NoOfQuestions\" value='"+rs.getString(2)+"'id=\"NoOfQuestions\">\n"+
				  "</div>\n"+
				"</div>\n"+
				"<div class=\"form-group row\">\n"+
				  "<label for=\"TestDuration\" class=\"col-2 col-form-label\">TestDuration</label>\n"+
				  "<div class=\"col-10\">\n"+
				    "<input class=\"form-control\" type=\"text\" value='"+rs.getString(3)+"' name=\"Duration\" id=\"Duration\">\n"+
				  "</div>\n"+
				"</div>\n"+

				"<div class=\"form-group row\">\n"+
				  "<label for=\"StartingDate\" class=\"col-2 col-form-label\">StartingDate</label>\n"+
				  "<div class=\"col-10\">\n"+
				    "<input class=\"form-control\" type=\"date\" value='"+rs.getString(4)+"'name=\"StartingDate\" id=\"StartingDate\">\n"+
				  "</div>\n"+
				"</div>\n"+
				  
				"<div class=\"form-group row\">\n"+
				  "<label for=\"EndingDate\" class=\"col-2 col-form-label\">EndingDate</label>\n"+
				  "<div class=\"col-10\">\n"+
				    "<input class=\"form-control\" type=\"date\"  value='"+rs.getString(5)+"'name=\"EndingDate\" id=\"EndingDate\">\n"+
				  "</div>\n"+
				"</div>\n"+
				"<div class=\"form-group row\">\n"+
				  "<label for=\"TestCode\" class=\"col-2 col-form-label\">TestCode</label>\n"+
				  "<div class=\"col-10\">\n"+
				    "<input class=\"form-control\" type=\"password\"value='"+rs.getString(6)+"' name=\"TestCode\" id=\"TestCode\">\n"+
				  "</div>\n"+
				"</div>\n"+
				"<div class=\"input-group\">\n"+
				   "<button type=\"submit\" class=\"btn btn-success\">Submit</button>\n"+
				 "</div>\n"+
				"</form>\n"+
				"</div>\n"+
				"</body>\n"+
				"</html>");

		}
			}
			catch(Exception e){
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
