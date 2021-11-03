package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainpageController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		lblloginid.setText( logincontroller.getinstance().getid() );
		loadpage("home");
	}
	
	 @FXML
	    private Button btnchatting;

	    @FXML
	    private Button btncommunity;

	    @FXML
	    private Button btnhome;

	    @FXML
	    private Button btnlogout;

	    @FXML
	    private Button btnmyinfo;

	    @FXML
	    private Button btnproduct;

	    @FXML
	    private AnchorPane cp;

	    @FXML
	    private Label lblloginid;

	    @FXML
	    private AnchorPane lp;

	    @FXML
	    private BorderPane mainpageborderpane;

    // 객체화
    public static MainpageController instance;
    
    public MainpageController() {
		instance = this;
	}
    public static MainpageController getinstance() {
    	return instance;
    }
    public String getloginid() {
    	return lblloginid.getText();
    }
    
    // 가운데 pane 변경하는 메소드 
    public void loadpage( String page ) {
    	try {
    		Parent parent = FXMLLoader.load( 
    				getClass().getResource("/fxml/"+page+".fxml"));
    		mainpageborderpane.setCenter(parent);
    	}
    	catch (Exception e) {}
    }
    
    @FXML
    void chatting(ActionEvent event) {
    	
    }

    @FXML
    void community(ActionEvent event) {
    	loadpage("boardlist");
    }

    @FXML
    void home(ActionEvent event) {
    	loadpage("home");
    }

    @FXML
    void logout(ActionEvent event) {
    	// 1. 알림창
    	Alert alert = new Alert( AlertType.CONFIRMATION );
    	alert.setContentText("로그아웃");
    	alert.setHeaderText("로그아웃 하시겠습니까?");
    	alert.setTitle("확인");
    	
    	Optional<ButtonType> optional = alert.showAndWait();
    	if (optional.get() == ButtonType.OK) {
    		// 2. main page 닫기
        	btnlogout.getScene().getWindow().hide();
        	try {
        		// 3. login page 열기
            	Stage stage = new Stage();
            	Parent parent = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        		Scene scene = new Scene( parent );
        		
        		stage.setScene(scene);
        			stage.setResizable(false);
        			stage.setTitle("게시판");
        		stage.show();
        	} catch(Exception e) {}
        	
    	}
    	
    }

    @FXML
    void myinfo(ActionEvent event) {
    	loadpage("myinfo");
    }

    @FXML
    void product(ActionEvent event) {

    }

}
