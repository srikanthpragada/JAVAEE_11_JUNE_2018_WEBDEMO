package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/names")
public class NamesServlet extends HttpServlet {
	ArrayList<String> names = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null)
			names.add(name);

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		pw.println("<h2>Names</h2>");
		for (String n : names) {
			pw.println(n + "<p/>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void init() {
		System.out.println("init()");
	}

	public void destroy() {
		System.out.println("destroy()");
	}

}
