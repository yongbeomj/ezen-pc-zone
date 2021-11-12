package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}

	// �ν��Ͻ�ȭ
	private static LoginController instance;
	public LoginController() {
		instance = this;
	}
	public static LoginController getinstance() {
		return instance;
	}

    @FXML
    private Button btnfindid;

    @FXML
    private Button btnfindpw;

    @FXML
    private Button btnlogin;

    @FXML
    private Button btnsignup;

    @FXML
    private Label lblconfirm;

    @FXML
    private AnchorPane loginpane;

    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpassword;

    @FXML
    void findid(ActionEvent event) {
    	btnfindid.getScene().getWindow().hide();
		loadpage("c_findid");
    }

    @FXML
    void findpw(ActionEvent event) {
       	btnfindpw.getScene().getWindow().hide();
    	loadpage("c_findpw");
    }

    @FXML
    void login(ActionEvent event) {
    	boolean result = MemberDao.getMemberDao().login(txtid.getText(), txtpassword.getText());
		if (result) {
			lblconfirm.setText(" �α��� ���� ");
			Alert alert = new Alert( AlertType.CONFIRMATION );
	    	alert.setContentText("�α���");
	    	alert.setHeaderText(txtid.getText() + " �� �湮���ּż� �����մϴ�.");
	    	alert.setTitle("�α���");
	    	alert.showAndWait();
			btnlogin.getScene().getWindow().hide();
	    	loadpage("c_mainpage");
		} else {
			lblconfirm.setText(" �α��� ���� [������ ������ �����ϴ�] ");
		}
	}

    @FXML
    void signup(ActionEvent event) {
		btnsignup.getScene().getWindow().hide();
		loadpage("c_signup");
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
	
	public String getid() {
		return txtid.getText();
	}
}
