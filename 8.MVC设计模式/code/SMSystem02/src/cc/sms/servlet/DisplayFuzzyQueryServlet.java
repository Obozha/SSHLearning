package cc.sms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.sms.service.impl.StudentServiceImpl;

public class DisplayFuzzyQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayFuzzyQueryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("utf-8");
			request.setAttribute("list", new StudentServiceImpl().findPartStuByFuzzy(request.getParameter("sname"),
					request.getParameter("gender")));
			request.getRequestDispatcher("list_all.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
