package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnector {

	public static Connection con;

	public static Connection getCon() throws ClassNotFoundException, SQLException {

		if (con == null) {
			String url = "jdbc:mysql://localhost:3306/jsp_study";
			String id = "root";
			String pwd = "1234";
			Class.forName("org.mariadb.jdbc.Driver"); // 리플렉션? 드라이버,인터페이스를 사용하기위해 사용
			con = DriverManager.getConnection(url, id, pwd); // DB커넥트
		}

		return con;

	}

	public static void closeCon() throws SQLException {
		if (con == null) {
			con.close();
			con = null;
		}
	}
}
