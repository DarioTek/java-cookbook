package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBCMySQL {

	public static void main(String[] args) {
		System.out.println("Start TestJDBC");
		// Connects to MySQL running on Windows 7 VBox guest OS
		String jdbcURL = "jdbc:mysql://localhost/hb_student_tracker?useSSL=false"; // ?useSSL=false -> Get rid of mysql SSL warning
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL, user, password);
			
			System.out.println("Successfully connected TestJDBC");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
