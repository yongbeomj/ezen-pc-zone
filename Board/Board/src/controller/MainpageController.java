package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainpageController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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

    }

    @FXML
    void myinfo(ActionEvent event) {
    	loadpage("myinfo");
    }

    @FXML
    void product(ActionEvent event) {

    }

}
