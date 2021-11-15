package application;

import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import controller.LoginController;
import dao.MemberDao;
import dao.TimeDao;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date today = new Date ();
		Date tomorrow = new Date ( today.getTime ( ) + (long) ( 1000 * 60 * 60 * 24 ) );
		Date connect = new Date ((long) ( 1000 * 60 * 60 * 24 ) );
		
		
		long reqTime = System.currentTimeMillis(); 
		String reqTimeStr = dayTime.format(new Date(reqTime));
		
		Thread.sleep(3123);
		
		long resTime = System.currentTimeMillis(); 
		String resTimeStr = dayTime.format(resTime);
		
		System.out.println("Date today : " + today);
		System.out.println("Date tomorrow : " + connect);
		System.out.println("long reqTime : " + reqTime);
		System.out.println("��û�ð� : " + reqTimeStr);
		System.out.println("����ð� : " + resTimeStr);
		System.out.println("�ɸ��ð� : " + (resTime - reqTime)/1000.000);
	}

}
