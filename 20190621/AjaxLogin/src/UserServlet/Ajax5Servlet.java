package UserServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ajax5Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 返回的是json数据
		PrintWriter out = response.getWriter();
		int id = 1;
		String name = "洗衣机";
		int price = 1800;
		out.print("[{'id':'" + id + "','name':'" + name + "','price':'" + price
				+ "'},{'id':'2','name':'电视机','price':'3800'}]"); // 这返回的就是json数据
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
