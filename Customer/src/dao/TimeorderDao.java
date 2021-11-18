package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TimeorderDao {

	
	// 필드
		private Connection connection;
		private PreparedStatement preparedStatement;
		private ResultSet resultSet;

		// 생성자
		public TimeorderDao() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimezone=UTC",
						"root", "1234");
			} catch (Exception e) {
			}
		}

		// 메소드
		// 객체 생성
		public static TimeorderDao timeorderDao = new TimeorderDao();

		public static TimeorderDao gettimeorderDao () {
			return timeorderDao ;
		}
		
		//최근 충전 요금
		public int new_time(int m_no) {
			String sql = "select *  from timeorder where m_no=?";
			String sql1 = "SELECT to_price FROM timeorder ORDER BY to_price DESC LIMIT 1";
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setInt(1, m_no);
				preparedStatement.executeQuery();
				preparedStatement=connection.prepareStatement(sql1);
				resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
					return resultSet.getInt(1);
				}else {
					return 0;
				}
				
			}catch (Exception e) {
				System.out.println("최근 충전 요금 오류");
				return 0;
			}
		}
			
			
			//String sql= "SELECT * FROM timeorder ORDER BY to_price DESC LIMIT 1 where m_no=?";
		}
		
		

