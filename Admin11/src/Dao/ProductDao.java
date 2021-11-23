package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import Domain.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductDao {
	
	private Connection connection; // DB ���� �������̽� ����
	private PreparedStatement preparedStatement; // SQL ���� �������̽� ����
	private ResultSet resultSet; // ����(�˻����) ���� �������̽� ����
	
	private static ProductDao productDao = new ProductDao();
	
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimeZonse=UTC", "root",
					"1234");
		} catch (Exception e) {
			System.err.println(" *DB���� ���� : " + e);
		}
	}
	
	// 3. �޼ҵ�
		public static ProductDao getProductDao() {
			return productDao;
		}
		
		
			// 1. ��ǰ ���
		public boolean register(Product product) {
			String sql = "insert into product"
					+ "(p_name, p_img, p_count, p_category, p_price, p_activation) "
					+ "values(?,?,?,?,?,?)";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, product.getP_name());
				preparedStatement.setString(2, product.getP_img());
				preparedStatement.setInt(3, product.getP_count());
				preparedStatement.setString(4, product.getP_category());
				preparedStatement.setInt(5, product.getP_price());
				preparedStatement.setInt(6, product.getP_activation());
				preparedStatement.executeUpdate();
				
				return true;
				
			} catch (Exception e) {	
			}
			return false;
		}
		// ��ǰ���
		public ObservableList<Product> productlist(int type, String p_name) {
			// 1. ����Ʈ ����
			ObservableList<Product> products = FXCollections.observableArrayList();
			
			if(type==0) {
				
				String sql = "select * from product order by p_no desc";
				try {
					preparedStatement = connection.prepareStatement(sql);
					resultSet = preparedStatement.executeQuery();
				} catch (Exception e) {
					
				}
				
			}else if(type==1) {
				String sql = "select * from product where p_name=? order by p_no desc";
				try {
					preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setString(1, p_name);
					resultSet = preparedStatement.executeQuery();
				} catch (Exception e) {
					
				}
			} 
			
		
			try {
			
				while(resultSet.next()) {
					Product product = new Product( 
							resultSet.getInt(1),
							resultSet.getString(2), 
							resultSet.getString(3), 
							resultSet.getInt(4), 
							resultSet.getString(5), 
							resultSet.getInt(6), 
							resultSet.getInt(7),
							resultSet.getString(8));
				
					// ��ü ����Ʈ ����
					products.add(product);
				}
			return products;
			} catch (Exception e) {
			}
			return products;
			
		}
		

		
		public boolean delete(int p_no) {
			String sql = "delete from product where p_no=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, p_no);
				preparedStatement.executeUpdate();
				return true;
			} catch (Exception e) {
			}
			return false;
			
		}
		
		// 6. ��ǰ���� Ȱ��ȭ ����
		public boolean activationupdate(int p_activation, int p_no) {
			String sql = "update product set p_activation=? where p_no=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, p_activation);
				preparedStatement.setInt(2, p_no);
				preparedStatement.executeUpdate();
				return true;
			} catch (Exception e) {
		
			}
			return false;

		}
		
		
		public boolean update(Product product) {
			String sql = "update product set p_name=?, p_img=?, p_count=?, p_category=?, p_price=? where p_no=?";
			
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, product.getP_name());
				preparedStatement.setString(2, product.getP_img());
				preparedStatement.setInt(3, product.getP_count());
				preparedStatement.setString(4, product.getP_category());
				preparedStatement.setInt(5, product.getP_price());
				preparedStatement.setInt(6, product.getP_no());
				preparedStatement.executeUpdate();
				return true;
			} catch (Exception e) {	
			}
			return false;
		}
		
		
//		// 7. ��ǰ ���� ��ȯ�ϴ� �޼ҵ�
//		public int productcount() {
//			String sql = "select count(*) from product";
//			
//			try {
//				preparedStatement = connection.prepareStatement(sql);
//				resultSet = preparedStatement.executeQuery();
//				if(resultSet.next()) {
//					return resultSet.getInt(1);	
//				}
//			}
//			catch (Exception e) {}
//			return 0;  // DB ���� 
//			
//		}
	
	
	

}
