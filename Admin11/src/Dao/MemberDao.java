package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Domain.Member;
import Domain.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MemberDao {
	private Connection connection; 
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private static MemberDao memberDao = new MemberDao();
	
	
	public MemberDao() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimeZonse=UTC", "root",
					"1234");
		} catch (Exception e) {
			System.err.println(" *DB���� ���� : " + e);
		}
	}
	
	public static MemberDao getMemberDao() {
		return memberDao;
	}
	
	
	public ObservableList<Member> memberlist(int type, String m_name) {
		// 1. ����Ʈ ����
		ObservableList<Member> members = FXCollections.observableArrayList();
		if(type==0) {
			
			String sql = "select * from member order by m_no desc";
			try {
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
			} catch (Exception e) {
				
			}
			
		}else if(type==1) {
			String sql = "select * from member where m_name=? order by m_no desc";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, m_name);
				resultSet = preparedStatement.executeQuery();
			} catch (Exception e) {
				
			}
		} 
	
		try {

			while(resultSet.next()) {
				
				Member member = new Member(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3), 
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6), 
						resultSet.getInt(7));

			
				// ��ü ����Ʈ ����
				
				members.add(member);
			}
		return members;
		} catch (Exception e) {
			System.out.println("ddd");
		}
		return members;
		
	}
	
	
	public boolean update(Member member) {
		String sql = "update member set m_pw=?, m_name=?, m_email=?, m_phone=?, m_sex=? where m_no=?" ;
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getM_pw());
			preparedStatement.setString(2, member.getM_name());
			preparedStatement.setString(3, member.getM_email());
			preparedStatement.setString(4, member.getM_phone());
			preparedStatement.setInt(5, member.getM_sex());
			preparedStatement.setInt(6, member.getM_no());
			preparedStatement.executeUpdate();
			
			return true;
		} catch (Exception e) {	
		}
		return false;
	}
	
	

	
	
	public boolean delete(int m_no) {
		String sql = "delete from member where m_no=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, m_no);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {
		}
		return false;
		
	}
	
	
	//pc ������� �ɹ� ���̵� ã�� �޼ҵ�
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
          System.out.println("pc ������� �ɹ� ���̵� ã�� ����");
          return null;
       }
    }
	
    
	
	// 12. ȸ�� ���� ��ȯ�ϴ� �޼ҵ�
	public int membercount() {
		String sql = "select count(*) from member";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);	
			}
		}
		catch (Exception e) {}
		return 0;  // DB ���� 
		
	}
	
	
	
			
	
	
	
	
	

}
