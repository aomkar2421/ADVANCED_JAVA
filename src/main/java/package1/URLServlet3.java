package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet3")
public class URLServlet3 extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String sname = req.getParameter("stdname");
		String sid = req.getParameter("sid");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registermodule","root","root");
			PreparedStatement ptst = con.prepareStatement("insert into school values (?,?)");
			
			ptst.setString(1, sid);
			ptst.setString(2, sname);
			ptst.execute();
			//out.println("Data Inserted Succesfully");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			out.print(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println("<a href='servlet4?id="+sid+"'>Go To Servlet 4</a>");
		
	}
}
