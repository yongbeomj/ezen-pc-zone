package Sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class memberdao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private static memberdao memberdao = new memberdao();
	
	public memberdao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/javafx?serverTimeZonse=UTC", "root",
														"1234");
		} catch (Exception e) {
		}
		
	}
	
	public static memberdao getmemberdao() {
		return memberdao;
	}
	
	public boolean signup(member member) {
		String sql = "insert into member(m_id,m_password,m_name,m_email,m_point) values(?,?,?,?,?)";
		
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getM_id());
			preparedStatement.setString(2, member.getM_pw());
			preparedStatement.setString(3, member.getM_name());
			preparedStatement.setString(4, member.getM_email());
			preparedStatement.setInt(5, member.getM_point());
			preparedStatement.executeUpdate();
			return true;
			
		} catch (Exception e) {
			
		}
		return false;
	}
	
	public boolean login(String id, String pw) {
		String sql = "select * from member where m_id=? and m_password=?";
		
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
		}
		return false;
		
	}

	public boolean idcheck(String id) {
		String sql = "select m_id from member where m_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) { 
				return true; 
			} else { 
				return false; 
			}
			
		} catch (Exception e) {
		return false;
		}
		
	}
	
	
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


	public String findpassword(String id, String email) {

		
		String sql = "select m_password from member where m_id=? and m_email=?";

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
	
	public boolean update(String id, String name, String email) {
		String sql = "update member set m_name=? , m_email=? where m_id = ? ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name );
			preparedStatement.setString(2, email );
			preparedStatement.setString(3, id );
			preparedStatement.executeUpdate();
			return true;
		}
		catch (Exception e) {} return false;
		
	}
	public boolean delete(String loginid) {
		String sql = "delete from member where m_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginid);
			preparedStatement.executeUpdate();
			return true; 

		} catch (Exception e) {

		}

		return false; 
	}
	
	public member getmember(String loginid) {
		String sql = "select * from member where m_id=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
		
			preparedStatement.setString(1, loginid);
			
			resultSet = preparedStatement.executeQuery();
		
			if (resultSet.next()) { 
				
			member member = new member(resultSet.getString(2), "", resultSet.getString(4), resultSet.getString(5),
						resultSet.getInt(6));
			

				return member;
			} else {
				return null; 
			}
		} catch (Exception e) {
		}
		return null; 

	}
	
	public boolean pointupdate(String id, int point) {
		String sql = "update member set m_point = m_point+? where m_id=?";
					
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, point);
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
			return true;
	
		} catch (Exception e) {
			return false; 
		}
	}
	

}
