package cn.fang.servletconfig;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigDemo1
 */
@WebServlet("/ServletConfigDemo1")
public class ServletConfigDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serverName = this.getServletConfig().getServletName();
		System.out.println("server名称"+serverName);
		System.out.println("info"+this.getServletInfo());
		Enumeration<String> en=this.getServletConfig().getInitParameterNames();
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			String value = this.getServletConfig().getInitParameter(name);
			System.out.println("初始化参数"+name+"--"+value);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
