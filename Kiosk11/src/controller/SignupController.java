package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import dao.TimeDao;
import domain.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class SignupController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
	   @FXML
	    private Button btnsignup;

	    @FXML
	    private Label lblback;

	    @FXML
	    private Label lblconfirm;

	    @FXML
	    private RadioButton radiobtnman;

	    @FXML
	    private RadioButton radiobtnwoman;

	    @FXML
	    private ToggleGroup sex;

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
	    private TextField txtphone;

    @FXML
    void back(MouseEvent event) {
      	lblback.getScene().getWindow().hide();
    	
    }

    @FXML
    void signup(ActionEvent event) {
    	boolean idcheck = MemberDao.getMemberDao().idcheck(txtid.getText());
    	if( txtid.getText().length() < 4 || txtid.getText().length() > 12 ) {
    		lblconfirm.setText("아이디는 4~12 글자로 만 가능합니다. "); 
    		return;  
    	}
    	if(idcheck) {
    		lblconfirm.setText("중복된 아이디 입니다");
    		return;
    	}
   
    	if(!txtpassword.getText().equals(txtpasswordconfirm.getText())) {
    		lblconfirm.setText("비밀번호가 다릅니다");
    		return;
    	}
    	if(txtpassword.getText().length()<4||txtpassword.getText().length()>8) {
    		lblconfirm.setText("비밀번호는 4~8 글자로 가능합니다");
    		return;
    	}
    	if( txtname.getText().length() <2 ) {
    		lblconfirm.setText("이름는 2글자 이상으로 만 가능합니다. "); 
    		return; 
    	}
    	if(txtemail.getText().length() <5 && !txtemail.getText().contains("@")) {
    		lblconfirm.setText("이메일 형식으로 입력해주세요."); 
    		return;
    	}
    	if(txtphone.getText().length()!=11) {
    		lblconfirm.setText("올바른 번호를 입력해주세요");
    		return;
    	}
    	
    	int sex = 0;
		if( radiobtnman.isSelected() ) { sex=1;}	// 해당 라디오버튼을 클릭했을떄 
		if( radiobtnwoman.isSelected() ) { sex=2;}	
		if(sex == 0) {
			lblconfirm.setText("성별을 선택해 주십시요");
			return;
		}
    	Member member = new Member(txtid.getText(), txtpassword.getText(), txtname.getText(), txtemail.getText(), txtphone.getText(), sex);	
    	boolean signup = MemberDao.getMemberDao().signup(member);    	
    	if(signup) {
    		TimeDao.gettimDao().timeinsert(MemberDao.getMemberDao().find_m_no(txtid.getText()));
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setContentText(" 회원가입 성공 ");
    		alert.setHeaderText("회원가입 성공");
    		alert.showAndWait(); 
    		lblconfirm.getScene().getWindow().hide();
    		
    		
    	}
    }

    
}

















