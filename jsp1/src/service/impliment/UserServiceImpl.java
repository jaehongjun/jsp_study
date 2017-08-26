package service.impliment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import common.DbConnector;
import service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public String insertUser(Map hm) {
		// TODO Auto-generated method stub
		
		String result = hm.get("name")+"님 회원가입 실패!";
		Connection con;
		try {
			con = DbConnector.getCon();
			String 	sql = "insert into user(id,password,name,hobby)";
					sql += "values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, (String) hm.get("id"));
			ps.setString(2, (String) hm.get("pwd"));
			ps.setString(3, (String) hm.get("name"));
			ps.setString(4, (String) hm.get("hobby"));
			int row = ps.executeUpdate();
			if(row==1) {
				result = "회원가입 성공!";
			}
			//con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}

}
