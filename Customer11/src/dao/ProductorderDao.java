package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Productorder;

public class ProductorderDao {

	
	private Connection connection; // db ���� �������̽� ����
	private PreparedStatement preparedStatement; // sql ���� �������̽� ����
	private ResultSet resultSet; // ���� ���� �������̽� ����

	public ProductorderDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimezone=UTC",
					"root", "1234");
		} catch (Exception e) {
		}
	}
	
	private static ProductorderDao proDao = new ProductorderDao();
	
	public static ProductorderDao getProductDao () {
		return proDao;
	}
	
	public boolean productorder(Productorder order) {
		String sql = "insert into productorder(po_contents,po_count,"
				+ "pc_no ,m_id ,po_price,po_activation) values (?,?,?,?,?,?)";
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, order.getPo_contents());
			preparedStatement.setInt(2, order.getPo_count());
			preparedStatement.setInt(3, order.getPc_no());
			preparedStatement.setString(4,order.getM_id());
			preparedStatement.setInt(5, order.getPo_price());
			preparedStatement.setInt(6, order.getPo_activation());
			preparedStatement.executeUpdate();
			System.out.println("�Ϸ�1");
			return true;
		} catch (Exception e) {
			System.out.println("productorder()");
		}
		return false;
	}
	//���� �ֱ� �ֹ���ȣ ��������
	   public int find_po_no() {
	      String sql="SELECT * FROM productorder ORDER BY po_no DESC LIMIT 1";
	      try {
	         preparedStatement=connection.prepareStatement(sql);
	         resultSet=preparedStatement.executeQuery();
	         if(resultSet.next()) {
	            return resultSet.getInt(1);
	         }else {
	            System.out.println("�ʱ� �ֹ���ȣ �������� ���");
	            return 0;
	         }
	      }catch (Exception e) {
	         System.out.println("�ʱ� �ֹ���ȣ �������� ���");
	         return 0;
	      }
	   }
	
	
}
