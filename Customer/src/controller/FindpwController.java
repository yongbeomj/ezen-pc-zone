package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FindpwController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
    @FXML
    private Label lblback;

    @FXML
    private Label lblconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    private Button btnfindpw;

    @FXML
    private AnchorPane findpwpane;

    @FXML
    private TextField txtid;

    @FXML
    void back(MouseEvent event) {
    	lblback.getScene().getWindow().hide();
    	LoginController.getinstance().loadpage("c_login");
    }

    @FXML
    void findpw(ActionEvent event) {
    	String result = MemberDao.getMemberDao().findpw(txtid.getText() ,txtemail.getText());
    	
    	if(result != null) {
    		// 알림창
        	Alert alert = new Alert( AlertType.CONFIRMATION );
        	alert.setContentText("비밀번호 찾기 성공");
        	alert.setHeaderText("고객님 비밀번호는 "+ result + " 입니다");
        	alert.setTitle("비밀번호 찾기");
        	alert.showAndWait();
        	// pw 찾기 창 닫고 로그인 창 다시 열기
        	btnfindpw.getScene().getWindow().hide();
        	LoginController.getinstance().loadpage("c_login");
    	} else {
    		lblconfirm.setText("일치하는 회원정보가 존재하지 않습니다");
    	}
    }
    
    
    
    
}
