package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Domain.ProductOrder;
import Domain.SalesDate;
import Domain.TimeOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TimeOrderDao {

	private Connection connection; // DB 연결 인터페이스 선언
	private PreparedStatement preparedStatement; // SQL 연결 인터페이스 선언
	private ResultSet resultSet; // 쿼리(검색결과) 연결 인터페이스 선언

	private static TimeOrderDao timeOrderDao = new TimeOrderDao();

	public TimeOrderDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimeZonse=UTC",
					"root", "1234");
		} catch (Exception e) {
			System.err.println(" *DB연동 실패 : " + e);
		}
	}

	public static TimeOrderDao getTimeOrderDao() {
		return timeOrderDao;
	}

	public int timeordercount() {
		String sql = "select to_price from timeorder";
		ArrayList<TimeOrder> toprices = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				toprices.add(new TimeOrder(resultSet.getInt(1)));
			}
			int price = 0;
			for (TimeOrder order : toprices) {
				price += order.getTo_price();
			}
			return price;
		} catch (Exception e) {
		}
		return 0; // DB 오류

	}

	// 시간 일매출
	public int timeorderdate1(String day) {

		String sql = "SELECT sum(to_price) FROM timeorder WHERE DATE_FORMAT(to_date, '%m-%d') BETWEEN ? AND ?";
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

	public ArrayList<SalesDate> timeorderdate3() {
		String sql = "SELECT sum(to_price), DATE_FORMAT(to_date, '%Y') FROM timeorder WHERE DATE_FORMAT(to_date, '%Y') BETWEEN ? AND ?;";
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

	// 연도별 월간 시간 매출 반환
	public int montimesales(String to_date) {
		String sql = "select sum(to_price) FROM timeorder WHERE DATE_FORMAT(to_date, '%Y-%m') = ?;";
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
	
	// 전체 시간 매출
	public int tottimesales(String to_date) {
		String sql = "select sum(to_price) FROM timeorder WHERE DATE_FORMAT(to_date, '%Y') = ?;";
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
