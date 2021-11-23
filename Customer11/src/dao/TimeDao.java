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

	// 사용시간 조회
	public int usetimecheck(int mno) {
		String sql = "select t_usetime from time where m_no = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, mno);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			} else {
				return 0;
			}
		} catch (Exception e) {
		}
		return 0;
	}

	// 남은시간 조회
	public int remaintimecheck(int mno) {
		String sql = "select t_remaintime from time where m_no = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, mno);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			} else {
				return 0;
			}
		} catch (Exception e) {
		}
		return 0;
	}

//	// 최근 충전 요금 조회
//	public int chargepricecheck(int ) {
//		String sql = "select t_remaintime from time where m_no = ?";
//		try {
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, mno);
//			resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				return resultSet.getInt(1);
//			} else {
//				return 0;
//			}
//		} catch (Exception e) {}
//		return 0;
//	}

	// 등록 날짜(충전 날짜) 조회
	public String chargedatecheck(int mno) {
		String sql = "select to_date from timeorder where m_no = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, mno);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getString(1);
			} else {
				return null;
			}
		} catch (Exception e) {
		}
		return null;
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

	// 실시간 차감

	public boolean timeupdate(int m_no, int add_time, int time_remaintime) {
		String sql = "update time set t_remaintime=? where m_no=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, time_remaintime + add_time);
			preparedStatement.setInt(2, m_no);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 실시간 사용시간 +1

	public boolean usetimeupdate(int m_no, int add_time, int time_usetime) {
		String sql = "update time set t_usetime=? where m_no=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, time_usetime + add_time);
			preparedStatement.setInt(2, m_no);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
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
