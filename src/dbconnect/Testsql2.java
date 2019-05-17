package dbconnect;

import java.sql.*;
import java.util.ArrayList;

import vo.Record;

public class Testsql2 {
	public static ArrayList<Record> query(){
		ArrayList<Record> records = new ArrayList<Record>();
		Connection conn = DatabaseConnect.getConnection();
		String sql = "select * from mrzhu";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			
	        ResultSet rs = pstmt.executeQuery();
	        while(rs.next()){
	        	Record record2 = new Record(
	        			rs.getString(1),
	    				rs.getString(2)
	        		);
				records.add(record2);

	        }
	        DbClose.close(rs, pstmt, conn);
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
