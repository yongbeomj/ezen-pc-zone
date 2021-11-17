package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductDao {

	// �ʵ�
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public static ProductDao productDao = new ProductDao();
	
	// ������
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/ezenpczone?serverTimezone=UTC", "root", "1234");
		} catch (Exception e) {}
	}

	// �޼ҵ�
	public static ProductDao getProductDao() {
		return productDao;
	}
	
	// ��ǰ ����Ʈ
	public ObservableList<Product> productlist() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		String sql = "select * from product order by p_no desc";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) { // �˻���� ���ڵ尡 ���������� ���ڵ� �ϳ��� ��ȯ
				// �ش� ���ڵ带 ��üȭ
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
	
	// ��ǰ �̹����� ��ȸ
	public ObservableList<Product> imgname() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		String sql = "select p_img from product order by p_no asc";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Product product = new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3));
				products.add(product);
			}
			return products;
			
		} catch (Exception e) {
		}
		return products;
	}
}
