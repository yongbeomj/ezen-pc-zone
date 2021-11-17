package application;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import controller.ChattingController;

public class Client {
	
	// 1. 소켓 
	public Socket socket;	// 클라이언트 소켓 
	
	// 2. 생성자
	public Client( Socket socket) {
		this.socket = socket; 	// 외부로 들어온 소켓으로 클라이언 객체 생성 
		receive();				// 접속과 동시에 받기 실행 
	}
	
	// 3. 서버로 메시지 받는 메소드 
	public void receive() {
		
		// 멀티스레드 
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) { // 무한루프
						// 메시지를 받기 
						InputStream inputStream = socket.getInputStream();// 입력스트림
						byte[] bytes = new byte[1000];	// 바이트 배열 선언 
						inputStream.read( bytes );		// 스트림에서 읽어온 바이트배열에 저장 
						String msg = new String( bytes ); // 바이트배열 ->> 문자열 변환
						
						// 받은 메시지를 서버내 접속된 모든 접속자에게 메시지 전달 
						for( Client client : ChattingController.clients ) {
							client.send( msg ); // 받은 문자를 보내기 
						}
					}
				}
				catch (Exception e) {}
			}
		};
		// 스레드풀에 스레드 추가 
		ChattingController.threadpool.submit(runnable);
	}
	// 4. 서버가 메시지를 보내는 메소드 
	public void send( String msg) {
		// 멀티스레드 
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					OutputStream outputStream = socket.getOutputStream(); // 출력 스트림
					outputStream.write( msg.getBytes() );
					outputStream.flush(); // 스트림내 메모리 초기화 
				}
				catch (Exception e) {}
				
			}
		};
		// 스레드풀에 스레드 추가 
		ChattingController.threadpool.submit(runnable);
	}
	

}


























