import java.sql.*;


public class Visualisierung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
		
		DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
		Connection my_con = DriverManager.getConnection("jdbc:oracle:thin:@dbl48.beuthhochschule.de:1521:oracle", "s898676", "GUW7yfaoK");
		
		Statement my_stmt = my_con.createStatement();
		
		String query = "SELECT Table_Name FROM all_tables";
		
		ResultSet my_result = my_stmt.executeQuery(query);
		
		my_result.next();
		int nr = my_result.getInt(1);
		String kd_name = my_result.getString("Table_Name");

		System.out.println(kd_name);
	
		
		
		my_con.close();
		
		}
		
		catch(Exception e) {
			
			System.out.println("didn´t work");
		}
		
	

	}

}
