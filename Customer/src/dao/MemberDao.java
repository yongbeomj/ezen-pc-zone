package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {

	// �ʵ�
	private Connection connection; // db ���� �������̽� ����
	private PreparedStatement preparedStatement; // sql ���� �������̽� ����
	private ResultSet resultSet; // ���� ���� �������̽� ����
	
	// ������
	public MemberDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/ezenpczone?serverTimezone=UTC" , "root" , "1234");
		} catch (Exception e) {}
	}
	
	// �޼ҵ�
		// ��ü ����
		private static MemberDao memberDao = new MemberDao();
		public static MemberDao getMemberDao() {
			return memberDao;
		}
		// 1. �α���
		public boolean login(String id, String pw) {
			String sql = "select * from member where m_id=? and m_pw=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, id);
				preparedStatement.setString(2, pw);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return false;
		}
		
		// 2. ID ã��
		public String findid(String name, String email) {
			String sql = "select m_id from member where m_name=? and m_email=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, email);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					return resultSet.getString(1);
				} else {
					return null;
				}
			} catch (Exception e) {}
			return null;
		}
		
		// 3. PW ã��
		public String findpw(String id, String email) {
			String sql = "select m_pw from member where m_name=? and m_email=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, id);
				preparedStatement.setString(2, email);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					return resultSet.getString(1);
				} else {
					return null;
				}
			} catch (Exception e) {}
			return null;
		} 
		
}