package cc.sms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.sms.bean.Student;
import cc.sms.service.StudentService;
import cc.sms.service.impl.StudentServiceImpl;

public class DisplayOneStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayOneStuServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		StudentService service = new StudentServiceImpl();
		try {
			request.setAttribute("stu", service.findStuByID(sid));
			request.getRequestDispatcher("update.jsp").forward(request, response);
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
