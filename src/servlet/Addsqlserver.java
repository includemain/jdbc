package servlet;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dbconnect.Testsqladd;

@WebServlet("/Addsqlserver")
public class Addsqlserver extends HttpServlet {
       
	private static final long serialVersionUID = 4359947118922880126L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.println(id);
		System.out.println(name);
		

		Testsqladd.query(id,name);
		OutputStream outputStream = response.getOutputStream();
		outputStream.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
