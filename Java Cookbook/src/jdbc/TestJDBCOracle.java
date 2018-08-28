package jdbc;
import java.sql.*; 

public class TestJDBCOracle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// paste the ojdbc14.jar file in jre/lib/ext folder for this program to work

		System.out.println("start");
		
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object
			// THis is based on the Oracle instance running on my Virtual Box
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@192.168.56.104:1521:orcl","hr","oracle");  
			
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select * from employees");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			  
			//step5 close the connection object  
			con.close();  
			  
			}catch(Exception e){ 
				System.out.println(e);
			}  
			  
		System.out.println("finish");
	}

}
