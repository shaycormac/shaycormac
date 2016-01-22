package cn.fang.refresh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RefreshDemo1
 */
@WebServlet("/RefreshDemo1")
public class RefreshDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//重定向的几种方法
		//1.
		//response.sendRedirect("https://www.baidu.com");
		//2.设置响应码和响应头
		response.setStatus(302);//这样不好
		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		response.setHeader("location", "https://www.baidu.com");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
