package FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrive {
	public static void main(String[] args) throws SQLException, IOException {
		
		File file = new File("sample1.pdf");
		FileOutputStream fos = new FileOutputStream(file);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/large", "root","root");
		PreparedStatement ptst = connection.prepareStatement("select * from binaryData where id=1");
		
		ResultSet rs = ptst.executeQuery();
		
		Blob blob;
		byte b [] = null;
		while (rs.next()) {
			blob = rs.getBlob(2);
			b = blob.getBytes(1, (int) blob.length());
		}
		
		fos.write(b);
		
		System.out.println("Operation Completed");
	}
}
