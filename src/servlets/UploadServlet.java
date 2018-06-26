package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		System.out.println(ctx.getClass());
		System.out.println(ctx.getRealPath(""));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Part file = request.getPart("mobileFile");
		Scanner s = new Scanner(file.getInputStream());
		out.println("<ul>");
		while (true) {
			try {
				String line = s.nextLine();
				out.println("<li>" + line + "</li>");
				// process mobile number
			} catch (Exception ex) {
				break;
			}
		}
		out.println("</ul>");
	}

}
