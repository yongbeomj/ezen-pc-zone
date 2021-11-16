package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import domain.Pc;

public class PcDao {

	// �ʵ�
	private Connection connection ; 
	private PreparedStatement preparedStatement; 
	private ResultSet resultSet; 
	
	private static PcDao pcDao = new PcDao();
	
	public static PcDao getPcDao() { return pcDao; }

	// ������
	public PcDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/ezenpczone?serverTimezone=UTC" , 
					"root" , "1234");
		}
		catch (Exception e) {
			System.out.println(" * DB ���� ���� : " + e);
		}
	}
	
	// �޼ҵ�
	public int pcnocheck(int m_no) {
		String sql = "select p_no from pc where m_no = ?";
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
		}
		return 0;
	}
	//pc �α���
	public void pclogin(int p_no , int m_no ) {
		String sql =  "update pc set m_no=?, p_activation=? where p_no=?";
		try {
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, m_no);
			preparedStatement.setInt(2, 2);
			preparedStatement.setInt(3, p_no);
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			System.out.println("�ڸ����� db ����");
		}
	}
	
	//pc �α׾ƿ�
	public void pclogout(int p_no , int m_no ) {
		String sql =  "update pc set m_no=?, p_activation=? where p_no=?";
		try {
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, 0);
			preparedStatement.setInt(2, 1);
			preparedStatement.setInt(3, p_no);
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			System.out.println("�ڸ����� db ����");
		}
	}
	
	//pc ����� Ȯ��
	public boolean pccheck(int m_no ) {
		String sql = "select * from pc where m_no=?";
		try {
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, m_no);
			//preparedStatement.setInt(2, p_no);
			resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			System.out.println("pccheck ����");
			return false;
		}
		
	}
	//������� pc Ȯ��
	public ArrayList<Pc> pcactivation_List(){
		ArrayList<Pc> pcactivList = new ArrayList<>();
		String sql = "SELECT p_no , m_no FROM ezenpczone.pc where p_activation=2";
		try {
			preparedStatement=connection.prepareStatement(sql);		
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Pc pc = new Pc(resultSet.getInt(1), resultSet.getInt(2));
				pcactivList.add(pc);
			}return pcactivList;
			
			
		}catch (Exception e) {
			return pcactivList;
		}
	}
	
	

	
	
	
	
}






























