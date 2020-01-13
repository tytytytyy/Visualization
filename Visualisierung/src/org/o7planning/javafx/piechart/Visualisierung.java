import java.sql.*;

public class Visualisierung {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection my_con = DriverManager.getConnection("jdbc:oracle:thin:@dbl43.beuth-hochschule.de:1521:rispdb1", "s898676", "student");

			Statement my_stmt = my_con.createStatement();

			String query = "SELECT * FROM all_tables";

			ResultSet my_result = my_stmt.executeQuery(query);

			while (my_result.next()) {
				String nr = my_result.getString(1);
				String kd_name = my_result.getString("table_name");

				System.out.println(kd_name);
				System.out.println(nr);



			}
			
			my_con.close();

		}

		catch (SQLException ex) {

			System.out.println("didnt work"+ ex.getMessage());
			System.out.println(ex.getMessage());
			System.out.println(ex.getMessage());

		}

	}

}
