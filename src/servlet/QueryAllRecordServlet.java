package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnect.Testsql;
import dbconnect.Testsql2;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import vo.*;
@WebServlet("/QueryAllRecordServlet")
public class QueryAllRecordServlet extends HttpServlet {
       
	private static final long serialVersionUID = 4359947118922880126L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		ArrayList<Record> records = null;
/*******************************************************************/
		if(id.length() == 0) {
			records = (ArrayList<Record>) Testsql2.query();	
		}else {
			records = (ArrayList<Record>) Testsql.query(id);	
		}
/****************************************************************/
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("records", records);
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(jsonObject);
		
		System.out.println(jsonArray);

		OutputStream outputStream = response.getOutputStream();
		outputStream.write(jsonArray.toString().getBytes("UTF-8"));
//		response.setContentType("text/html;chatset=UTF-8");
		outputStream.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
