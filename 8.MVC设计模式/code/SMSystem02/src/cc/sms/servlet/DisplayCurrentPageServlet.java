package cc.sms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.sms.dao.Page;
import cc.sms.service.impl.StudentServiceImpl;

public class DisplayCurrentPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayCurrentPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			Page page = new StudentServiceImpl().findStuByCurrentPage(currentPage);

			request.setAttribute("page", page);
			request.getRequestDispatcher("dividePageSearch.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
