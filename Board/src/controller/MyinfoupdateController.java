package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.memberdao;
import domain.member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MyinfoupdateController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		// 1. 로그인된 아이디의 DB에서 회원정보 찾기 
//		String loginid = MainpageController.getinstance().getloginid();
//		member member = memberdao.getmemberdao().getmember(loginid);
//		// 2. DB에서 찾은 회원정보 레이블에 넣기 
//		lblid.setText( member.getM_id() );
//		txtname.setText( member.getM_name() );
//		txtemail.setText( member.getM_email() );
//		lblpoint.setText( member.getM_point() + "" );
		
	}
	
	@FXML
    private Button btncancel;

    @FXML
    private Button btnupdate;

    @FXML
    private Label lblid;

    @FXML
    private Label lblpoint;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtname;

    @FXML
    void cancel(ActionEvent event) {
    	MainpageController.getinstance().loadpage("myinfo");
    }

    @FXML
    void update(ActionEvent event) {
    	
    	boolean result = memberdao.getmemberdao().update(lblid.getText(), txtname.getText(), txtemail.getText());
    	
    	if( result ) { 
    		Alert alert = new Alert(AlertType.INFORMATION); alert.setHeaderText("회원정보 수정 완료"); alert.showAndWait(); 
    		MainpageController.getinstance().loadpage("myinfo");
    	}
    	else { 
    		Alert alert = new Alert(AlertType.INFORMATION); alert.setHeaderText("회원정보 수정 오류"); alert.showAndWait();  
    	}
    }
	    
	    
}
