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
import javafx.stage.Stage;

public class MainpageController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
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
    private Button btnlogout;

    @FXML
    private Button btnmove;

    @FXML
    private Button btnpause;

    @FXML
    private Button btnproductorder;

    @FXML
    private Button btnchatting;

    @FXML
    void logout(ActionEvent event) {
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText(" 로그아웃 ");
    	alert.setHeaderText(" 로그아웃 하시겠습니까? ");
    	alert.setTitle("확인");
    	alert.showAndWait();
    }

    @FXML
    void move(ActionEvent event) {
    	
    }

    @FXML
    void pause(ActionEvent event) {
    	
    }

    @FXML
    void productorder(ActionEvent event) {
    	loadpage("c_productorder");
    }

    @FXML
    void chatting(ActionEvent event) {
    	loadpage("c_chatting");
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
