package Controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import Dao.MemberDao;
import Dao.PcDao;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController implements Initializable {

		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			lblpcno.setText(SystemController.pc_no+"");
			int m_no = PcDao.getPcDao().m_nocheck(SystemController.pc_no);
			
			if(m_no!=0) {
				lblid.setText(MemberDao.getMemberDao().find_m_id(m_no));
			}
			int port= PcDao.getPcDao().pc_portfind(SystemController.pc_no);
			clientstart(port);
			//System.out.println(port);
		
		}
		
		Socket socket;

		// Ŭ���̾�Ʈ ����
		public void clientstart(int port) {
			Thread thread = new Thread() {
				@Override
				public void run() {
					try {
						socket = new Socket("127.0.0.1", port);
						send("admin �� ���� �߽��ϴ�. \n");
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
					Platform.runLater(() -> txtchat.appendText(msg));
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
	    private TextArea txtchat;

	    @FXML
	    private TextField txtcontents;

	    @FXML
	    void entersend(ActionEvent event) {
	    	send(" admin: " + txtcontents.getText() + "\n");
			txtcontents.setText("");
			txtcontents.requestFocus();
	    }

	    @FXML
	    void msgsend(ActionEvent event) {
	    	send(" admin: " + txtcontents.getText() + "\n");
			txtcontents.setText("");
			txtcontents.requestFocus();
	    }
}
