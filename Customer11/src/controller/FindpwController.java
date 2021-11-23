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
    		// �˸�â
        	Alert alert = new Alert( AlertType.CONFIRMATION );
        	alert.setContentText("��й�ȣ ã�� ����");
        	alert.setHeaderText("���� ��й�ȣ�� "+ result + " �Դϴ�");
        	alert.setTitle("��й�ȣ ã��");
        	alert.showAndWait();
        	// pw ã�� â �ݰ� �α��� â �ٽ� ����
        	btnfindpw.getScene().getWindow().hide();
        	LoginController.getinstance().loadpage("c_login");
    	} else {
    		lblconfirm.setText("��ġ�ϴ� ȸ�������� �������� �ʽ��ϴ�");
    	}
    }
    
    
    
    
}
