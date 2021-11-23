package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Domain.Pc;

public class PcDao {

	
	private Connection connection ; 
	private PreparedStatement preparedStatement; 
	private ResultSet resultSet; 
	
	private static PcDao pcDao = new PcDao();
	
	public static PcDao getPcDao() { return pcDao; }
	
	
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
	
	//pc �ڸ�����
	public void pcset(int p_no , int m_no ) {
		String sql =  "update pc set m_no=?, pc_activation=? where p_no=?";
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
	public int pcnocheck(int m_no ) {
		String sql = "select * from pc where m_no=?";
		try {
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, m_no);
			//preparedStatement.setInt(2, p_no);
			resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}else {
				return 0;
			}
		}catch (Exception e) {
			System.out.println("pcnocheck ����");
			return 0;
		}
		
	}
	//������� pc Ȯ��(���Ұ� pc)
	public ArrayList<Pc> pcactivation_List(int type){
		ArrayList<Pc> pcactivList = new ArrayList<>();
		if(type==1) {
			String sql = "SELECT pc_no , m_no FROM ezenpczone.pc where pc_activation=1";
			try {
			preparedStatement=connection.prepareStatement(sql);		
			resultSet = preparedStatement.executeQuery();
			} catch (Exception e) {
			} 
		}else if(type==2) {
			String sql = "SELECT pc_no , m_no FROM ezenpczone.pc where pc_activation=2";
			try {
			preparedStatement=connection.prepareStatement(sql);		
			resultSet = preparedStatement.executeQuery();
			} catch (Exception e) {
			} 
			
		}
		
		try {
		
			while(resultSet.next()) {
				Pc pc = new Pc(resultSet.getInt(1), resultSet.getInt(2));
				pcactivList.add(pc);
			}return pcactivList;
			
			
		}catch (Exception e) {
			return pcactivList;
		}
	}
	public ArrayList<Pc> pcactivation_List(){
		ArrayList<Pc> pcactivList = new ArrayList<>();
		String sql = "SELECT pc_no,pc_activation,m_no FROM ezenpczone.pc ";
		try {
			preparedStatement=connection.prepareStatement(sql);	
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Pc pc = new Pc(resultSet.getInt(1), resultSet.getInt(2),resultSet.getInt(3));
				pcactivList.add(pc);
			}return pcactivList;
			
			
		}catch (Exception e) {
			return pcactivList;
		}
	}
	
	//pc��ȣ�� ���� ã��
		public int m_nocheck(int p_no ) {
			String sql = "select m_no from pc where pc_no=?";
			try {
				preparedStatement= connection.prepareStatement(sql);
				preparedStatement.setInt(1, p_no);
				//preparedStatement.setInt(2, p_no);
				resultSet= preparedStatement.executeQuery();
				if(resultSet.next()) {
					return resultSet.getInt(1);
				}else {
					return 0;
				}
			}catch (Exception e) {
				System.out.println("pccheck ����");
				return 0;
			}
			
		}
		//�ǽ� ��Ʈ��ȣ ã��
		public int pc_portfind(int p_no ) {
			String sql = "select pc_port from pc where pc_no=?";
			try {
				preparedStatement= connection.prepareStatement(sql);
				preparedStatement.setInt(1, p_no);
				//preparedStatement.setInt(2, p_no);
				resultSet= preparedStatement.executeQuery();
				if(resultSet.next()) {
					return resultSet.getInt(1);
				}else {
					return 0;
				}
			}catch (Exception e) {
				System.out.println("pccheck ����");
				return 0;
			}
			
		}
		
		//pc ����� Ȯ��
		public int pcrepair(int pc_no ) {
			String sql = "select pc_activation from pc where pc_no=?";
			try {
				preparedStatement= connection.prepareStatement(sql);
				preparedStatement.setInt(1, pc_no);
				//preparedStatement.setInt(2, p_no);
				resultSet= preparedStatement.executeQuery();
				if(resultSet.next()) {
					return resultSet.getInt(1);
				}else {
					return 0;
				}
			}catch (Exception e) {
				System.out.println("pccheck ����");
				return 0;
			}
			
		}
	
	
}






























