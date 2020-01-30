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
 * Servlet implementation class EditQuestion
 */
@WebServlet("/EditQues")
public class EditQues extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditQues() {
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
			"<a href=\"ViewQuestion\" class=\"btn btn-primary btn-success\"><span class=\"glyphicon glyphicon-th-list\"></span> View</a>\n"+
			"<a href=\"editquestion.html\" class=\"btn btn-primary btn-success\"><span class=\"glyphicon glyphicon-pencil\"></span> Edit </a>\n"+
			"<a href=\"deletequestion.html\" class=\"btn btn-primary btn-success\"><span class=\"glyphicon glyphicon-trash\"></span> Delete</a>\n"+
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
				String Question=request.getParameter("Question");
				ResultSet rs = stmt.executeQuery("select * from question where testname = '"+name+"' and Question ='"+Question+"'");
			
				if(rs.next()){
					
				out.println("<!DOCTYPE html>\n");
				out.println("<html>\n");
				out.println("<head>\n");
				out.println("<meta charset='ISO-8859-1'>"+

				"<title>Student - Update</title>"+
				"<link rel=\"stylesheet\" href=\"css/bootstrap.css\"/>"+
				"</head>"+
				"<body>"+
				"<form action=\"EditQues2\" method=\"post\">"+
				"<div style='width :512px;margin:0px 0 0 320px;'>"+

				"<div class=\"form-group\">"+
				"<br>"+
				"<br>"+
				"<div class=\"form-group\">"+
				  "<label for=\"TestName\" class=\"col-2 col-form-label\">TestName</label>"+
				  "<div class=\"col-10\">"+
				    "<input class=\"form-control\" type=\"text\" readonly=\"readonly\" name=\"TestName\" value='"+rs.getString(7)+"' id=\"TestName\">"+
				  "</div>"+
				"</div>"+

				  "<label for=\"Question\">Question</label>"+
				  "<textarea class=\"form-control\" rows=\"5\" id=\"Question\"  readonly=\"readonly\" name=\"Question\">"+Question+"</textarea>"+
				"</div>"+
				"<label for=\"options\">Answers</label>"+
				"<div class=\"options\">"+
				 "<div class = \"input-group\">"+
				         "<span class = \"input-group-addon\">Option 1</span>"+
				         "<input type = \"text\" class = \"form-control\" id=\"Option1\" value='"+rs.getString(2)+"'name=\"Option1\">"+
				      "</div>"+
				      "<br>"+
				      "<div class = \"input-group\">"+
				         "<span class = \"input-group-addon\">Option 2</span>"+
				         "<input type = \"text\" class = \"form-control\" id=\"Option2\" value='"+rs.getString(3)+"'name=\"Option2\">"+
				      "</div>"+
				"<br>"+
				      "<div class = \"input-group\">"+
				         "<span class = \"input-group-addon\">Option 3</span>"+
				         "<input type = \"text\" class = \"form-control\" id=\"Option3\"value='"+rs.getString(4)+"' name=\"Option3\">"+
				      "</div>"+
				      "<br>"+
				      "<div class = \"input-group\">"+
				         "<span class = \"input-group-addon\">Option 4</span>"+
				         "<input type = \"text\" class = \"form-control\" id=\"Option4\" value='"+rs.getString(5)+"'name=\"Option4\">"+
				      "</div>"+
				      "</div>"+
				      "<br>");
				      if(rs.getString(6).equalsIgnoreCase("Option1")){
				out.println("<label for=\"radioCorrect\">Correct Answer</label>"+
				"<div class=\"radioCorrect\">"+
				
				"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" checked=\"checked\"value=\"Option1\">Option 1</label>"+
				"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option2\">Option 2</label>"+
				"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option3\">Option 3</label>"+
				"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option4\">Option 4</label>"+
				"</div>");
				      }
				      if(rs.getString(6).equalsIgnoreCase("Option2")){
							out.println("<label for=\"radioCorrect\">Correct Answer</label>"+
							"<div class=\"radioCorrect\">"+
							
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option1\">Option 1</label>"+
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" checked=\"checked\"value=\"Option2\">Option 2</label>"+
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option3\">Option 3</label>"+
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option4\">Option 4</label>"+
							"</div>");
							      }
				      if(rs.getString(6).equalsIgnoreCase("Option3")){
							out.println("<label for=\"radioCorrect\">Correct Answer</label>"+
							"<div class=\"radioCorrect\">"+
							
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option1\">Option 1</label>"+
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option2\">Option 2</label>"+
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" checked=\"checked\"value=\"Option3\">Option 3</label>"+
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option4\">Option 4</label>"+
							"</div>");
							      }
				      if(rs.getString(6).equalsIgnoreCase("Option4")){
							out.println("<label for=\"radioCorrect\">Correct Answer</label>"+
							"<div class=\"radioCorrect\">"+
							
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option1\">Option 1</label>"+
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option2\">Option 2</label>"+
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\" value=\"Option3\">Option 3</label>"+
							"<label class=\"radio-inline\"><input type=\"radio\" name=\"optradio\"checked=\"checked\" value=\"Option4\">Option 4</label>"+
							"</div>");
							      }
				out.println("<br>"+
				"<div  class=\"input-group\">"+

				   "<button type=\"submit\" class=\"btn btn-success\">Submit</button>"+
				"&nbsp;"+
				   "<a href=\"managequestion.html\" class=\"btn btn-primary btn-success\"><span class=\"glyphicon glyphicon-circle-arrow-right\"></span> Next</a>"+
				   "</div>"+
				"</div>"+
				"</form>"+
				"</body>"+
				"</html>");
			}
			}catch(Exception e)
			{
				out.print(e);
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