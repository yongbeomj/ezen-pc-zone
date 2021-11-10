package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LoginController {
	
	  	public static LoginController instance;
	  	
	  	public LoginController() {
	  		instance = this;
	  	}
	  	
	  	public static LoginController getinstance() {
	  		return instance;
	  	}
	
		@FXML
	    private BorderPane borderpane;

	    @FXML
	    private Button btnlogin;

	    @FXML
	    private AnchorPane loginanchor;

	    @FXML
	    void login(ActionEvent event) {
	    	loadpage("k_main");
	    }
	    
	    public void loadpage( String page ) {
	    	try {
	    		Parent parent = FXMLLoader.load(
	    				getClass().getResource("/fxml/"+page+".fxml"));
	    		borderpane.setCenter(parent);
	    	}
	    	catch (Exception e) {}
	    }
}
