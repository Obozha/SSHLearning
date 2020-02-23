package cc.sms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cc.sms.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class DeleteStuServlet
 */
public class DeleteStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteStuServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("sid");
		try {
			request.setAttribute("status", new StudentServiceImpl().deleteStuByID(Integer.parseInt(sid)));
			request.getRequestDispatcher("DisplayAllListServlet").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
