package cn.fang.servlet3asen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoadServlet
 * 异步处理，脏活，累活在新的线程中处理,异步支持asyncSupported=true
 */
@WebServlet(urlPatterns = { "/DownLoadServlet" }, asyncSupported = true)

public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("异步处理开始<br>");
		out.flush();
		System.out.println("异步处理开始");
		// 启动异步处理
		AsyncContext asyncContext = request.startAsync();
		asyncContext.start(new Runnable() {

			@Override
			public void run() {
				out.println("重活在这里做<br>");
				out.flush();
				System.out.println("重活在这里做");
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("被打断");
				}
				out.println("粗活在这里做<br>");
				out.flush();
				System.out.println("粗活在这里做");

			}
		});

		out.println("异步处理结束<br>");
		out.flush();
		System.out.println("异步处理结束");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
