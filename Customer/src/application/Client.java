package application;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import controller.ChattingController;

public class Client {
	
	// 1. ���� 
	public Socket socket;	// Ŭ���̾�Ʈ ���� 
	
	// 2. ������
	public Client( Socket socket) {
		this.socket = socket; 	// �ܺη� ���� �������� Ŭ���̾� ��ü ���� 
		receive();				// ���Ӱ� ���ÿ� �ޱ� ���� 
	}
	
	// 3. ������ �޽��� �޴� �޼ҵ� 
	public void receive() {
		
		// ��Ƽ������ 
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					while(true) { // ���ѷ���
						// �޽����� �ޱ� 
						InputStream inputStream = socket.getInputStream();// �Է½�Ʈ��
						byte[] bytes = new byte[1000];	// ����Ʈ �迭 ���� 
						inputStream.read( bytes );		// ��Ʈ������ �о�� ����Ʈ�迭�� ���� 
						String msg = new String( bytes ); // ����Ʈ�迭 ->> ���ڿ� ��ȯ
						
						// ���� �޽����� ������ ���ӵ� ��� �����ڿ��� �޽��� ���� 
						for( Client client : ChattingController.clients ) {
							client.send( msg ); // ���� ���ڸ� ������ 
						}
					}
				}
				catch (Exception e) {}
			}
		};
		// ������Ǯ�� ������ �߰� 
		ChattingController.threadpool.submit(runnable);
	}
	// 4. ������ �޽����� ������ �޼ҵ� 
	public void send( String msg) {
		// ��Ƽ������ 
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					OutputStream outputStream = socket.getOutputStream(); // ��� ��Ʈ��
					outputStream.write( msg.getBytes() );
					outputStream.flush(); // ��Ʈ���� �޸� �ʱ�ȭ 
				}
				catch (Exception e) {}
				
			}
		};
		// ������Ǯ�� ������ �߰� 
		ChattingController.threadpool.submit(runnable);
	}
	

}


























