package cn.fang.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RefereDemo
 */
@WebServlet("/RefereDemo")
public class RefereDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//防盗链，利用request的请求头里面的信息
		String referer =request.getHeader("referer");
		//进行判断,如果是从本网站进去的，就是本机，不是本网站的，统统让他们进首页，首页里面再指向这个页面，完成防盗链。
		if (referer == null || !referer.startsWith("http://localhost")) 
		{
			response.sendRedirect("/shaycormac/index.jsp");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/jsp/fuck.jsp").forward(request, response);
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
