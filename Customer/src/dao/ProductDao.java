package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductDao {

	// 필드
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public static ProductDao productDao = new ProductDao();
	
	// 생성자
	public ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/ezenpczone?serverTimezone=UTC", "root", "1234");
		} catch (Exception e) {}
	}

	// 메소드
	public static ProductDao getProductDao() {
		return productDao;
	}
	
	// 제품 리스트
	public ObservableList<Product> productlist() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		String sql = "select * from product order by p_no desc";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) { // 검색결과 레코드가 없을때까지 레코드 하나씩 반환
				// 해당 레코드를 객체화
				Product product = new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getInt(4),
						resultSet.getString(5),
						resultSet.getInt(6),
						resultSet.getInt(7),
						resultSet.getString(8));
				// 객체 리스트 저장
				products.add(product);
			}
			return products;
		} catch (Exception e) {
		}
		return products;
	}
	
	// 제품 이미지명 조회
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
