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
    		lblconfirm.setText("���̵�� 4~12 ���ڷ� �� �����մϴ�. "); 
    		return;  
    	}
    	if(idcheck) {
    		lblconfirm.setText("�ߺ��� ���̵� �Դϴ�");
    		return;
    	}
   
    	if(!txtpassword.getText().equals(txtpasswordconfirm.getText())) {
    		lblconfirm.setText("��й�ȣ�� �ٸ��ϴ�");
    		return;
    	}
    	if(txtpassword.getText().length()<4||txtpassword.getText().length()>8) {
    		lblconfirm.setText("��й�ȣ�� 4~8 ���ڷ� �����մϴ�");
    		return;
    	}
    	if( txtname.getText().length() <2 ) {
    		lblconfirm.setText("�̸��� 2���� �̻����� �� �����մϴ�. "); 
    		return; 
    	}
    	if(txtemail.getText().length() <5 && !txtemail.getText().contains("@")) {
    		lblconfirm.setText("�̸��� �������� �Է����ּ���."); 
    		return;
    	}
    	if(txtphone.getText().length()!=11) {
    		lblconfirm.setText("�ùٸ� ��ȣ�� �Է����ּ���");
    		return;
    	}
    	
    	int sex = 0;
		if( radiobtnman.isSelected() ) { sex=1;}	// �ش� ������ư�� Ŭ�������� 
		if( radiobtnwoman.isSelected() ) { sex=2;}	
		if(sex == 0) {
			lblconfirm.setText("������ ������ �ֽʽÿ�");
			return;
		}
    	Member member = new Member(txtid.getText(), txtpassword.getText(), txtname.getText(), txtemail.getText(), txtphone.getText(), sex);	
    	boolean signup = MemberDao.getMemberDao().signup(member);    	
    	if(signup) {
    		TimeDao.gettimDao().timeinsert(MemberDao.getMemberDao().find_m_no(txtid.getText()));
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setContentText(" ȸ������ ���� ");
    		alert.setHeaderText("ȸ������ ����");
    		alert.showAndWait(); 
    		lblconfirm.getScene().getWindow().hide();
    		
    		
    	}
    }

    
}

















