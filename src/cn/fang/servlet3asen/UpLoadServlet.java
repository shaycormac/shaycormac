package cn.fang.servlet3asen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpLoadServlet
 */
@WebServlet("/UpLoadServlet")
@MultipartConfig
public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理文件上传！！
		//获得普通域，不变
		String username =request.getParameter("username");
		System.out.println(username);
		
		//获得上传文件，不一样o
		Part part =request.getPart("myfile");
		//将这个文件保存在服务器的一个地方
		
		String path = request.getRealPath("/images");
		
		//简介的方法
		part.write("/images/xiaoxiao.jpg");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
