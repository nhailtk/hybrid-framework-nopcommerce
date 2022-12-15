package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerJTDSTestConnection {
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		return SQLServerJTDSConnUtils.getSQLServerConnection();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection...");

		// Lay ra doi tuong Connection ket noi DB
		Connection conn = SQLServerJTDSTestConnection.getMyConnection();
		System.out.println("Opened connection:" + conn);

		Statement statement = conn.createStatement();

		String sql = "SELECT * FROM [automationfc].[dbo].[Product_Type];";

		// Thuc thi cau lenh SQL tra ve doi tuong ResultSet
		ResultSet rs = statement.executeQuery(sql);

		// Duyet ket qua tra ve
		while (rs.next()) {
			// di chuyen con tro toi ban ghi ke tiep
			String empFistName = rs.getString(1);
			String empLastName = rs.getString("NAME");

			System.out.println("================");
			System.out.println("Emp Fistname: " + empFistName);
			System.out.println("Emp Lastname: " + empLastName);

		}
		// Dong ket noi
		conn.close();
		System.out.println("==========Closed connection========");

	}

}
