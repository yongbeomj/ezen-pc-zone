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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblid.setText(loginid);
		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
		int p_no = PcDao.getPcDao().pcnocheck(m_no);
		lblpcno.setText(p_no + "");
	}
	
	Socket socket;

	// 클라이언트 시작
	public void clientstart() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					socket = new Socket("127.0.0.1", 1234);
					send(loginid + " 님 입장 했습니다 \n");
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

}
