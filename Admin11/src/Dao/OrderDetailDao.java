package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Domain.OrderDetail;
import Domain.ProductOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderDetailDao {

	
	private Connection connection;
	private PreparedStatement preparedStatement; 
	private ResultSet resultSet; 
	
	
	public OrderDetailDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimeZonse=UTC", "root",
					"1234");
		} catch (Exception e) {
			System.err.println(" *DB연동 실패 : " + e);
		}
	}
	
	
	private static OrderDetailDao orderdetailDao = new OrderDetailDao();
	
	public static OrderDetailDao getOrderDetailDao() {
		return orderdetailDao;
	}
	
	public ObservableList<OrderDetail> orderDetails(int od_no) {
		ObservableList<OrderDetail> details = FXCollections.observableArrayList();
		String sql = "select od_no, p_name, od_category, od_count, od_price from orderdetail where po_no=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, od_no);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				OrderDetail orderDetail = new OrderDetail(
						resultSet.getInt(1), 
						resultSet.getString(2),
						resultSet.getString(3), 
						resultSet.getInt(4), 
						resultSet.getInt(5));
				details.add(orderDetail);
			}
			return details;
		} catch (Exception e) {
			System.out.println("db오류");
			
		}
		return details;

	}
		
	
	
	
	
	
	
	
	
	
	
}
