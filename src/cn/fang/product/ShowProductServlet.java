package cn.fang.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowProductServlet
 * 商品首页，展示商品的名称，点击超链接，进入商品的详细页面
 */
@WebServlet("/ShowProductServlet")
public class ShowProductServlet extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//第一步，设置字体，设计中文乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//打开首页，展示所有的书籍
		PrintWriter out=response.getWriter();
		out.print("欢迎您，请点击想要查看的图书，进入详情观看更多：<br/>");
		Map<String, Product> map = DB.getAllProducts();
		for (Map.Entry<String, Product> entry : map.entrySet()) 
		{
			Product product = entry.getValue();
			//关键点，超链接后面带上书的id
			out.print("<a href='/shaycormac/DisPlayServlet?id="+product.getId()+"' target='_blank'>"+product.getName()+"</a><br/>");
			
		}
		//曾经看过的书籍
		out.print("您曾经浏览过的图书为：<br/>");
		//第一没有数据，以后都有了，定义cookie里面的数据的key为history，从这个数组中查找这个值，由于是字符串，让它变成数组，根据id将值体现出来
		Cookie [] cookies =request.getCookies();
		Cookie cookie = null;//用来接收找到的history。
		//遍历数组，数组不能为空
		for (int i = 0;cookies!=null && i < cookies.length; i++)
		{
			if (cookies[i].getName().equals("history"))
			{
				//找到了！！
				cookie = cookies[i];
			}
		}
		//假设找到了的话，进行操作，先判断
		if (cookie !=null)
		{
			//字符数组 1_3_6_5
			String value = cookie.getValue();
			//转换成数组,匹配正则表达式，双反斜杠，一个表示转译，一个表示在字符串里需要加上、\
			String ids[] = value.split("\\_");
			//遍历数组，得到相应的id，展示出来
			for (String id : ids) 
			{
				Product product = map.get(id);
				out.print(product.getName()+"</br>");
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


//需要通过数据库来展示所有的商品，并放到jsp中，先模拟一下吧，，假如商品存在静态的map集合中，首先要有对象
class DB
{
	private static Map<String, Product> map = new HashMap<>();
	
	static
	{
		map.put("1", new Product("1", "小炳华", "Java基础", 33.5));
		map.put("2", new Product("2", "小沫华", "Html", 80.56));
		map.put("3", new Product("3", "大柳卉", "Css", 72.3));
		map.put("4", new Product("4", "大方方", "Servlet", 30));
		map.put("5", new Product("5", "中爸爸", "jQuery", 58.23));
		map.put("6", new Product("6", "中妈妈", "JavaScript", 66.5));
	}
	
	public static Map<String, Product> getAllProducts ()
	{
		return map;
	}
	

}
//商品有四个属性把，序号，书名，作者，价格，暂定double，需要转换成bigdecimal实际上，暂不考虑
class Product
{
	private String id;
	private String author;
	private String name;
	private double price;
	
	public Product(String id, String author, String name, double price) {
		super();
		this.id = id;
		this.author = author;
		this.name = name;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
