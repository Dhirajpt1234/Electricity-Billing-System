package electricity.billing.system;

import java.sql.*;

public class Connect {
	Connection conn;
	Statement statement;

	Connect() {
		// TODO Auto-generated constructor stub
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "DHIRAJpt");
			statement = conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
