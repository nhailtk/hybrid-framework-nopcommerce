package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerJTDSConnUtils {
	public static Connection getSQLServerConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "automationfc";
		String userName = "sa";
		String password = "abc123";

		return getSQLServerConnection(hostName, sqlInstanceName, database, userName, password);
	}

	public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String database, String userName, String password) {
		Connection conn = null;
		try {
			// Khai bao class Driver cho MySQL
			// Viec nay can thiet voi Java 5
			// Java 6 tu dong tim kiem Driver thich hop nen khong can dong code nay
			// Class.forName("net.sourceforge.jtds.jdbc.Driver");

			// Cau truc URL Connection danh cho MySQL
			// Vi du: jdbc:jtds:sqlserver://localhost:1433/automationfc;instance=SQLEXPRESS
			String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + database + ";instance=" + sqlInstanceName;
			conn = DriverManager.getConnection(connectionURL, userName, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
