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
	
	// 0.������ Ŭ���̾�Ʈ�� �����ϱ� ���� ����Ʈ 
	public static Vector<Client> clients = new Vector<>();
	
	
			// Arraylist : ����ȭx[���Ͻ�����]		// Vector : ����ȭo[��Ƽ������]
			// ����ȭ : ������ �޼ҵ忡 ������ �����尡 ȣ�� �Ҷ� ȣ����� �ű�� 
	
	// 0. �����带 �������ִ� ������Ǯ [ ExecutorService : ������Ǯ ���� �������̽� ] 
	public static ExecutorService threadpool;
	
	// 1. �������� ���� 
	ServerSocket serverSocket;
	
	// 2. �������� �޼ҵ� 
	public void serverstart() {
		
		try {
			// 1. �������Ͽ� �޸� �Ҵ� 
			serverSocket = new ServerSocket();
			// 2. �������Ͽ� ���ε� [ ip , port ���� ] 
			serverSocket.bind( new InetSocketAddress( "127.0.0.1" , 1234 ) );
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txtserver.setEditable(false); // �������� 
		lblserver.setText("���� ������");
	}
	
	@FXML
	private TextArea txtserver;
	@FXML
	private Button btnserver;
	@FXML
	private Label lblserver;
	
	@FXML
	void start( ActionEvent event ) {
		if( btnserver.getText().equals("���� ����") ) {
			//1. ���� ���� 
				serverstart();
			//2. �޽���â�� ���� ����
				// Platform.runLater(  () -> { } ); 
				// ��Ƽ�����带 �̿��� �ǽð� �÷��� ���� ����
			Platform.runLater( () -> {   
				txtserver.appendText(" [--- server start --- ]\n");
				//3. ��ư �̸� ���� 
				btnserver.setText("���� ����");
				lblserver.setText("���� ������");
			});
		}else {
			// 1. �������� 
				serverstop();
			// 2. �޽���â�� ���� ���� 
			Platform.runLater( () -> {  
				txtserver.appendText(" [--- server stop --- ]\n"); 
				btnserver.setText("���� ����");
				lblserver.setText("���� ������");
			});
		}
	}
	
}













