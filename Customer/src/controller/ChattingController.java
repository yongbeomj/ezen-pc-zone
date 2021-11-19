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

	
	//+++++++++++++++++++++++++++++++++++++++ ���� ����+++++++++++++++++++++++++++++++++++++
		// 0.������ Ŭ���̾�Ʈ�� �����ϱ� ���� ����Ʈ 
				public static Vector<Client> clients = new Vector<>();
						// Arraylist : ����ȭx[���Ͻ�����]		// Vector : ����ȭo[��Ƽ������]
						// ����ȭ : ������ �޼ҵ忡 ������ �����尡 ȣ�� �Ҷ� ȣ����� �ű�� 
				
				// 0. �����带 �������ִ� ������Ǯ [ ExecutorService : ������Ǯ ���� �������̽� ] 
				public static ExecutorService threadpool;
				
				// 1. �������� ���� 
				ServerSocket serverSocket;
				
				// 2. �������� �޼ҵ� 
				public void serverstart(int port) {
					
					try {
						// 1. �������Ͽ� �޸� �Ҵ� 
						serverSocket = new ServerSocket();
						// 2. �������Ͽ� ���ε� [ ip , port ���� ] 
						serverSocket.bind( new InetSocketAddress( "127.0.0.1" , port ) );
					}
					catch (Exception e) {}
				
					Runnable runnable = new Runnable() { // �ǽð����� Ŭ���̾�Ʈ ���� ��û ��� 
						
						@Override
						public void run() {
							try {
								while(true) {
									Socket socket = serverSocket.accept();	// 1. ��û ���� --> ������ ���� ��üȭ
									clients.add( new Client(socket) );		// 2. ������ �������� Ŭ���̾�Ʈ ��ü ���� �ؼ� ����Ʈ�� ���� 
								}
							}
							catch (Exception e) {}
						}
					};
					threadpool = Executors.newCachedThreadPool(); // ������ ����Ǹ� ������Ǯ �޸� �ʱ�ȭ 
					threadpool.submit( runnable );				// Ŭ���̾�Ʈ ��û �����带 ������Ǯ�� �߰� 
				}
				// 3. �������� �޼ҵ� 
				public void serverstop() {
					try {
						// 0. ������ ���ӵ� ȸ������ ���� ��� �ݱ� 
						for( Client client : clients ) {
							client.socket.close(); // ���� �ݱ� 
						}
						serverSocket.close(); // 1. �������� �ݱ� 
						threadpool.shutdown(); // 2. ������Ǯ �ݱ� 
					}
					catch (Exception e) {}
				}
			//+++++++++++++++++++++++++++++++++++++++ ���� ���� +++++++++++++++++++++++++++++++++++++
				int port= PcDao.getPcDao().pc_portfind(p_no);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblid.setText(loginid);
		lblpcno.setText(p_no+"");
		
		serverstart(port);
    	Platform.runLater( () -> {
    		txtclient.appendText(" --- [ ���� ���� ���� ] ---\n");
		});
	}
	
	Socket socket;

	// Ŭ���̾�Ʈ ����
	public void clientstart(int port) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					socket = new Socket("127.0.0.1", port);
					send(loginid + " �� ���� �߽��ϴ�. \n");
					receive();
				} catch (Exception e) {
				}
			}
		};
		thread.start();
	}
	// Ŭ���̾�Ʈ ���� �޼ҵ�
	public void clientstop() {
		try {
			socket.close();
		} catch (Exception e) {

		}
	}

	// �޼��� ������
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

	// �޼��� �ޱ�
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
    
	// ���� ������
	@FXML
	void entersend(ActionEvent event) {
		send(loginid + " : " + txtcontents.getText() + "\n");
		txtcontents.setText("");
		txtcontents.requestFocus();
	}

	// Ŭ�� ������
	@FXML
	void msgsend(ActionEvent event) {
		send(loginid + " : " + txtcontents.getText() + "\n");
		txtcontents.setText("");
		txtcontents.requestFocus();
	}

	@FXML
    void connect(ActionEvent event) {
		if( btnconnect.getText().equals("����")) {
			// 1. Ŭ���̾�Ʈ ���� 
			clientstart(port);
			// 2. ���� �޽��� ���� 
			Platform.runLater( ()-> txtclient.appendText(" --- [ ���� ���� ] ---\n")  );
			// 3. ��Ʈ�� ���� ���� 
			btnconnect.setText("������");
			
		}
//		else {
//			// 1. Ŭ���̾�Ʈ ����
//			clientstop();
//			// 2. ���� �޽��� ���� 
//			Platform.runLater( ()-> txtclient.appendText(" --- [ ���� ���� ] ---\n")  );
//			// 3. ��Ʈ�� ���� ���� 
//			btnconnect.setText("����");
//			
//		}
    }
    

}
