package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TimeDao {

	private Connection connection ; 
	private PreparedStatement preparedStatement; 
	private ResultSet resultSet; 
	
	private static TimeDao timeDao = new TimeDao();
	
	public static TimeDao gettimDao() {return timeDao;}
	
	public TimeDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/ezenpczone?serverTimezone=UTC" , 
					"root" , "1234");
		}
		catch (Exception e) {
			System.out.println(" * DB 연동 실패 : " + e);
		}
	}
	
	// 시간 db 생성
	public void timeinsert(int m_no) {
		String sql = "insert into time(t_usetime, t_remaintime, m_no) value(?,?,?)";
		try {
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, 0);
			preparedStatement.setInt(3, m_no);
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			System.out.println("db연동 실패");
		}
		
	}

	// 시간 충전
	public boolean timeupdate (int m_no ,int add_time ,int time_remaintime) {
		String sql ="update time set t_remaintime=? where m_no=?";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, time_remaintime+add_time);
			preparedStatement.setInt(2, m_no);
			preparedStatement.executeUpdate();
			return true ;
		}catch (Exception e) {
			return false;
		}
	}
	//남은 시간 구하는 메소드
	public int time_remaintime(int m_no) {
		String sql ="select t_remaintime from time where m_no =?";
				try {
					preparedStatement=connection.prepareStatement(sql);
					preparedStatement.setInt(1, m_no);
					resultSet=preparedStatement.executeQuery();
					if(resultSet.next()) {
						return resultSet.getInt(1);
					}else {
						return 0;
					}
				}catch (Exception e) {
					return 0;
				}
	}
	
	
}

















