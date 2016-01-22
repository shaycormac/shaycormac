package cn.fang.servletcontext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 利用servletcontext域统计网站的在线人数，
 * 重写初始化方法。在里面给配个初始值，只要服务器不重启，可以一直统记在线人数
 * 通过这个练习，体会域之间的数据通信，前提假设第一次访问的是本页面，其他都无所谓了
 * 有些框架都是通过全局配置，来得到初始化参数
 */
@WebServlet("/ServletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException 
	{
		// TODO Auto-generated method stub
		super.init();
		ServletContext sContext = this.getServletContext();
		//服务器一开启，就调用了这个方法，配置了初始化人数参数
		sContext.setAttribute("count", 0);
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//统计人数，只要有人来访问，就要加一，首先得到count，由于初始化已经配置好了，因此
		response.setContentType("text/html;charset=utf-8");
		int count =(int) this.getServletContext().getAttribute("count");
		++count;
		PrintWriter out = response.getWriter();
		out.write("当前在线的人数为:"+count);
		//再将人数存进域里留着其他资源来使用
		this.getServletContext().setAttribute("count", count);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
