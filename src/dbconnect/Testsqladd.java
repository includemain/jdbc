package dbconnect;

import java.sql.*;
import java.util.ArrayList;

import vo.Record;

public class Testsqladd {
	public static ArrayList<Record> query(String id,String cname){
		ArrayList<Record> records = new ArrayList<Record>();
		Connection conn = DatabaseConnect.getConnection();
		String sql = "insert into mrzhu values(?,?)";
		
		
		
		PreparedStatement pstmt;
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, cname);
			pstmt.executeUpdate();//执行sql语句
			conn.close();//关闭数据库连接对象
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return records;
	}

}
