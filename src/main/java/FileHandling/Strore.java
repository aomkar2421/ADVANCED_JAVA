package FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Strore {
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/large", "root","root");
		PreparedStatement ptst = connection.prepareStatement("insert into binaryData (name, d) values (?,?)");
		
		File file = new File("sampleimage.jpg");
		FileInputStream fis = new FileInputStream(file);
		
		ptst.setString(1, file.getName());
		ptst.setBinaryStream(2, fis, file.length());
		ptst.execute();
		
		System.out.println("Operation Completed");
	}
}
