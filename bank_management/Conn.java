package bank_management;

import java.sql.*;

public class Conn {

	Connection c;
	Statement s;
	public Conn() {
		try {
			//Class.forName(com.mysql.cj.jdbc.Driver);
			c = DriverManager.getConnection("jdbc:mysql://localhost/sepbank","root","");
			s = c.createStatement();
			
			//ResultSet rs = s.executeQuery("select * MAX(")
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
