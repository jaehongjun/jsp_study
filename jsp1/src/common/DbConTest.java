package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConTest {

	public static void main(String[] args) {
		Connection con;
		String url = "jdbc:mysql://localhost:3306/jsp_study";
		String id = "root";
		String pwd = "1234";
		Statement st;
		try {
			Class.forName("org.mariadb.jdbc.Driver"); // 리플렉션? 드라이버,인터페이스를 사용하기위해 사용
			con = DriverManager.getConnection(url, id, pwd); //DB커넥트
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
			// TODO: handle exception
		}
		
		

	}
}
