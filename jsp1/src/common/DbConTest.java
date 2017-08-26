package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConTest {

	public static void main(String[] args) {
		Connection con;
		Statement st;
		try {
			con = DbConnector.getCon();
			System.out.println("연결 성공");
			st = con.createStatement(); //쿼리실행전
			ResultSet rs = st.executeQuery("select * from user");
			while(rs.next()) {
				System.out.print(rs.getString("user_no"));
				System.out.print(rs.getString("id"));
				System.out.print(rs.getString("password"));
				System.out.println(rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		

	}
}
