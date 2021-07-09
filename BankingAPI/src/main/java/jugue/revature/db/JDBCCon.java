package jugue.revature.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCCon {
	
	public static Connection con=null;
	
	public static Connection getConnection() {
		
		if (con==null) {
			String endpoint ="juguedatabase.cxny2ll0igvi.us-east-2.rds.amazonaws.com";
			String url = "jdbc:postgresql://" + endpoint + "/postgres";
			String username = "jugue";
			String password = "Yorguedi1420*";
			
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return con;
		
	}
	public static void main(String[] args) {
		Connection conn1 = getConnection();
		Connection conn2 = getConnection();
		Connection conn3 = getConnection();
		
		System.out.println(conn1);
		System.out.println(conn2);
		System.out.println(conn3);

	}

}
