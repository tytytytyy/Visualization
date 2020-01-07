import java.sql.*;

public class Visualisierung {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection my_con = DriverManager.getConnection("jdbc:oracle:thin:@dbl48.beuthhochschule.de:1521:oracle", "s80408", "GUW7yfaoK");
		
		Statement my_stmt = my_con.createStatement();
		
		String query = "select kdnr,firma from kdst";
		
		ResultSet my_result=my_stmt.executeQuery(query);
		
		while(my_result.next()) {
			int nr = my_result.getInt(1);
			String kd_name = my_result.getString("firma"); }
		
		my_con.close();
		
		}
		catch(Exception e) {
			
			
		}
		
	

	}

}
