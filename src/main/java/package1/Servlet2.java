package package1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String string = req.getParameter("uname");
		PrintWriter out = res.getWriter();
		out.println("<h1>omkar</h1>");
		

		Cookie [] c1 = req.getCookies();
		String nameString = null;
		boolean f = false;
		
		if (c1.equals(null)) {
			out.println("You are new user");
		}
		else {
			for (Cookie c2 : c1) {
				String a = c2.getName();
				if (a.equals("username")) {
					nameString = c2.getValue();
					f = true;
				}
			}
		}
		if (f) {
			out.println("Welcome back "+nameString);
		}
	}
}
