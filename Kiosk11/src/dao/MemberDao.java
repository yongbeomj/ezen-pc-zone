package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Member;

public class MemberDao {

	private Connection connection ; 
	private PreparedStatement preparedStatement; 
	private ResultSet resultSet; 
	
	private static MemberDao memberDao = new MemberDao();
	
	public static MemberDao getMemberDao() { return memberDao; }
	
	
	public MemberDao() {
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
	//1. 회원가입 메소드
	public boolean signup (Member member) {
		String sql =  "insert into member(m_id, m_pw, m_name, m_email, m_phone, m_sex) value(?, ?, ?, ?, ?,?)";
		try {
		
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, member.getM_id());
		preparedStatement.setString(2, member.getM_pw());
		preparedStatement.setString(3, member.getM_name());
		preparedStatement.setString(4, member.getM_email());
		preparedStatement.setString(5, member.getM_phone());
		preparedStatement.setInt(6, member.getM_sex());
		preparedStatement.executeUpdate();
		
		return true;
		}catch (Exception e) {
			System.out.println("db 연동 실패");
			return false;
		}
	}
	//2. 아이디 중복체크
	public boolean idcheck (String id) {
		String sql = "select m_id from member where m_id =?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
	//로그인 메소드
	public boolean login (String id , String pw) {
		String sql = "select * from member where m_id=? and m_pw=?";
		try {
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);
			resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			return false;
		}
	}
	
	//맴버 번호 찾기 메소드
	public int find_m_no (String m_id) {
		
		String sql = "select m_no from member where m_id=?";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, m_id);
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

























