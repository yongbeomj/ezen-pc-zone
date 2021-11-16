package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.PcDao;
import dao.TimeDao;
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

	// �α��� id ��ȸ
	String loginid = LoginController.getinstance().getloginid();
	// m_no ��ȸ
	int m_no = MemberDao.getMemberDao().mnocheck(loginid);
	// m_no�� pc_no ��ȸ
	int p_no = PcDao.getPcDao().pcnocheck(m_no);
	// m_no�� usetime ��ȸ
	int t_usetime = TimeDao.getTimeDao().usetimecheck(m_no);
	// m_no�� remaintime ��ȸ
	int t_remaintime = TimeDao.getTimeDao().remaintimecheck(m_no);

	Runnable runnable = new Runnable() {
	      
	      @Override
	      public void run() {
	         while(true) {
	            int t_remaintime = TimeDao.getTimeDao().remaintimecheck(m_no);
	            TimeDao.getTimeDao().timeupdate(m_no, -1, t_remaintime);
	            try {
	               Thread.sleep(1000);
	            } catch (InterruptedException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }
	         }
	      }
	   };
	   Thread thread = new Thread(runnable);
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText(loginid);
		lblpcno.setText(p_no + "");
		lblusetime.setText(t_usetime + "");
		lblremaintime.setText(t_remaintime + "");
		// m_no�� ���� ��� ��ȸ
		lblprice.setText(""); // �ӽ�
		 
		thread.start();
		
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
			// �ð� ����
		}
	}
	
	@FXML
	void pause(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(" �Ͻ����� ");
		alert.setHeaderText(" �Ͻ����� �Ͻðڽ��ϱ�? ");
		alert.setTitle("�Ͻ�����");
		// �Ͻ������� ������ �ð��� ���߰� �α��� â Ȱ��ȭ
		
		Optional<ButtonType> optional = alert.showAndWait();
		if (optional.get() == ButtonType.OK) {
			thread.stop();
			btnlogout.getScene().getWindow().hide();
			LoginController.getinstance().loadpage("c_login");
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

}
