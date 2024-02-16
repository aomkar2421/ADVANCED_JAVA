package package1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String a = req.getParameter("uname");
		
		PrintWriter out = res.getWriter();
		out.println("<h1>Hello "+a+"</h1>");
		out.println("<a href='serv2'>Click here to go Servlet2</a>");
		
		Cookie c = new Cookie("username", a);
		res.addCookie(c);
	}
}
