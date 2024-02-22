package RegistrationModule;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.File;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
public class Register extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		out.println("omkar");

		String name = req.getParameter("uname");
		String pass = req.getParameter("upass");
		String mail = req.getParameter("umail");
		Part part = req.getPart("imgfile");
		
		String fname = part.getSubmittedFileName();
		out.println(fname);


		try {
			Thread.sleep(3000);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/RegisterModule", "root", "root");
			PreparedStatement ptst = con.prepareStatement("insert into register (name, password, email, filename) values (?,?,?,?)" );
			ptst.setString(1, name);
			ptst.setString(2, pass);
			ptst.setString(3, mail);
			ptst.setString(4, fname);
			ptst.execute();


			InputStream is = part.getInputStream();
			byte [] data = new byte [is.available()];

			is.read(data);
			String path = "D:\\Utilities\\Files\\"+fname;
//			String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "image" + File.separator + fname;

			out.println(path);

			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();

			out.println("Done");


		} catch (Exception e) {
			out.println(e);
			out.println("Error Ocurred");
		}
	}
}
