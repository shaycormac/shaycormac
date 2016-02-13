package cn.fang.downfile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownFileServlet
 */
@WebServlet(name="myServlet",urlPatterns={"/DownFileServlet","/aha"},loadOnStartup=1,
initParams={@WebInitParam(name="tom",value="123"),@WebInitParam(name="lili",value="456")})


public class DownFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path =this.getServletContext().getRealPath("images/江爷爷告诉你怎么做人！！.jpg");
		int pos = path.lastIndexOf("\\");
		String filename = path.substring(pos+1);
		String uEncoder = URLEncoder.encode(filename,"utf-8");
		System.out.println(uEncoder);
		response.setContentType("application/x-download");
		response.setHeader("Content-Disposition", "attachment;filename="+uEncoder);
		URL url=this.getServletContext().getResource("images/江爷爷告诉你怎么做人！！.jpg");
		InputStream in = url.openStream();
		OutputStream out=response.getOutputStream();
		int len =0;
		byte buff [] = new byte [1024];
		while((len=in.read(buff))!=-1)
		{
			out.write(buff, 0, len);
			out.flush();
		}
		out.close();
		in.close();
		
		//获得初始化参数
		ServletConfig sConfig=this.getServletConfig();
		String username=sConfig.getInitParameter("tom");
		System.out.println(username);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
