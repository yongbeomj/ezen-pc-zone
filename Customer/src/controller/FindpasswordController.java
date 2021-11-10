package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FindpasswordController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblconfirm.setText("");
	}
	
	@FXML
	private Label lblback;
	
	@FXML
	private Label lblconfirm;
	
	@FXML
	void back(MouseEvent event) {
		lblback.getScene().getWindow().hide();
    	LoginController.getinstance().loadpage("c_login");
	}
	    
}
