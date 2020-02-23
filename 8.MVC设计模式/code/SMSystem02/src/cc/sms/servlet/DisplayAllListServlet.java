package cc.sms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.sms.bean.Student;
import cc.sms.service.StudentService;
import cc.sms.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class DisplayAllListServlet
 */
public class DisplayAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayAllListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentService service = new StudentServiceImpl();
		try {
			List<Student> list = service.findAllStu();
			request.setAttribute("list", list);
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
