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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class signcontroller implements Initializable {
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
	@FXML
    private Label btnback;

    @FXML
    private Button btnsignup;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane signuppane;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtname;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private PasswordField txtpasswordconfirm;

    @FXML
    void back(MouseEvent event) {
    	logincontroller.getinstance().loadpage("login");
    }

    @FXML
    void signup(ActionEvent event) {
    	
    	if(txtid.getText().length() < 4  || txtid.getText().length() > 13) {
    		lblconfirm.setText("ID는 4~12글자만 가능");
    		return;
    	}
    	if(txtpassword.getText().length() < 4  || txtpassword.getText().length() > 9) {
    		lblconfirm.setText("PW는 4~8글자만 가능");
    		return;
    	}
    	if(!txtpassword.getText().equals(txtpasswordconfirm.getText())) {
    		lblconfirm.setText("PW가 동일하지 않음");
    		return;
    	}
    	if(txtname.getText().length() < 2) {
    		lblconfirm.setText("이름은 2글자이상만 가능");
    		return;	
    	}
    	if(txtemail.getText().length() <5 && !txtemail.getText().contains("@") ) {
    		lblconfirm.setText("Email형식만 가능");
    		return;
    	}
    	boolean idcheck = memberdao.getmemberdao().idcheck(txtid.getText());
    	if(idcheck) { 
    		lblconfirm.setText("현재사용중인 ID");
    		return;
    	}
    	
    	
    	
    	member member = new member(txtid.getText(),txtpassword.getText(),txtname.getText(),txtemail.getText());
    	boolean result = memberdao.getmemberdao().signup(member);
    	
    	if(result) {
			lblconfirm.setText("가입해주셔서 감사합니다.");
			Alert alert = new Alert(AlertType.INFORMATION); 
			alert.setContentText("회원가입 완료 [Point 1500 지급]"); 
			alert.setHeaderText("회원가입 성공"); 
			alert.setTitle("알림");
			alert.showAndWait(); 
			logincontroller.getinstance().loadpage("login");
    	} else {
    		lblconfirm.setText("회원가입 실패");
    	}
    }
	
	
}
