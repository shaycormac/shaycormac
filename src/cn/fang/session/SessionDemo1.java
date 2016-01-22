package cn.fang.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo1
 */
@WebServlet("/SessionDemo1")
public class SessionDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//默认情况下，服务器为每一次会话创建唯一的id，作用域在本次会话中，
		String date ="date";
		HttpSession session=request.getSession();
		session.setAttribute("date", date);
		response.getWriter().write("ok");
		//修改一下，变成多个会话都使用同一个session，需要修改cookie里面的这个id的值。
		/*String date ="date";
		HttpSession session=request.getSession();//这一步其实做了很多工作，第一次新建一个session,以后在近来的时候首先session去cooike中找id，找不到，去超链接找。
		session.setAttribute("date", date);
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		//设置多个会话窗口的缓存时间和作用域
		cookie.setMaxAge(1*30*60);//最多30分钟，默认10分钟写到硬盘中，要是有自定义的对象，必须要实现序列化接口，才能写道硬盘中
		cookie.setPath("/shaycormac");
		//最后添加到respond中
		response.addCookie(cookie);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
