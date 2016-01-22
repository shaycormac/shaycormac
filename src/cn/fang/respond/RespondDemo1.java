package cn.fang.respond;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RespondDemo1
 */
@WebServlet("/RespondDemo1")
public class RespondDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//禁止浏览器缓存，因为浏览器只要有缓存了，就不会再次发请求
		//没设定前
		response.getWriter().write("当前的时间是"+new Date().toLocaleString());
		System.out.println("哈哈，我执行了");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
