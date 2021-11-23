package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Member;

public class MemberDao {

	// 필드
	private Connection connection; // db 연결 인터페이스 선언
	private PreparedStatement preparedStatement; // sql 연결 인터페이스 선언
	private ResultSet resultSet; // 쿼리 연결 인터페이스 선언

	// 생성자
	public MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimezone=UTC",
					"root", "1234");
		} catch (Exception e) {
		}
	}

	// 메소드
	// 객체 생성
	private static MemberDao memberDao = new MemberDao();

	public static MemberDao getMemberDao() {
		return memberDao;
	}

	// 1. 로그인
	public boolean login(String id, String pw) {
		String sql = "select * from member where m_id=? and m_pw=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	// 2. ID 찾기
	public String findid(String name, String email) {
		String sql = "select m_id from member where m_name=? and m_email=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
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

	// 3. PW 찾기
	public String findpw(String id, String email) {
		String sql = "select m_pw from member where m_name=? and m_email=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, email);
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

	// 4. 회원 코드 조회
	public int mnocheck(String id) {
		String sql = "select m_no from member where m_id = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
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
	// 5. 회원 아이디 조회
	public String midcheck( int m_no) {
		String sql = "select m_id from member where m_no=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, m_no);
			resultSet = preparedStatement.executeQuery();
			if( resultSet.next() ) { return resultSet.getString(1); } // 현재 아이디가 존재하면
			else { return ""; }
		}
		catch (Exception e) {}
		return "";  
	}

	//pc 사용중인 맴버 아이디 찾기 메소드
		public String find_m_id (int m_no) {
			String sql = "SELECT m_id FROM member where m_no=?";
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement.setInt(1, m_no);
				resultSet= preparedStatement.executeQuery();
				if(resultSet.next()) {
					return resultSet.getString(1);
				}else {
					return resultSet.getString(1);
				}
			}catch (Exception e) {
				System.out.println("pc 사용중인 맴버 아이디 찾기 실패");
				return null;
			}
		}

}
