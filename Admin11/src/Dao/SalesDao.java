package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Domain.SalesDate;

public class SalesDao {
	
	private Connection connection; // DB 연결 인터페이스 선언
	private PreparedStatement preparedStatement; // SQL 연결 인터페이스 선언
	private ResultSet resultSet; // 쿼리(검색결과) 연결 인터페이스 선언
	
	
	private static SalesDao salesDao = new SalesDao();
	
	public SalesDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ezenpczone?serverTimeZonse=UTC", "root",
					"1234");
		} catch (Exception e) {
			System.err.println(" *DB연동 실패 : " + e);
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
