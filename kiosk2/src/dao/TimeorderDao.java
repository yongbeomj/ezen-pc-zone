package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TimeorderDao {

	private Connection connection ; 
	private PreparedStatement preparedStatement; 
	private ResultSet resultSet; 
	
	private static TimeorderDao timeorderDao = new TimeorderDao();
	
	public static TimeorderDao getTimeorderDao() { return timeorderDao; }
	
	public TimeorderDao() {
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
	
	
	// 타임오더
	public void timeorder(int price, int m_no ) {
		String sql = "insert into timeorder(to_price ,m_no ) value(?,?)";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, price);
			preparedStatement.setInt(2, m_no);
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}






























