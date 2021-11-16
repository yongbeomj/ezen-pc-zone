package controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.PcDao;
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

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// ���� ����
		ServerController serverController = new ServerController();
		serverController.serverstart();
		// �ڵ� ����
		connect(null);
		btnconnect.setVisible(false);
		
		txtcontents.setDisable(false);
		btnsend.setDisable(false);
		lblid.setText(loginid);
		lblpcno.setText(p_no + "");
	}
	
	Socket socket;

	// Ŭ���̾�Ʈ ����
	public void clientstart() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					socket = new Socket("127.0.0.1", 1234);
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
			clientstart();
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
