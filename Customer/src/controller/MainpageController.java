package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import dao.MemberDao;
import dao.PcDao;
import dao.TimeDao;
import domain.Pc;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainpageController implements Initializable {

	// 로그인 id 조회
	String loginid = LoginController.getinstance().getloginid();

	// m_no 조회
	int m_no = MemberDao.getMemberDao().mnocheck(loginid);
	// m_no의 pc_no 조회
	int p_no = PcDao.getPcDao().pcnocheck(m_no);

	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(loginid);
		System.out.println(m_no);
		System.out.println(p_no);

		lblloginid.setText(loginid);
		lblpcno.setText(p_no + "");
		// m_no의 남은 요금 조회
		lblprice.setText(""); // 임시

		
		
		// 남은시간 실시간 db 조회
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				Runnable updater = new Runnable() {

					@Override
					public void run() {

						// 시간 변경
						int time = TimeDao.getTimeDao().remaintime(m_no);
						int hour = time / (60 * 60);
						int minute = time / 60 - (hour * 60);
						int second = time % 60;
						lblremaintime.setText(hour + ":" + String.format("%02d", minute) + ":"
								+ String.format("%02d", second));

					}
				};

				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
					}

					// UI update is run on the Application thread
					Platform.runLater(updater);
				}
			}

		});
		thread1.start();

	}


	// 인스턴스화
	public static MainpageController instance;

	public MainpageController() {
		instance = this;
	}

	public static MainpageController getinstance() {
		return instance;
	}

	@FXML
	private Button btnchatting;

	@FXML
	private Button btnlogout;

	@FXML
	private Button btnmove;

	@FXML
	private Button btnpause;

	@FXML
	private Button btnproductorder;

	@FXML
	private ImageView image1;

	@FXML
	private ImageView image2;

	@FXML
	private Label lblpcno;

	@FXML
	private Label lblloginid;

	@FXML
	private Label lblprice;

	@FXML
	private Label lblremaintime;

	@FXML
	private Label lblusetime;

	@FXML
	void chatting(ActionEvent event) {
		loadpage("c_chatting");
	}

	@FXML
	void logout(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(" 로그아웃 ");
		alert.setHeaderText(" 로그아웃 하시겠습니까? ");
		alert.setTitle("로그아웃");
		// 알림창이 떴을 때 옵션(확인, 취소)에 따라 기능 다름
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) { // 확인을 누르면
			PcDao.getPcDao().pclogout(p_no, m_no);
			btnlogout.getScene().getWindow().hide(); // 메인창을 끄고
			LoginController.getinstance().loadpage("c_login"); // 로그인 창 활성화
		}
	}

	@FXML
	void move(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(" 자리이동 ");
		alert.setHeaderText(" 자리이동 하시겠습니까? ");
		alert.setTitle("자리이동");
		// 알림창이 떴을 때 옵션(확인, 취소)에 따라 기능 다름
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) {
			btnmove.getScene().getWindow().hide();
			loadpage("c_move");
		}
	}

	@FXML
	void pause(ActionEvent event) {

		if (btnpause.getText().equals("일시정지")) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText(" 일시정지 ");
			alert.setHeaderText(" 일시정지 하시겠습니까? ");
			alert.setTitle("일시정지");

			Optional<ButtonType> optional = alert.showAndWait();
			if (optional.get() == ButtonType.OK) {
//				thread1.stop();
				btnpause.setText("시작");
			}
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText(" 시작 ");
			alert.setHeaderText(" 시작 하시겠습니까? ");
			alert.setTitle("시작");

			Optional<ButtonType> optional = alert.showAndWait();
			if (optional.get() == ButtonType.OK) {
//				thread2.start();
				btnpause.setText("일시정지");
			}
		}
	}

	@FXML
	void productorder(ActionEvent event) {
		btnproductorder.getScene().getWindow().hide();
		loadpage("c_productorder");
	}

	public void loadpage(String page) {
		Stage stage = new Stage();
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/" + page + ".fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("EZEN PC ZONE");
			stage.show();
		} catch (Exception e) {
		}
	}

//	// 일시정지 후 재시작 스레드
//	Thread thread2 = new Thread(new Runnable() {
//		@Override
//		public void run() {
//			Runnable updater = new Runnable() {
//				@Override
//				public void run() {
//					// 시간 변경
//					int time = TimeDao.getTimeDao().remaintimecheck(m_no);
//					int hour = time / (60 * 60);
//					int minute = time / 60 - (hour * 60);
//					int second = time % 60;
//					lblremaintime
//							.setText(hour + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second));
//				}
//			};
//
//			while (true) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException ex) {
//				}
//				Platform.runLater(updater);
//			}
//		}
//
//	});
}
