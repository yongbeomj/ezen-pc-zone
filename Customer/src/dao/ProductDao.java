package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimezone=UTC",
					"root", "1234");
		} catch (Exception e) {
		}
	}

	// 메소드
	public static ProductDao getProductDao() {
		return productDao;
	}

	// 전체 제품 리스트
	public ObservableList<Product> productlist() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		String sql = "select * from product order by p_no desc";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) { // 검색결과 레코드가 없을때까지 레코드 하나씩 반환
				// 해당 레코드를 객체화
				Product product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getInt(7),
						resultSet.getString(8));
				// 객체 리스트 저장
				products.add(product);
			}
			return products;
		} catch (Exception e) {
		}
		return products;
	}

	// 제품 수
	public int productcount() {
		String sql = "select count(*) from product";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (Exception e) {
		}
		return 0;
	}

	// 버튼 리스트
	public ArrayList<Product> buttonlist() {
		ArrayList<Product> buttons = new ArrayList<>();
		String sql = "select p_no ,p_name,p_img, p_count ,p_category,p_price,p_activation  from product";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product button = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getInt(7));
				buttons.add(button);
			}
			return buttons;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return buttons;
	}

	// 옵저버리스트
	public ObservableList<Product> p_list() {
		ObservableList<Product> buttons = FXCollections.observableArrayList();
		String sql = "select p_no ,p_name,p_img, p_count ,p_category,p_price,p_activation  from product";
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Product button = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getInt(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getInt(7));
				buttons.add(button);
			}
			return buttons;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return buttons;

	}

}
