package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TimeDao {

	// 필드
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	// 생성자
	public TimeDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimezone=UTC",
					"root", "1234");
		} catch (Exception e) {
		}
	}

	// 메소드
	// 객체 생성
	public static TimeDao timeDao = new TimeDao();

	public static TimeDao getTimeDao() {
		return timeDao;
	}

	// 사용 시간
	public int usetime(int m_no) {
		String sql = "select t_usetime from time where m_no = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, m_no);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (Exception e) {
			return 0;
		}
		return 0;
	}

	// 남은 시간
	public int remaintime(int m_no) {
		String sql = "select t_remaintime from time where m_no =?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, m_no);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

}
