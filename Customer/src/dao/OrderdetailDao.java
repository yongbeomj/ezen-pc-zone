package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Orderdetail;


public class OrderdetailDao {
	
	private Connection connection; // db 연결 인터페이스 선언
	private PreparedStatement preparedStatement; // sql 연결 인터페이스 선언
	private ResultSet resultSet;
	
	public OrderdetailDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimezone=UTC",
					"root", "1234");
		} catch (Exception e) {
			System.out.println("OrderdetailDao()");
		}
	}

	// 메소드
	// 객체 생성
	private static OrderdetailDao orderdetailDao = new OrderdetailDao();

	public static OrderdetailDao getOrderdetailDao() {
		return orderdetailDao;
	}
	//주문상세보기
	   public void orderdetail(Orderdetail orderdetail) {
	      String sql = "insert into orderdetail(po_no,p_no,p_name,od_category,od_count,od_price) value(?,?,?,?,?,?)";
	      try {
	         preparedStatement=connection.prepareStatement(sql);
	         preparedStatement.setInt(1, orderdetail.getPo_no());
	         preparedStatement.setInt(2, orderdetail.getP_no());
	         preparedStatement.setString(3, orderdetail.getP_name());
	         preparedStatement.setString(4, orderdetail.getOd_category());
	         preparedStatement.setInt(5, orderdetail.getOd_count());
	         preparedStatement.setInt(6, orderdetail.getOd_price());
	         preparedStatement.executeUpdate();
	      }catch (Exception e) {
	         System.out.println("주문상세보기 오류");
	      }
	   }
}
