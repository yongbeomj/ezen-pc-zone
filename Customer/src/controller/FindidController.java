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

public class FindidController implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
    @FXML
    private Button btnfindid;

    @FXML
    private AnchorPane findidpane;

    @FXML
    private Label lblback;

    @FXML
    private Label lblconfirm;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtname;

    @FXML
    void back(MouseEvent event) {
    	lblback.getScene().getWindow().hide();
    	LoginController.getinstance().loadpage("c_login");
    }

    @FXML
    void findid(ActionEvent event) {
    	String result = MemberDao.getMemberDao().findid(txtname.getText() ,txtemail.getText());
    	
    	if(result != null) {
    		// �˸�â
        	Alert alert = new Alert( AlertType.CONFIRMATION );
        	alert.setContentText("���̵� ã�� ����");
        	alert.setHeaderText("���� ���̵�� "+ result + " �Դϴ�.");
        	alert.setTitle("���̵� ã��");
        	alert.showAndWait();
        	// id ã�� â �ݰ� �α��� â �ٽ� ����
        	btnfindid.getScene().getWindow().hide();
        	LoginController.getinstance().loadpage("c_login");
    	} else {
    		lblconfirm.setText("��ġ�ϴ� ���̵� �������� �ʽ��ϴ�");
    	}
    	
    }

    
    
    
}
