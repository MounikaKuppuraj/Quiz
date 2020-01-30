
package org;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Question
 */
@WebServlet("/ques")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question() {
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
			String question = request.getParameter("Question");
			String option1 = request.getParameter("Option1");
			String option2 = request.getParameter("Option2");
			String option3 = request.getParameter("Option3");
			String option4 = request.getParameter("Option4");
			String crctopt = request.getParameter("optradio");
			String TestName=request.getParameter("TestName");
			String correct=null;
			if(crctopt.equals("Option1")){
				correct="Option1";
			}
			else if(crctopt.equals("Option2")){
				correct="Option2";

			}
			else if(crctopt.equals("Option3")){
				correct="Option3";

			}
			else if(crctopt.equals("Option4")){
				correct="Option4";

			}
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");
				Statement stmt =   conn.createStatement();
				stmt.executeUpdate("insert into question values('"+question+"','"+option1+"','"+option2+"','"+option3+"','"+option4+"','"+correct+"','"+TestName+"')");
				stmt.close();
				conn.close();
			} catch(Exception e){
				System.out.println(e);
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
