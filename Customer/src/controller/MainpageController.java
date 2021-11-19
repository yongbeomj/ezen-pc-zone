package controller;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import dao.MemberDao;
import dao.PcDao;
import dao.TimeDao;
import dao.TimeorderDao;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainpageController implements Initializable {
	// �α��� id ��ȸ
	String loginid = LoginController.getinstance().getloginid();
	// m_no ��ȸ
	int m_no = MemberDao.getMemberDao().mnocheck(loginid);
	// m_no�� pc_no ��ȸ
	int p_no = PcDao.getPcDao().pcnocheck(m_no);
	// ���ð� ����
	int use_time = 1;
	boolean sw = true;

	// ���ð� ��ȸ
	int t_usetime = TimeDao.getTimeDao().usetime(m_no);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// ��� ����
		lblprice.setText(TimeorderDao.gettimeorderDao().new_time(m_no) + "");
		lblloginid.setText(loginid);
		lblpcno.setText(p_no + "");
		// m_no�� ���� ��� ��ȸ
		remaintime(1);
		use_time(1);

	}

	// ���� �ð� �޼ҵ�
	public void remaintime(int type) {
		// �����ð� �ǽð� db ��ȸ
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Runnable updater = new Runnable() {

					@Override
					public void run() {

						if (sw) {
							// �ð� ����
							int t_remaintime = TimeDao.getTimeDao().remaintime(m_no);
							TimeDao.getTimeDao().timeupdate(m_no, -1, t_remaintime);
							// �ð� ����
							int time = TimeDao.getTimeDao().remaintime(m_no);
							int hour = time / (60 * 60);
							int minute = time / 60 - (hour * 60);
							int second = time % 60;
							lblremaintime.setText(
									hour + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second));
							if (t_remaintime < 0) {
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setHeaderText("������� �Ǿ����ϴ�");
								PcDao.getPcDao().pclogout(p_no, m_no);
								btnlogout.getScene().getWindow().hide(); // ����â�� ����
								LoginController.getinstance().loadpage("c_login"); // �α��� â Ȱ��ȭ
							}
						}
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
		if (type == 1) {
			thread1.start();
		}
		if (type == 2) {
			try {
				thread1.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// ���ð� �޼ҵ�
	public void use_time(int type) {
		// ���ð� ������
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				Runnable updater = new Runnable() {
					@Override
					public void run() {
						if (sw) {
							int t_usetime = TimeDao.getTimeDao().usetime(m_no);
							TimeDao.getTimeDao().usetimeupdate(m_no, 1, t_usetime);
							int hour1 = use_time / (60 * 60);
							int minute1 = use_time / 60 - (hour1 * 60);
							int second1 = use_time % 60;
							lblusetime.setText(hour1 + ":" + String.format("%02d", minute1) + ":"
									+ String.format("%02d", second1));
							use_time++;
						}
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
		if (type == 1) {
			thread2.start();
		}
		if (type == 2) {
			try {
				thread2.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// �ν��Ͻ�ȭ
	public static MainpageController instance;

	public MainpageController() {
		instance = this;
	}

	public static MainpageController getinstance() {
		return instance;
	}

	@FXML
	private ImageView imglogo;

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
		alert.setContentText(" �α׾ƿ� ");
		alert.setHeaderText(" �α׾ƿ� �Ͻðڽ��ϱ�? ");
		alert.setTitle("�α׾ƿ�");
		// �˸�â�� ���� �� �ɼ�(Ȯ��, ���)�� ���� ��� �ٸ�
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) { // Ȯ���� ������
			PcDao.getPcDao().pclogout(p_no, m_no);
			btnlogout.getScene().getWindow().hide(); // ����â�� ����
			LoginController.getinstance().loadpage("c_login"); // �α��� â Ȱ��ȭ
		}
	}

	@FXML
	void move(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(" �ڸ��̵� ");
		alert.setHeaderText(" �ڸ��̵� �Ͻðڽ��ϱ�? ");
		alert.setTitle("�ڸ��̵�");
		// �˸�â�� ���� �� �ɼ�(Ȯ��, ���)�� ���� ��� �ٸ�
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) {
			btnmove.getScene().getWindow().hide();
			loadpage("c_move");
		}
	}

	@FXML
	void pause(ActionEvent event) {

		if (btnpause.getText().equals("�Ͻ�����")) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText(" �Ͻ����� ");
			alert.setHeaderText(" �Ͻ����� �Ͻðڽ��ϱ�? ");
			alert.setTitle("�Ͻ�����");

			Optional<ButtonType> optional = alert.showAndWait();
			if (optional.get() == ButtonType.OK) {
				sw = false;
				btnpause.setText("����");
			}
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText(" ���� ");
			alert.setHeaderText(" ���� �Ͻðڽ��ϱ�? ");
			alert.setTitle("����");

			Optional<ButtonType> optional = alert.showAndWait();
			if (optional.get() == ButtonType.OK) {
				sw = true;
				btnpause.setText("�Ͻ�����");
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
			FileInputStream logomark = new FileInputStream("src/image/logomark_ezen.png");
			Image image = new Image(logomark);
			stage.getIcons().add(image);
			stage.show();
		} catch (Exception e) {
		}
	}

}
