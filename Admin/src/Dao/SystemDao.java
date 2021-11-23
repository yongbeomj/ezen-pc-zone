package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SystemDao {
	
	private Connection connection; // DB 연결 인터페이스 선언
	private PreparedStatement preparedStatement; // SQL 연결 인터페이스 선언
	private ResultSet resultSet; // 쿼리(검색결과) 연결 인터페이스 선언
	
	private static SystemDao systemDao = new SystemDao();
	
	public static SystemDao getSystemDao() {
		return systemDao;
	}
	
	public SystemDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimeZonse=UTC", "root",
					"1234");
		} catch (Exception e) {
			System.err.println(" *DB연동 실패 : " + e);
		}
	}


	
	public boolean repairupdate(int p_activation, int p_no) {
		String sql = "update pc set pc_activation=? where pc_no=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, p_activation);
			preparedStatement.setInt(2, p_no);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
	
		}
		return false;

	}
	
	
	
}
