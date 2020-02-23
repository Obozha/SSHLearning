package cc.sms.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.sms.bean.Student;
import cc.sms.service.impl.StudentServiceImpl;

public class UpdateStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateStuServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String hobbyList = Arrays.toString(request.getParameterValues("hobby"));

		Student stu=null;
		try {
			stu=new Student(
					Integer.parseInt(request.getParameter("sid")),
					request.getParameter("sname"),
					request.getParameter("gender"), 
					request.getParameter("phone"), 
					new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")), 
					hobbyList.substring(1, hobbyList.length() - 1),
					request.getParameter("info"));
			System.out.println(stu.toString());
			
			request.setAttribute("status", new StudentServiceImpl().updateStuByID(stu));
			request.getRequestDispatcher("DisplayAllListServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
