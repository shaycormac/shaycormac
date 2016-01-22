package cn.fang.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * Servlet implementation class DisPlayServlet
 * 这是商品详细页面，客户点击超链接进入这个页面，同时带来了后面的id参数，取出来，一个是显示这个id的详情，同时，把id
 * 回写到cookie里面，这是难点
 */
@WebServlet("/DisPlayServlet")
public class DisPlayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//第一步，设置回写编码，不能少
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//从请求中得到参数id的值
		String id= request.getParameter("id");
		//从数据库中调出关于这个id的一切，写在这个页面上
		PrintWriter out=response.getWriter();
		out.print("本书的详情为：<br/>");
		Map<String, Product> map = DB.getAllProducts();
		Product product =map.get(id);
		out.print("书的序号为："+id+"</br>");
		out.print("书的名字为："+product.getName()+"</br>");
		out.print("书的作者为："+product.getAuthor()+"</br>");
		out.print("书的价格为：<font color='red'>"+product.getPrice()+"元</font></br>");
		out.print("<b>作者生平简介：这是一个好娃娃！</b>");
		
		//把得到的这个id写到cookie中去，同时别忘记了设置cookie的时间
		//用一个方法返回这个字符串,id写进这个方法，request得到cookie
		String history = getHistory (product.getId(),request);
		//得到这个字符串，再写进cookie就可以了
		Cookie cookie = new Cookie("history", history);
        cookie.setMaxAge(1*24*3600);
        response.addCookie(cookie);
	}

	/**
	 * @param id
	 * @param request
	 * @return
	 */
	private String getHistory(String id, HttpServletRequest request) 
	{
		// 既然作为标记history里面的值，无非就是下面四种情况，相当于把id写进这个cookie,
		//需要注意的是，每次点击它的时候，最后一次点击的需要放在首位，同时删除原来的位置
		//逻辑要清楚，借助数组与集合的转换去做
		//记住cookie,和上面类似
		String history = null;
		Cookie [] cookies =request.getCookies();
		for (int i = 0;cookies !=null && i < cookies.length; i++)
		{
			if (cookies[i].getName().equals("history"))
			{
				history = cookies[i].getValue();
			}
		}
		//1.客户第一次进，history为空，直接加入id即可
		if (history == null)
		{
		  history=id;	
		  return history;
		}
		
			String [] ids =history.split("\\_");
			//变成集合很重要
			LinkedList<String> list = new LinkedList<>(Arrays.asList(ids));
			
			//里面有值了，假如我们设最多出现4个，那么无非下面三种情况
			//2.有值，但是没有你点击的那个值，首先值未满，直接添加进去
		  if(list.contains(id))
		  {
			 list.remove(id); 
		  }else
		  {
			  if (list.size()>=4)
			  {
				list.removeLast();
			}
		  
		  }
		  
			list.addFirst(id);
			//list变成字符串
			StringBuffer sBuffer =new StringBuffer();
			for (String string : list) 
			{
				sBuffer.append(string+"_");
			}
			return sBuffer.deleteCharAt(sBuffer.length()-1).toString();
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
