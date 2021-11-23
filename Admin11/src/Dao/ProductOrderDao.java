package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Domain.Product;
import Domain.ProductOrder;
import Domain.SalesDate;
import Domain.TimeOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductOrderDao {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	public ProductOrderDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimeZonse=UTC",
					"root", "1234");
		} catch (Exception e) {
			System.err.println(" *DB���� ���� : " + e);
		}
	}

	private static ProductOrderDao productorderDao = new ProductOrderDao();

	public static ProductOrderDao getProductOrderDao() {
		return productorderDao;
	}

	public ObservableList<ProductOrder> productorderlist() {
		ObservableList<ProductOrder> productorders = FXCollections.observableArrayList();
		String sql = "select * from productorder order by po_no desc";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductOrder productorder = new ProductOrder(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getString(6),
						resultSet.getInt(7), resultSet.getInt(8));

				// ��ü ����Ʈ ����
				productorders.add(productorder);
			}
			return productorders;
		} catch (Exception e) {
		}
		return productorders;

	}

	// 6. ��ǰ���� Ȱ��ȭ ����
	public boolean activationupdate1(int po_activation, int po_no) {
		String sql = "update productorder set po_activation=? where po_no=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, po_activation);
			preparedStatement.setInt(2, po_no);
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception e) {

		}
		return false;

	}

	public int productordercount() {
		String sql = "select po_price from productorder";
		ArrayList<ProductOrder> poprices = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				poprices.add(new ProductOrder(resultSet.getInt(1)));
			}
			int price = 0;
			for (ProductOrder order : poprices) {
				price += order.getPo_price();
			}
			return price;
		} catch (Exception e) {
		}
		return 0; // DB ����

	}

	// ��ǰ �ϸ���
	public int productorderdate1(String day) {

		String sql = "SELECT sum(po_price) FROM productorder WHERE DATE_FORMAT(po_date, '%m-%d') BETWEEN ? AND ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, day);
			preparedStatement.setString(2, day);
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


	// 5��ġ ��ǰ ����
	public ArrayList<SalesDate> productorderdate3() {
		String sql = "SELECT sum(po_price), DATE_FORMAT(po_date, '%Y') FROM productorder WHERE DATE_FORMAT(po_date, '%Y') BETWEEN ? AND ?;";
		ArrayList<SalesDate> producs = new ArrayList<>();
		try {
			for (int i = 2017; i < 2022; i++) {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, i);
				preparedStatement.setInt(2, i + 1);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					SalesDate sa = new SalesDate(resultSet.getString(2), resultSet.getInt(1));
					producs.add(sa);
				}

			}
			return producs;
		} catch (Exception e) {
			return producs;
		}

	}

	// ������ ���� ��ǰ ���� ��ȯ
	public int monproductsales(String to_date) {
		String sql = "select sum(po_price) FROM productorder WHERE DATE_FORMAT(po_date, '%Y-%m') = ?;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, to_date);
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
	
	   // ��ü �ð� ����
	   public int totproductsales(String to_date) {
	      String sql = "select sum(po_price) FROM productorder WHERE DATE_FORMAT(po_date, '%Y') = ?;";
	      try {
	         preparedStatement = connection.prepareStatement(sql);
	         preparedStatement.setString(1, to_date);
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
	
}










