package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Domain.SalesDate;

public class SalesDao {
	
	private Connection connection; // DB ���� �������̽� ����
	private PreparedStatement preparedStatement; // SQL ���� �������̽� ����
	private ResultSet resultSet; // ����(�˻����) ���� �������̽� ����
	
	
	private static SalesDao salesDao = new SalesDao();
	
	public SalesDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimeZonse=UTC", "root",
					"1234");
		} catch (Exception e) {
			System.err.println(" *DB���� ���� : " + e);
		}
	}
	
	public static SalesDao getSalesDao() {
		return salesDao;
	}
	
	
	public static int totalprice() {
		
	int totalprice = TimeOrderDao.getTimeOrderDao().timeordercount() +
			ProductOrderDao.getProductOrderDao().productordercount();
	return totalprice;
	
	}
	



}
