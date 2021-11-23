package controller;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import domain.Client;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ServerController implements Initializable {
	
	// 0.접속한 클라이언트를 저장하기 위한 리스트 
	public static Vector<Client> clients = new Vector<>();
	
	
			// Arraylist : 동기화x[단일스레드]		// Vector : 동기화o[멀티스레드]
			// 동기화 : 동일한 메소드에 여러개 스레드가 호출 할때 호출순서 매기기 
	
	// 0. 스레드를 관리해주는 스레드풀 [ ExecutorService : 스레드풀 구현 인터페이스 ] 
	public static ExecutorService threadpool;
	
	// 1. 서버소켓 선언 
	ServerSocket serverSocket;
	
	// 2. 서버실행 메소드 
	public void serverstart() {
		
		try {
			// 1. 서버소켓에 메모리 할당 
			serverSocket = new ServerSocket();
			// 2. 서버소켓에 바인딩 [ ip , port 설정 ] 
			serverSocket.bind( new InetSocketAddress( "127.0.0.1" , 1234 ) );
		}
		catch (Exception e) {}
	
		Runnable runnable = new Runnable() { // 실시간으로 클라이언트 접속 요청 대기 
			
			@Override
			public void run() {
				try {
					while(true) {
						Socket socket = serverSocket.accept();	// 1. 요청 수락 --> 수락된 소켓 객체화
						clients.add( new Client(socket) );		// 2. 수락된 소켓으로 클라이언트 객체 생성 해서 리스트에 저장 
					}
				}
				catch (Exception e) {}
			}
		};
		threadpool = Executors.newCachedThreadPool(); // 서버가 실행되면 스레드풀 메모리 초기화 
		threadpool.submit( runnable );				// 클라이언트 요청 스레드를 스레드풀에 추가 
	}
	// 3. 서버중지 메소드 
	public void serverstop() {
		try {
			// 0. 서버에 접속된 회원들의 소켓 모두 닫기 
			for( Client client : clients ) {
				client.socket.close(); // 소켓 닫기 
			}
			serverSocket.close(); // 1. 서버소켓 닫기 
			threadpool.shutdown(); // 2. 스레드풀 닫기 
		}
		catch (Exception e) {}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtserver.setEditable(false); // 수정금지 
		lblserver.setText("서버 중지중");
	}
	
	@FXML
	private TextArea txtserver;
	@FXML
	private Button btnserver;
	@FXML
	private Label lblserver;
	
	@FXML
	void start( ActionEvent event ) {
		if( btnserver.getText().equals("서버 실행") ) {
			//1. 서버 실행 
				serverstart();
			//2. 메시지창에 내용 띄우기
				// Platform.runLater(  () -> { } ); 
				// 멀티스레드를 이용한 실시간 플랫폼 내용 전달
			Platform.runLater( () -> {   
				txtserver.appendText(" [--- server start --- ]\n");
				//3. 버튼 이름 변경 
				btnserver.setText("서버 중지");
				lblserver.setText("서버 실행중");
			});
		}else {
			// 1. 서버중지 
				serverstop();
			// 2. 메시지창에 내용 띄우기 
			Platform.runLater( () -> {  
				txtserver.appendText(" [--- server stop --- ]\n"); 
				btnserver.setText("서버 실행");
				lblserver.setText("서버 중지중");
			});
		}
	}
	
}













