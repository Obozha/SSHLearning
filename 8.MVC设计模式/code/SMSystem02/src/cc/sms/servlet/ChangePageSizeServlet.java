package cc.sms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.sms.dao.StudentDao;
import cc.sms.params.Params;

/**
 * Servlet implementation class ChangePageSizeServlet
 */
public class ChangePageSizeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePageSizeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageSizeString = request.getParameter("pageSize");
		if (!pageSizeString.equals("")) {
			int pageSize = Integer.parseInt(pageSizeString);
			Params.pageSize = pageSize;
		}
		request.getRequestDispatcher("DisplayCurrentPageServlet?currentPage=1").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
