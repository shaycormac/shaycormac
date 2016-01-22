package cn.fang.respond;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseImg
 */
@WebServlet("/ResponseImg")
public class ResponseImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=this.getServletContext().getMimeType("/download/haoxiangni.mp3");
		System.out.println(type);
		//response.setContentType(type);
		//response.setHeader("content-Disposition", "attachment;filename=haoxiangni.mp3");
		//System.out.println(type);
		String path = this.getServletContext().getRealPath("/download/haoxiangni.mp3");
		OutputStream out = response.getOutputStream();
		InputStream in = new FileInputStream(path);
		byte [] buffer = new byte[1024];
		int len = -1;
		while((len = in.read(buffer))!=-1){
			out.write(buffer, 0, len);
		}
		out.flush();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
