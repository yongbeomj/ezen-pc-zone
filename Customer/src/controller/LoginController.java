package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	// 인스턴스화
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
	private Button btnlogin;
	
    @FXML
    private Button btnfindpassword;
	
	@FXML
	private Button btnsignup;
	
    @FXML
    private AnchorPane loginpane;
	
	@FXML
	void findid(ActionEvent event) {
		btnfindid.getScene().getWindow().hide();
		loadpage("c_findid");
	}
	
	@FXML
	void login(ActionEvent event) {
		Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText(" 로그인 ");
    	alert.setHeaderText("로그인 성공");
    	alert.setTitle("확인");
    	alert.showAndWait();
    	
    	btnlogin.getScene().getWindow().hide();
    	loadpage("c_mainpage");
	}
	
    @FXML
    void findpassword(ActionEvent event) {
    	btnfindpassword.getScene().getWindow().hide();
    	loadpage("c_findpassword");
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
			stage.show();
		}
		catch (Exception e) {}
		
	}

	    
}
