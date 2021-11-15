package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.PcDao;
import dao.TimeDao;
import domain.Member;
import domain.Pc;
import domain.Time;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainpageController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 로그인 id 조회
		String loginid = LoginController.getinstance().getloginid();
		lblloginid.setText(loginid);
		// m_no 조회
		int m_no = MemberDao.getMemberDao().mnocheck(loginid);
		// m_no의 pc_no 조회
		int p_no = PcDao.getPcDao().pcnocheck(m_no);
		lblpcno.setText(p_no + "");
		// m_no의 usetime 조회
		int t_usetime = TimeDao.getTimeDao().usetimecheck(m_no);
		lblusetime.setText(t_usetime + "");
		// m_no의 remaintime 조회
		int t_remaintime = TimeDao.getTimeDao().remaintimecheck(m_no);
		lblremaintime.setText(t_remaintime + "");
		// m_no의 남은 요금 조회
		lblprice.setText(""); // 임시
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
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText(" 로그아웃 ");
    	alert.setHeaderText(" 로그아웃 하시겠습니까? ");
    	alert.setTitle("로그아웃");
    	// 알림창이 떴을 때 옵션(확인, 취소)에 따라 기능 다름
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK ) { // 확인을 누르면
    		btnlogout.getScene().getWindow().hide(); // 메인창을 끄고
        	LoginController.getinstance().loadpage("c_login"); // 로그인 창 활성화
    	}
    }

    @FXML
    void move(ActionEvent event) {
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText(" 자리이동 ");
    	alert.setHeaderText(" 자리이동 하시겠습니까? ");
    	alert.setTitle("자리이동");
    	// 알림창이 떴을 때 옵션(확인, 취소)에 따라 기능 다름
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK ) {
    		btnmove.getScene().getWindow().hide();
        	loadpage("c_move");
    		// 시간 멈춤
    	}
    }

    @FXML
    void pause(ActionEvent event) {
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText(" 일시정지 ");
    	alert.setHeaderText(" 일시정지 하시겠습니까? ");
    	alert.setTitle("일시정지");
    	
    	Optional<ButtonType> optional = alert.showAndWait();
    	if( optional.get() == ButtonType.OK ) {
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
			Parent parent = FXMLLoader.load(getClass().getResource("/fxml/"+page+".fxml"));
			Scene scene = new Scene( parent );
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("EZEN PC ZONE");
			stage.show();
		}
		catch (Exception e) {}
	}
	
	
}
