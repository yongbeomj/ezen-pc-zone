package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dao.MemberDao;
import dao.PcDao;
import domain.Client;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChattingController implements Initializable {

	private String loginid = LoginController.getinstance().getloginid();
	private int m_no = MemberDao.getMemberDao().mnocheck(loginid);
	private int p_no = PcDao.getPcDao().pcnocheck(m_no);

	
	//+++++++++++++++++++++++++++++++++++++++ 서버 열기+++++++++++++++++++++++++++++++++++++
		// 0.접속한 클라이언트를 저장하기 위한 리스트 
				public static Vector<Client> clients = new Vector<>();
						// Arraylist : 동기화x[단일스레드]		// Vector : 동기화o[멀티스레드]
						// 동기화 : 동일한 메소드에 여러개 스레드가 호출 할때 호출순서 매기기 
				
				// 0. 스레드를 관리해주는 스레드풀 [ ExecutorService : 스레드풀 구현 인터페이스 ] 
				public static ExecutorService threadpool;
				
				// 1. 서버소켓 선언 
				ServerSocket serverSocket;
				
				// 2. 서버실행 메소드 
				public void serverstart(int port) {
					
					try {
						// 1. 서버소켓에 메모리 할당 
						serverSocket = new ServerSocket();
						// 2. 서버소켓에 바인딩 [ ip , port 설정 ] 
						serverSocket.bind( new InetSocketAddress( "127.0.0.1" , port ) );
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
			//+++++++++++++++++++++++++++++++++++++++ 서버 열기 +++++++++++++++++++++++++++++++++++++
				int port= PcDao.getPcDao().pc_portfind(p_no);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblid.setText(loginid);
		lblpcno.setText(p_no+"");
		
		serverstart(port);
    	Platform.runLater( () -> {
    		txtclient.appendText(" --- [ 서버 접속 성공 ] ---\n");
		});
	}
	
	Socket socket;

	// 클라이언트 시작
	public void clientstart(int port) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					socket = new Socket("127.0.0.1", port);
					send(loginid + " 님 입장 했습니다. \n");
					receive();
				} catch (Exception e) {
				}
			}
		};
		thread.start();
	}
	// 클라이언트 종료 메소드
	public void clientstop() {
		try {
			socket.close();
		} catch (Exception e) {

		}
	}

	// 메세지 보내기
	public void send(String msg) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					OutputStream outputStream = socket.getOutputStream();
					outputStream.write(msg.getBytes());
					outputStream.flush();
				} catch (Exception e) {
				}
			}
		};
		thread.start();
	}

	// 메세지 받기
	public void receive() {
		while (true) {
			try {
				InputStream inputStream = socket.getInputStream();
				byte[] bytes = new byte[1000];
				inputStream.read(bytes);
				String msg = new String(bytes);
				Platform.runLater(() -> txtclient.appendText(msg));
			} catch (Exception e) {
			}
		}
	}

	@FXML
	private Button btnsend;

	@FXML
	private Label lblid;

	@FXML
	private Label lblpcno;

	@FXML
	private TextArea txtclient;

	@FXML
	private TextField txtcontents;

    @FXML
    private Button btnconnect;
    
	// 엔터 보내기
	@FXML
	void entersend(ActionEvent event) {
		send(loginid + " : " + txtcontents.getText() + "\n");
		txtcontents.setText("");
		txtcontents.requestFocus();
	}

	// 클릭 보내기
	@FXML
	void msgsend(ActionEvent event) {
		send(loginid + " : " + txtcontents.getText() + "\n");
		txtcontents.setText("");
		txtcontents.requestFocus();
	}

	@FXML
    void connect(ActionEvent event) {
		if( btnconnect.getText().equals("접속")) {
			// 1. 클라이언트 실행 
			clientstart(port);
			// 2. 접속 메시지 전달 
			Platform.runLater( ()-> txtclient.appendText(" --- [ 접속 성공 ] ---\n")  );
			// 3. 컨트롤 내용 변경 
			btnconnect.setText("나가기");
			
		}
//		else {
//			// 1. 클라이언트 종료
//			clientstop();
//			// 2. 퇴장 메시지 전달 
//			Platform.runLater( ()-> txtclient.appendText(" --- [ 접속 종료 ] ---\n")  );
//			// 3. 컨트롤 내용 변경 
//			btnconnect.setText("접속");
//			
//		}
    }
    

}
