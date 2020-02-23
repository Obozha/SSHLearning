package cc.sms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.sms.bean.Student;
import cc.sms.service.impl.StudentServiceImpl;

public class AddStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddStuServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String hobbyList = Arrays.toString(request.getParameterValues("hobby"));
		try {
			Student stu = new Student(request.getParameter("sname"), request.getParameter("gender"),
					request.getParameter("phone"),
					new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday")),
					hobbyList.substring(1, hobbyList.length() - 1), request.getParameter("info"));

			request.setAttribute("status", new StudentServiceImpl().insertStu(stu));
			request.getRequestDispatcher("DisplayAllListServlet").forward(request, response);
		} catch (ParseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
